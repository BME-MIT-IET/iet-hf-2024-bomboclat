package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Graphics.*;


/**
 * A csövet reprezentáló osztály
 */
public class Pipe extends Field implements Stepable{
    //A cső végpontjait számontartó lista. Egy időpillanatban maximum 2 db eleme lehet.
    List<Node> endpoints;
    //Azt tárolja, hogy lyukas-e a cső.
    boolean has_hole;
    //Azt tárolja, hogy jelenleg van-e víz a csőben.
    boolean has_water;
    //A körök során elfolyt víz mennyiségét tárolja az adott csőre.
    int lost;
    //Azt tárolja, hogy tartózkodik-e éppen játékos a csövön.
    boolean has_player;
    //Azt tárolja, hogy még hány körig nem lehet lyukasztani a csövet.
    int hole_timer;
    //Azt tárolja, hogy csúszós-e a cső.
    boolean slippery;
    //Azt tárolja, hogy ragadós-e a cső.
    boolean sticky;
    //Megjelenítését kezelő View objektum.
    PipeView pipeView;

    /**
     * Pipe konstruktora.
     */
    public Pipe(){
        has_hole = false;
        has_water = false;
        lost = 0;
        has_player = false;
        endpoints = new ArrayList<Node>(2);
        endpoints.add(null);
        endpoints.add(null);
        pipeView = new PipeView(this);
    }

    /**
     * Ha a cső nem csúszós, abban az esetben
     * visszaadja az endpoints adattag direction indexű elemét. Hogyha csúszós, úgy
     * véletlenszerűen az egyik végpontját adja vissza. Hogyha ragadós saját magát. Illetve a
     * megfelelő flageket beállítja.
     * @param direction Az adott irány.
     * @return Ha nem csúszós és nem is ragadós, akkor az endpoints adattag direction indexű elemét, 
     * más esetekben pedig a fentebb említett szabályok szerint ad vissza egy adott objektumot.
     */
    public Field getNeighbour(int direction) {
        if(direction>=2){
            return null;
        }else if(!sticky && !slippery){
            return endpoints.get(direction);
        }else if(slippery){
            int rnd = new Random().nextInt(2);
            slippery = false;
            return endpoints.get(rnd);
        }else if(sticky){
            sticky = false;
            return this;
        }
        return this;
    }

    /**
     * Megjavítja a csövet, eltünteti róla a lyukat.
     */
    public boolean Fix() {
        if(has_hole)
        {
            has_hole = false;
            return true;
        }
        return false;
    }

    /**
     * Kilyukasztja a csövet amennyiben a hole_timer attribútum az 0. És a
     * hole_timer beállítja egy véletlen számra 3-ig (ennyi körig nem lehet kilyukasztani
     * megint a csövet.). Ha determinisztikusan működik, akkor nem random ideig nem lehet kilyukasztani
     * a csövet, hanem 2 körig.
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     */
    public boolean Drill(boolean rnd) {
        if(hole_timer == 0){
            if(rnd){
                hole_timer = new Random().nextInt(3)+1;
            }else{
                hole_timer = 2;
            }
            has_hole = true;
            return true;
        }
        return false;
    }
    
    /** 
     * A csőre a paraméterben megadott mennyiségű víz érkezik. Ha ez a
     * mennyiség nagyobb, mint 0 akkor a has_water attribútumot igazra állítjuk, valamint ha
     * lyukas a cső akkor az a víz elfolyik tehát a lost értékét növeli.
     * @param amount Az átadott víz mennyisége
     */
    public void GiveWater(int amount) {
        if(amount > 0){
            if(!has_hole){
                has_water = true;
            }else{
                lost+=amount;
            }
        }
    }

    
    /** 
     * Kivesszük a csőből a vizet, amennyiben van benne.
     * @return int A kivett víz mennyisége
     */
    public int TakeWaterAway() {
        int ret = has_water ? 1 : 0;
        has_water = false;
        return ret;
    }
    
    /** 
     * Meghívja az ősosztály Accept függvényét, majd
     * beállítja a has_player attribútumot igazra. Ráálítja a 
     * játékost a csőre, ha nem állnak már rajta.
     * @param c A játékost, amelyet rá szeretnének állítani a csőre.
     */
    public void Accept(Character c) {
        if(!has_player) {
            has_player = true;
            super.Accept(c);
        }
    }

    /**
     * Meghívja az ősosztály Remove függvényét, majd
     * beállítja a has_player attribútumot hamisra.
     * Leveszi a játékost aki éppen a csövön áll.
     * @param c A levetendő játékos.
     */
    public void Remove(Character c) {
        has_player = false;
        super.Remove(c);
    }

