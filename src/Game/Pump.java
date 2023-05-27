package Game;

import Graphics.IView;
import Graphics.PumpView;

/**
 * A pumpát reprezentáló osztály.
 */
public class Pump extends Node{
    /**
     * Azt tárolja, hogy működik-e a pumpa. True ha igen, false ha nem.
     */
    boolean working;
    /**
     * Azt tárolja, hogy melyik Pipe objektumból pumpál vizet.
     */
    Pipe from;
    /**
     * Azt tárolja, hogy melyik Pipe objektumba pumpál vizet.
     */
    Pipe where;

    PumpView pumpview;

    /**
     * Pump konstruktora.
     */
    public Pump(){
        working = true;
        from = null;
        where = null;
        pumpview = new PumpView(10, 10, this);
    }

    /**
     * Megjavítja az elromlott pumpát, ha a pumpa már működik, akkor nincsen hatása.
     */
    public boolean Fix() {
        working = true;
        return true;
    }

    /**
     * Kicseréli hogy melyik Pipe objektumból melyik Pipe objektumba pumpál a paraméterként kapott csövekre.
     * @param in Paraméterként megadott Pipe objektum, hogy honnan pumpáljon.
     * @param out Paraméterként megadott Pipe objektum, hogy hova pumpáljon.
     */
    public void Change(Pipe in, Pipe out) {
        this.from = in;
        this.where = out;
    }

    /**
     * Lépésenként frissíti a ki és bemeneti csövein a vízfolyam állapotát. Valamint véletlenszerűen elronthatja a
     * pumpát a hívása.
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     */
    public void Step(boolean rnd) {
        int incoming = this.from.TakeWaterAway();
        this.where.GiveWater(incoming);
    }

    /**
     * Elrontja a pumpát.
     */
    public void Die() {
        working = false;
    }
   
    /** 
     * Leteszi a paraméterben megadott szerelő kezében lévő csövet, azaz hozzáadja a pumpából kimenő/pumpába befutó csövek közé.
     * @param m a csövet letenni kívánó szerelő
    */
    public void PlacePipe(Mechanic m){
        Pipe pipeInHand = m.GetPipeInHand();
        edges.add(pipeInHand);

        int pipeEnd = m.GetPipeEnd();

        if(pipeEnd == 0){
            pipeInHand.setEndpoint(this, 0);
            m.SetPipeInHand(null);
            m.SetPipeEnd(-1);
        } else if (pipeEnd == 1){
            pipeInHand.setEndpoint(this, 1);
            m.SetPipeInHand(null);
            m.SetPipeEnd(-1);
        } else if(pipeEnd == 2){
            pipeInHand.setEndpoint(this, 0);
            m.SetPipeEnd(1);
        }
    }

    /**
     * Felveszi a pumpa csövei közül az elsőt a mechanic kezébe
     * @param m a szerelő játékos
     * @return a felvett cső
     */
    public Pipe PickUpPipe(Mechanic m){
        if(m.GetPipeEnd() != -1){
            m.SetPipeEnd(2);
            return null;
        } else{
            Pipe returnPipe = edges.get(0);
            int pipeEnd;

            if(returnPipe.getNeighbour(0) == this){
                pipeEnd = 0;
            } else {
                pipeEnd = 1;
            }

            m.SetPipeEnd(pipeEnd);
            return returnPipe;
        }
    }

    /**
     * Beállítja azt a csövet, ahova kifolyik a víz.
     * @param p Az a Pipe objektum, amire beállítja.
     */
    public void setWhere(Pipe p) {
        where = p;
    } 

    /**
     * Beállítja azt a csövet, ahonnan folyik a víz.
     * @param p Az a Pipe objektum, amire beállítja.
     */
    public void setFrom(Pipe p) {
        from = p;
    }

    @Override
    public void setView(IView pw) {
        pumpview = (PumpView) pw;
    }

    public PumpView getView() {return pumpview;}

    public boolean isWorking() {return working;}

    
}
