# Manuális tesztelés

## Teszt 1
<table>
  <tr>
   <td>
<strong>Teszt-eset neve</strong>
   </td>
   <td>Step on empty pipe from pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos megpróbál rálépni egy üres csőre a pumpáról amin áll.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Annak tesztelése, hogy a játékos ebben az esetben rá tud lépni az adott csőre.
   </td>
  </tr>
</table>

### Lépések
1. A játékos egy pumpán áll.  
![Alt szöveg](/doc/test_images/1.1image.png)  
2. Megnyomjuk a Move gombot, és rákattintunk a csőre.  
![Alt szöveg](/doc/test_images/1.2image.png)  


3. Ekkor a játékos a kattintott csőre kerül.  
![Alt szöveg](/doc/test_images/1.3image.png)

## Teszt 2
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on occupied pipe from pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos megpróbál rálépni egy foglalt csőre a pumpáról amin áll.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Annak tesztelése, hogy a játékos ilyen esetben nem tud a csőre lépni, hiszen az sértené a játékszabályokat.
   </td>
  </tr>
</table>

### Lépések
1. Egy játékos rálép a melletünk elhelyezkedő csőre a Move  akcióval (piros, vagyis a jelenleg soron lévő játékos).
![Alt szöveg](/doc/test_images/2.1image.png)
![Alt szöveg](/doc/test_images/2.2image.png)

2. Amint sorra kerül a mi játékosunk, aki éppen egy pumpán áll, megpróbál a Move akcióval ugyanarra a csőre lépni.
![alt text](/doc/test_images/2.3image.png)

3. Látható, hogy ez nem sikerült.
![alt text](/doc/test_images/2.4image.png)



## Teszt 3
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on empty pipe from city
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos megpróbál rálépni üres csőre a városból, amin áll.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Annak tesztelése, hogy a játékos ebben az esetben rá tud lépni az adott csőre.
   </td>
  </tr>
</table>

### Lépések
1. A játékos a városon áll. (sárga négyzet)  
![Alt szöveg](/doc/test_images/3.1image.png)

2. Megnyomjuk a Move gombot, és rákattintunk az üres csőre.  
![alt text](/doc/test_images/3.2image.png)

3. Látható, hogy sikeresen odalépett.  
![alt text](/doc/test_images/3.3image.png)



## Teszt 4
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on occupied pipe from city
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos megpróbál rálépni foglalt csőre a városból, amin áll.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Annak tesztelése, hogy a játékos ilyen esetben nem tud a csőre lépni, hiszen az sértené a játékszabályokat.
   </td>
  </tr>
</table>

### Lépések:

1. A játékosunk rálép a városra (sárga négyzet) a Move akcióval (piros ez a játékos, hiszen ő van soron).

![alt text](/doc/test_images/4.1image.png)

2. Egy másik játékos egy ezzel szomszédos csőre lép a Move akcióval.

![alt text](/doc/test_images/4.2image.png)
3. A mi játékosunk soron kerül, majd megpróbál a Move akcióval arra a csőre lépre, amin már áll a másik játékos.

![alt text](/doc/test_images/4.3image.png)

4. Nem sikerül ezt megtenni, ahogy a fenti képen is látszik.



## Teszt 5
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on empty pipe from source
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos megpróbál rálépni egy üres csőre a forrásból, amin áll.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Annak tesztelése, hogy a játékos ebben az esetben rá tud lépni az adott csőre.
   </td>
  </tr>
</table>

### Lépések
1. A játékos a forráson áll (kék négyzet).  
![alt text](/doc/test_images/5.1image.png)
2. Megnyomja a Move gombot, és rákattint az üres csőre.  
![alt text](/doc/test_images/5.2image.png)
3. A játékos sikeresen a csőre kerül.  
![alt text](/doc/test_images/5.3image.png)



## Teszt 6
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on occupied pipe from source
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos megpróbál rálépni foglalt csőre a forrásból, amin áll.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Annak tesztelése, hogy a játékos ilyen esetben nem tud a csőre lépni, hiszen az sértené a játékszabályokat.
   </td>
  </tr>
