package Game;

import java.util.ArrayList;
import java.util.List;
import skeleton.*;


/**
 * A csőhálózat csomópontjait reprezentáló osztály.
 */
abstract public class Node extends Field implements Stepable{
    /**A csomópontba befutó csövek. */
    protected List<Pipe> edges;

    /**Node konstruktora. */
    public Node(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Node has been initialized");
        TesterMain.tabCount++;
        edges=new ArrayList<>();
        TesterMain.tabCount--;
    }

    /**
     * Visszaadja az adott irányba lévő szomszédját. 
     * @param d Irány, amelyből a szomszédot lekérik.
     * @return Az adott irányból a szomszédos mező, vagy ha az adott irányba nincs érvényes mező, nullt ad vissza.
     */
     public Field getNeighbour(int d){
         for(int i=0; i < TesterMain.tabCount; i++) {
             System.out.print("\t");
         }
        System.out.println("Node::getNeighbour()");
         TesterMain.tabCount++;
         TesterMain.tabCount--;
        return edges.get(d).has_player == true ? null : edges.get(d);
     }

    /**
     * Absztrakt függvény, nincs implementálva.
     */
    public abstract void Step(boolean rnd);

    /**
     * Összeszámolja a szerelők pontját a városba folyt 
     * vízmennyiség alapján, ha városra hívódik meg, egyébként nem csinál semmit, elnyeli a hívást.
     * @return Az összeadott pontok száma, null ha olyan objektumra hívják meg ami nem definiálta felül a függvényt.
     */
    public int getMechanicPoint(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Node::getMechanicPoint()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
        return 0;
    }

    /**
     * A leszármazottakban van felüldefiniálva abban az esetben ha lehet belőlük felvenni csövet.
     * @param m mechanic típusú játékos, aki az adott node(leszármazottan) áll.
     * @return a felvett cső
     */
    public Pipe PickUpPipe(Mechanic m){
        return null;
    }

    /**
     * A leszármazottakban van felüldefiniálva abban az esetben ha lehet rájuk letenni/hozzájuk adni csövet.
     * @param m a mechanic típusú játékos, aki leteszi a kezéből a csövet.
     */
    public void PlacePipe(Mechanic m){
        return;
    }

    /**
     * Hozzáaadja az paraméterként kapott csövet az edges listához (a szomszédaihoz).
     * @param p Az paraméterként kapott cső.
     */
    public void addEdge(Pipe p){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Node::addEdge()");
        edges.add(p);
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    /**
     * Eltávolítja a paraméterként kapott csövet az edges listából (a szomszédaiból).
     * @param p A paraméterként kapott cső.
     */
    public void removeEdge(Pipe p){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Node::removeEdge()");
        edges.remove(p);
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    public int getNeighbourCount(){
        return edges.size();
    }
}
