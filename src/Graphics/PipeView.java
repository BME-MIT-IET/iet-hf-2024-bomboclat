package Graphics;
import Game.*;

import java.awt.*;

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

        // Graphics2D g2d = (Graphics2D)g;
        // Rectangle rect1 = new Rectangle(100, 100, 20, 20);
        // g2d.setColor(Color.WHITE);
        // g2d.translate(rect1.x+(rect1.width/2), rect1.y+(rect1.height/2));
        // g2d.rotate(Math.toRadians(90));
        // g2d.draw(rect1);
        // g2d.fill(rect1);

        if(!haswater){
            g.setColor(Color.BLACK);
        }else{
            g.setColor(Color.BLUE);
        }
        // Graphics2D g2d = (Graphics2D)g;
        // Rectangle rect1 = new Rectangle(end0X, end0Y, , 20);
    }

    public Pipe getPipe(){
        return pipe;
    }

    private int distanceBetweenTwoPoints(int x1, int x2, int y1, int y2){
        return 1;
    }

    public void setPipe(Pipe p){
        pipe = p;
    }

    //TODO kezelni kell, ha nincs szomszédja
    @Override
    public int getPlayerPositionX() {
        int halfway;
        if(end1X>=end0X){
            halfway = (end1X-end0X)/2+end0X;
            return halfway;
        }
        halfway = (end0X-end1X)/2+end1X;
        return halfway;
    }

    @Override
    public int getPlayerPositionY() {
        int halfway;
        if(end1Y>=end0Y){
            halfway = (end1Y-end0Y)/2+end0Y;
            return halfway;
        }
        halfway = (end0Y-end1Y)/2+end1Y;
        return halfway;
    }
}
