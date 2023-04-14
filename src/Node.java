import java.util.ArrayList;
import java.util.List;

/**
 * A csőhálózat csomópontjait reprezentáló osztály.
 */
abstract public class Node extends Field implements Stepable{
    /**A csomópontba befutó csövek. */
    protected List<Pipe> edges;

    /**Node konstruktora. */
    public Node(){
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Node has been initialized");
        Main.tabCount++;
        edges=new ArrayList<>();
        Main.tabCount--;
    }

    /**
     * Visszaadja az adott irányba lévő szomszédját. 
     * @param d Irány, amelyből a szomszédot lekérik.
     * @return Az adott irányból a szomszédos mező, vagy ha az adott irányba nincs érvényes mező, nullt ad vissza.
     */
     public Field getNeighbour(int d){
         for(int i=0; i < Main.tabCount; i++) {
             System.out.print("\t");
         }
        System.out.println("Node::getNeighbour()");
         Main.tabCount++;
         Main.tabCount--;
        return edges.get(d).has_player == true ? null : edges.get(d);
     }

    /**
     * Absztrakt függvény, nincs implementálva.
     */
    public abstract void Step();

    /**
     * Összeszámolja a szerelők pontját a városba folyt 
     * vízmennyiség alapján, ha városra hívódik meg, egyébként nem csinál semmit, elnyeli a hívást.
     * @return Az összeadott pontok száma, null ha olyan objektumra hívják meg ami nem definiálta felül a függvényt.
     */
    public int getMechanicPoint(){
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Node::getMechanicPoint()");
        Main.tabCount++;
        Main.tabCount--;
        return 0;
    }

    /**
     * Hozzáaadja az paraméterként kapott csövet az edges listához (a szomszédaihoz).
     * @param p Az paraméterként kapott cső.
     */
    public void addEdge(Pipe p){
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Node::addEdge()");
        edges.add(p);
        Main.tabCount++;
        Main.tabCount--;
    }

    /**
     * Eltávolítja a paraméterként kapott csövet az edges listából (a szomszédaiból).
     * @param p A paraméterként kapott cső.
     */
    public void removeEdge(Pipe p){
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Node::removeEdge()");
        edges.remove(p);
        Main.tabCount++;
        Main.tabCount--;
    }

}
