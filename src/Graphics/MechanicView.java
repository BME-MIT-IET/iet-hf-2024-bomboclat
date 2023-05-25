package Graphics;
import Game.Mechanic;

import java.awt.*;

public class MechanicView implements IView{
    private Mechanic mechanic;
    private int x;
    private int y;

    public MechanicView(){
        x = 0;
        y = 0;
        mechanic = null;
    }

    public void setMechanic(Mechanic m){
        mechanic = m;
    }

    public Mechanic getMechanic(){
        return mechanic;
    }

    @Override
    public void Update(Graphics g) {
        //TODO
    }

    @Override
    public int getPlayerPositionX() {
        //TODO
        return 0;
    }

    @Override
    public int getPlayerPositionY() {
       //TODO
        return 0;
    }
}
