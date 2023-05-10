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



    public Character() {
        
    }

    /**
     * Character konstruktor
     * @param nMoves A lépések száma
     * @param nField A mező, amelyen álljon
     */
    public Character(int nMoves, Field nField){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Character has been initialized");
        moves = nMoves;
        field = nField;
        field.Accept(this);
        TesterMain.tabCount--;
    }

    /**
     * A lépések settere
     * @param newMoves A lépések új értéke
     */
    public void setMoves(int newMoves){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Character::setMoves()");
        moves = newMoves;
        TesterMain.tabCount--;
    }

    /**
     * A lépések gettere
     */
    public int getMoves(){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Character::getMoves()");
        TesterMain.tabCount--;
        return moves;
    }

    /**
     * A jelenlegi mező settere
     * @param newField A jelenlegi mező
     */
    public void setField(Field newField){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Character::setField()");
        field = newField;
        TesterMain.tabCount--;
    }

    /**
     * A jelenlegi mező gettere
     */
    public Field getField(){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Character::getField()");
        TesterMain.tabCount--;
        return field;
    }

    /**
     * Pumpa bemenetét és kimenetét állító függvény
     * @param o Új bemenet
     * @param d Új kimenet
     */
    public void ChangePump(Pipe o, Pipe d){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Character::ChangePump()");
        field.Change(o, d);
        TesterMain.tabCount--;
    }

    /**
     * A mozgatást végző függvény
     * @param d Egy irány arról a mezőről, amin áll
     */
    public void Move(int d){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Character::Move()");
        Field neighbour = field.getNeighbour(d);
        if(neighbour != null){
            field.Remove(this);
            neighbour.Accept(this);
        }
        TesterMain.tabCount--;
    }

    /**
     * A karakter kilyukasztja amin éppen áll
     * Ha nem csövön áll, akkor nem történik semmi
     */
    public boolean DrillPipe(boolean rnd){ 
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Character::DrillPipe()");
        boolean ret = field.Drill(rnd);
        TesterMain.tabCount--;
        return ret;
    }

    public boolean Glue(){
        boolean ret = field.Glue();
        return ret;
    }
}
