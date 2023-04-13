public class TestClass {

    //Példa lehet bármi a neve
    public void Test1() {
        //Ezzel kezdődjön minden teszt
        Main.tabCount = 0;

        Pump pump = new Pump();
        Character c = new Character(1, pump);
        Pipe pipe = new Pipe();

        c.setField(pump);
        pump.addEdge(pipe);
        pipe.setEndpoint(pump, 0);

        c.Move(0);
    }
    /**
     * 2 Step on empty pipe from pump
     */
    public void TestStepOnEmptyPipePump(){
        Main.tabCount = 0;

        Pump pump = new Pump();
        Character c = new Character(1, pump);
        Pipe pipe = new Pipe();

        c.setField(pump);
        pump.addEdge(pipe);
        pipe.setEndpoint(pump, 0);

        c.Move(0);
    }

    /**
     * 3 Step on occupied pipe from pump
     */
    public void TestStepOnOccupiedPipePump(){
        Main.tabCount = 0;

        Pump pump = new Pump();
        Pipe pipe = new Pipe();
        Character c1 = new Character(1, pump);
        Character c2 = new Character(1, pipe);

        c1.setField(pump);
        c2.setField(pipe);
        pump.addEdge(pipe);
        pipe.setEndpoint(pump, 0);

        c1.Move(0);
    }

    /**
     * 4 Step on empty pipe from city
     */
    public void TestStepOnEmptyPipeCity(){
        Main.tabCount = 0;

        City city = new City();
        Character c = new Character(1, city);
        Pipe pipe = new Pipe();

        c.setField(city);
        city.addEdge(pipe);
        pipe.setEndpoint(city, 0);

        c.Move(0);
    }

    /**
     * 5 Step on occupied pipe from city
     */
     public void TestStepOnOccupiedPipeCity(){
        Main.tabCount = 0;

        City city = new City();
        Pipe pipe = new Pipe();
        Character c1 = new Character(1, city);
        Character c2 = new Character(1, pipe);

        c1.setField(city);
        c2.setField(pipe);
        city.addEdge(pipe);
        pipe.setEndpoint(city, 0);

        c1.Move(0);
    }

    /**
     * 6 Step on empty pipe from source 
     */
    public void TestStepOnEmptyPipeSource(){
        Main.tabCount = 0;

        Source source = new Source();
        Character c = new Character(1, source);
        Pipe pipe = new Pipe();

        c.setField(source);
        source.addEdge(pipe);
        pipe.setEndpoint(source, 0);

        c.Move(0);
    }

    /**
     * 7 Step on occupied pipe from source
     */
    public void TestStepOnOccupiedPipeSource(){
        Main.tabCount = 0;

        Source source = new Source();
        Pipe pipe = new Pipe();
        Character c1 = new Character(1, source);
        Character c2 = new Character(1, pipe);

        c1.setField(source);
        c2.setField(pipe);
        source.addEdge(pipe);
        pipe.setEndpoint(source, 0);

        c1.Move(0);
    }

    /**
     * 11 Water flows from Source to Pump
     */
    public void TestWaterFlowsSourceToPump(){
        Main.tabCount = 0;
        
        Source source = new Source();
        Pipe edge = new Pipe();
        Pump pump = new Pump();
        edge.setEndpoint(source, 0);
        edge.setEndpoint(pump, 1);
        pump.addEdge(edge);
        pump.Change(edge, edge);
        source.Step();
        pump.Step();
    }

    /**
     * 12 Water flows in City
     */
    public void TestWaterFlowsInCity(){
        Main.tabCount = 0;

        City city = new City();
        Pipe inlet = new Pipe();
        inlet.setEndpoint(city, 1);

        city.Step();
    }

    /**
     * 13 Water flows in blocked input of Pump
     */
    public void TestWaterFlowsInBlocked(){
        Main.tabCount = 0;
        
        Pump pump = new Pump();
        Pipe blocked = new Pipe();
        Pipe from = new Pipe();
        blocked.setEndpoint(pump, 1);
        from.setEndpoint(pump, 1);
        Pipe where = new Pipe();
        where.setEndpoint(pump, 0);
        pump.Change(from, where);

        pump.Step();
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
     * 15 Water flows out of broken pipe
     */
    public void TestWaterFlowsOutOfBrokenPipe() {
        Main.tabCount=0;

        Game game = new Game();
        Source source = new Source();
        Pipe pipe = new Pipe();
        Playfield playfield = new Playfield();
        Pump pump = new Pump();
        Pipe pipe2 = new Pipe();

        game.setCurrPlayfield(playfield);
        pipe.setEndpoint(source, 0);
        pipe.setEndpoint(pump, 1);
        pump.setFrom(pipe);
        playfield.addNode(source);
        playfield.addNode(pump);
        playfield.addPipe(pipe);
        pipe2.setEndpoint(pump, 0);
        pump.setWhere(pipe2);

        pipe.Drill();

        game.EndRound();

    }

    /**
     * 16 Fix Pipe
     */
    public void TestFixPipe() {
        Main.tabCount =0;

        Pipe pipe = new Pipe();
        Mechanic mechanic = new Mechanic(5, pipe);
        mechanic.Fix();

    }

    /**
     * 17 Test Place Pipe on Pump
     */
    public void TestPlacePipeOnPump() {
        Main.tabCount = 0;

        Pipe pipe = new Pipe();
        Pump pump = new Pump();
        pump.addEdge(pipe);
        Mechanic mechanic = new Mechanic(5, pump);

        mechanic.PickUpPipe();

        mechanic.PlacePipe();

    }

    /**
     * 18 Test Place Pipe on Pipe
     */
    public void TestPlacePipeOnPipe() {
        Main.tabCount = 0;

        Pipe pipe = new Pipe();
        Pump pump = new Pump();
        pump.addEdge(pipe);
        Mechanic mechanic = new Mechanic(5, pump);
        mechanic.setField(pipe);

        mechanic.PickUpPipe();

        mechanic.PlacePipe();
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
        Main.tabCount = 0;
        
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
     * 21 Pick up Pipe on City
     */
    public void TestPickUpPipeOnCity(){
        Main.tabCount = 0;
        
        City city = new City();
        Mechanic mechanic = new Mechanic(1, city);
        Pipe edge = new Pipe();
        edge.setEndpoint(city, 1);
        mechanic.setField(city);

        mechanic.PickUpPipe();
    }

    /**
     * 22 Pick up Pipe on Pump
     */
    public void TestPickUpPipeOnPump(){
        Main.tabCount = 0;
        
        Pump pump = new Pump();
        Mechanic mechanic = new Mechanic(1, pump);
        Pipe edge = new Pipe();
        edge.setEndpoint(pump, 1);
        mechanic.setField(pump);

        mechanic.PickUpPipe();
    }

    /**
     * 23 Pick up Pipe on Pipe
     */
    public void TestPickUpPipeOnPipe(){
        Main.tabCount = 0;
        
        Pipe pipe = new Pipe();
        Mechanic mechanic = new Mechanic(1, pipe);
        mechanic.setField(pipe);

        mechanic.PickUpPipe();
    }

    /**
     * 24 Pick up Pipe on Source
     */
    public void TestPickUpPipeOnSource(){
        Main.tabCount = 0;
        
        Source source = new Source();
        Mechanic mechanic = new Mechanic(1, source);
        mechanic.setField(source);

        mechanic.PickUpPipe();
    }

    public void TestDestroyPumpFixPump() {
        Main.tabCount = 0;

        Pump pump = new Pump();
        Mechanic mechanic = new Mechanic(5, pump);

        pump.Die();
        mechanic.Fix();
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

        s1.Step();
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
        
        c.Step();
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

        pump.Step();
    }

    /** 
     * 29 Test Drill Pipe On Pipe
     */
    public void TestDrillPipe() {
        Pipe p = new Pipe();
        Source s = new Source();

        Nomad n = new Nomad(10, p);

        City c = new City();

        p.setEndpoint(s, 0);
        p.setEndpoint(c, 1);

        n.DrillPipe();
    }
}
