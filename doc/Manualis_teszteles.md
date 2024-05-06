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