## BittoDuo_Projlab

Szoftver-projekt laboratóriumon készített házi feladatunk, egy játékot írtunk Java nyelven.

# A szoftver áttekintése:

A játék a játékosok (szabotőrök illetve szerelők) és a csőhálózat különböző elemei között
lezajló interakciókból áll. Négy ilyen elem van: Forrás, ciszterna, cső, pumpa. A csőhálózaton
kívül elhelyezkedő sivatag mezőkkel a játékos nem tud interaktálni, nem léphet rájuk, azok
csak elnyelik a vizet. A forrás mezőkből a játékosoktól függetlenül folyik körönként a víz,
azonban ráállhatnak ezekre a mezőkre további lehetőségek és következmények nélkül. A
ciszterna mezők elnyelik a vizet, illetve a játékos elkészített pumpákat tud kivenni belőlük ha
rááll egy ciszterna mezőre, melyek a folyamatos termelés miatt mindig rendelkezésre állnak.
A pumpa mezőkön mozogni is lehet, illetve a szerelők át tudják állítani, hogy melyik
csatlakoztatott csőből melyikbe pumpálja a vizet. A cső mezőkön szintén haladhatnak a játékosok, illetve rajtuk állva a szabotőrök kilyukaszthatják, a szerelők pedig megfoltozhatják
őket. A csöveket a játékosok áthelyezhetik, úgy, hogy egyik végét megfogják egy másik,
szabadon választott csomóponthoz (ciszternához, forráshoz, vagy pumpához)
csatlakoztathatják. A szerelők a csöveket kettévágva pumpát illeszthetnek be. A játék egy fix
csőhálózattal indul, ennek átépítése, optimalizálása vagy épp tönkretétele a játékosok feladata.
A játékosok egymás után lépnek, felváltva a szabotőr illetve szerelő szerepűek, így a
szoftvernek hálózati elvárásai nincsenek. Minden játékos előre meghatározott számú akciót
(lépés, szerelés, tönkretétel, lehelyezés) hajthat végre a körében, ezek befejezése után a másik
játékos következik. A víz a forrásokból mindig egységnyit folyik a körök végén, miután az
adott körben minden játékos befejezte a lépését.

