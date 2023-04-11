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

    }

    /**
     * 19 Place Pump on Pump
     */
    public void TestPlacePumpOnPump() {

    }

    /**
     * 20 Place Pump on Pipe
     */
    public void TestPlacePumpOnPipe() {

    }

    /**
     * 26 Test Water Step Source
     */
    public void TestWaterStepSource() {

    }

    /**
     * 27 Test Water Step City
     */
    public void TestWaterStepCity() {

    }

    /**
     * 28 Test Water Step Pump
     */
    public void TestWaterStepPump() {

    }

    /** 
     * 29 Test Drill Pipe On Pipe
     */
    public void TestDrillPipe() {

    }
}
