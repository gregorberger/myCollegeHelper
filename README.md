# myCollegeHelper

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
