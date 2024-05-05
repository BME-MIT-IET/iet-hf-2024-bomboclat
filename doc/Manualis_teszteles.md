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