    /**
     * Lehelyezünk egy pumpát az adott csőszakaszra egy új cső létrehozásával.
     * @param p  A lehelyezendő pumpa.
     * @return  Sikeres lehelyezés esetén null, egyébként a pumpa.
     */
    public Pump PlacePump(Pump p) {
        Pipe p2 = new Pipe();
        p2.setEndpoint(p, 0);
        if(this.getEndpoint(1)!=null){
            p2.setEndpoint(this.getEndpoint(1), 1);
            this.getEndpoint(1).removeEdge(this);
        }        
        this.setEndpoint(p, 1);
        return null;
    }

    /**
     * Beállítja az elfolyt víz mennyiségét a paraméterben megadott értékre.
     * @param l  A beállítandó érték.
     */
    public void setLost(int l) {
        lost = l;
    }

    /**
     * Beállítja a cső egyik végpontját. Amennyiben d
     * 0 vagy 1, úgy a d-re meghívja az addEdge függvényt saját magát átadva
     * paraméterként. Az endpoints listában a d indexű elemet kicseréli n-re.
     * @param n Az új végpont.
     * @param d Az átállítandó végpont indexe (0 vagy 1).
     */
    public void setEndpoint(Node n, int d) {
        if(d<endpoints.size()){
            n.addEdge(this);
            endpoints.remove(d);
            endpoints.add(d,n);
        }
        else {
            n.addEdge(this);
            endpoints.add(d,n);
        }
    }

    /**
     * Visszaadja az eddig elfolyt víz mennyiségét
     * @return Az eddig elfolyt víz mennyisége
     */
    public int getLost() {
        return lost;
    }

    /**
     * Megmondja, hogy d irányban milyen vége van a csőnek, ha a d 0 vagy 1.
     * Egyéb esetben null-t ad vissza.
     * @param d Az adott irány (0 vagy 1).
     * @return A végpont az adott irányba.
     */
    public Node getEndpoint(int d) {
        if(d<endpoints.size()){
            return endpoints.get(d);
        }
        return null;
    }


    /**
     * Visszaadja, hogy csúszós-e a cső.
     * @return Igaz, ha csúszós, hamis, ha nem.
     */
    public boolean getSlippery(){
        return slippery;
    }

    /**
     * Beállítja, hogy csúszós-e vagy nem a cső.
     * @param nSlippery Az új érték: igaz, ha csúszóssá szeretnénk tenni a csövet, hamis ha nem.
     */
    public void setSlippery(boolean nSlippery){
        slippery = nSlippery;
    }

    /**
     * Visszaadja, hogy ragadós-e a cső.
     * @return Igaz, ha ragadós, hamis, ha nem.
     */
    public boolean getSticky(){
        return sticky;
    }

    /**
     * Beállítja, hogy ragadós-e vagy nem a cső.
     * @param nSticky Az új érték: igaz, ha ragadóssá szeretnénk tenni a csövet, hamis ha nem.
     */
    public void setSticky(boolean nSticky){
        sticky = nSticky;
    }

    /**
     * Beragasztózza a csövet. A sticky értékét true-ra állítja.
     */
    public boolean Glue(){
        if(this.getEndpoint(0)!=null){
            players.get(0).Move(0);
        }else if(this.getEndpoint(1)!=null){
            players.get(0).Move(1);
        }
        sticky = true;
        return true;
    }

    /**
     * Csúszóssá teszi a csövet. A slippery értékét true-ra állítja.
     */
    public boolean Lube(){
        if(this.getEndpoint(0)!=null){
            players.get(0).Move(0);
        }else if(this.getEndpoint(1)!=null){
            players.get(0).Move(1);
        }
        slippery = true;
        return true;
    }

    /**
     * A Pipe osztály Step függvénye. Csökkenti a hole_timer attribútum értékét,
     * ha az nem 0.
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     */
    public void Step(boolean rnd) {
        if(hole_timer > 0){
            hole_timer--;
        }
    }

    /**
     * A szomszédok számát adja vissza
     * @return 2, mivel egy csőnek mindig 2 vége van
     */
    public int getNeighbourCount(){
        return 2;
    }

    /**
     * Visszaadja azt a PipeView objektumot, ami felelős a megjelenítéséért.
     */
    public PipeView getView(){
        return pipeView;
    }

    /**
     * Beállítja v objektumra a pipeView attribútumot.
     * @param v
     */
    public void setView(IView v){
        pipeView= (PipeView) v;
    }

    public boolean getHasWater(){
        return has_water;
    }

    public boolean getHasHole(){
        return has_hole;
    }

    public void setHasWater(boolean t){
        has_water = t;
    }
}