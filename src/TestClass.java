public class TestClass {

    //Példa lehet bármi a neve
    public void Test1() {
        //Ezzel kezdődjön minden teszt
        Main.tabCount = 0;

        Character c = new Character(1, null);
        Pump pump = new Pump();
        Pipe pipe = new Pipe();

        c.setField(pump);
        pump.addEdge(pipe);
        pipe.setEndpoint(pump, 0);

        c.Move(0);
    }

    /**
     * 14 Change Pump
     */
    public void TestChangePump() {
        Main.tabCount = 0;

        City c = new City();
        
        Pump pump = new Pump();
        
        Pipe p1 = new Pipe();
        Pipe p2 = new Pipe();
        Pipe p3 = new Pipe();
        
        Source s1 = new Source();
        Source s2 = new Source();

        p1.setEndpoint(pump, 0);
        p1.setEndpoint(s2, 1);
        
        p2.setEndpoint(pump, 0);
        p2.setEndpoint(s1, 1);

        p3.setEndpoint(pump, 0);
        p3.setEndpoint(c, 1);

        pump.setWhere(p1);
        pump.setFrom(p2);

        pump.Change(p2, p3);
    }

    /**
     * 19 Place Pump on Pump
     */
    public void TestPlacePumpOnPump() {
        Main.tabCount = 0;

        Pump pump = new Pump();
        Pump p = new Pump();

        Mechanic m = new Mechanic(10, p);

        m.setPumpInHand(pump);
        
        m.PlacePump();
    }

    /**
     * 20 Place Pump on Pipe
     */
    public void TestPlacePumpOnPipe() {
        Pump pump = new Pump();
        Pipe p = new Pipe();

        Mechanic m = new Mechanic(10, p);
        m.setPumpInHand(pump);
        
        Pump pump0 = new Pump();
        Pump pump1 = new Pump();

        p.setEndpoint(pump0, 0);
        p.setEndpoint(pump1, 1);

        m.PlacePump();
    }

    /**
     * 26 Test Water Step Source
     */
    public void TestWaterStepSource() {
        Main.tabCount = 0;

        City c = new City();
        
        Pump pump = new Pump();
        
        Pipe p1 = new Pipe();
        Pipe p2 = new Pipe();
        Pipe p3 = new Pipe();
        
        Source s1 = new Source();
        Source s2 = new Source();

        p1.setEndpoint(pump, 0);
        p1.setEndpoint(s2, 1);
        
        p2.setEndpoint(pump, 0);
        p2.setEndpoint(s1, 1);

        p3.setEndpoint(pump, 0);
        p3.setEndpoint(c, 1);

        pump.setWhere(p1);
        pump.setFrom(p2);
    }

    /**
     * 27 Test Water Step City
     */
    public void TestWaterStepCity() {
        Main.tabCount = 0;

        City c = new City();
        
        Pump pump = new Pump();
        
        Pipe p1 = new Pipe();
        Pipe p2 = new Pipe();
        Pipe p3 = new Pipe();
        
        Source s1 = new Source();
        Source s2 = new Source();

        p1.setEndpoint(pump, 0);
        p1.setEndpoint(s2, 1);
        
        p2.setEndpoint(pump, 0);
        p2.setEndpoint(s1, 1);

        p3.setEndpoint(pump, 0);
        p3.setEndpoint(c, 1);

        pump.setWhere(p1);
        pump.setFrom(p2);

    }

    /**
     * 28 Test Water Step Pump
     */
    public void TestWaterStepPump() {
        Main.tabCount = 0;

        City c = new City();
        
        Pump pump = new Pump();
        
        Pipe p1 = new Pipe();
        Pipe p2 = new Pipe();
        Pipe p3 = new Pipe();
        
        Source s1 = new Source();
        Source s2 = new Source();

        p1.setEndpoint(pump, 0);
        p1.setEndpoint(s2, 1);
        
        p2.setEndpoint(pump, 0);
        p2.setEndpoint(s1, 1);

        p3.setEndpoint(pump, 0);
        p3.setEndpoint(c, 1);

        pump.setWhere(p1);
        pump.setFrom(p2);

    }

    /** 
     * 29 Test Drill Pipe On Pipe
     */
    public void TestDrillPipe() {

    }
}
