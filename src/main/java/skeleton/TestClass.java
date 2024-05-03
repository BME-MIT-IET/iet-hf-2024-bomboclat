package skeleton;

import Game.*;
import Game.Character;


public class TestClass {

    /**
     * 1 Step on empty pipe from pump
     */
    public void TestStepOnEmptyPipePump(){
        TesterMain.tabCount = 0;

        Pump pump = new Pump();
        Character c = new Character(1, pump);
        Pipe pipe = new Pipe();

        c.setField(pump);
        pipe.setEndpoint(pump, 0);

        c.Move(0);
    }

    /**
     * 2 Step on occupied pipe from pump
     */
    public void TestStepOnOccupiedPipePump(){
        TesterMain.tabCount = 0;

        Pump pump = new Pump();
        Pipe pipe = new Pipe();
        Character c1 = new Character(1, pump);
        Character c2 = new Character(1, pipe);

        c1.setField(pump);
        c2.setField(pipe);
        pipe.setEndpoint(pump, 0);

        c1.Move(0);
    }

    /**
     * 3 Step on empty pipe from city
     */
    public void TestStepOnEmptyPipeCity(){
        TesterMain.tabCount = 0;

        City city = new City();
        Character c = new Character(1, city);
        Pipe pipe = new Pipe();

        c.setField(city);
        pipe.setEndpoint(city, 0);

        c.Move(0);
    }

    /**
     * 4 Step on occupied pipe from city
     */
     public void TestStepOnOccupiedPipeCity(){
        TesterMain.tabCount = 0;

        City city = new City();
        Pipe pipe = new Pipe();
        Character c1 = new Character(1, city);
        Character c2 = new Character(1, pipe);

        c1.setField(city);
        c2.setField(pipe);
        pipe.setEndpoint(city, 0);

        c1.Move(0);
    }

    /**
     * 5 Step on empty pipe from source 
     */
    public void TestStepOnEmptyPipeSource(){
        TesterMain.tabCount = 0;

        Source source = new Source();
        Character c = new Character(1, source);
        Pipe pipe = new Pipe();

        c.setField(source);
        pipe.setEndpoint(source, 0);

        c.Move(0);
    }

    /**
     * 6 Step on occupied pipe from source
     */
    public void TestStepOnOccupiedPipeSource(){
        TesterMain.tabCount = 0;

        Source source = new Source();
        Pipe pipe = new Pipe();
        Character c1 = new Character(1, source);
        Character c2 = new Character(1, pipe);

        c1.setField(source);
        c2.setField(pipe);
        pipe.setEndpoint(source, 0);

        c1.Move(0);
    }

    /**
     * 7 Step on pump from pipe
     */
    public void TestStepOnPumpFromPipe(){
        TesterMain.tabCount=0;

        Pipe field=new Pipe();
        Pump pump=new Pump();
        Character c=new Character(1, field);
        field.setEndpoint(pump, 0);

        c.Move(0);
    }

    /**
     * 8 Step on city from pipe
     */
    public void TestStepOnCityFromPipe(){
        TesterMain.tabCount=0;

        Pipe field=new Pipe();
        City pump=new City();
        Character c=new Character(1, field);
        field.setEndpoint(pump, 0);

        c.Move(0);
    }

    /**
     * 9 Step on source from pipe
     */
    public void TestStepOnSourceFromPipe(){
        TesterMain.tabCount=0;

        Pipe field=new Pipe();
        Source pump=new Source();
        Character c=new Character(1, field);
        field.setEndpoint(pump, 0);

        c.Move(0);
    }

    /**
     * 10 Water flows from Source to Pump
     */
    public void TestWaterFlowsSourceToPump(){
        TesterMain.tabCount = 0;
        
        Source source = new Source();
        Pipe edge = new Pipe();
        Pump pump = new Pump();
        edge.setEndpoint(source, 0);
        edge.setEndpoint(pump, 1);
        pump.addEdge(edge);
        pump.Change(edge, edge);
        source.Step(true);
        pump.Step(true);
    }

    /**
     * 11 Water flows in City
     */
    public void TestWaterFlowsInCity(){
        TesterMain.tabCount = 0;

        City city = new City();
        Pipe inlet = new Pipe();
        inlet.setEndpoint(city, 1);

        city.Step(true);
    }

    /**
     * 12 Water flows in blocked input of Pump
     */
    public void TestWaterFlowsInBlocked(){
        TesterMain.tabCount = 0;
        
        Pump pump = new Pump();
        Pipe blocked = new Pipe();
        Pipe from = new Pipe();
        blocked.setEndpoint(pump, 1);
        from.setEndpoint(pump, 1);
        Pipe where = new Pipe();
        where.setEndpoint(pump, 0);
        pump.Change(from, where);

        pump.Step(true);
    }

