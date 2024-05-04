package hu.bomboclat.Graphics;

import hu.bomboclat.Game.*;
import java.awt.*;

/**
 * A City típusú objektumok kirajzolásáért felelős osztály
 */
public class CityView extends NodeView{

    /**
     * A várost/ciszternát reprezentáló négyzet szélessége
     */
    int width = 75;
    /**
     * A várost/ciszternát reprezentáló négyzet magassága
     */
    int height = 75;

    /**
     * Konstruktor.
     * @param _x A Node X koordinátája.
     * @param _y A Node Y koordinátája.
     * @param _node A kirajzolandó Node objektum.
     */
    public CityView(int _x, int _y, Node _node){
        super(_x, _y, _node);
    }

    /**
     * X és Y koordináták alapján(Node-től örökölt attribútumok) elvégzi a
     * city kirajzolását.
     * A kirajzolt kép: Egy téglalap(kék) benne egy körrel(fekete)
     */
    @Override
    public void Update(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        Stroke stroke1 = new BasicStroke(3f);
        g2d.setColor(Color.YELLOW);
        g2d.setStroke(stroke1);
        g2d.drawRect(x, y, width, height);

        g2d.setColor(Color.BLACK);
        g2d.drawOval(x + 37, y + 37, 5, 5);
    }

    /**
     * Visszaadja a Node X koordinátáját. -> City esetében ez a négyzet közepe
     * @return A Node X koordinátája.
     */
    @Override
    public int getPlayerPositionX() {
        return x + width / 2;
    }
    /**
     * Visszaadja a Node Y koordinátáját. -> City esetében ez a négyzet közepe.
     * @return A Node Y koordinátája.
     */
    @Override
    public int getPlayerPositionY() {
        return y + height / 2;
    }

}
