import java.util.List;

abstract public class Node extends Field implements Stepable{
    /**A csomópontba befutó csövek. */
    protected List<Pipe> edges;

    /**
     * Visszaadja az adott irányba lévő szomszédját. 
     * @param d Irány, amelyből a szomszédot lekérik.
     * @return Az adott irányból a szomszédos mező, vagy ha az adott irányba nincs érvényes mező, nullt ad vissza.
     */
     public Field getNeighbour(int d){}

    /**
     * Absztrakt függvény, nincs implementálva.
     */
    public abstract void Step();

    /**
     * Összeszámolja a szerelők pontját a városba folyt 
     * vízmennyiség alapján, ha városra hívódik meg, egyébként nem csinál semmit.
     * @return Az összeadott pontok száma.
     */
    public int getMechanicPoint(){}

    /**
     * Hozzáaadja az adott csövet az edges listához (a szomszédaihoz).
     * @param p Az adott cső.
     */
    public void addEdge(Pipe p){}

    /**
     * Eltávolítja az adott csövet az edges listából (a szomszédaiból).
     * @param p Az adott cső.
     */
    public void removeEdge(Pipe p){}




}