</table>

### Lépések
1. A játékosunk, amikor sorra kerül, rálép a Move akcióval egy forrásra (kék négyzet).
![alt text](/doc/test_images/6.1image.png)
2. Egy másik játékos a Move akcióval rálép egy mellette elhelyezkedő csőre.
![alt text](/doc/test_images/6.2image.png)
3. A játékosunk megpróbál a Move akcióval erre a foglalt csőre rálépni a Move akcióval.
![alt text](/doc/test_images/6.3image.png)
4. Nem sikerül neki, ahogy a fenti képen is látszik.



## Teszt 7
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on pump from pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos megpróbál egy csőről egy szomszédos pumpára rálépni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>A játékos sikeresen átlép egy mellette lévő pumpára.
   </td>
  </tr>
</table>

### Lépések
1. A játékos egy csövön áll.  
![alt text](/doc/test_images/7.1image.png)
2. A játékos megnyomja a Move gombot, és rákattint a kívánt pumpára.  
![alt text](/doc/test_images/7.2image.png)
3. Sikeresen a pumpára kerül a játékos.  
![alt text](/doc/test_images/7.3image.png)


## Teszt 8
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on city from pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos megpróbál egy csőről egy szomszédos ciszternára rálépni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>A játékos sikeresen átlép a ciszternára.
   </td>
  </tr>
</table>

### Lépések
1. A játékosunk a Move akcióval egy olyan csőre lép, amelynek egy szomszédja egy ciszterna (sárga négyzet).
![alt text](/doc/test_images/8.1image.png)
2. A Move akcióval megpróbál a ciszternára lépni.
![alt text](/doc/test_images/8.2image.png)
3. Sikerül ez az akció.



## Teszt 9
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on source from pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos megpróbál egy csőről egy szomszédos forrásra rálépni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>A játékos sikeresen átlép a forrásra.
   </td>
  </tr>
</table>

### Lépések
1. A játékos egy csövön áll, amihez kapcsolódik egy forrás (kék négyzet).  
![Alt szöveg](/doc/test_images/9.1image.png)
2. A játékos megnyomja a Move gombot, és rákattint a forrásra.  
![alt text](/doc/test_images/9.2image.png)
3. A játékos sikeresen a forrásra kerül.  
![alt text](/doc/test_images/9.3image.png)



## Teszt 10

<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Water flows on Pump from Source
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy forrásból vizet indítunk a kimenetén a cső végére kötött pumpa felé.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy a pálya elemei megfelelően adják tovább a rajtuk átfolyó vizet.
   </td>
  </tr>
</table>

### Lépések
1. Be kell állítani a víznek a folyásának kívánt útját. A forrás mindig "tesz" vizet a mellette lévő csövekbe, továbbá úgy van most beállítva (amit tesztelni is szeretnénk),hogy a pumpák bemenete és kimenete úgy van beállítva, hogy a végén a ciszternába eljusson a víz.
![alt text](/doc/test_images/10.1image.png)
2. Meg kell várni egy kör végét, amikor a víz elkezd folyni.
![alt text](/doc/test_images/10.2image.png)
3. Meg kell vizsgálni, hogy egyezik-e a folyás pályája az elvárttal. Egyeznek, így sikerült minden elemnek megfelelően továbbitani a vizet. 



## Teszt 11
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Water flows in City
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy ciszternába a rajta kötött csövön keresztül víz érkezik
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy a ciszternába bele tud-e folyni a víz.
   </td>
  </tr>
</table>

### Lépések
1. Egy olyan pálya összeállítása, ahol a ciszternába egy bekötött cső van, ami vízhez juthat.  
![alt text](/doc/test_images/11.1image.png)
2. Meg kell várni a kör végét, hogy a víz folyását meg lehessen vizsgálni.  
![alt text](/doc/test_images/11.2image.png)
3. Lehet látni, hogy valóban a ciszternába folyik a víz (ebben az esetben egészen a forrástól).  
![alt text](/doc/test_images/11.3image.png)



