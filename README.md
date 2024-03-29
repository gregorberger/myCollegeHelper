# myCollegeHelper

Naslov seminarske naloge: MyCollegeHelper

Člana ekipe:

63160063 Gregor Berger
63180223 Marko Pernat
Z informacijskim sistemom bova omogočila pomoč pri opravljanju študentskih sprotnih obveznosti. Sistem bo omogočal avtomatsko dodajanje obveznosti v Google Calander, predmetnik (dodajanje zapiskov), pregled točkovanja vaj pri posameznem predmetu, ročno dodajanje obveznosti za posamezen predmet.

Informacijski sistem bo sestavljen iz glavnega okna ki predstavlja koledar, ob strani pa bi imel možnost filtriranja prikaz obveznosti po predmetu. Pod koledarjem bi se nahajal predmetnik ki je opisan v 2. točki.

1. avtomatsko dodajanje obveznosti v Google Calander: Strežnik bo vzel obveznosti iz spletne učilnice posameznika in jih bo dodal v informacijski sistem. Uporabnika bo sistem opozoril par dni pred iztekom dogodka. Ima pa tudi možnost ročne spremembe časa opozorila.

2. predmetnik: Pregled predmetov posameznega študenta, z možnostjo dodajanja zapiskov za posamezen predmet (tekst in slike). Nad predmetom bo ikona s številom koliko obveznosti še ima študent za ta predmet. Pri posameznem predmetu bi imel link do pregleda ocen vaj in drugih obveznosti pri tem predmetu.


Ideja za to nalogo:

MyCollegeHelper je aplikacija, namenjena za študente, ki uporabljajo spletne učilnice Moodle. Razčlenjena je na dva dela – aplikacijo na telefonu in spletno aplikacijo, ki sta med seboj sinhronizirani. Uporabnik lahko tako dostopa do svojih ocen in zapiskov preko telefona kot tudi preko računalnika.

Za izdelavo te aplikacije sva se odločila, ker sva kot študenta imela težave pri upravljanju obveznosti, saj spletna učilnica ni omogočila nobenih obvestil o koncu posameznih obveznosti. Kot dopolnilo sva imela idejo o ustvarjanju svojih zapiskov med predavanji, ki so potem shranjeni na enem mestu in lahko dostopni tako iz računalnika kot iz mobilnega telefona.

Potrudila sva se, da sva naredila uporabniku čim bolj prijazen vmesnik in design obeh aplikacij. V izdelavi aplikacij naju je vodil predvsem cilj uporabnosti.


SPLETNA APLIKACIJA

Spletna aplikacija deluje na principu prijave v Google račun, da lahko uporabnik dostopa do svojega Google koledarja. Ko je prijava v Google račun uspešna, se prikaže domač zaslon spletne aplikacije MyCollegeHelper. Pričaka ga njegov koledar in možnost prijave v spletno učilnico Moodle. Po uspešni prijavi v učilnico, se mu v koledarju prikažejo obveznosti. Možnost pogleda svojih obveznosti je dnevna, tedenska in mesečna. Pod koledarjem se nahajajo njegovi predmeti, ki vsebujejo ocene in zapiske.


MOBILNA APLIKACIJA

Mobilna aplikacija je narejena tako, da prikaže vpisno polje, preko katerega dostopa do podatkov v bazi. Po vpisu in kliku na gumb se prikažejo predmeti, na katere lahko uporabnik tudi klikne. Zraven gumba za prikaz predmetov se nahaja gumb za prikaz vseh ocen.

===============================================================================

Dostop do produkcije: https://mycollegehelper-app.azurewebsites.net

Swagger: https://mycollegehelper-app.azurewebsites.net/swagger-ui.html

Dostop do dev: https://mycollegehelper-dev.azurewebsites.net

Baza:
![2020-12-30 17 02 28](https://i.imgur.com/tmvS6Ux.png)


![2021-01-04 17 02 28](https://i.imgur.com/IfHkxhR.png)

![2021-01-04 17 02 28](https://i.imgur.com/RiUPmNI.png)

![2021-01-04 17 02 28](https://i.imgur.com/jwyWYaL.png)

![2021-01-012 20 54 00](https://i.imgur.com/4vQQLbG.png)

![2021-01-012 20 55 00](https://i.imgur.com/Fo5PQZl.png)
