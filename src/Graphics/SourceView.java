package Graphics;

import java.awt.*;

import Game.*;

public class SourceView extends NodeView{

    /**
     * Konstruktor.
     * @param _x A Node X koordinátája.
     * @param _y A Node Y koordinátája.
     * @param _node A kirajzolandó Node objektum.
     */
    public SourceView(int _x, int _y, Node _node){
        super(_x, _y, _node);
    }

    /**
     * X és Y koordináták alapján(Node-től örökölt attribútumok) elvégzi a
     * source kirajzolását.
     */ 
    @Override
    public void Update(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(x, y, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 5, 5);
    }
}
