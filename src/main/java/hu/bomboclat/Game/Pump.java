package hu.bomboclat.Game;

import hu.bomboclat.Graphics.IView;
import hu.bomboclat.Graphics.PumpView;

/**s
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

    /**
     * Tárolja az adott példányhoz tartozó PumpView objektumot, amely a megjelenítését végzi el a pump-nak.
     */
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
        if(this.edges.contains(in) && this.edges.contains(out)) {
            this.from = in;
            this.where = out;
        }
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
        //A játékhoz is hozzá kell adni a csövet
        Game.frame.currentGame.currPlayfield.addPipe(pipeInHand);
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
            if(m.GetPipeEnd() == 1 || m.GetPipeEnd() == 0){
                if(edges.contains(m.GetPipeInHand())){
                    edges.remove(m.GetPipeInHand());
                    m.GetPipeInHand().endpoints.remove(this);
                    m.SetPipeEnd(2);
                }
            }
            return m.GetPipeInHand();
        } else{
            Pipe returnPipe = edges.remove(0);
            returnPipe.endpoints.remove(this);
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

    /**
     * Visszaadja a pumpview tagváltozóban található PumpView objektum referenciáját.
     * @return A referencia.
     */
    public PumpView getView() {return pumpview;}

    /**
     * Visszaadja a working tagváltozóban tárolt boolean értéket.
     * @return working tagváltozó (annak értéke)
     */
    public boolean isWorking() {return working;}

    public Pipe getFrom(){
        return from;
    }

    public Pipe getWhere(){
        return where;
    }
}
