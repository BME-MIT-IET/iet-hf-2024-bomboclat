package hu.bomboclat.Graphics;
import java.awt.Color;
import java.awt.Graphics;

import hu.bomboclat.Game.Pump;

/**
 * A Pump típusú objektumok kirajzolásáért felelős osztály
 */
public class PumpView extends NodeView{

    /**
     * A kirajzolandó pump objektum.
     */
    Pump pump;
    /**
     * A kirajzolandó Node objektum mérete.
     */
    int SIZE = 30;

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

    /**
     * Visszaadja a Node X koordinátáját.
     * @return A Node X koordinátája.
     */
    public int getPlayerPositionX() {
        return x + SIZE / 2;
    }
    /**
     * Visszaadja a Node Y koordinátáját.
     * @return A Node Y koordinátája.
     */
    public int getPlayerPositionY() {
        return y + SIZE / 2;
    }

    /**
     * Setter a pump tagváltozóhoz.
     * @param p A beállítandó objektum referenciája.
     */
    public void setPump(Pump p) { pump = p;}

    /**
     * Getter a pipe tagváltozóhoz.
     * @return pump tagváltozó referenciája
     */
    public Pump getPump() {return pump;}

    /**
     * Kirajzolja a pumpát a pumpa megfelelő állapota szerint
     * @param g Az a graphics objektum, amire rajzolunk.
     */
    @Override
    public void Update(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, SIZE, SIZE);
        if(!pump.isWorking()) {
            g.setColor(Color.RED);
            g.drawLine((int)(Math.cos(Math.PI / 6) * SIZE/2  + getPlayerPositionX()),(int)(Math.sin(Math.PI / 6) * SIZE/2+ getPlayerPositionY()),(int)(Math.cos(Math.PI *180/150)* SIZE/2 + getPlayerPositionX()),(int)(Math.sin(Math.PI * 180/150) * SIZE/2+ getPlayerPositionY()));
            g.drawLine((int)((Math.cos(Math.PI *120/180)* SIZE/2 + getPlayerPositionX())),(int)(Math.sin(Math.PI *120/180) * SIZE/2+ getPlayerPositionY()),(int)(Math.cos(Math.PI * 330/180)* SIZE/2 + getPlayerPositionX()),(int)(Math.sin(Math.PI* 330/180) * SIZE/2+ getPlayerPositionY()));
        }
    }
}
