package Game;

import java.util.ArrayList;
import java.util.List;
import skeleton.*;


/**
 * A karakterek által használható mezőket reprezentáló osztály.
 */
abstract public class Field{
    /**Az adott mezőn álló játékosok. */
    protected List<Character> players;

    /**Field konstruktora. */
    public Field(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field has been initialized");
        TesterMain.tabCount++;
        players=new ArrayList<>();
        TesterMain.tabCount--;
    }
    
    /**
     * Ez egy absztrakt függvény, mivel a Field osztály leszármazottai más-más szabályok alapján adják meg,
     * hogy az adott irányba milyen szomszédos mezőjük van, illetve maguk a leszármazottak tárolják a szomszédos
     * mezőiket.
     * @param d Irány, amelyből a szomszédot lekérik.
     * @return Az adott irányból a szomszédos mező, vagy ha az adott irányba nincs érvényes mező, nullt ad vissza.
     */
    abstract public Field getNeighbour(int d);

    /**
     * Leveszi a paraméterben kapott karaktert a mezőről, vagyis eltávolítja a players listából.
     * @param c Karakter objektum, amelyet le akarnak venni a mezőről.
     */
    public void Remove(Character c){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field::Remove()");
        this.players.remove(c);
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    /**
     * Felveszi a paraméterben kapott karaktert a mezőre, vagyis eltárolja a players listában.
     * @param c Karakter objektum, amelyet fel akarnak vetetni a mezőre.
     */
    public void Accept(Character c){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field::Accept()");
        TesterMain.tabCount++;
        this.players.add(c);
        c.setField(this);
        TesterMain.tabCount--;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     */
    public void Fix(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field::Fix()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     */
    public void Drill(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field::Drill()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @param in Az a cső, amelyet bementi csőként kell beállítani.
     * @param out Az a cső, amelyet kimeneti csőként kell beállítani.
     */
    public void Change(Pipe in, Pipe out){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field::Change()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra
     * hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @return A Pipe objektum amit felvett, ha olyan objektumra hívják meg, melynek ez a függvénye felül van
     * definiálva, ha olyanra aminek nincs akkor null.
     */
    public Pipe PickUpPipe(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field::PickUpPipe()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
        return null;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra
     * hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @return A Pump objektum amit felvett, ha olyan objektumra hívják meg, melynek ez a függvénye felül van
     * definiálva, ha olyanra aminek nincs akkor null.
     */
    public Pump PickUpPump(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field::PickUpPump()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
        return null;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra
     * hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @param p A lehelyezendő Pipe objektum.
     */
    public void addEdge(Pipe p){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field::addEdge()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra
     * hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @param p A lehelyezendő Pump objektum.
     * @return Ha a pumpát le lehet helyezni az objektumra amin meghívják, mert felül van definiálva ez a
     * függvénye, akkor null, egyéb esetben visszaadja a pumpát amit paraméterként kapott, megpróbált
     * lehelyezni.
     */
    public Pump PlacePump(Pump p){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Field::PlacePump()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
        return p;
    }




}