package Graphics;

import Game.Field;
import Game.Node;

import java.awt.*;
import java.io.ObjectInputStream.GetField;

public abstract class NodeView implements IView{
    /**
     * A Node X koordinátája.
     */
    protected int x;
    /**
     * A Node Y koordinátája.
     */
    protected int y;
    /**
     * A kirajzolandó Node objektum.
     */
    protected Node node;
    /**
     * Konstruktor.
     * @param _x A Node X koordinátája.
     * @param _y A Node Y koordinátája.
     * @param _node A kirajzolandó Node objektum.
     */
    public NodeView(int _x, int _y, Node _node) {
        x=_x;
        y=_y;
        node=_node;
    }
    /**
     * Beállítja a Node X koordinátáját.
     * @param _x A Node új X koordinátája.
     */
    public void setX(int _x) {
        x=_x;
    }
    /**
     * Beállítja a Node Y koordinátáját.
     * @param _y A Node új Y koordinátája.
     */
    public void setY(int _y) {
        y=_y;
    }
    /**
     * Absztrakt függvény kirajzoláshoz.
     * @param g Graphics objektum rajzoláshoz.
     */
    public abstract void Update(Graphics g);
    /**
     * Visszaadja a Node X koordinátáját.
     * @return A Node X koordinátája.
     */
    public int getPlayerPositionX() {
        return x;
    }
    /**
     * Visszaadja a Node Y koordinátáját.
     * @return A Node Y koordinátája.
     */
    public int getPlayerPositionY() {
        return y;
    }
    /**
     * Visszaadja a Nodeot amihez a NodeView tartozik.
     * @return A node attribútum.
     */
    public Node getNode() {
        return node;
    }
    /**
     * Beállítja a node attribútumot n-re.
     * @param n Node objektum, erre állítja be a node attribútumot.
     */
    public void setNode(Node n) {
        node=n;
    }

    @Override
    public Field getField() {
        return node;
    }
}
