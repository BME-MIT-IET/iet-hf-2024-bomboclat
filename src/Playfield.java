import java.util.List;
import java.util.ArrayList;

/**
 * A játékmezőt tárolja, ilyen objektumokban lehet pályákat tárolni.
 */
public class Playfield implements Stepable{

    //a játékban a csúcspontként tárolt elemeket tárolja, ezekből felépíthető minden pálya, hiszen a csúcsok ismerik az éleiket.
    List<Node> nodes;
    //Az előbb említett csúcspontokhoz tartozó éleket, azaz a csöveket tároló változó.
    List<Pipe> pipes;


    /**
     * Playfield konstruktor
     */
    public Playfield(){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Playfield has been initialized");
        Main.tabCount++;
        nodes = new ArrayList<Node>();
        pipes = new ArrayList<Pipe>();
        Main.tabCount--;
    }

    /**
     * A Stepable interface Step() függvényének az implementációja.
     * Lépteti az összes játémezőt/meghívja a Step() függvényüket.
     */
    @Override
    public void Step() {
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Playfield::Step()");
        Main.tabCount++;
        for(int i = 0; i < nodes.size(); i++){
            nodes.get(i).Step();
        }
        Main.tabCount--;
    }
    
    /**
     * Hozzáad egy csomópontot a játékmezőhöz.
     * @param n a hozzáadandó csomópont
     */
    public void addNode(Node n){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Playfield::addNode()");
        Main.tabCount++;
        nodes.add(n);
        Main.tabCount--;
    }

    /**
     * Levesz egy csomópontot a játékmezőről.
     * @param n a törlendő csomopónt
     */
    public void deleteNode(Node n){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Playfield::deleteNode()");
        Main.tabCount++;
        nodes.remove(n);
        Main.tabCount--;
    }

    /**
     * Hozzáad egy csövet a játékmezőhöz.
     * @param p a hozzáadandó cső
     */
    public void addPipe(Pipe p){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Playfield::addPipe()");
        Main.tabCount++;
        pipes.add(p);
        Main.tabCount--;
    }

    /**
     * Levesz egy csövet a játékmezőről.
     * @param p a törlendő cső
     */
    public void deletePipe(Pipe p){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Playfield::deletePipe()");
        Main.tabCount++;
        pipes.remove(p);
        Main.tabCount--;
    }

    /***
     * Összeszámolja a szerelők/mechanic-ek által megszerzett pontokat
     * @return int a megszerzett pontok száma
     */
    public int getMechanicPoints(){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Playfield::getMechanicPoints()");
        Main.tabCount++;
        int count = 0;
        for(int i = 0; i < nodes.size(); i++){
            count += nodes.get(i).getMechanicPoint();
        }
        Main.tabCount--;
        return count;
    }

    /**
     * Összeszámolja a nomádok által megszerzett pontokat
     * @return int a megszerzett pontok száma
     */
    public int getNomadPoints(){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Playfield::getNomadPoints()");
        Main.tabCount++;
        int count = 0;
        for(int i = 0; i < pipes.size(); i++){
            count += pipes.get(i).getLost();
        }
        Main.tabCount--;
        return count;
    }

}
