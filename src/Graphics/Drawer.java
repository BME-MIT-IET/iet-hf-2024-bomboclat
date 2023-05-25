package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Drawer extends Canvas{
    //A rajzolható objektumok listája
    List<IView> viewable;

    //Konstruktor
    public Drawer() {
        viewable = new ArrayList<IView>();
    }

    /**
     * Hozzáad egy kirajzolandó elemet
     * @param v kirajzolandó elem
     */
    public void addViewable(IView v) {viewable.add(v);}

    /**
     * Kitörli a paraméterként kapott elemet
     * @param v törlendő elem
     */
    public void deleteViewable(IView v) {viewable.remove(v);}

    /**
     * Kirajzolja az összes elemet
     * @param g A grafikus objektum amire rajzolni kell
     */
    public void Draw(Graphics g) {
        for(IView v : viewable) {
            v.Update(g);
        }
    }

    /**
     * Erre hív a repaint az újrarajzoláshoz
     */
    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        Draw(g);
    }
}
