package Game;
import skeleton.*;


/**
 * A szerelőt reprezentáló osztály
 */
public class Mechanic extends Character{
    
    private Pipe pipe_in_hand;
    private Pump pump_in_hand;

    public Mechanic(int nMoves, Field nField){
        super(nMoves, nField);
    }

    /**
     * Megkísérli megjavítani az adott mezőt, amin éppen áll függetlenül
     * attól, hogy az cső vagy pumpa.
     */
    public void Fix(){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Mechanic::Fix()");
        field.Fix();
        TesterMain.tabCount--;
    }

    /**
     * A szerelő leteszi a kezáben lévő pumpát, arra a csőre, amin áll
     */
    public void PlacePump(){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Mechanic::PlacePump()");
        pump_in_hand = field.PlacePump(pump_in_hand);
        TesterMain.tabCount--;
    }

    /**
     * A szerelő beköti a kezében lévő csövet abba a pumpába, amin áll
     */
    public void PlacePipe(){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Mechanic::PlacePipe()");
        field.addEdge(pipe_in_hand);
    }
    /**
     * A szerelőnek ezen függvénye hívódik meg, amikor a
     * játékos egy ciszternában pumpát szeretne a kezébe venni. Ekkor felvesz egy
     * pumpát, amivel a kezében mozoghat a pályán.
     */
    public void PickUpPump(){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Mechanic::PickUpPump()");
        pump_in_hand = field.PickUpPump();
        TesterMain.tabCount--;
    }

    /**
     * A szerelő megkísérel felvenni egy csövet (pontosabban
     * annak az egyik végét) arról a mezőről, amelyen áll, majd ha ez sikerül, a cső
     * vége a kezébe kerül, ezzel tud tovább mozogni.
     */
    public void PickUpPipe(){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Mechanic::PickUpPipe()");
        pipe_in_hand = field.PickUpPipe();
        TesterMain.tabCount--;
    }

    public void setPumpInHand(Pump p) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Mechanic::setPumpInHand()");
        pump_in_hand = p;
        TesterMain.tabCount--;
    }

    public void setPipeInHand(Pipe p) {
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Mechanic::setPipeInHand()");
        pipe_in_hand = p;
        TesterMain.tabCount--;
    }
}
