package Graphics;

import Game.Nomad;

import java.awt.*;

public class NomadView implements IView{
    private Nomad nomad;
    private int x;
    private int y;

    public NomadView(){
        x = y = 0;
        nomad = null;
    }

    public void setNomad(Nomad n){
        nomad = n;
    }

    public Nomad getNomad(){
        return nomad;
    }

    @Override
    public void Update(Graphics g) {
        //TODO
    }

    @Override
    public int getPlayerPositionX() {
        //TODO
        return 0;
    }


    public int getPlayerPositionY() {
        //TODO
        return 0;
    }
}
