package hu.bomboclat.Game;

import java.util.ArrayList;
import java.util.List;


/**
 * A csőhálózat csomópontjait reprezentáló osztály.
 */
public abstract class Node extends Field implements Stepable{
    /**
     * A csomópontba befutó csövek. 
     */
    protected List<Pipe> edges;

    /**
     * Node konstruktora. 
     */
    protected Node(){
        edges=new ArrayList<>();
    }

    /**
     * Visszaadja az adott irányba lévő szomszédját. 
     * @param d Irány, amelyből a szomszédot lekérik.
     * @return Az adott irányból a szomszédos mező, vagy ha az adott irányba nincs érvényes mező, nullt ad vissza.
     */
     public Field getNeighbour(int d){
        return edges.get(d).has_player ? null : edges.get(d);
     }

    /**
     * Absztrakt függvény, nincs implementálva.
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     * public abstract void Step(boolean rnd) ez volt a függvény, sonarlint kitöröltette.
     */

    /**
     * Összeszámolja a szerelők pontját a városba folyt 
     * vízmennyiség alapján, ha városra hívódik meg, egyébként nem csinál semmit, elnyeli a hívást.
     * @return Az összeadott pontok száma, null ha olyan objektumra hívják meg ami nem definiálta felül a függvényt.
     */
    public int getMechanicPoint(){
        return 0;
    }

    /**
     * A leszármazottakban van felüldefiniálva abban az esetben ha lehet belőlük felvenni csövet.
     * @param m mechanic típusú játékos, aki az adott node(leszármazottan) áll.
     * @return a felvett cső
     */
    @Override
    public Pipe PickUpPipe(Mechanic m){
        return null;
    }

    /**
     * A leszármazottakban van felüldefiniálva abban az esetben ha lehet rájuk letenni/hozzájuk adni csövet.
     * @param m a mechanic típusú játékos, aki leteszi a kezéből a csövet.
     */
    @Override
    public void PlacePipe(Mechanic m){
        return;
    }

    /**
     * Hozzáaadja az paraméterként kapott csövet az edges listához (a szomszédaihoz).
     * @param p Az paraméterként kapott cső.
     */
    @Override
    public void addEdge(Pipe p){
        edges.add(p);
    }

    /**
     * Eltávolítja a paraméterként kapott csövet az edges listából (a szomszédaiból).
     * @param p A paraméterként kapott cső.
     */
    public void removeEdge(Pipe p){
        edges.remove(p);
    }

    /**
     * A szomszédok számát adja vissza
     * @return Hány szomszédja van a csomópontnak
     */
    public int getNeighbourCount(){
        return edges.size();
    }
}
