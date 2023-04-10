public class Source extends Node{

    /**
     * Source konstruktora.
     */
    public Source(){
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Source has been initialized");
        Main.tabCount++;
        Main.tabCount--;
    }

    /**
     * Minden belőle kivezető csőre vizet tesz.
     */
    public void Step() {
        for(int i=0; i < Main.tabCount; i++) {
            System.out.print("\t");
        }
        System.out.println("Source::Step()");
        Main.tabCount++;
        for(int i=0; i < this.edges.size(); i++) {
            this.edges.get(i).GiveWater(1);
        }
        Main.tabCount--;
    }
}
