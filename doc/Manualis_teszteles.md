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
