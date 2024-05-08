# Manuális tesztelés

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

