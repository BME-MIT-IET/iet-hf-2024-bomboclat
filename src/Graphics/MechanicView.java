package Graphics;
import Game.Mechanic;

public class MechanicView : IView{
    private Mechanic mechanic;
    private int x;
    private int y;

    MechanicView(){
        x = 0;
        y = 0;
        mechanic = null;
    }

    public void Update(){
        
    }

    public void setMechanic(Mechanic m){
        mechanic = m;
    }

    public Mechanic getMechanic(){
        return mechanic;
    }
    
}
