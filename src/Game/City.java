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
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("City has been initialized");
        TesterMain.tabCount++;
        consumed=0;
        TesterMain.tabCount--;
    }

    /**
     * Összeadja a rákötött csöveken beérkező vízmennyiséget.
     */
    public void Step() {
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("City::Step()");
        TesterMain.tabCount++;
        int sum = 0;
        for(int i=0; i < this.edges.size(); i++) {
            sum += this.edges.get(i).TakeWaterAway();
        }
        consumed += sum;
        TesterMain.tabCount--;
    }

    /**
     * Visszaadja, hogy hány pontja van a szerelőknek vagyis a consumed értékét.
     * @return A szerelők pontjai, a consumed tagváltozó értéke.
     */
    public int getMechanicPoint(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("City::getMechanicPoint()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
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
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("City::PickUpPump()");
        TesterMain.tabCount++;
        Pump p = new Pump();
        TesterMain.tabCount--;
        return p;
    }


}
