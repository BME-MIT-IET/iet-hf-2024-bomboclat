package Graphics;

import Game.*;
import java.awt.*;

public class CityView extends NodeView{

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

        Stroke stroke1 = new BasicStroke(6f);
        g2d.setColor(Color.YELLOW);
        g2d.setStroke(stroke1);
        g2d.drawRect(x, y, 20, 20);

        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, 5, 5);
    }

}
