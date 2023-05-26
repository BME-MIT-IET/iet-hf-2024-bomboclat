package Graphics;
import Game.*;

import java.awt.*;
import java.awt.geom.Line2D;

public class PipeView implements IView{
    //Az a pipe objektum, aminek a megjelenítésért felelős.
    Pipe pipe;
    int end1X;
    int end1Y;
    int end0X;
    int end0Y;

    public PipeView(Pipe _pipe){
        pipe = _pipe;
        if(pipe.getEndpoint(0)!=null){
            end0X = pipe.getEndpoint(0).getView().getPlayerPositionX();
            end0Y = pipe.getEndpoint(0).getView().getPlayerPositionY();
        }else{
            end0X = -1;
            end0Y = -1;
        }
        if(pipe.getEndpoint(1)!= null){
            end1X = pipe.getEndpoint(1).getView().getPlayerPositionX();
            end1Y = pipe.getEndpoint(1).getView().getPlayerPositionY();
        }else{
            end1X = -1;
            end1Y = -1;
        }
    }

    @Override
    public void Update(Graphics g) {
        int NodeSize = 10;
        boolean haswater = pipe.getHasWater();
        boolean isSticky = pipe.getSticky();
        boolean isSlippery = pipe.getSlippery();
        boolean hasHole = pipe.getHasHole();

        
        //TODO kezelni kell, ha nincs szomszédja
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

        if(!haswater){
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
            g2.drawOval(getPlayerPositionX(), getPlayerPositionY(), NodeSize/2, NodeSize/2);
        }
    }

    public Pipe getPipe(){
        return pipe;
    }

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
            halfway = (end1X-end0X)/2+end0X;
            return halfway;
        }
        halfway = (end0X-end1X)/2+end1X;
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
            halfway = (end1Y-end0Y)/2+end0Y;
            return halfway;
        }
        halfway = (end0Y-end1Y)/2+end1Y;
        return halfway;
    }
}
