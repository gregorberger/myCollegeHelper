# myCollegeHelper

Naslov seminarske naloge: MyCollegeHelper

Člana ekipe:

63160063 Gregor Berger
63180223 Marko Pernat
Z informacijskim sistemom bova omogočila pomoč pri opravljanju študentskih sprotnih obveznosti. Sistem bo omogočal avtomatsko dodajanje obveznosti v Google Calander, predmetnik (dodajanje zapiskov), pregled točkovanja vaj pri posameznem predmetu, ročno dodajanje obveznosti za posamezen predmet.

Informacijski sistem bo sestavljen iz glavnega okna ki predstavlja koledar, ob strani pa bi imel možnost filtriranja prikaz obveznosti po predmetu. Pod koledarjem bi se nahajal predmetnik ki je opisan v 2. točki.

1. avtomatsko dodajanje obveznosti v Google Calander: Strežnik bo vzel obveznosti iz spletne učilnice posameznika in jih bo dodal v informacijski sistem. Uporabnika bo sistem opozoril par dni pred iztekom dogodka. Ima pa tudi možnost ročne spremembe časa opozorila.

2. predmetnik: Pregled predmetov posameznega študenta, z možnostjo dodajanja zapiskov za posamezen predmet (tekst in slike). Nad predmetom bo ikona s številom koliko obveznosti še ima študent za ta predmet. Pri posameznem predmetu bi imel link do pregleda ocen vaj in drugih obveznosti pri tem predmetu.

===============================================================================

Za zagon dockerjev znotraj projekta odpri terminal in vpisi:
  1. docker-compose build
  2. docker-compose up
 
Povezava do mysql baze lokalno je:
  * host: localhost
  * port: 3306
  * user: root
  * password: example

Dostop do lokalne strani:
  * http://localhost:8080/
  
Vsakic k se spremeni kj na controllerju je treba v Maven nardit clean in package, da se nardi nov .war
To lahko nardis v Intelliju na desni strani al pa nardis Run/Debug configuracijo in jo samo zaženes.
![2015-09-20 17 02 28](https://i.imgur.com/qIwe4VN.pngA)
