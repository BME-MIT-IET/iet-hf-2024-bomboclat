package Graphics;
import java.awt.Color;
import java.awt.Graphics;

import Game.Pump;

public class PumpView extends NodeView{
    Pump pump;

    /**
     * Konstruktor
     * @param _x x pozíció a képernyőn
     * @param _y y pozíció a képernyőn
     * @param p A hozzátartozó pump
     */
    public PumpView(int _x, int _y, Pump p) {
        super(_x, _y, p);
        pump = p;
    }

    public void setPump(Pump p) { pump = p;}

    public Pump getPump() {return pump;}

    /**
     * Kirajzolja a pumpát a pumpa megfelelő állapota szerint
     * @param g Az a graphics objektum, amire rajzolunk.
     */
    @Override
    public void Update(Graphics g) {
        int SIZE = 30;
        g.setColor(Color.BLACK);
        g.fillOval(getPlayerPositionX(), getPlayerPositionY(), SIZE, SIZE);
        if(!pump.isWorking()) {
            g.setColor(Color.RED);
            g.drawLine((int)Math.cos(Math.PI / 6) + getPlayerPositionX(),(int)Math.sin(Math.PI / 6) + getPlayerPositionY(),(int)Math.cos(Math.PI *180/150) + getPlayerPositionX(),(int)Math.sin(Math.PI * 180/150) + getPlayerPositionY());
            g.drawLine((int)Math.cos(Math.PI *120/180) + getPlayerPositionX(),(int)Math.sin(Math.PI *120/180) + getPlayerPositionY(),(int)Math.cos(Math.PI * 330/180) + getPlayerPositionX(),(int)Math.sin(Math.PI* 330/180) + getPlayerPositionY());
        }
    }
}
