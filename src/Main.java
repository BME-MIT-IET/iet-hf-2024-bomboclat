
public class Main {
    public static int tabCount = 0;

    public static void main(String[] args){
        Character c = new Character(1, null);
        Pump pump = new Pump();
        Pipe pipe = new Pipe();

        c.setField(pump);
        pump.addEdge(pipe);
        pipe.setEndpoint(pump, 0);

        c.Move(0);
    }
}
