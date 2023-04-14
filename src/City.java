/**
 * A ciszternát reprezentáló osztály.
 */
public class City extends Node{
    /**
     * A városba (más néven ciszternába) befolyt víz mennyisége.
     */
    private int consumed;
    /**
     * City konstruktora.
     */
    public City(){
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("City has been initialized");
        Main.tabCount++;
        consumed=0;
        Main.tabCount--;
    }

    /**
     * Összeadja a rákötött csöveken beérkező vízmennyiséget.
     */
    public void Step() {
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("City::Step()");
        Main.tabCount++;
        int sum = 0;
        for(int i=0; i < this.edges.size(); i++) {
            sum += this.edges.get(i).TakeWaterAway();
        }
        consumed += sum;
        Main.tabCount--;
    }

    /**
     * Visszaadja, hogy hány pontja van a szerelőknek vagyis a consumed értékét.
     * @return A szerelők pontjai, a consumed tagváltozó értéke.
     */
    public int getMechanicPoint(){
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("City::getMechanicPoint()");
        Main.tabCount++;
        Main.tabCount--;
        return consumed;
    }

    /**
     * A városból egy, onnan kivezető cső nem ciszterna felőli végét lehet felvenni ezzel a függvénnyel.
     * @return A függvény a felvett cső objektumot adja vissza.
     */
    public Pipe PickUpPipe() {
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("City::PickUpPipe()");
        Main.tabCount++;
        Pipe n = new Pipe();
        n.setEndpoint(this, 1);
        Main.tabCount--;
        return n;
    }

    /**
     * A városból új pumpákat tudnak felvenni ezzel a függvénnyel.
     * @return A függvény a felvett pumpa objektumot adja vissza.
     */
    public Pump PickUpPump() {
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("City::PickUpPump()");
        Main.tabCount++;
        Main.tabCount--;
        return null;
    }


}
