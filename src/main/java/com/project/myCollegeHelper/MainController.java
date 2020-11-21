package com.project.myCollegeHelper;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;
import com.google.api.services.calendar.model.Event;
import com.project.myCollegeHelper.entity.*;
import com.project.myCollegeHelper.service.StudentServiceImpl;
import com.project.myCollegeHelper.service.UserServiceImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.util.*;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MainController {

    String studentEmail;
    Integer studentId;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    StudentServiceImpl studentService;

    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = LoginController.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8081).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }


    private static String imeInPriimek;

    private static void setOdlozisce() {
        Clipboard odlozisce = Toolkit.getDefaultToolkit().getSystemClipboard();
        odlozisce.setContents(new StringSelection("@"), null);
    }

    /**
     * Preden kličeš to metodo moraš poklicat getPredmetiInOcene()
     * @return
     */
    public static String getOsnovnePodatke() {
        if (imeInPriimek.equals(""))
            return imeInPriimek;
        return imeInPriimek.substring(imeInPriimek.indexOf("<h1>") + 4, imeInPriimek.indexOf("</h1>"));
    }


    public static void quitWebDriver(WebDriver chrome) {
        chrome.quit();
    }


    private static int mesecVStevilo(String NapisanMesec) {
        String[] meseci = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Avg", "Sep", "Oct", "Nov", "Dec"};
        for (int i=0; i<12; i++) {
            if (NapisanMesec.equals(meseci[i]))
                return i+1;
        }
        return -1;
    }


    /**
     * Metoda ki vrne ArrayList predmetnika in ocen.
     * Kliče se v zažetku programa samo 1x in si shrani v spremenljivko.
     * To metodo moraš poklicat da dobiš ime in priimek
     */
    private static TreeMap<String, String> getPredmetiInOcene(WebDriver chrome) {
        chrome.get("https://ucilnica.fri.uni-lj.si/grade/report/overview/index.php");
        TreeMap<String, String> predmetnik = new TreeMap<>();

        for (String vrstica : chrome.getPageSource().split("\n")) {
            if (vrstica.contains("page-header-headings"))
                imeInPriimek = vrstica;
            if (vrstica.contains("Predmeti, ki jih obiskujem")) {
                for (String x : vrstica.split("a href=\""))
                    if (x.contains("https"))
                        predmetnik.put(
                                x.substring(x.indexOf('>') + 1       , x.indexOf('<')),
                                x.substring(x.indexOf("\">", 110) + 2, x.indexOf("</td></tr><tr")));
                break;
            }
        }
        return predmetnik;
    }

    /**
     * Metoda uporabi parameter in potegne podatke iz spleta
     * Namenjena je, da se kliče samo 1x v programu
     * @param chrome Webdriver da lahko pridobimo podatke iz spleta
     * @return vrne String[][] z dogodki
     */
    public static String[][] getDogodki(WebDriver chrome) {
        chrome.get("https://ucilnica.fri.uni-lj.si/calendar/view.php?view=upcoming");
        String[][] dogodki = new String[100][3];
        int i = 0;

        for (String vrstica : chrome.getPageSource().split("\n")) {
            if (vrstica.contains("<a id=\"calendar-day-popover-link"))
                break;
            if (vrstica.contains("name d-inline-block"))
                dogodki[i][0] = vrstica.substring(vrstica.indexOf('>') + 1, vrstica.indexOf("</h3>"));

            else if (vrstica.contains("view=day&amp")) {
                // če google omogoča unix time, lahko izbrišem spodnji dve vrstici
                long unixCas = Long.parseLong(vrstica.substring(vrstica.indexOf("time=") + 5, vrstica.indexOf('"', 60)));
                String cloveskiFormatCasa = new java.util.Date(unixCas * 1000).toString();

                dogodki[i][1] = String.format("%s.%d.%s", cloveskiFormatCasa.substring(8, 10),
                        mesecVStevilo(cloveskiFormatCasa.substring(4, 7)), cloveskiFormatCasa.substring(24));

            } else if (vrstica.contains("a href=\"https://ucilnica.fri.uni-lj.si/course"))
                dogodki[i++][2] = vrstica.substring(vrstica.indexOf("\">", 60) + 2, vrstica.indexOf("</a>"));
        }

        return dogodki;
    }


    public static WebDriver VpisNaUcilnico(String mail, String geslo, String potDoEXEdatoteke) {
        setOdlozisce();
        System.setProperty("webdriver.chrome.driver", potDoEXEdatoteke);
        WebDriver chrome = new ChromeDriver();

        chrome.get("https://ucilnica.fri.uni-lj.si/login/index.php");
        chrome.findElement(By.id("username")).sendKeys(mail);
        chrome.findElement(By.id("password")).sendKeys(geslo);

        chrome.findElement(By.id("loginbtn")).click();
        return chrome;
    }


    public static ArrayList<String> getPredmeti(TreeMap<String, String> predmetiInOcene) {
        ArrayList<String> predmeti = new ArrayList<>();

        for (Map.Entry<String, String> x : predmetiInOcene.entrySet())
            predmeti.add(x.getKey());
        return predmeti;
    }


    public static ArrayList<String> getOcene(TreeMap<String, String> predmetiInOcene) {
        ArrayList<String> ocene = new ArrayList<>();

        for (Map.Entry<String, String> x : predmetiInOcene.entrySet())
            ocene.add(x.getValue());
        return ocene;
    }

    /**
     * Work in progress
     * @param naslov
     * @param predmet
     * @param ura
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public static void ustvariDogodekVKoledarju(String naslov, String predmet, String ura) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        Event event = new Event()
                .setSummary(naslov)
                .setDescription(predmet);

        DateTime uraZacetkaDogodka = new DateTime(ura);
        EventDateTime zacetek = new EventDateTime()
                .setDateTime(uraZacetkaDogodka)
                .setTimeZone("America/Los_Angeles");;
        event.setStart(zacetek);

        DateTime uraKoncaDogodka = new DateTime(ura);
        EventDateTime konec = new EventDateTime()
                .setDateTime(uraKoncaDogodka)
                .setTimeZone("America/Los_Angeles");;
        event.setEnd(konec);

        /*EventAttendee[] attendees = new EventAttendee[] {
                new EventAttendee().setEmail("lpage@example.com"),
                new EventAttendee().setEmail("sbrin@example.com"),
        };
        event.setAttendees(Arrays.asList(attendees));


        EventReminder[] reminderOverrides = new EventReminder[] {
                new EventReminder().setMethod("email").setMinutes(24 * 60),
                new EventReminder().setMethod("popup").setMinutes(10),
        };
        Event.Reminders reminders = new Event.Reminders()
                .setUseDefault(false)
                .setOverrides(Arrays.asList(reminderOverrides));
        event.setReminders(reminders);
         */

        String calendarId = "primary";
        event = service.events().insert(calendarId, event).execute();
        System.out.printf("Event created: %s\n", event.getHtmlLink());
    }



    @GetMapping("/")
    public String main(Model model, Principal principal) throws IOException {
        String userName = ((OAuth2AuthenticationToken) principal).getPrincipal().getAttribute("name");
        String firstName = ((OAuth2AuthenticationToken) principal).getPrincipal().getAttribute("given_name");
        String lastName = ((OAuth2AuthenticationToken) principal).getPrincipal().getAttribute("family_name");
        String email = ((OAuth2AuthenticationToken) principal).getPrincipal().getAttribute("email");
        String sessionId = ((WebAuthenticationDetails)((OAuth2AuthenticationToken) principal).getDetails()).getSessionId();

        logUser(firstName, lastName, email, sessionId);

        model.addAttribute("userName", userName);
        model.addAttribute("email", email);


        /*
        WebDriver chrome = VpisNaUcilnico("mail_za_ucilnico", "geslo_za_ucilnico",
                new File("./ChromeDriver").getCanonicalPath() + "\\chromedriver.exe");

        TreeMap<String, String> predmetiInOcene = getPredmetiInOcene(chrome);
        // končni dogodki za uporabo
        String[][] dogodki = getDogodki(chrome);
        // končni predmeti za uporabo
        ArrayList<String> predmeti = getPredmeti(predmetiInOcene);
        // končne ocene za uporabo
        ArrayList<String> ocene = getOcene(predmetiInOcene);
        String imePriimek = getOsnovnePodatke();

        quitWebDriver(chrome); */


        // TODO: to se zgodi ko se vpise v račun eUčilnice
        StudentsEntity student = new StudentsEntity();
        student.setName("Gregor");
        student.setLastName("Berger");
        student.setEmail("gb5811@student.uni.lj.si");
        StudentsEntity studentsEntity = studentService.getStudentByEmail("gb5811@student.uni.lj.si");

        studentId = studentsEntity.getSid();
        studentEmail = studentsEntity.getEmail();

        studentService.insertStudent(student);

        // Tuki gre ces vse predmete in jih vnese (treba for zanko nardit)
        SubjectsEntity subject = new SubjectsEntity();
        subject.setName("Informacijski sistemi");
        studentService.insertSubject(subject);


        // Tudi se za ocene (more for zanka tut bit)
        GradesEntity gradesEntity = new GradesEntity();
        gradesEntity.setStudentId(studentId);
        SubjectsEntity subjectsEntity = studentService.getSubject("Informacijski sistemi");
        gradesEntity.setSubjectId(subjectsEntity.getSubid());
        gradesEntity.setGrade("10");
        studentService.insertGrade(gradesEntity);

        return "main";
    }

    private void logUser(String firstName, String lastName, String email, String sessionId) {
        boolean userSessionExists = userService.userSessionExists(sessionId);
        if(!userSessionExists) {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setInsertDate(new Date());
            user.setSession_id(sessionId);
            userService.insertUser(user);
        }
    }

    @GetMapping("/getEvents")
    public ResponseEntity<String> getEvents() throws GeneralSecurityException, IOException {

        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        // List the next 10 events from the primary calendar.
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("primary")
                .setMaxResults(10)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            System.out.println("No upcoming events found.");
        } else {
            System.out.println("Upcoming events");
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                System.out.printf("%s (%s)\n", event.getSummary(), start);
            }
        }
        return ResponseEntity.ok("neki");
    }

    @RequestMapping(value = "/subject/{subjectName}", method = GET)
    public String getSubjectNotes(@PathVariable("subjectName") String subjectName, Model model){
        model.addAttribute("subjectName", subjectName);

        SubjectsEntity subjectsEntity = studentService.getSubject(subjectName);
        String subjectId = String.valueOf(subjectsEntity.getSubid());
        model.addAttribute("notesList", studentService.getNotes(studentId.toString(), subjectId));

        model.addAttribute("totalGrade", studentService.getGrade(studentId.toString(), subjectId).getGrade());

        return "subjectNotes";
    }

    @GetMapping("/subject/insertNote")
    public ResponseEntity<SubjectNotesEntity> insertNote(String title, String noteText, String subjectName){

        StudentsEntity studentsEntity = studentService.getStudentByEmail(studentEmail);
        SubjectsEntity subjectsEntity = studentService.getSubject(subjectName);

        SubjectNotesEntity subjectNotesEntity = new SubjectNotesEntity();
        subjectNotesEntity.setTitle(title);
        subjectNotesEntity.setNotes(noteText);
        subjectNotesEntity.setStudentId(studentsEntity.getSid());
        subjectNotesEntity.setSubjectId(subjectsEntity.getSubid());

        studentService.insertSubjectNote(subjectNotesEntity);

        return ResponseEntity.ok(subjectNotesEntity);
    }

    @GetMapping("/subject/loadNote")
    public ResponseEntity<SubjectNotesEntity> loadNote(String noteId){
        return ResponseEntity.ok(studentService.getNote(noteId));
    }
}
