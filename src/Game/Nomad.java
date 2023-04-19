package Game;

import skeleton.*;

/**
 * A szabotőrt reprezentáló osztály
 */
public class Nomad extends Character{
    
    public Nomad(int nMoves, Field nField){
        super(nMoves, nField);
    }
    
    /**
     * A szabotőr kilyukasztja amin éppen áll
     * Ha nem csövön áll, akkor nem történik semmi
     */
    public void DrillPipe(){
        for(int i = 0; i < TesterMain.tabCount; i++) {System.out.print("\t");}
        TesterMain.tabCount++;
        System.out.println("Nomad::DrillPipe()");
        field.Drill();
        TesterMain.tabCount--;
    }
}
