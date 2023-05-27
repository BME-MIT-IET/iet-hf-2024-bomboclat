package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;

import Game.Character;
import Game.Field;

public class Drawer extends Canvas{
    //A rajzolható objektumok listája
    List<IView> viewable;

    //Az éppen mozogni kívánó karakter null ha senki.
    Character wantsToMove = null;

    //Konstruktor
    public Drawer() {
        viewable = new ArrayList<IView>();
        addMouseListener(new MouseClickListener());
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

    public void setWantsToMove(Character w) {wantsToMove = w; }

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

    /**
     * Vissaadja a legközelebbi Fieldet a képernyőn az x y koordinátákhoz
     * @param x amihez nézzük x koordináta
     * @param y amihez nézzük y koordináta
     * @return a Field ami legközelebb van a fenti koordinátákhoz
     */
    public Field getClosestField(int x, int y) {
        int mindistance = 60000;
        Field ret = null;
        for(IView v : viewable) {
            if(Math.sqrt((v.getPlayerPositionX() - x)*(v.getPlayerPositionX() - x)+(v.getPlayerPositionY() - y)*(v.getPlayerPositionY() - y)) < mindistance) {
                if(v.getField() != null) {
                    mindistance = (int) Math.sqrt((v.getPlayerPositionX() - x)*(v.getPlayerPositionX() - x)+(v.getPlayerPositionY() - y)*(v.getPlayerPositionY() - y));
                    ret = v.getField();
                }
            }
        }
        return ret;
    }


    /**
     * Egér listener a karakter mozgatáshoz
     */
    private class MouseClickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                if(wantsToMove != null) {
                    Field desField = getClosestField(e.getX(), e.getY());
                    Field currField = wantsToMove.getField();
                    
                    if(currField.getSlippery()) {
                        wantsToMove.Move(0);
                        repaint();
                        return;
                    }
                    if(currField.getNeighbour(0) == currField) {
                        repaint();
                        return;
                    }
                    for(int i = 0; i < currField.getNeighbourCount(); i++) {
                        if(currField.getNeighbour(i) == desField) {
                            wantsToMove.Move(i);
                            repaint();
                            return;
                        }
                    }

                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}
