# Célja
A build keretrendszer beüzemelésének célja, hogy bizonyos körülmények között lefusson egy CI build a giten ezzel segítve a validációt, valamint hogy megfelelően fordul-e a program. 

## A build megírásának módja:
A github actions fülön létrehoztam egy új maven buildet, majd kitöltöttem a yaml és a pom.xml tartalmát a megfelelő adatokkal.

## A build beállításai:
A buildhez a JDK 17-es verzióját választottam, hiszen a projektünk is ezen JDK verzióra készült. A build minden egyes pushnál lefut, kivéve hogyha csak a /doc mappa tartalma módosul a push során. Ezt a  következő módon érjük el:
```
push:
    paths-ignore:
      - 'doc/**'
```
Ez azt jelenti hogy csak akkor fut le az action hogyha a push tartalmaz olyan diff-et amiben nem a doc mappa tartalma módosult, tehát valami source kód vagy erőforrás módosítás történt.

## Szükséges módosítások
A projektet át kellet mozgatni a src/main/java mappába, hiszen a maven ezt várja, és innen fog buildelni.