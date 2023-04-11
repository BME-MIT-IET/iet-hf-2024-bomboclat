/**
 * A szabotőrt reprezentáló osztály
 */
public class Nomad {
    
    /**
     * A szabotőr kilyukasztja amin éppen áll
     * Ha nem csövön áll, akkor nem történik semmi
     */
    public void DrillPipe(){
        for(int i = 0; i < Main.tabCount; i++) {System.out.print("\t");}
        Main.tabCount++;
        System.out.println("Nomad::DrillPipe()");
        field.Drill();
        Main.tabCount--;
    }
}
