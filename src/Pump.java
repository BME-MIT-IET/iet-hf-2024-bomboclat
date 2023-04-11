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
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump has been initialized");
        Main.tabCount++;
        working = true;
        from = null;
        where = null;
        Main.tabCount--;
    }

    /**
     * Megjavítja az elromlott pumpát, ha a pumpa már működik, akkor nincsen hatása.
     */
    public void Fix() {
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::Fix()");
        Main.tabCount++;
        working = true;
        Main.tabCount--;
    }

    /**
     * Kicseréli hogy melyik Pipe objektumból melyik Pipe objektumba pumpál a paraméterként kapott csövekre.
     * @param in Paraméterként megadott Pipe objektum, hogy honnan pumpáljon.
     * @param out Paraméterként megadott Pipe objektum, hogy hova pumpáljon.
     */
    public void Change(Pipe in, Pipe out) {
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::Change()");
        Main.tabCount++;
        this.from = in;
        this.where = out;
        Main.tabCount--;
    }

    /**
     * Lépésenként frissíti a ki és bemeneti csövein a vízfolyam állapotát. Valamint véletlenszerűen elronthatja a
     * pumpát a hívása.
     */
    public void Step() {
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::Step()");
        Main.tabCount++;
        int incoming = this.from.TakeWaterAway();
        this.where.GiveWater(incoming);
        Main.tabCount--;
    }

    /**
     * Elrontja a pumpát.
     */
    public void Die() {
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::Die()");
        Main.tabCount++;
        working = false;
        Main.tabCount--;
    }

    //TODO
    public Pipe PickUpPipe() {
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Pump::PickUpPipe()");
        Main.tabCount++;

        return null; // lefordulas miatt
    }

}
