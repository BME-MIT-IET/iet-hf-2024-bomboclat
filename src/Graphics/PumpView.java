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

    @Override
    public void Update(Graphics g) {
        int SIZE = 10;
        g.setColor(Color.BLACK);
        g.drawOval(getPlayerPositionX(), getPlayerPositionY(), SIZE, SIZE);
        if(!pump.isWorking()) {
            g.setColor(Color.RED);
            g.drawLine(,,,);
        }
    }
}
