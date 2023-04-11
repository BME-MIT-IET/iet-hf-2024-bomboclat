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
}