## Teszt 12
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Water flows in blocked input of Pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy pumpába az egyik rákötött csőből folyna át víz, viszont nem ez a cső a pumpa kiválasztott bemenete.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy a lezárt végekről nem tud továbbfolyni a víz.
   </td>
  </tr>
</table>

### Lépések
1. Egy olyan pálya összeállítása, ahol egy pumpa bemenete és kimenete úgy van beállítva, hogy a víz ott elakadjon. Ebben az esetben a forrás melletti cső pumpa szomszédján tettem ezt meg.
![alt text](/doc/test_images/12.1image.png)
2. Meg kell várni a kör végét, hogy a víz folyását meg lehessen vizsgálni.
![alt text](/doc/test_images/12.1image.png)
3. Lehet látni, hogy valóban nem folyik tovább a víz ott.



## Teszt 13
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Change Pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy pumpának átállítjuk a ki és bemenetét. 
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizzük, hogy a pumpa átállítása működik-e.
   </td>
  </tr>
</table>

### Lépések
1. Megvizsgáljuk, hogy alap esetben honnan, hova folyik a víz. Ezt a 11. teszt példájában szereplő esettel szemléltetjük.  
![alt text](/doc/test_images/11.3image.png)
2. Rálépünk a pumpára egy karakterrel, és átállítjuk a pumpálási irányt.  

3. Lehet látni, hogy valóban nem folyik tovább a víz az eredeti irányba.  
![alt text](/doc/test_images/13.3image.png)



## Teszt 14
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Water flows out of broken pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A csőből ha lyukas kifolyik a víz a sivatagba.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizzük, hogy a csőből a víz elfolyt, nem folyt tovább.
   </td>
  </tr>
</table>

### Lépések
1. Egy olyan pálya összeállítása, ahol a víz folyásának útjában egy törött cső van. Törött cső esetén a csöven egy piros pont van középen.
![alt text](/doc/test_images/14.1image.png)
2. Egy kör végét megvárni, hogy látszódjon a víz folyása.
![alt text](/doc/test_images/14.2image.png)
3. Láthatjuk, hogy nem folyik a víz a törött cső után.



## Teszt 15
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Fix Pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A szerelő játékos a csövön állva ha a cső lyukas megfoltozhatja azt.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizzük, hogy a cső melyet a játékos megpróbál megfoltozni val épp lesz ha eddig lyukas volt, illetve ha eddigis épp volt akkor továbbra is az marad.
   </td>
  </tr>
</table>

### Lépések
1. A szituáció: van egy lyukas cső a pályán. Látható, ahogy a víz nem is folyik tovább.  
![alt text](/doc/test_images/15.1image.png)
2. A szerelővel odalépünk, és megnyomjuk a Fix gombot.  
![alt text](/doc/test_images/15.2image.png)
3. Látható, ahogy megjavul a cső, és a víz is továbbfolyik már rajta.  
![alt text](/doc/test_images/15.3image.png)



## Teszt 16
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Place Pipe on Pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Megkísérelünk letenni egy cső objektumot egy Pump objektumra, vagyis bekötni a pumpába.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizzük, hogy a cső valóban bekötődött a pumpába.
   </td>
  </tr>
</table>

### Lépések
1. A szerelő játékosunknak egy cső objektumot fel kell vennie a Pick up pipe akcióval egy tetszőleges helyről. Pumpán állva random dől el melyik cső kerül felszedve. Ilyenkor megjelenik a játékos kezében egy cső jel, valamint a másik pumpán megjelent egy "fél" cső, ami jelzi, hogy oda kerül majd bekötésre egy cső.
![alt text](/doc/test_images/16.1image.png)
2. Ahhoz a helyre (akár több) Move akcióval el kell jutnia, ahova szeretné bekötni a csövet.
![alt text](/doc/test_images/16.2image.png)
3. A Place pipe akcióval el kell itt helyeznie.
![alt text](/doc/test_images/16.3image.png)
4. Meg kell vizsgálni, hogy valóban bekötődött-e a cső. A szerelő kezéből eltűnt a cső.



