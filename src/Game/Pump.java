package Game;
import skeleton.*;


/**
 * A pumpát reprezentáló osztály.
 */
public class Pump extends Node{
    /**
     * Azt tárolja, hogy működik-e a pumpa. True ha igen, false ha nem.
     */
    boolean working;
    /**
     * Azt tárolja, hogy melyik Pipe objektumból pumpál vizet.
     */
    Pipe from;
    /**
     * Azt tárolja, hogy melyik Pipe objektumba pumpál vizet.
     */
    Pipe where;

    /**
     * Pump konstruktora.
     */
    public Pump(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump has been initialized");
        TesterMain.tabCount++;
        working = true;
        from = null;
        where = null;
        TesterMain.tabCount--;
    }

    /**
     * Megjavítja az elromlott pumpát, ha a pumpa már működik, akkor nincsen hatása.
     */
    public void Fix() {
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::Fix()");
        TesterMain.tabCount++;
        working = true;
        TesterMain.tabCount--;
    }

    /**
     * Kicseréli hogy melyik Pipe objektumból melyik Pipe objektumba pumpál a paraméterként kapott csövekre.
     * @param in Paraméterként megadott Pipe objektum, hogy honnan pumpáljon.
     * @param out Paraméterként megadott Pipe objektum, hogy hova pumpáljon.
     */
    public void Change(Pipe in, Pipe out) {
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::Change()");
        TesterMain.tabCount++;
        this.from = in;
        this.where = out;
        TesterMain.tabCount--;
    }

    /**
     * Lépésenként frissíti a ki és bemeneti csövein a vízfolyam állapotát. Valamint véletlenszerűen elronthatja a
     * pumpát a hívása.
     */
    public void Step() {
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::Step()");
        TesterMain.tabCount++;
        int incoming = this.from.TakeWaterAway();
        this.where.GiveWater(incoming);
        TesterMain.tabCount--;
    }

    /**
     * Elrontja a pumpát.
     */
    public void Die() {
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::Die()");
        TesterMain.tabCount++;
        working = false;
        TesterMain.tabCount--;
    }

    /**
     * Felvesz egy szomszédos csövet.
     */
    public Pipe PickUpPipe() {
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::PickUpPipe()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
        return edges.get(0);
    }

    public void setWhere(Pipe p) {
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::setWhere()");
        TesterMain.tabCount++;
        where = p;
        TesterMain.tabCount--;
    } 

    public void setFrom(Pipe p) {
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::setFrom()");
        
        TesterMain.tabCount++;
        from = p;
        TesterMain.tabCount--;
    }

}
