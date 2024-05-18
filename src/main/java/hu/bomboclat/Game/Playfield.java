package hu.bomboclat.Game;


import java.util.List;
import java.util.ArrayList;


/**
 * A játékmezőt tárolja, ilyen objektumokban lehet pályákat tárolni.
 */
public class Playfield implements Stepable{

    /**
     * A játékban a csúcspontként tárolt elemeket tárolja, ezekből felépíthető minden pálya, hiszen a csúcsok ismerik az éleiket.
     */
    List<Node> nodes;
    /**
     * Az előbb említett csúcspontokhoz tartozó éleket, azaz a csöveket tároló változó.
     */
    List<Pipe> pipes;


    /**
     * Playfield konstruktor
     */
    public Playfield(){
        nodes = new ArrayList<>();
        pipes = new ArrayList<>();
    }
    // random comment

    /**
     * A Stepable interface Step() függvényének az implementációja.
     * Lépteti az összes játémezőt/meghívja a Step() függvényüket.
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     */
    @Override
    public void Step(boolean rnd) {
        for(int i = 0; i < nodes.size(); i++){
            nodes.get(i).Step(rnd);
        }
        for(int i = 0; i<pipes.size(); i++) {
            pipes.get(i).Step(rnd);
        }
    }
    
    /**
     * Hozzáad egy csomópontot a játékmezőhöz.
     * @param n a hozzáadandó csomópont
     */
    public void addNode(Node n){
        nodes.add(n);
    }

    /**
     * Levesz egy csomópontot a játékmezőről.
     * @param n a törlendő csomopónt
     */
    public void deleteNode(Node n){
        nodes.remove(n);
    }

    /**
     * Hozzáad egy csövet a játékmezőhöz.
     * @param p a hozzáadandó cső
     */
    public void addPipe(Pipe p){
        pipes.add(p);
    }

    /**
     * Levesz egy csövet a játékmezőről.
     * @param p a törlendő cső
     */
    public void deletePipe(Pipe p){
        pipes.remove(p);
    }

    /***
     * Összeszámolja a szerelők/mechanic-ek által megszerzett pontokat
     * @return int a megszerzett pontok száma
     */
    public int getMechanicPoints(){
        int count = 0;
        for(int i = 0; i < nodes.size(); i++){
            count += nodes.get(i).getMechanicPoint();
        }
        return count;
    }

    /**
     * Összeszámolja a nomádok által megszerzett pontokat
     * @return int a megszerzett pontok száma
     */
    public int getNomadPoints(){
        int count = 0;
        for(int i = 0; i < pipes.size(); i++){
            count += pipes.get(i).getLost();
        }
        return count;
    }

    public List<Node> getNodes(){
        return nodes;
    }

    public List<Pipe> getPipes(){
        return pipes;
    }

}