## Teszt 17
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Place Pipe on Pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Megkísérelünk letenni egy cső objektumot egy másik cső objektumra.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizzük, hogy a cső nem rakódott le sehova, hiszen ez egy értelmetlen és szabálytalan művelet.
   </td>
  </tr>
</table>

### Lépések
1. Egy szerelővel felveszünk egy cső objektumot.  
![alt text](/doc/test_images/17.1image.png)
2. Átlépünk vele a legközelebbi csőre, és megnyomjuk a Place Pipe gombot.  
![alt text](/doc/test_images/17.2image.png)
3. Látható, ahogy nem történik semmi, még a turn számláló sem növekedett.  
![alt text](/doc/test_images/17.3image.png)



## Teszt 18
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Place pump on pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy pumpát próbál lehelyezni a játékos a kezéből, úgy hogy éppen egy pumpán áll.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrzi, hogy nem tudunk pumpát elhelyezni olyan mezőre, amire nem lehet.
   </td>
  </tr>
</table>

### Lépések
1. Egy szerelő játékosnak a ciszternán állva a a Pick up pump akcióval fel kell vennie egy pumpát. Ekkor a kezében megjelenik egy pumpa.
![alt text](/doc/test_images/18.1image.png)
![alt text](/doc/test_images/18.2image.png)
2. Ahhoz a helyre (akár több) Move akcióval el kell jutnia, ahova le szeretné helyezni a pumpát, ebben az esetben ez egy pumpa.
![alt text](/doc/test_images/18.3image.png)
3. Place pump akcióval megpróbálja lehelyezni a felvett pumpát.
![alt text](/doc/test_images/18.4image.png)
4. Látszik, hogy nem sikerült, a kezében maradt a pumpa.



## Teszt 19
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Place pump on pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy pumpát helyez le a kezéből a játékos arra a csőre. amin áll.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy helyes-e a pumpa lehelyezése
   </td>
  </tr>
</table>

### Lépések
1. Egy szerelő játékosnak a ciszternán állva a a Pick up pump gombbal felvesz egy pumpát.  
![alt text](/doc/test_images/19.1image.png)
2. A játékos rálép egy csőre és megnyomja a place pump gombot.  
![alt text](/doc/test_images/19.2image.png)
3. Ekkor látható, hogy megjelenik a pumpa a kívánt csövön.  
![alt text](/doc/test_images/19.3image.png)



## Teszt 20
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Pick up Pipe on City
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy játékos egy ciszternán állva lecsatlakoztatja az egyik cső végét.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy a csiszternába kötött csövek nem lecsatlakoztathatóak, mivel a ciszternán a Pick up pipe új csövet ad.
   </td>
  </tr>
</table>

### Lépések
1. Egy szerelő játékos egy ciszternára lép a Move akcióval.
![alt text](/doc/test_images/20.1image.png)
2. A Pick up pipe akcióval megpróbál egy csövet felvenni.
![alt text](/doc/test_images/20.2image.png)
3. Látható, hogy nem egy eddig is ciszternába kötött csövet kap, hanem egy teljesen új csövet a játékos (ezt az ábrán úgy szemléltetem, hogy egy Move akcióval arrébb lépek, hogy jobban látszódjon).
![alt text](/doc/test_images/20.3image.png) 



## Teszt 21
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Pick up Pipe on Pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy játékos egy pumpán állva lecsatlakoztatja az egyik cső végét.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy a pumpába kötött csöveket le lehet-e csatlakoztatni.
   </td>
  </tr>
</table>

### Lépések
1. Egy szerelő egy pumpán állva megnyomja a Pick Up Pipe gombot.  
![alt text](/doc/test_images/21.1image.png)
2. Ez sikerül neki, és látható a kezében a megjelenő pumpa.  
![alt text](/doc/test_images/21.2image.png)



## Teszt 22
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Pick up Pipe on Pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy játékos egy csövön állva megpróbálja azt lecsatlakoztatni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy egy csövön állva az adott csövet nem lehet felvenni.
   </td>
  </tr>
</table>

