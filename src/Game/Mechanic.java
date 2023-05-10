package Game;
import skeleton.*;


/**
 * A szerelőt reprezentáló osztály
 */
public class Mechanic extends Character{
    
    private Pipe pipe_in_hand;
    private Pump pump_in_hand;
    private int pipeEnd;

    public Mechanic() {
        pipe_in_hand = null;
        pump_in_hand = null;
        pipeEnd = -1;
    }

    public Mechanic(int nMoves, Field nField){
        super(nMoves, nField);
    }

    /**
     * Megkísérli megjavítani az adott mezőt, amin éppen áll függetlenül
     * attól, hogy az cső vagy pumpa.
     */
    public boolean Fix(){
        boolean ret =field.Fix();
        return ret;
    }

    /**
     * A szerelő leteszi a kezáben lévő pumpát, arra a csőre, amin áll
     */
    public void PlacePump(){
        pump_in_hand = field.PlacePump(pump_in_hand);
    }

    /**
     * A szerelő beköti a kezében lévő csövet abba a pumpába, amin áll
     */
    public void PlacePipe(){
        field.addEdge(pipe_in_hand);
    }
    /**
     * A szerelőnek ezen függvénye hívódik meg, amikor a
     * játékos egy ciszternában pumpát szeretne a kezébe venni. Ekkor felvesz egy
     * pumpát, amivel a kezében mozoghat a pályán.
     */
    public void PickUpPump(){
        pump_in_hand = field.PickUpPump();
    }

    /**
     * A szerelő megkísérel felvenni egy csövet (pontosabban
     * annak az egyik végét) arról a mezőről, amelyen áll, majd ha ez sikerül, a cső
     * vége a kezébe kerül, ezzel tud tovább mozogni.
     */
    public void PickUpPipe(){
        Pipe pipe = field.PickUpPipe(this);
        if(pipe != null){
            pipe_in_hand = pipe;
        }
    }

    public void setPumpInHand(Pump p) {
        pump_in_hand = p;
    }

    public void setPipeInHand(Pipe p) {
        pipe_in_hand = p;
    }

    public Pipe GetPipeInHand(){
        return pipe_in_hand;
    }

    public Pump GetPumpInHand(){
        return pump_in_hand;
    }

    public int GetPipeEnd(){
        return pipeEnd;
    }

    public void SetPipeInHand(Pipe pipe){
        pipe_in_hand = pipe;
    }

    public void SetPipeEnd(int end){
        pipeEnd = end;
    }
}
