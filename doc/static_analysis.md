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
### ./Game/Nomad.java
### ./Game/Pipe.java
### ./Game/Playfield.java
### ./Game/Pump.java
### ./Game/Source.java
### ./Game/Stepable.java
### ./Graphics/CityView.java
### ./Graphics/Drawer.java
### ./Graphics/GameFrame.java
### ./Graphics/IView.java
### ./Graphics/MechanicView.java
### ./Graphics/NodeView.java
### ./Graphics/NomadView.java
### ./Graphics/PipeView.java
### ./Graphics/PumpView.java
### ./Graphics/SourceView.java
### ./skeleton/TestClass.java
### ./skeleton/TesterMain.java
### ./Main.java