### Lépések
1. Egy szerelő játékos egy csőre lép.
![alt text](/doc/test_images/22.1image.png)
2. Megpróbál a Pick up pipe akcióval felvenni onnan egy csövet.
![alt text](/doc/test_images/22.2image.png)
3. Ahogy a fenti lépen is látszik, nem sikerült.



## Teszt 23
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Pick up Pipe on Source
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Egy játékos egy forráson állva lecsatlakoztatja az egyik cső végét.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy forrásról nem lehet lecsatlakoztatni csövet.
   </td>
  </tr>
</table>

### Lépések
1. Egy szerelő a forrásra lép és megnyomja a Pick Up Pipe gombot.  
![alt text](/doc/test_images/23.1image.png)
2. Látható, hogy nem sikerül neki, és lépést sem veszít érte.  
![alt text](/doc/test_images/23.2image.png)



## Teszt 24
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Destroy Pump and Fix Pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A pumpa a játék folyamán a víz folyásakor bármikor tönkremehet. Megjavítani egy rajta álló szerelő játékos tudja.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy ha a szerelő egy tönkrement pumpát javít akkor az valóban megjavul, ha pedig egy működő pumpát, akkor nem történik semmi.
   </td>
  </tr>
</table>

### Lépések
1. A játék folyamán bármikor elromolhat egy pumpa, így ott megjelenik egy X.
![alt text](/doc/test_images/24.1image.png)
2. Egy szerelő játékos erre a pumpára megy (akár több) Move akcióval.
![alt text](/doc/test_images/24.2image.png)
3. A Fix akcióval megpróbálja ezt megjavítani.
![alt text](/doc/test_images/24.3image.png)
4. Ahogy a képen is látszik, sikerült, eltűnt az X.



## Teszt 25
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Test water step source
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Teszteli a forrás csomópont step víz folyásának szimulálását.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy helyes-e a forrás víz irányítási működése.
   </td>
  </tr>
</table>

### Lépések
1. Tekintjük a játék egy első, még víz lépés előtti állapotát. Kilyukasztunk egy csövet, ami a city és a forrás között van.  
![alt text](/doc/test_images/25.1image.png)
2. Ezután passzoljuk a játékosok alkalmait, és a következő körre kerül a játék, amikor is már folyt a víz. Látható, hogy a forrásból kifelé ki is folyt (egészen a lyukas csőig persze), tehát helyesen működik.  
![alt text](/doc/test_images/25.2image.png)



## Teszt 26
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on and from glued Pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Aki először rálép egy ragadóssá tett Pipe objektumra, az egy ideig nem tud továbblépni onnan.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy amennyiben a játékos elsőként lépett rá egy ragadós csőre, akkor valóban nem tud onnan rögtön elmozogni.
   </td>
  </tr>
</table>

### Lépések
1. Egy játékos egy cső pályaelemre lép.
![alt text](/doc/test_images/26.1image.png)
2. A játékos a Glue akcióval ragadóssá teszi azt, valamint ő ezzel az akcióval a a cső egyik végére kerül random.
![alt text](/doc/test_images/26.2image.png)
3. Egy másik játékos rálép erre a csőre.
![alt text](/doc/test_images/26.3image.png)
4. Move akcióval megpróbál innen ellépni, de nem megy.
![](/doc/test_images/26.4image.png)
5. A következő Move akcióval már megy.
![alt text](/doc/test_images/26.5image.png)



## Teszt 27
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Test water step Pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Teszteli a pumpa step víz folyásának szimulálását.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy helyes-e a pumpa irányítási működése.
   </td>
  </tr>
</table>

### Lépések
1. Tekintjük a játék egy első, még víz lépés előtti állapotát. Kilyukasztunk egy csövet, ami a pumpa és a forrás között van, hogy jobban szemléltessük a példát.  
![alt text](/doc/test_images/25.1image.png)
2. Ezután passzoljuk a játékosok alkalmait, és a következő körre kerül a játék, amikor is már folyt a víz. Látható, hogy a (bal alsó) pumpán keresztül folyt a víz, tehát helyesen működik.  
![alt text](/doc/test_images/25.2image.png)



