## Célja
A UI tesztelés célja, hogy a megírt felhasználói felületet ne kézzel kelljen tesztelnie a fejlesztőknek, hanem az automatizált teszteket lefuttatva gyorsan és hatékonyan lehessen teszteli az alkalmazásunk felhasználói felületét.

## UI tesztelési eszközök
A megadott feladatkiírásban feltüntetett 3 lehetőség (Selenium, Tosca, Appium) sajnos nem támogat Java Swing felhasználói felület tesztelést, viszont megpróbáltam AssertJ segtíségével letesztelni programunk felhasználói felületét.

## UI keretrendszer felállítása
Az AssertJ keretrendszert a pom.xml-be való függőség felvételével tudjuk elérni, majd pedig a JUnit tesztekhez hasonlóan írhatunk teszteket, amiben hivatkozhatjuk a felhasználói felület elemeit, rajtuk pedig műveleteket végezhetünk el(pl.: kattintás, érték beírása).

## Tesztek elkészítése
Elsőként a keretrendszer tesztjeként egy olyan tesztet írtam, amely szimplán létrehoz egy játékot 1-1 játékossal majd pedig az összes körön keresztül passzol, ez követően pedig bezárja a játékot. Ezzel a teszttel tudjuk megnézni, hogy az alap funkciók működnek-e a játék során.