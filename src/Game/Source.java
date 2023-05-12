package Game;
import skeleton.*;



/**
 * A forrást reprezentáló osztály.
 */
public class Source extends Node{

    /**
     * Source konstruktora.
     */
    public Source(){
        
    }

    /**
     * Minden belőle kivezető csőre vizet tesz.
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     */
    public void Step(boolean rnd) {
        for(int i=0; i < this.edges.size(); i++) {
            this.edges.get(i).GiveWater(1);
        }
    }

    /** 
     * Leteszi a paraméterben megadott szerelő kezében lévő csövet, azaz hozzáadja a pumpából kimenő/pumpába befutó csövek közé.
     * Kezeli a szerelő kezében lévő csövet. (Kiveszi/egyik végét bennehagyja annak függvényében, hogy a szerelő kezében a csőnek mely
     * vége(i) volt(ak))
     * @param m a csövet letenni kívánó szerelő
    */
    public void PlacePipe(Mechanic m){
        Pipe pipeInHand = m.GetPipeInHand();
        edges.add(pipeInHand);

        int pipeEnd = m.GetPipeEnd();

        if(pipeEnd == 0){
            pipeInHand.setEndpoint(this, 0);
            m.setPipeInHand(null);
            m.SetPipeEnd(-1);
        } else if (pipeEnd == 1){
            pipeInHand.setEndpoint(this, 1);
            m.setPipeInHand(null);
            m.SetPipeEnd(-1);
        } else if(pipeEnd == 2){
            pipeInHand.setEndpoint(this, 0);
            m.SetPipeEnd(1);
        }
    }
}
