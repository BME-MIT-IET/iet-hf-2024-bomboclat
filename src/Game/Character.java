package Game;
import skeleton.*;

/**
 * A karaktert reprezentáló osztály
 */
public class Character{
    //A lépései száma az adott körben
    protected int moves;
    //Az a mező, amin éppen áll
    protected Field field;

    public int getAllMoves() {
        return allMoves;
    }

    private int allMoves;
    private boolean isActive;


    public boolean Lube() {
        return false;
    }


    /**
     * Character default konstruktor
     */
    public Character() {
        moves = 0;
        field = null;
    }

    /**
     * Character konstruktor
     * @param nMoves A lépések száma
     * @param nField A mező, amelyen álljon
     */
    public Character(int nMoves, Field nField){
        moves = nMoves;
        field = nField;
        field.Accept(this);
    }

    /**
     * A lépések settere
     * @param newMoves A lépések új értéke
     */
    public void setMoves(int newMoves){
        moves = newMoves;
    }

    /**
     * A lépések gettere
     */
    public int getMoves(){
        return moves;
    }

    /**
     * A jelenlegi mező settere
     * @param newField A jelenlegi mező
     */
    public void setField(Field newField){
        field = newField;
    }

    /**
     * A jelenlegi mező gettere
     */
    public Field getField(){
        return field;
    }

    /**
     * Pumpa bemenetét és kimenetét állító függvény
     * @param o Új bemenet
     * @param d Új kimenet
     */
    public void ChangePump(Pipe o, Pipe d){
        moves--;
        field.Change(o, d);
    }

    /**
     * A mozgatást végző függvény
     * @param d Egy irány arról a mezőről, amin áll
     */
    public void Move(int d){
        Field neighbour = field.getNeighbour(d);
        if(neighbour != null){
            field.Remove(this);
            neighbour.Accept(this);
            moves--;
        }
    }

    /**
     * A karakter kilyukasztja amin éppen áll
     * Ha nem csövön áll, akkor nem történik semmi
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     */
    public boolean DrillPipe(boolean rnd){ 
        boolean ret = field.Drill(rnd);
        if(ret){
            moves--;
        }
        return ret;
    }

    public boolean Fix(){
        return false;
    }

    public void setActive()
    {}
    public void setNotActive()
    {}

    /**
     * A karakter beragasztózza amin éppen áll
     * Ha nem csövön áll, akkor nem történik semmi
     * @return ha igaz, akkor sikeresen beragasztózta a csövet
     */
    public boolean Glue(){
        boolean ret = field.Glue();
        if(ret){
            moves--;
        }
        return ret;
    }

    public void PickUpPipe(){}
    public void PickUpPump(){}

    public boolean PlacePipe(){
        return false; //Nem sikerült letenni a csövet
    }

    public boolean PlacePump(){
        return false; //Sikertelen pumpa lehelyezés
    }
}
