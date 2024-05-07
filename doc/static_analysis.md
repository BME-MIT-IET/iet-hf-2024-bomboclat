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
Ezen osztály esetében is megjelen azt `@Override` probléma, ez javítva lett. Ezenkívül itt is lehetett pár `if statement`-et összevonni egy előtte lévővel, így ezt is megtettük, ezzel javítva az olvashatóságot. Ez egyébként bizonyos esetekben azt eredményezte, hogy az `if statement` tovább volt egyszerűsíthető (pl.: `v != null && v instanceof PipeView`, ahol az `instanceof` eleve `false`-t ad vissza `null` objektum esetén.). Így tehát ezek is javítva lettek.

A listával kapcsolatos probléma itt is előjött, ez is javítva lett.

Adott függvény esetében (`mouseClicked(MouseEvent e)`) a komplexitás túl nagy, avagy a függvény túl hosszú. A `GameFrame.java` részben megfogalmazottak értelmében ezt célszerű lenne feldarabolni kisebb függvényekre az olvashatóság és karbantarthatóság növelésének érdekében.
Az említett függvényben egyébként egy nagyon hosszú `if-else` struktúra is megtalálható. Itt a SonarLint jelezte, hogy bizonyos feltételek esetében egy-egy részfeltétel elhagyható, hiszen mindig igaz az értéke. Ez is javítva lett.

A program még kiemelte azt is, hogy bizonyos, implementáció nélküli (pl.: `mouseEntered(MouseEvent e)`) esetében vagy exception-t kéne dobni, hogy nem lett megvalósítva a függvény, vagy implementálni kellene. A csapat által alkotott kommentelés értelmében ezt a hibát ignoráltuk.

Szerepel még kettő ehhez hasonló kódrészlet a forráskódban: `Math.sqrt((v.getPlayerPositionX() - x)*(v.getPlayerPositionX() - x)+(double)(v.getPlayerPositionY() - y)*(v.getPlayerPositionY() - y))`
A SonarLint kiemelte, hogy ez nem feltétlen a legjobb megközelítés, hiszen cast-olás nélkül nem várt eredményekkel találkozhatunk, hiszen a függvény `double`-t ad vissza, míg mi `int`-ekkel dolgozunk a számolás során. Bár ritkán, de ez nem várt mellékhatásokkal járhat. Így ezt javítottuk.
### ./Graphics/GameFrame.java
Ezen osztály esetében már több hiba lépett fel.
Ezek egy része arra vonatkozott, hogy az osztály privát tagváltozói deklarálva vannak, de igazából csak egy függvény esetében vannak használva. Ez a program jelenlegi állapotában rontja a kód olvashatóságát, hiszen feleslegesen vannak tagváltozóként deklarálva, miközben az osztálynek egyrészt nincsenek leszármazottai, másrészt ezen tagváltozókhoz nem készítettünk gettereket, így kívülről se érjük el őket. Javítottuk ezt getterek és setterek írásával.

A másik probléma bizonyos stringek újra leírása többször. Ezzel a kód karbantarthatósága romlik, hiszen ha egy helyen átírjuk a string-et, akkor minden másikon is át kell. Ezt egy konstans bevezetésével lehet kiküszöbölni, amely konstanst ezután minden régi string helyén hivatkozunk. Ezzel gyakorlatilag elég egyetlen egy helyen megváltoztatni a string értékét ahhoz, hogy pl. a kimenet más legyen.

A harmadik probléma az `initFrame()` függvény komplexitása. Sajnos a függvény túlságosan hosszú, így romlik a karbantarthatósága, illetve olvashatósága. Alap esetben célszerű lenne ezt a függvényt több, kisebb függvényre feldarabolni felelősségek mentén.
### ./Graphics/IView.java
Nem volt probléma ezen osztály esetén - leszámítva a naming convention-öket.
### ./Graphics/MechanicView.java
Nem volt probléma ezen osztály esetén azon kívűl, hogy logger helyett `System.out.println()`-t használtunk - leszámítva a naming convention-öket.
A logok használatának egyébként számos előnye van, amely egy nagyobb projekt esetében elengedhetetlen
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
Egy problémán kívűl nem volt semmi gond - leszámítva a naming convention-öket.
 A probléma azzal volt, hogy egy másik osztály statikus tagját változtattuk nem statikus függvényekből. Ez egyedül azért nem baj számunkra, mert a program alkotása során ezt figyelembe vettük.
### ./skeleton/TesterMain.java
Ezen osztály esetében is a kiadott hibák a program felépítése által indokolhatóak. Például a 33 soros (miközben "maximum 30 lenne a megengedett") `switch-case` valóban nem olvasható, de ezt jobban nem tudtuk megoldani. Természetesen egy valódi helyzetben célszerű lenne erre rendes megoldást találni.
### ./Main.java
Ebben az esetben egyedül egy elfelejtett komment volt a probléma. Ez több ilyen komment esetén valóban rontja az olvashatóságot. Törölve lett.