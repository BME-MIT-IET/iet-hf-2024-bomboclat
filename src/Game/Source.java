package Game;
import skeleton.*;



/**
 * A forrást reprezentáló osztály.
 */
public class Source extends Node{

    /**
     * Source konstruktora.
     */
    public Source(){
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Source has been initialized");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    /**
     * Minden belőle kivezető csőre vizet tesz.
     */
    public void Step() {
        for(int i=0; i < TesterMain.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Source::Step()");
        TesterMain.tabCount++;
        for(int i=0; i < this.edges.size(); i++) {
            this.edges.get(i).GiveWater(1);
        }
        TesterMain.tabCount--;
    }
}
