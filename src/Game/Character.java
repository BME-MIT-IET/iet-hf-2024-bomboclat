package Game;
import skeleton.*;

/**
 * A karaktert reprezentáló osztály
 */
public class Character{
    //A lépései száma az adott körben
    private int moves;
    //Az a mező, amin éppen áll
    protected Field field;


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
        }
    }

    /**
     * A karakter kilyukasztja amin éppen áll
     * Ha nem csövön áll, akkor nem történik semmi
     * @param rnd ha igaz, akkor nemdeterminisztikusan működik
     */
    public boolean DrillPipe(boolean rnd){ 
        boolean ret = field.Drill(rnd);
        return ret;
    }

    /**
     * A karakter beragasztózza amin éppen áll
     * Ha nem csövön áll, akkor nem történik semmi
     * @return ha igaz, akkor sikeresen beragasztózta a csövet
     */
    public boolean Glue(){
        boolean ret = field.Glue();
        return ret;
    }
}