## Teszt 28
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Test drill pipe on pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos egy csövön állva megpróbálja kifúrni azt.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy a csövet ki tudja-e lyukasztani a játékos.
   </td>
  </tr>
</table>

### Lépések
1. Egy játékos Move akcióval egy csőre lép.
![alt text](/doc/test_images/28.1image.png)
2. A játékos a Drill akcióval megpróbálha kilyukasztani a csövet.
![](/doc/test_images/28.2image.png)
3. Lehet látni, hogy sikerült, megjelent a piros pötty a csövön.



## Teszt 29
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Pick up pump on city
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos egy ciszternán állva megpróbál egy új pumpát a kezébe kapni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizzük, hogy a játékos kap egy pumpát a kezébe.
   </td>
  </tr>
</table>

### Lépések
1. Egy szerelővel a cityre lépünk, és megnyomjuk a Pick Up Pump gombot.  
![alt text](/doc/test_images/29.1image.png)
2. Látható, hogy a játékos kezében meg is jelenik a pumpa.  
![alt text](/doc/test_images/29.2image.png)



## Teszt 30
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Pick up pump on pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos egy pumpán állva megpróbál egy új pumpát a kezébe kapni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizzük, hogy a játékos nem kap pumpát a kezébe.
   </td>
  </tr>
</table>


### Lépések
1. Egy játékos egy pumpa pályaelemre lép Move akcióval.
![alt text](/doc/test_images/30.1image.png)
2. A játékos a Pick up pump akcióval megpróbál egy pumpát felvenni.
![alt text](/doc/test_images/30.2image.png)
3. Nem sikerül neki, ahogy a fenti képen is látható.



## Teszt 31
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Pick up pump on pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos egy csövön állva megpróbál egy új pumpát a kezébe kapni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizzük, hogy a játékos nem kap pumpát a kezébe.
   </td>
  </tr>
</table>

### Lépések
1. Egy szerelő egy csövön állva megnyomja a Pick Up Pump gombot.  
![alt text](/doc/test_images/31.1image.png)
2. Látható, hogy nem került a kezébe a pumpa, és a turn-je sem növekedett, a teszt sikeres volt.  
![alt text](/doc/test_images/31.2image.png)



## Teszt 32
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Pick up pump on source
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékos egy forráson állva megpróbál egy új pumpát a kezébe kapni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizzük, hogy a játékos nem kap pumpát a kezébe.
   </td>
  </tr>
</table>

### Lépések
1. Egy játékos egy forrás pályaelemre lép a Move akcióval.
![alt text](/doc/test_images/32.1image.png)

2. A Pick up pump akcióval megpróbál egy pumpát felvenni.
![alt text](/doc/test_images/32.2image.png)

3. Nem sikerül neki, ahogy a fenti képen is látható.



## Teszt 33
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Repaired Pipe cannot be drilled
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Azok a csövek, melyek nemrégiben lettek megjavítva véletlen ideig nem lyukaszthatók ki.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy olyan csövet amit még nem lehet kilyukasztani a rajta álló játékos nem tudja kilyukasztani.
   </td>
  </tr>
</table>

### Lépések
1. A pályán egy karakterrel kilyukasztunk egy csövet.  
![alt text](/doc/test_images/33.1image.png)
2. Ráállunk egy szerelővel, és megnyomjuk a Fix gombot.  
![alt text](/doc/test_images/33.2image.png)
3. (Elmozgunk a szerelővel.) Ráállunk egy szabotőrrel, és megnyomjuk a Drill gombot.  
![alt text](/doc/test_images/33.3image.png)
4. Látható, hogy nem sikerül a lyukasztás, bármeddig is nyomogatjuk a gombot.  
![alt text](/doc/test_images/33.4image.png)
5. Passzoljuk a köreinket (6. körbe kerülünk), és látható, hogy mostmár a Drill megnyomására...  
![alt text](/doc/test_images/33.5image.png)
6. ...kilyukad a kívánt cső.  
![alt text](/doc/test_images/33.6image.png)



## Teszt 34
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Lubricate Pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A szabotőr játékos a csövet amin áll rövid időre csúszóssá tudja tenni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy a szabotőr a csövet valóban csúszóssá tette.
   </td>
  </tr>
