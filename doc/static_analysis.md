# Célja
A statikus analízis célja, hogy a kód futtatása nélkül végezzük el a kód elemzését, melynek során lehetséges bug-okat, biztonsági réseket vagy a kóddal kapcsolatos minőséi problémákat keresünk. Ezen hibák, problémák kijavításával egy jobb, biztonságosabb kódot tudunk létrehozni.

# Használt eszközök
A projekt analízese során 2 eszközt használtunk. Egyrészt a SonarLint-et, ami egy VSCode extension. Segítségével adott file elemzését lehet automatikusan elvégezni, melynek az eredménye adott file-hoz kapcsolódó hibák, problémák listája.
A másik eszköz a SonarCloud, melynek segítségével egy átfogóbb képet kaphatunk egy webes felületen az egész projektről, mint például a projekthez tartozó kód megbízhatósága, karbantarthatósága.

# Az elemzés menete
Az elemzés során az előbb említett VSCode extension segítségével végignéztük az összes (code) file-t és az ebben található hibákat megvizsgáltuk, bizonyos részüket ki is javítottuk. A következőkben ezen elemzés kerül részletesen ismertetésre.

### ./CommandInterpreter/CommandInterpreter.java
### ./ICommand.java
### ./Game/Character.java
Az esetek túlnyomó részében a hiba itt a következő volt:
"Rename this method name to match the regular expression '^[a-z][a-zA-Z0-9]*$'."
A szabály leírása szerint a "naming convention"-ök csapatok együttműködését segítheti elő. A projekt során ezeket sajnos nem konzisztensen követtük mindenhol, így ez adott esetben javításra szorulna olyan szinte, hogy legalább az egyik naming convention-t követni kellene a projekt során. Mivel nem egy több csapat által kezelt projektről van szó, így a SonarLint-es warning által ajánlott convention lecserélhető lenne egy másikra - ha az konzisztensen lenne alkalmazva az egész projektben. Ez a probléma a projekt egészében előfordul, így innentől kezdve ezt nem emeljük ki.

Ezzel szemben a problémák másik része már egy fontosabb hibára világítottak rá:
"Add a nested comment explaining why this method is empty, throw an UnsupportedOperationException or complete the implementation."
Alapjáraton ez problémás lenne. A sonarlint-es warning viszont megoldható azzal, ha egy placeholder kommentet a függvény hasába helyezünk - ezt eddig a függvény felé írtuk ezzel követve a kommentezési szokásokat.
### ./Game/City.java
Ezen file esetében 2 probléma lépett fel.

Az első probléma az, hogy az "Override" annotáció a projekt kódban több helyen hiányzik. Ez egy könnyen kifelejthető probléma, de ugyanakkor a kód olvashatóságát növeli, ha ez explicit ki van írva. Javításra került.

A másik probléma az volt, hogy egy bizonyos függvény esetében (PickUpPump) a visszatérítendő változó először létre van hozva, majd ezután return-öli a függvény. Ez plusz komplexitást ad a kódhoz és adott esetben ronthat az olvashatóságon.
### ./Game/Field.java
A problémák egy része itt is különböző kódolási irányelvek megsértése miatt léptek fel. Például:
- A Field osztály absztrakt, így nem kéne publikussá tenni a konstruktorát, hiszen nem példányosítható. Helyette a protected a megfelelő.
- Nem a Java nyelv specifikációjának megfelelő sorrendben lettek leírva egy függvény modifier-jei. 'public abstract' helyett 'abstract public'-ként szerepeltek.
### ./Game/Game.java
A következő sorral két probléma is volt:
`public static GameFrame frame;`
Egyrészt az osztály egy adott tagváltozója publikus. Ez az egységbezárás elvét sérti. A változóban tárolt objektum így gyakorlatilag bárhonnan megváltoztatható, ami nem várt viselkedést eredményezhet. Ennek ellenére ez a program írásakor egy szándékos tervezői lépés volt.
Másrészt a statikus mező nem final. Ez egy biztonsági rést jelent a program számára, hiszen ezzel a "megosztott állapottal" bármelyik másik (a Game referenciát birtokló) osztály bármit tud kezdeni, így pl. null-ra is állíthatja.

A problémák egy másik része arra világított rá, hogy egy bizonyos Java verzió felett felesleges megadni egy ArrayList típusát az ArrayList lista inicializálásnál, hiszen ez már abból kiderül, hogy milyen típúsu ArrayList objektummal tesszük azt egyenlővé. Például:
`(ArrayList<Character>) characters = new ArrayList<Character>();`
helyett
`(ArrayList<Character>) characters = new ArrayList<>();`
Ezzel a kód olvashatóságát tudjuk tovább növelni
### ./Game/Mechanic.java
Egyrészt egy kommentelt kódrész benne maradt a kódban. Erre mondta a SonarLint, hogy ezt el kéne távolítani jogosan, hiszen ez a kód olvashatóságát rontja - abban az esetben egyre jobban minél több ilyen "elfelejtett" komment található a kódban.

