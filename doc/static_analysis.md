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
A szabály leírása szerint a "naming convention"-ök csapatok együttműködését segítheti elő. A projekt során ezeket sajnos nem konzisztensen követtük mindenhol, így ez adott esetben javításra szorulna olyan szinte, hogy legalább az egyik naming convention-t követni kellene a projekt során. Mivel nem egy több csapat által kezelt projektről van szó, így a SonarLint-es warning által ajánlott convention lecserélhető lenne egy másikra - ha az konzisztensen lenne alkalmazva az egész projektben.

Ezzel szemben a problémák másik része már egy fontosabb hibára világítottak rá:
"Add a nested comment explaining why this method is empty, throw an UnsupportedOperationException or complete the implementation."
Alapjáraton ez problémás lenne. A sonarlint-es warning viszont megoldható azzal, ha egy placeholder kommentet a függvény hasába helyezünk - ezt eddig a függvény felé írtuk ezzel követve a kommentezési szokásokat.
### ./Game/City.java
### ./Game/Field.java
### ./Game/Game.java
### ./Game/Mechanic.java
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