</table>

### Lépések
1. Egy szabotőr játékos agy cső pályaelemre lép a Move akcióval.
![alt text](/doc/test_images/34.1image.png)
2. A játékos a Lube akcióval megpróbálja csúszássá tenni a csövet.
![alt text](/doc/test_images/34.2image.png)
3. Sikerül neki, és átkerül az egyik oldalára a csőnek.



## Teszt 35
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Lubricate Pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A szabotőr játékos a csövet amin áll rövid időre csúszóssá tudja tenni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy amennyiben a szabotőr egy Pump objektumon (vagy bármilyen Node-on) áll, az nem lesz csúszós, hiszen ez egy érvénytelen művelet.
   </td>
  </tr>
</table>

### Lépések
1. A szabotőrrel egy pumpára lépünk és megnyomjuk a Lube gombot.  
![alt text](/doc/test_images/35.1image.png)
2. Látható, hogy nem történik semmi, és a pumpán is marad, tehát nem sikerült a pumpa csúszóssá tétele, a teszt sikeres.  
![alt text](/doc/test_images/35.2image.png)



## Teszt 36
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Step on lubricated Pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>Aki csúszós csőre rálép véletlenszerűen a cső valamelyik végéhez kapcsolódó elemre kerül.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogyha valaki a csúszós csőre lépne akkor valóban a cső valamelyik végére kerül és nem a cső objektumra.
   </td>
  </tr>
</table>

### Lépések
1. Egy szabotőr játékos agy cső pályaelemre lép a Move akcióval.
![alt text](/doc/test_images/34.1image.png)
2. A játékos a Lube akcióval megpróbálja csúszássá tenni a csövet.
![alt text](/doc/test_images/34.2image.png)
3. Sikerül neki, és átkerül az egyik oldalára a csőnek.
4. Egy másik játékos megpróbál rálépni erre a csúszós csőre, és átkerül random a cső egyik oldalára (ebben az esetben visszakerült oda, ahol eredetileg is volt).
![](/doc/test_images/36.1image.png)
![alt text](/doc/test_images/36.2image.png)
5. Már nem csúszós a cső, ahogy a fenti képen is látható.



## Teszt 37
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Glue Pipe on Pipe
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékosok a csövet amin állnak ragadóssá tudják tenni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy a játékos a csövet valóban ragadóssá tette.
   </td>
  </tr>
</table>

### Lépések
1. Egy játékos rálép egy csőre és megnyomja a Glue gombot.  
![alt text](/doc/test_images/37.1image.png)
2. Ez sikerül neki, és látható a csövön megjelenő ragasztó.  
![alt text](/doc/test_images/37.2image.png)
3. Egy másik játékossal rálépünk a csőre, és utána megpróbálunk elmozdulni.  
![alt text](/doc/test_images/37.3image.png)
4. Látható, hogy a csövön marad a játékos, a teszt sikeres.  
![alt text](/doc/test_images/37.4image.png)



## Teszt 38
<table>
  <tr>
   <td><strong>Teszt-eset neve</strong>
   </td>
   <td>Glue on Pump
   </td>
  </tr>
  <tr>
   <td><strong>Rövid leírás</strong>
   </td>
   <td>A játékosok a csövet amin állnak ragadóssá tudják tenni.
   </td>
  </tr>
  <tr>
   <td><strong>Teszt célja</strong>
   </td>
   <td>Ellenőrizni, hogy amennyiben a játékos egy Pump objektumon (vagy bármilyen Node-on) áll, az nem lesz ragadós, hiszen ez egy érvénytelen művelet.
   </td>
  </tr>
</table>

### Lépések
1. Egy játékos egy pumpa pályaelemre megy a Move akcióval.
![alt text](/doc/test_images/38.1image.png)
2. Megpróbálja a Glue akcióval ezt ragadossá tenni.
![alt text](/doc/test_images/38.2image.png)
3. Nem sikerül neki, hiszen a pumpát nem lehet ragadóssá tenni.