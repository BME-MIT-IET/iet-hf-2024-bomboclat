import java.util.List;

abstract public class Field{
    /**Az adott mezőn álló játékosok. */
    protected List<Character> players;
    
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
    public void Remove(Character c){}

    /**
     * Felveszi a paraméterben kapott karaktert a mezőre.
     * @param c Karakter objektum, amelyet fel akarnak vetetni a mezőre.
     */
    public void Accept(Character c){}

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     */
    public void Fix(){}

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     */
    public void Drill(){}

    /**
     * Nem csinál semmit, elnyeli a hívást, ha olyan objektumra hívják, aminek nincsen ez a függvénye felüldefiniálva.
     * @param p Az a cső, amelyet bementi csőként kell beállítani.
     * @param d Az a cső, amelyet kimeneti csőként kell beállítani.
     */
    public void Change(Pipe o, Pipe d){}

    /**
     * 
     * @return
     */
    public Pipe PickUpPipe(){}

    /**
     * 
     * @return
     */
    public Pump PickUpPump(){}

    /**
     * 
     */
    public void PlacePipe(){}

    /**
     * 
     * @param d
     * @return
     */
    public Node getEndpoint(int d){}

    /**
     * 
     * @param p
     */
    public void addEdge(Pipe p){}

    /**
     * 
     * @param p 
     * @return
     */
    public Pump PlacePump(Pump p){}




}