package Game;

import java.util.ArrayList;
import java.util.List;
import skeleton.*;

import Graphics.*;


/**
 * A karakterek által használható mezőket reprezentáló osztály.
 */
abstract public class Field{
    /**Az adott mezőn álló játékosok. */
    protected List<Character> players;

    /**Field konstruktora. */
    public Field(){
        players=new ArrayList<>();
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
        if(c!=null){
            players.remove(c);
        }
    }

    /**
     * Felveszi a paraméterben kapott karaktert a mezőre, vagyis eltárolja a players listában.
     * @param c Karakter objektum, amelyet fel akarnak vetetni a mezőre.
     */
    public void Accept(Character c){
        if(c!=null){
            this.players.add(c);
            c.setField(this);
        }
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     */
    public boolean Fix(){
        return false;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     */
    public boolean Drill(boolean rnd){
        return false;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @param in Az a cső, amelyet bementi csőként kell beállítani.
     * @param out Az a cső, amelyet kimeneti csőként kell beállítani.
     */
    public void Change(Pipe in, Pipe out){
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra
     * hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @return A Pipe objektum amit felvett, ha olyan objektumra hívják meg, melynek ez a függvénye felül van
     * definiálva, ha olyanra aminek nincs akkor null.
     */
    public Pipe PickUpPipe(Mechanic p){
        return null;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra
     * hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @return A Pump objektum amit felvett, ha olyan objektumra hívják meg, melynek ez a függvénye felül van
     * definiálva, ha olyanra aminek nincs akkor null.
     */
    public Pump PickUpPump(){
        return null;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra
     * hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @param p A lehelyezendő Pipe objektum.
     */
    public void addEdge(Pipe p){
        
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
        return p;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva
     * @param m A szerelő, aki le akar helyezni csövet
     */
    public void PlacePipe(Mechanic m){
        return;
    }
    
    /**
     * Elnyeli a függvényhívást olyan mezőkre, ahol annak nincs funkciója.
     */
    public boolean Glue(){
        return false;
    }

    /**
     * Elnyeli a függvényhívást olyan mezőkre, ahol annak nincs funkciója.
     */
    public boolean Lube(){
        return false;
    }

    /**
     * Visszaadja a szomszédok számát
     * Ebben az esetben virtuális függvényként jelenik meg, a leszármazottakban felül kell definiálni
     * @return Szomszédok száma
     */
    abstract public int getNeighbourCount();

    abstract public IView getView();
    abstract public void setView(IView view);
}