package Game;

import java.util.ArrayList;
import java.util.List;
import skeleton.*;


/**
 * A csövet reprezentáló osztály
 */
public class Pipe extends Field implements Stepable{
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
    //Mikor lyukaszható újra
    int hole_timer;
    //Csúszós-e a cső
    boolean slippery;
    //Ragadós-e a cső
    boolean sticky;

    /**
     * Pipe konstruktor
     */
    public Pipe(){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Pipe has been initialized");
        has_hole = false;
        has_water = false;
        lost = 0;
        has_player = false;
        endpoints = new ArrayList<Node>(2);
        endpoints.add(null);
        endpoints.add(null);
        TesterMain.tabCount--;
    }

    /**
     * A cső adott irányba lévő végét adja vissza
     * @param direction Az adott irány
     * @return Szomszéd az adott irányba
     */
    public Field getNeighbour(int direction) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::getNeighbour()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
        return endpoints.get(direction);
    }

    /**
     * Megjavítja a csövet, eltüntei róla a lyukat
     */
    public void Fix() {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::Fix()");
        TesterMain.tabCount++;
        has_hole = false;
        TesterMain.tabCount--;
    }

    /**
     * Kilyukasztja a csövet
     */
    public void Drill() {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::Drill()");
        TesterMain.tabCount++;
        has_hole = true;
        TesterMain.tabCount--;
    }
    
    /** 
     * Vizet ad a csőnek
     * @param amount Az átadott víz mennyisége
     */
    public void GiveWater(int amount) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::GiveWater()");
        TesterMain.tabCount++;
        lost += has_hole ? 1 : 0;
        has_water = !has_hole;
        TesterMain.tabCount--;
    }

    
    /** 
     * Elveszi a csőből a vizet
     * @return int A kivett víz mennyisége
     */
    public int TakeWaterAway() {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::TakeWaterAway()");
        TesterMain.tabCount++;
        int ret = has_water ? 1 : 0;
        has_water = false;
        TesterMain.tabCount--;
        return ret;
    }

    /**
     * Megnöveli az elfolyt víz mennyiségét. 
     */
    public void addLost() {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::addLost()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    
    /** 
     * Elfogad a mezőre egy játékost amennyiben van a csövön hely
     * @param c Az elfogadandó játékos
     */
    public void Accept(Character c) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::Accept()");
        TesterMain.tabCount++;
        if(!has_player) {
            c.setField(this);
            has_player = true;
        }
        TesterMain.tabCount--;
    }

    /**
     * Leveszi a játékost aki éppen a csövön áll
     * @param c A levetendő játékos
     */
    public void Remove(Character c) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::Remove()");
        TesterMain.tabCount++;
        has_player = false;
        players.remove(c);
        TesterMain.tabCount--;
    }

    /**
     * Lehelyezünk egy pumpát az adott csőszakaszra.
     * @param p  A lehelyezendő pumpa.
     * @return  Sikeres lehelyezés esetén null, egyébként a pumpa
     */
    public Pump PlacePump(Pump p) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::PlacePump()");
        TesterMain.tabCount++;
        Pipe p2 = new Pipe();
        p2.setEndpoint(p, 0);
        p2.setEndpoint(this.getEndpoint(1), 1);
        this.getEndpoint(1).removeEdge(this);
        this.setEndpoint(p, 1);
        TesterMain.tabCount--;
        return p;
    }

    /**
     * Beállítja az elfolyt víz mennyiségét
     * @param l  A beállítandó érték
     */
    public void setLost(int l) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::setLost()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
        lost = l;
    }

    /**
     * Átállítja a cső egyik végpontját
     * @param n Az új végpont
     * @param d Az átállítandó végpont indexe (0 vagy 1)
     */
    public void setEndpoint(Node n, int d) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::setEndpoint()");
        TesterMain.tabCount++;
        if(d == 0 || d == 1){
            n.addEdge(this);
            endpoints.remove(d);
            endpoints.add(d,n);
        }
        TesterMain.tabCount--;
    }

    /**
     * Visszaadja az eddig elfolyt víz mennyiségét
     * @return Az eddig elfolyt víz mennyisége
     */
    public int getLost() {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::getLost()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
        return lost;
    }

    /**
     * Megadja a cső egyik végpontját az adott irányba
     * @param d Az adott irány (0 vagy 1)
     * @return A végpont az adott irányba
     */
    public Node getEndpoint(int d) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        System.out.println("Pipe::getEndpoint()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
        return endpoints.get(d);
    }


    /**
     * Visszaadja, hogy csúszós-e a cső
     * @return Igaz, ha csúszós, hamis, ha nem
     */
    public boolean getSlippery(){
        return slippery;
    }

    /**
     * Beállítja, hogy csúszós-e vagy nem a cső
     * @param nSlippery Az új érték: igaz, ha csúszóssá szeretnénk tenni a csövet, hamis ha nem
     */
    public void setSlippery(boolean nSlippery){
        slippery = nSlippery;
    }

    /**
     * Visszaadja, hogy ragadós-e a cső
     * @return Igaz, ha ragadós, hamis, ha nem
     */
    public boolean getSticky(){
        return sticky;
    }

    /**
     * Beállítja, hogy ragadós-e vagy nem a cső
     * @param nSlippery Az új érték: igaz, ha ragadóssá szeretnénk tenni a csövet, hamis ha nem
     */
    public void setSticky(boolean nSticky){
        sticky = nSticky;
    }

    public void Glue(){

    }

    public void Lube(){
        
    }

    @Override
    public void Step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Step'");
    }

    int getNeighbourCount(){
        return 2;
    }
}