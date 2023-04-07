import java.util.List;

abstract public class Field{
    List<Character> players;
    
    /**
     * 
     * @param d
     * @return
     */
    abstract Field getNeighbour(int d);

    /**
     * 
     * @param c
     */
    void Remove(Character c){}

    /**
     * 
     * @param c
     */
    void Accept(Character c){}

    /**
     * 
     */
    void Fix(){}

    /**
     * 
     */
    void Drill(){}

    /**
     * 
     * @param p
     * @param d
     */
    void Change(Pipe p, Pipe d){}

    /**
     * 
     * @return
     */
    Pipe PickUpPipe(){}

    /**
     * 
     * @return
     */
    Pump PickUpPump(){}

    /**
     * 
     */
    void PlacePipe(){}

    /**
     * 
     * @param d
     * @return
     */
    Node getEndpoint(int d){}

    /**
     * 
     * @param p
     */
    void addEdge(Pipe p){}

    /**
     * 
     * @param p
     * @return
     */
    Pump PlacePump(Pump p){}




}