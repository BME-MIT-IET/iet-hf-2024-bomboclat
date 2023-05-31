package Graphics;
import Game.*;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Az a pipe objektum, aminek a megjelenítésért felelős.
 */
public class PipeView implements IView{
    /**
     * A pipe objektum, amit megjelenít
     */
    Pipe pipe;
    /**
     * A megjelenített pipe 1. számú végének x koordinátája.
     */
    int end1X;
    /**
     * A megjelenített pipe 1. számú végének y koordinátája.
     */
    int end1Y;
    /**
     * A megjelenített pipe 2. számú végének x koordinátája.
     */
    int end0X;
    /**
     * A megjelenített pipe 1. számú végének y koordinátája.
     */
    int end0Y;

    /**
     * PipeView konstruktora, az endNumberX/Y tegváltozókat annak függvényében állítja be, hogy a csőnek
     * mely végei vannak bekötve valahova.
     * @param _pipe pipe tagváltozó fogja ezt a referenciát tárolni
     */
    public PipeView(Pipe _pipe){
        pipe = _pipe;
        if(pipe.getEndpoint(0)!=null){
            end0X = pipe.getEndpoint(0).getView().getPlayerPositionX();
            end0Y = pipe.getEndpoint(0).getView().getPlayerPositionY();
        }
        if(pipe.getEndpoint(1)!= null){
            end1X = pipe.getEndpoint(1).getView().getPlayerPositionX();
            end1Y = pipe.getEndpoint(1).getView().getPlayerPositionY();
        }
        if(pipe.getEndpoint(0)!=null && pipe.getEndpoint(1)== null){
            end1X = pipe.getEndpoint(0).getView().getPlayerPositionX()+15;
            end1Y = pipe.getEndpoint(0).getView().getPlayerPositionY()+15;
        }else if(pipe.getEndpoint(0)==null && pipe.getEndpoint(1)!= null){
            end0X = pipe.getEndpoint(1).getView().getPlayerPositionX()+15;
            end0Y = pipe.getEndpoint(1).getView().getPlayerPositionY()+15;
        }
    }

    /**
     * Elvégzi az objektum kirajzolását a g objektumra.
     * A rajzoláshoz lekérdezi először a cső állapotát:
     * - Ragadós-e?
     * - Csúszós-e?
     * - Van-e rajta lyuk?
     * - X,Y koordinátái a végeknek annak függvényében, hogy a cső be van-e kötve bármelyik végén valahova.
     * Ezután elvégzi a kirajzolást a fent megszerzett adatok függvényében.
     * @param g amire történik a rajzolás.
     */
    @Override
    public void Update(Graphics g) {
        int NodeSize = 10;
        boolean isSticky = pipe.getSticky();
        boolean isSlippery = pipe.getSlippery();
        boolean hasHole = pipe.getHasHole();

        
        if(pipe.getEndpoint(0)!=null){
            end0X = pipe.getEndpoint(0).getView().getPlayerPositionX();
            end0Y = pipe.getEndpoint(0).getView().getPlayerPositionY();
        }
        if(pipe.getEndpoint(1)!= null){
            end1X = pipe.getEndpoint(1).getView().getPlayerPositionX();
            end1Y = pipe.getEndpoint(1).getView().getPlayerPositionY();
        }


        if(pipe.getEndpoint(0)==null && pipe.getEndpoint(1)== null){
            return;
        }

        if(pipe.getEndpoint(0)!=null && pipe.getEndpoint(1)== null){
            end1X = pipe.getEndpoint(0).getView().getPlayerPositionX()+15;
            end1Y = pipe.getEndpoint(0).getView().getPlayerPositionY()+15;
        }else if(pipe.getEndpoint(0)==null && pipe.getEndpoint(1)!= null){
            end0X = pipe.getEndpoint(1).getView().getPlayerPositionX()+15;
            end0Y = pipe.getEndpoint(1).getView().getPlayerPositionY()+15;
        }


        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));

        if(!pipe.isHadwater()){
            g2.setColor(Color.BLACK);
        }else{
            g2.setColor(Color.BLUE);
        }
        g2.draw(new Line2D.Float(end0X, end0Y, end1X, end1Y));

        if(isSlippery){
            g2.setColor(Color.cyan);
            g2.setStroke(new BasicStroke(4));
            g2.draw(new Line2D.Float(end0X, end0Y, end1X, end1Y));
        }else if(isSticky){
            g2.setColor(new Color(153,102,0));
            g2.setStroke(new BasicStroke(4));
            g2.draw(new Line2D.Float(end0X, end0Y, end1X, end1Y));
        }
        if(hasHole){
            g2.setColor(Color.RED);
            g2.fillOval(getPlayerPositionX(), getPlayerPositionY(), NodeSize, NodeSize);
        }
    }

    /**
     * Getter a pipe tagváltozóhoz.
     * @return pipe tagváltozó referenciája
     */
    public Pipe getPipe(){
        return pipe;
    }

    /**
     * Setter a pipe tagváltozóhoz.
     * @param p A beállítandó objektum referenciája.
     */
    public void setPipe(Pipe p){
        pipe = p;
    }

    /**
     * Visszaadja, hogy milyen x koordinátán kell állnia a játékosnak a csövön. Ha a cső mindkér vége üres, akkor -1
     * értékkel tér vissza.
     */
    @Override
    public int getPlayerPositionX() {
        if(pipe.getEndpoint(0)==null && pipe.getEndpoint(1)== null){
            return -1;
        }
        int halfway;
        if(end1X>=end0X){
            halfway = (end1X-end0X)/2+end0X+5;
            return halfway;
        }
        halfway = (end0X-end1X)/2+end1X-5;
        return halfway;
    }

    /**
     * Visszaadja, hogy milyen y koordinátán kell állnia a játékosnak a csövön. Ha a cső mindkét vége üres, akkor -1
     * értékkel tér vissza.
     */
    @Override
    public int getPlayerPositionY() {
        if(pipe.getEndpoint(0)==null && pipe.getEndpoint(1)== null){
            return -1;
        }
        int halfway;
        if(end1Y>=end0Y){
            halfway = (end1Y-end0Y)/2+end0Y-5;
            return halfway;
        }
        halfway = (end0Y-end1Y)/2+end1Y+5;
        return halfway;
    }

    /**
     * Visszaadja a pipe tagváltozóban tárolt objektum referenciáját.
     * @return az objektum referenciája.
     */
    @Override
    public Field getField() {
        return pipe;
    }
}
