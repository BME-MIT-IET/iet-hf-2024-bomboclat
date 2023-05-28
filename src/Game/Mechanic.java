package Game;
import Graphics.MechanicView;
import Graphics.PumpView;

import java.io.Console;

/**
 * A szerelőt reprezentáló osztály
 */
public class Mechanic extends Character{
    
    private Pipe pipe_in_hand;
    private Pump pump_in_hand;
    private int pipeEnd;
    private MechanicView mechanicView;

    /**
     * Mechanic default konstruktor
     */
    public Mechanic() {
        pipe_in_hand = null;
        pump_in_hand = null;
        pipeEnd = -1;
        mechanicView = new MechanicView();
        mechanicView.setMechanic(this);
    }
    @Override
    public void setActive() {
        mechanicView.setSelected(true);
    }
    @Override
    public void setNotActive()
    {
        mechanicView.setSelected(false);
    }

    /**
     * Mechanic konstruktor
     * @param nMoves A szerelő lépéseinek száma egy körben
     * @param nField Az a mező, amelyiken a szerelő áll
     */
    public Mechanic(int nMoves, Field nField){
        super(nMoves, nField);
        pipe_in_hand = null;
        pump_in_hand = null;
        pipeEnd = -1;
        mechanicView = new MechanicView();
        mechanicView.setMechanic(this);
    }

    /**
     * Megkísérli megjavítani az adott mezőt, amin éppen áll függetlenül
     * attól, hogy az cső vagy pumpa.
     */
    public boolean Fix(){
        boolean ret =field.Fix();
        if(ret){
            moves--;
        }
        return ret;
    }

    /**
     * A szerelő leteszi a kezáben lévő pumpát, arra a csőre, amin áll
     */
    public boolean PlacePump(){
        if(pump_in_hand != null){
            pump_in_hand = field.PlacePump(pump_in_hand);
            if(pump_in_hand == null){
                moves--;
                return true; //Sikeres pumpa lehelyezés
            }
            return false; //Sikertelen pumpa lehelyezés
        }
        return false; //Sikertelen pumpa lehelyezés
    }

    /**
     * A szerelő beköti a kezében lévő csövet abba a pumpába, amin áll
     */
    public boolean PlacePipe(){
        field.PlacePipe(this);
        if(pipe_in_hand == null){
            moves--;
            return true; //Sikerült letenni a csövet
        }
        return false; //Nem sikerült letenni a csövet
    }
    /**
     * A szerelőnek ezen függvénye hívódik meg, amikor a
     * játékos egy ciszternában pumpát szeretne a kezébe venni. Ekkor felvesz egy
     * pumpát, amivel a kezében mozoghat a pályán.
     */
    public void PickUpPump(){
        boolean emptyHanded = false;
        if(pump_in_hand == null){
            emptyHanded = true;
        }
        pump_in_hand = field.PickUpPump();
        if(pump_in_hand != null && emptyHanded){
            moves--;
        }
    }

    /**
     * A szerelő megkísérel felvenni egy csövet (pontosabban
     * annak az egyik végét) arról a mezőről, amelyen áll, majd ha ez sikerül, a cső
     * vége a kezébe kerül, ezzel tud tovább mozogni.
     */
    public void PickUpPipe(){
        boolean emptyHanded = false;
        boolean oneEnd = false;
        if(pipeEnd == -1){
            emptyHanded = true;
        }
        if(pipeEnd == 0 || pipeEnd == 1){
            oneEnd = true;
        }
        if(emptyHanded || oneEnd){
            Pipe pipe = field.PickUpPipe(this);
            if(pipe != null) {
                pipe_in_hand = pipe;
                moves--;
            }
        }
    }

    /**
     * Setter a pump_in_hand tagváltozónak
     * @param p A beállítani kívánt pumpa
     */
    public void setPumpInHand(Pump p) {
        pump_in_hand = p;
    }

    /**
     * Getter a pipe_in_hand tagváltozónak
     * @return A szerelő kezében lévő cső, vagy null, ha nincs a kezében cső
     */
    public Pipe GetPipeInHand(){
        return pipe_in_hand;
    }

    /**
     * Getter a pump_in_hand tagváltozónak
     * @return A szerelő kezében lévő pumpa, vagy null, ha nincs a kezében pumpa
     */
    public Pump GetPumpInHand(){
        return pump_in_hand;
    }

    /**
     * Getter a szerelő kezében lévő cső végére
     * @return A kezében lévő cső melyik vége van a kezében
     */
    public int GetPipeEnd(){
        return pipeEnd;
    }

    /**
     * Setter a pipe_in_hand tagváltozónak
     * @param pipe A beállítani kívánt cső
     */
    public void SetPipeInHand(Pipe pipe){
        pipe_in_hand = pipe;
	    //pipeEnd = 0;
    }

    /**
     * Setter a pipeEnd tagváltozónak
     * @param end A beállítani kívánt csővég
     */
    public void SetPipeEnd(int end){
        pipeEnd = end;
    }

    public void setView(MechanicView view){
        mechanicView = view;
    }

    public MechanicView getView(){
        return mechanicView;
    }
}
