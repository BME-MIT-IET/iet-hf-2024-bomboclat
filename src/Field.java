import java.util.ArrayList;
import java.util.List;

abstract public class Field{
    /**Az adott mezőn álló játékosok. */
    protected List<Character> players;

    /**Field konstruktora */
    public Field(){
        System.out.println("Field has been initialized");
        players=new ArrayList<>();
    }
    
    /**
     * Ez egy absztrakt függvény, mivel a leszármazottai más-más szabályok alapján adják meg, 
     * hogy az adott irányba milyen szomszédos mezőjük van, illetve a leszármazottai tárolják a szomszédos
     * mezőiket.
     * @param d Irány, amelyből a szomszédot lekérik.
     * @return Az adott irányból a szomszédos mező, vagy ha az adott irányba nincs érvényes mező, nullt ad vissza.
     */
    abstract public Field getNeighbour(int d);

    /**
     * Leveszi a paraméterben kapott karaktert a mezőről.
     * @param c Karakter objektum, amelyet le akarnak venni a mezőről.
     */
    public void Remove(Character c){
        System.out.println("Field::Remove()");
    }

    /**
     * Felveszi a paraméterben kapott karaktert a mezőre.
     * @param c Karakter objektum, amelyet fel akarnak vetetni a mezőre.
     */
    public void Accept(Character c){
        System.out.println("Field::Accept()");
        c.setField(this);
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     */
    public void Fix(){
        System.out.println("Field::Fix()");
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     */
    public void Drill(){
        System.out.println("Field::Drill()");
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @param p Az a cső, amelyet bementi csőként kell beállítani.
     * @param d Az a cső, amelyet kimeneti csőként kell beállítani.
     */
    public void Change(Pipe o, Pipe d){
        System.out.println("Field::Change()");
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra
     * hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @return
     */
    public Pipe PickUpPipe(){
        System.out.println("Field::PickUpPipe()");
        return null;
    }

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra
     * hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @return 
     */
    public Pump PickUpPump(){
        System.out.println("Field::PickUpPump()");
        return null;
    }

    /**
     * 
     */
    public void PlacePipe(){
        System.out.println("Field::PlacePipe()");
    }

    /**
     * 
     * @param d
     * @return
     */
    public Node getEndpoint(int d){
        System.out.println("Field::getEndpoint()");
        return null;
    }

    /**
     * 
     * @param p
     */
    public void addEdge(Pipe p){
        System.out.println("Field::addEdge()");
    }

    /**
     * 
     * @param p 
     * @return
     */
    public Pump PlacePump(Pump p){
        System.out.println("Field::PlacePump()");
        return p;
    }




}