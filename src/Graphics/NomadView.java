package Graphics;
import Game.Nomad;

public class NomadView implements IView{
    private Nomad nomad;
    private int x;
    private int y;

    public NomadView(){
        x = y = 0;
        nomad = null;
    }

    public void Update(){

    }

    public void setNomad(Nomad n){
        nomad = n;
    }

    public Nomad getNomad(){
        return nomad;
    }
}