    /**
     * 13 Change Pump
     */
    public void TestChangePump() {
        TesterMain.tabCount = 0;

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
     * 14 Water flows out of broken pipe
     */
    public void TestWaterFlowsOutOfBrokenPipe() {
        TesterMain.tabCount=0;

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

        pipe.Drill(true);

        game.EndRound();

    }

    /**
     * 15 Fix Pipe
     */
    public void TestFixPipe() {
        TesterMain.tabCount =0;

        Pipe pipe = new Pipe();
        Mechanic mechanic = new Mechanic(5, pipe);
        mechanic.Fix();

    }

    /**
     * 16 Test Place Pipe on Pump
     */
    public void TestPlacePipeOnPump() {
        TesterMain.tabCount = 0;

        Pipe pipe = new Pipe();
        Pump pump = new Pump();
        pump.addEdge(pipe);
        Mechanic mechanic = new Mechanic(5, pump);

        mechanic.PickUpPipe();

        mechanic.PlacePipe();

    }

    /**
     * 17 Test Place Pipe on Pipe
     */
    public void TestPlacePipeOnPipe() {
        TesterMain.tabCount = 0;

        Pipe pipe = new Pipe();
        Pump pump = new Pump();
        pump.addEdge(pipe);
        Mechanic mechanic = new Mechanic(5, pump);
        mechanic.setField(pipe);

        mechanic.PickUpPipe();

        mechanic.PlacePipe();
    }

    /**
     * 18 Place Pump on Pump
     */
    public void TestPlacePumpOnPump() {
        TesterMain.tabCount = 0;

        Pump pump = new Pump();
        Pump p = new Pump();

        Mechanic m = new Mechanic(10, p);

        m.setPumpInHand(pump);
        
        m.PlacePump();
    }

    /**
     * 19 Place Pump on Pipe
     */
    public void TestPlacePumpOnPipe() {
        TesterMain.tabCount = 0;
        
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
     * 20 Pick up Pipe on City
     */
    public void TestPickUpPipeOnCity(){
        TesterMain.tabCount = 0;
        
        City city = new City();
        Mechanic mechanic = new Mechanic(1, city);
        Pipe edge = new Pipe();
        edge.setEndpoint(city, 1);
        mechanic.setField(city);

        mechanic.PickUpPipe();
    }

    /**
     * 21 Pick up Pipe on Pump
     */
    public void TestPickUpPipeOnPump(){
        TesterMain.tabCount = 0;
        
        Pump pump = new Pump();
        Mechanic mechanic = new Mechanic(1, pump);
        Pipe edge = new Pipe();
        edge.setEndpoint(pump, 1);
        mechanic.setField(pump);

        mechanic.PickUpPipe();
    }

    /**
     * 22 Pick up Pipe on Pipe
     */
    public void TestPickUpPipeOnPipe(){
        TesterMain.tabCount = 0;
        
        Pipe pipe = new Pipe();
        Mechanic mechanic = new Mechanic(1, pipe);
        mechanic.setField(pipe);

        mechanic.PickUpPipe();
    }

    /**
     * 23 Pick up Pipe on Source
     */
    public void TestPickUpPipeOnSource(){
        TesterMain.tabCount = 0;
        
        Source source = new Source();
        Mechanic mechanic = new Mechanic(1, source);
        mechanic.setField(source);

        mechanic.PickUpPipe();
    }

    /**
     * 24 Destroy pump, fix pump
     */
    public void TestDestroyPumpFixPump() {
        TesterMain.tabCount = 0;

        Pump pump = new Pump();
        Mechanic mechanic = new Mechanic(5, pump);

        pump.Die();
        mechanic.Fix();
    }

    /**
     * 25 Test Water Step Source
     */
    public void TestWaterStepSource() {
        TesterMain.tabCount = 0;

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

        s1.Step(true);
    }

    /**
     * 26 Test Water Step City
     */
    public void TestWaterStepCity() {
        TesterMain.tabCount = 0;

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
        
        c.Step(true);
    }

    /**
     * 27 Test Water Step Pump
     */
    public void TestWaterStepPump() {
        TesterMain.tabCount = 0;

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

        pump.Step(true);
    }

    /** 
     * 28 Test Drill Pipe On Pipe
     */
    public void TestDrillPipe() {
        Pipe p = new Pipe();
        Source s = new Source();

        Nomad n = new Nomad(10, p);

        City c = new City();

        p.setEndpoint(s, 0);
        p.setEndpoint(c, 1);

        n.DrillPipe(true);
    }

    /**
     * 29 Pick up pump on city
     */
    public void TestPickUpPumpOnCity(){
        TesterMain.tabCount=0;

        City field=new City();
        Mechanic m=new Mechanic(1, field);

        m.PickUpPump();
    }

    /**
     * 30 Pick up pump on pump
     */
    public void TestPickUpPumpOnPump(){
        TesterMain.tabCount=0;

        Pump field=new Pump();
        Mechanic m=new Mechanic(1, field);

        m.PickUpPump();
    }

    /**
     * 31 Pick up pump on pipe
     */
    public void TestPickUpPumpOnPipe(){
        TesterMain.tabCount=0;

        Pipe field=new Pipe();
        Mechanic m=new Mechanic(1, field);

        m.PickUpPump();
    }

    /**
     * 32 Pick up pump on source
     */
    public void TestPickUpPumpOnSource(){
        TesterMain.tabCount=0;

        Source field=new Source();
        Mechanic m=new Mechanic(1, field);

        m.PickUpPump();
    }
}
