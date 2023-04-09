import java.util.ArrayList;
import java.util.List;

/**
 * A csövet reprezentáló osztály
 */
public class Pipe extends Field{
    //A cső végpontjai
    List<Node> endpoints;
    //Lyukas-e a cső
    boolean has_hole;
    //Van-e víz a csőben
    boolean has_water;
    //Elfolyt víz mennyisége
    int lost;
    //Áll-e a rajta játékos
    boolean has_player;

    /**
     * Pipe konstruktor
     */
    public Pipe(){
        System.out.println("Pipe has been initialized");
        has_hole = false;
        has_water = false;
        lost = 0;
        has_player = false;
        endpoints = new ArrayList<Node>(2);
    }

    /**
     * A cső adott irányba lévő végét adja vissza
     * @param direction Az adott irány
     * @return Szomszéd az adott irányba
     */
    public Field getNeighbour(int direction) {
        System.out.println("Pipe::getNeighbour()");
        return endpoints.get(direction);
    }

    /**
     * Megjavítja a csövet, eltüntei róla a lyukat
     */
    public void Fix() {
        System.out.println("Pipe::Fix()");
    }

    /**
     * Kilyukasztja a csövet
     */
    public void Drill() {
        System.out.println("Pipe::Drill()");
    }

    /**
     * A Pipe step függvénye
     */
    public void Step() {
        System.out.println("Pipe::Step()");
    }
    
    /** 
     * Vizet ad a csőnek
     * @param amount Az átadott víz mennyisége
     */
    public void GiveWater(int amount) {
        System.out.println("Pipe::GiveWater()");
    }

    
    /** 
     * Elveszi a csőből a vizet
     * @return int A kivett víz mennyisége
     */
    public int TakeWaterAway() {
        System.out.println("Pipe::TakeWaterAway()");
        int ret = has_water ? 1 : 0;
        has_water = false;
        return ret;
    }

    /**
     * Megnöveli az elfolyt víz mennyiségét. 
     */
    public void addLost() {
        System.out.println("Pipe::addLost()");
    }

    
    /** 
     * Elfogad a mezőre egy játékost amennyiben van a csövön hely
     * @param c Az elfogadandó játékos
     */
    public void Accept(Character c) {
        System.out.println("Pipe::Accept()");
    }

    /**
     * Leveszi a játékost aki éppen a csövön áll
     * @param c A levetendő játékos
     */
    public void Remove(Character c) {
        System.out.println("Pipe::Remove()");
    }

    /**
     * Lehelyezünk egy pumpát az adott csőszakaszra.
     * @param p  A lehelyezendő pumpa.
     * @return  Sikeres lehelyezés esetén null, egyébként a pumpa
     */
    public Pump PlacePump(Pump p) {
        System.out.println("Pipe::PlacePump()");
        return p;
    }

    /**
     * Beállítja az elfolyt víz mennyiségét
     * @param l  A beállítandó érték
     */
    public void setLost(int l) {
        System.out.println("Pipe::setLost()");
        lost = l;
    }

    /**
     * Átállítja a cső egyik végpontját
     * @param n Az új végpont
     * @param d Az átállítandó végpont indexe (0 vagy 1)
     */
    public void setEndpoint(Node n, int d) {
        System.out.println("Pipe::setEndpoint()");
        if(d == 0 || d == 1){
            n.addEdge(this);
            endpoints.remove(d);
            endpoints.add(d,n);
        }
    }

    /**
     * Visszaadja az eddig elfolyt víz mennyiségét
     * @return Az eddig elfolyt víz mennyisége
     */
    public int getLost() {
        System.out.println("Pipe::getLost()");
        return lost;
    }

    /**
     * Megadja a cső egyik végpontját az adott irányba
     * @param d Az adott irány (0 vagy 1)
     * @return A végpont az adott irányba
     */
    public Node getEndpoint(int d) {
        System.out.println("Pipe::getEndpoint()");
        return endpoints.get(d);
    }
}