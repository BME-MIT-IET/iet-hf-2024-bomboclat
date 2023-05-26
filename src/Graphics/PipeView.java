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
        Node neighbour0 = pipe.getEndpoint(0);
        Node neighbour1 = pipe.getEndpoint(1);
        if(neighbour0!=null){
            end0X = pipe.getEndpoint(0).getView().getPlayerPositionX();
            end0Y = pipe.getEndpoint(0).getView().getPlayerPositionY();
        }
        if(neighbour1 != null){
            end1X = pipe.getEndpoint(1).getView().getPlayerPositionX();
            end1Y = pipe.getEndpoint(1).getView().getPlayerPositionY();
        }
    }

    @Override
    public void Update(Graphics g) {
        int NodeSize = 10;
        boolean haswater = pipe.getHasWater();
        boolean isSticky = pipe.getSticky();
        boolean isSlippery = pipe.getSlippery();
        boolean hasHole = pipe.getHasHole();

        if(!haswater){
            g.setColor(Color.BLACK);
        }else{
            g.setColor(Color.BLUE);
        }
        
    }

    public Pipe getPipe(){
        return pipe;
    }

    public void setPipe(Pipe p){
        pipe = p;
    }

    @Override
    public int getPlayerPositionX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerPositionX'");
    }

    @Override
    public int getPlayerPositionY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerPositionY'");
    }
}