A másik probléma a már egyszer előjött `@Override` annotáció hiánya. Ez továbbra is az olvashatóságot hivatott növelni.
### ./Game/Node.java
Ezen osztály esetében is előjött a modifier-ek sorrendjének problémája. Ez javításra került. Illetve ebben az esetben is egy absztrakt osztályról beszélhetünk, melynek a konstruktorja publikus. Ezt már a `Character` osztályban kifejtettek szerint érdemes `protected`-re megváltoztatni.

`return edges.get(d).has_player == true ? null : edges.get(d);` sor esetében a boolean value `true`-val való ellenőrzése felesleges, ami a kód olvashatóságát rontja, így az kitörölhető.

Az osztályban található a "Step" függvény is, amely absztrakt. Mivel ez már a Stepable interfész része, ezért itt nincs szükség újra deklarálni, a leszármazottakban enélkül is meg lehet majd valósítani.

Az `@Override` annotáció hiánya itt is megjelent.
### ./Game/Nomad.java
Nem volt probléma ezen osztály esetén - leszámítva a naming convention-öket.
### ./Game/Pipe.java
Ezen osztály esetében is előjött az ArrayList típúsának megadásával kapcsolatos probléma. Ez - a már `Game.java` részben kifejtettek értelmében - ki lett javítva.

A már sokszor említett `@Override` annotációval kapcsolatos probléma itt is előjött, így az ki lett javítva.

A `getNeighbour(int direction)` függvény esetében a második `else if` felesleges, hiszen ekkor az az ág MINDEN esetben igazként értékelődik ki. Ennek oka, hogy az előző ágban ellenőriztük, hogy a `sticky` változó false-e. Ha nem, akkor biztos true, így nem kell ezt explicit ellenőrizni. Ez a kód olvashatóságát rontja, így ezt is javítottuk.
### ./Game/Playfield.java
Ennek az osztálynak az eseetében csak a `Game.java` esetében már említett ArrayList-es "probléma" lépett fel, így ez is javításra került.
### ./Game/Pump.java
Ezen osztály esetében is előjött az `@Override` annotációval kapcsolatos probléma. Javításra került.

Ami ennél érdekesebb az a `PickUpPipe(Mechanic m)` függvényben található meg. Itt az `if` statement második és harmadik sora összefűzhető egybe. Ez adott esetben fejlesztés során nem is tűnik fel az embernek vagy "biztonságból" szétszedi, mégis, az összefésüléssel növelhető a kód olvashatósága.
### ./Game/Source.java
Ezen osztály esetében csak egy hiba jött fel, ez pedig a `@Override` annotációval volt kapcsolatos, így javítva lett - természetesen itt is megfigyelhető volt egy naming convention-nel kapcsolatos jelzés.
### ./Game/Stepable.java
Nem volt probléma ezen osztály esetén - leszámítva a naming convention-öket.
### ./Graphics/CityView.java
Nem volt probléma ezen osztály esetén - leszámítva a naming convention-öket.
### ./Graphics/Drawer.java

### ./Graphics/GameFrame.java
### ./Graphics/IView.java
Nem volt probléma ezen osztály esetén - leszámítva a naming convention-öket.
### ./Graphics/MechanicView.java
Nem volt probléma ezen osztály esetén - leszámítva a naming convention-öket.
### ./Graphics/NodeView.java
Ezen esetben is előjön a már kifejtett "absztrakt osztály, publikus metódus" probléma. Ezt is javítottuk.

Ezenkívűl a kód olvashatóságát itt is tovább rontja az, hogy egy függvény szerepel benne(`Update`), aminek nem kellene, hiszen az interfészben már definiálva van. Ezt itt explicit tehát nem kell definiálni, elég az absztrakt osztály leszármazottaiban, akik ezt felülírják majd.
### ./Graphics/NomadView.java
Ezen forráskód esetén az egyetlen plusz hiba az volt, hogy egy `try-catch` block `catch` része üresen állt. Ez valós környezetben hatalmas problémát jelenthetne, hiszen bár a felhasználó számára tovább futna a program, de mivel a `catch` blokk hasában semmi sem szerepel, így a hiba nem lett rendesen lekezelve ezzel pontenciális bug-okat okozva.
Bár itt egy rendesebb megoldás kéne, de ezen projekt esetén csak szimplán kiírattuk az exception-t a konzolba. (Erre a SonarLint továbbra is hibát jelez, logger használatát szorgalmazva.)
### ./Graphics/PipeView.java
Nem volt probléma ezen osztály esetén - leszámítva a naming convention-öket.
### ./Graphics/PumpView.java
Ezen osztály esetén is visszaköszönt az `@Override` annotációval kapcsolatos probléma, így azt javítottuk.

A naming convention-öket leszámítva még egy hiba lépett fel. Eszerint az egyik sorban feleslegesen használtunk egy zárójelet. Bár ez kicsi dolog, de tény, hogy a kód olvashatóságát ronthatja, így ez is javításra került.
### ./Graphics/SourceView.java
Nem volt probléma ezen osztály esetén - leszámítva a naming convention-öket.
### ./skeleton/TestClass.java
### ./skeleton/TesterMain.java
### ./Main.java