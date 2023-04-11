/**
 * A karaktert reprezentáló osztály
 */
public class Character{
    //A lépései száma az adott körben
    private int moves;
    //Az a mező, amin éppen áll
    protected Field field;


    /**
     * Character konstruktor
     * @param nMoves A lépések száma
     * @param nField A mező, amelyen álljon
     */
    public Character(int nMoves, Field nField){
        for(int i = 0; i < Main.tabCount; i++) {System.out.print("\t");}
        Main.tabCount++;
        moves = nMoves;
        field = nField;
        System.out.println("Character has been initialized");
        Main.tabCount--;
    }

    /**
     * A lépések settere
     * @param newMoves A lépések új értéke
     */
    public void setMoves(int newMoves){
        for(int i = 0; i < Main.tabCount; i++) {System.out.print("\t");}
        Main.tabCount++;
        System.out.println("Character::setMoves()");
        moves = newMoves;
        Main.tabCount--;
    }

    /**
     * A lépések gettere
     */
    public int getMoves(){
        for(int i = 0; i < Main.tabCount; i++) {System.out.print("\t");}
        Main.tabCount++;
        System.out.println("Character::getMoves()");
        Main.tabCount--;
        return moves;
    }

    /**
     * A jelenlegi mező settere
     * @param newField A jelenlegi mező
     */
    public void setField(Field newField){
        for(int i = 0; i < Main.tabCount; i++) {System.out.print("\t");}
        Main.tabCount++;
        System.out.println("Character::setField()");
        field = newField;
        Main.tabCount--;
    }

    /**
     * A jelenlegi mező gettere
     */
    public Field getField(){
        for(int i = 0; i < Main.tabCount; i++) {System.out.print("\t");}
        Main.tabCount++;
        System.out.println("Character::getField()");
        Main.tabCount--;
        return field;
    }

    /**
     * Pumpa bemenetét és kimenetét állító függvény
     * @param o Új bemenet
     * @param d Új kimenet
     */
    public void ChangePump(Pipe o, Pipe d){
        for(int i = 0; i < Main.tabCount; i++) {System.out.print("\t");}
        Main.tabCount++;
        System.out.println("Character::ChangePump()");
        field.Change(o, d);
        Main.tabCount--;
    }

    /**
     * A mozgatást végző függvény
     * @param d Egy irány aról a mezőről, amin áll
     */
    public void Move(int d){
        for(int i = 0; i < Main.tabCount; i++) {System.out.print("\t");}
        Main.tabCount++;
        System.out.println("Character::Move()");
        Field neighbour = field.getNeighbour(d);
        if(neighbour != null){
            field.Remove(this);
            neighbour.Accept(this);
        }
        Main.tabCount--;
    }
}
