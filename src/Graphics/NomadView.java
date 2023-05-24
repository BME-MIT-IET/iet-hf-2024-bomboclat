package Graphics;

public class NomadView : IView{
    private Nomad nomad;
    private int x;
    private int y;

    public Nomad(){
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
