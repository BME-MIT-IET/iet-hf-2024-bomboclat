package Game;
import skeleton.*;


/**
 * A ciszternát reprezentáló osztály.
 */
public class City extends Node{
    /**
     * A városba (más néven ciszternába) befolyt víz mennyisége. A szerelők pontszámát reprezentálja
     */
    private int consumed;
    /**
     * City konstruktora.
     */
    public City(){
        consumed=0;
    }

    /**
     * Összeadja a rákötött csöveken beérkező vízmennyiséget.
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     */
    public void Step(boolean rnd) {
        int sum = 0;
        for(int i=0; i < this.edges.size(); i++) {
            sum += this.edges.get(i).TakeWaterAway();
        }
        consumed += sum;
    }

    /**
     * Visszaadja, hogy hány pontja van a szerelőknek vagyis a consumed értékét.
     * @return A szerelők pontjai, a consumed tagváltozó értéke.
     */
    public int getMechanicPoint(){
        return consumed;
    }

    /** regi fv
     * A városból egy, onnan kivezető cső nem ciszterna felőli végét lehet felvenni ezzel a függvénnyel.
     * @param m a csövet felvenni kívánó szerelő játékos.
     * @return A függvény a felvett cső objektumot adja vissza.
     */
    public Pipe PickUpPipe(Mechanic m){
        Pipe returnPipe = new Pipe();
        returnPipe.setEndpoint(this, 0);

        m.SetPipeEnd(1);
        return returnPipe;
    }

    
    /**
     * A városból új pumpákat tudnak felvenni ezzel a függvénnyel.
     * @return A függvény a felvett pumpa objektumot adja vissza.
     */
    public Pump PickUpPump() {
        Pump p = new Pump();
        return p;
    }


}
