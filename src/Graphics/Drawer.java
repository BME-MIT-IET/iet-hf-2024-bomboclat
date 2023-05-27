package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
            if(v != null)
                v.Update(g);
        }
    }

    public void setViewables(List<IView> l) {viewable = l;}

    /**
     * Erre hív a repaint az újrarajzoláshoz
     */
    public void paint(Graphics g) {
        BufferedImage bim = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics img = bim.getGraphics(); 
        img.setColor(new Color(255, 238, 203));
        img.fillRect(0, 0, getWidth(), getHeight());
        Draw(img);
        g.drawImage(bim,0,0,null);
    }
}
