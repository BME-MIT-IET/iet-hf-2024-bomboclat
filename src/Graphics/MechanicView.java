package Graphics;
import Game.Mechanic;

import java.awt.*;

/**
 * A szerelő megjelnítéséért felelős osztály
 */
public class MechanicView implements IView{
    //A szerelő, akit megjelenít
    private Mechanic mechanic;
    //A megjelenítési pozíció x koordinátája
    private int x;
    //A megjelenítési pozíció y koordinátája
    private int y;

    /**
     * Default konstruktor
     */
    public MechanicView(){
        x = 0;
        y = 0;
        mechanic = null;
    }

    /**
     * A megjelenített szerelő settere
     * @param m A megjeleníteni kívánt szerelő
     */
    public void setMechanic(Mechanic m){
        mechanic = m;
    }

    /**
     * A megejelíntett szerelő gettere
     */
    public Mechanic getMechanic(){
        return mechanic;
    }

    @Override
    public void Update(Graphics g) {
        //TODO
    }

    /**
     * A megjelenítési pozíció x koordinátájának gettere
     */
    @Override
    public int getPlayerPositionX() {
        return x;
    }
    /**
     * A megjelenítési pozíció y koordinátájának gettere
     */
    @Override
    public int getPlayerPositionY() {
       return y;
    }
}
