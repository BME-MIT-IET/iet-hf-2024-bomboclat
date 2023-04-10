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
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        Main.tabCount++;
        System.out.println("Pipe has been initialized");
        has_hole = false;
        has_water = false;
        lost = 0;
        has_player = false;
        endpoints = new ArrayList<Node>(2);
        Main.tabCount--;
    }

    /**
     * A cső adott irányba lévő végét adja vissza
     * @param direction Az adott irány
     * @return Szomszéd az adott irányba
     */
    public Field getNeighbour(int direction) {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::getNeighbour()");
        Main.tabCount++;
        Main.tabCount--;
        return endpoints.get(direction);
    }

    /**
     * Megjavítja a csövet, eltüntei róla a lyukat
     */
    public void Fix() {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::Fix()");
        Main.tabCount++;
        Main.tabCount--;
    }

    /**
     * Kilyukasztja a csövet
     */
    public void Drill() {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::Drill()");
        Main.tabCount++;
        Main.tabCount--;
    }

    /**
     * A Pipe step függvénye
     */
    public void Step() {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::Step()");
        Main.tabCount++;
        Main.tabCount--;
    }
    
    /** 
     * Vizet ad a csőnek
     * @param amount Az átadott víz mennyisége
     */
    public void GiveWater(int amount) {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::GiveWater()");
        Main.tabCount++;
        Main.tabCount--;
    }

    
    /** 
     * Elveszi a csőből a vizet
     * @return int A kivett víz mennyisége
     */
    public int TakeWaterAway() {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::TakeWaterAway()");
        Main.tabCount++;
        int ret = has_water ? 1 : 0;
        has_water = false;
        Main.tabCount--;
        return ret;
    }

    /**
     * Megnöveli az elfolyt víz mennyiségét. 
     */
    public void addLost() {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::addLost()");
        Main.tabCount++;
        Main.tabCount--;
    }

    
    /** 
     * Elfogad a mezőre egy játékost amennyiben van a csövön hely
     * @param c Az elfogadandó játékos
     */
    public void Accept(Character c) {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::Accept()");
        Main.tabCount++;
        Main.tabCount--;
    }

    /**
     * Leveszi a játékost aki éppen a csövön áll
     * @param c A levetendő játékos
     */
    public void Remove(Character c) {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::Remove()");
        Main.tabCount++;
        Main.tabCount--;
    }

    /**
     * Lehelyezünk egy pumpát az adott csőszakaszra.
     * @param p  A lehelyezendő pumpa.
     * @return  Sikeres lehelyezés esetén null, egyébként a pumpa
     */
    public Pump PlacePump(Pump p) {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::PlacePump()");
        Main.tabCount++;
        Main.tabCount--;
        return p;
    }

    /**
     * Beállítja az elfolyt víz mennyiségét
     * @param l  A beállítandó érték
     */
    public void setLost(int l) {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::setLost()");
        Main.tabCount++;
        Main.tabCount--;
        lost = l;
    }

    /**
     * Átállítja a cső egyik végpontját
     * @param n Az új végpont
     * @param d Az átállítandó végpont indexe (0 vagy 1)
     */
    public void setEndpoint(Node n, int d) {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::setEndpoint()");
        Main.tabCount++;
        if(d == 0 || d == 1){
            n.addEdge(this);
            endpoints.remove(d);
            endpoints.add(d,n);
        }
        Main.tabCount--;
    }

    /**
     * Visszaadja az eddig elfolyt víz mennyiségét
     * @return Az eddig elfolyt víz mennyisége
     */
    public int getLost() {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::getLost()");
        Main.tabCount++;
        Main.tabCount--;
        return lost;
    }

    /**
     * Megadja a cső egyik végpontját az adott irányba
     * @param d Az adott irány (0 vagy 1)
     * @return A végpont az adott irányba
     */
    public Node getEndpoint(int d) {
        for(int i = 0; i <= Main.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::getEndpoint()");
        Main.tabCount++;
        Main.tabCount--;
        return endpoints.get(d);
    }
}