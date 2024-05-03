package hu.bomboclat.Game;

import java.util.ArrayList;
import java.util.List;

import hu.bomboclat.Graphics.*;


/**
* Felelőssége a játék lebonyolítása, illetve a főbb események kezelése.
 */
public class Game {
    public boolean isFinished() {
        return finished;
    }

    boolean finished = false;

    // A játék összes körének számát tárolja
    int all_rounds;
    // A játék köreinek számát tárolja.
    int round_count;
    // A játékosokat tároló változó
    List<Character> characters;
    // A pályát tároló változó.
    Playfield currPlayfield;
    // Aktív játékost tároló tagváltozó
    Character currPlayer;

    /**
     * Getter függvény a rounc_count változóhoz.
     * @return a változóban tárolt érték.
     */
    public int getRound_count() {
        return round_count;
    }

    /**
     * Getter függvény a currPlayer tagváltozóhoz.
     * @return a változóban tárolt objektum referencia.
     */
    public Character getCurrPlayer() {
        return currPlayer;
    }

    public int getStep_count() {
        return step_count;
    }

    /**
     * Azt tárolja, hogy a játékos mennyi lépést végzett el.
     */
    int step_count;

    /**
     * GameFrame-t tároló statikus változó. Grafikus megjelenítéshez kell.
     */
    public static GameFrame frame;

    /**
     * Game konstruktor
     */
    public Game(int _all_rounds){
        round_count = 0;
        all_rounds = _all_rounds;
        characters = new ArrayList<Character>();
        currPlayfield = null;
    }

    /**
     * Game második konstuktora. A grafikus megjelenítés miatt szükséges (GameFrame f paraméter)
     */
    public Game(int _all_rounds, GameFrame f){
        frame = f;
        round_count = 0;
        all_rounds = _all_rounds;
        characters = new ArrayList<Character>();
        currPlayfield = null;
    }

    /**
     * Default konstruktor
     */
    public Game(){
        round_count = 0;
        all_rounds = 10;
        characters = new ArrayList<Character>();
        currPlayfield = null;
    }

    /**
     * Elindítja a játékmenetet.
     */        
    public List<IView> StartGame(int _characters){
        List<IView> ret = new ArrayList<IView>();
        round_count = 0;
        currPlayfield = new Playfield();

        City c1 = new City();
        c1.getView().setX(20);
        c1.getView().setY(20);
        ret.add(c1.getView());
        Source s1 = new Source();
        s1.getView().setX(400);
        s1.getView().setY(20);
        ret.add(s1.getView());
        currPlayfield.addNode(c1);
        currPlayfield.addNode(s1);

        Pump p1 = new Pump();
        p1.getView().setX(50);
        p1.getView().setY(300);
        ret.add(p1.getView());
        Pump p2 = new Pump();
        p2.getView().setX(500);
        p2.getView().setY(300);
        ret.add(p2.getView());
        Pipe pipe1 = new Pipe();
        ret.add(pipe1.getView());
        Pipe pipe2 = new Pipe();
        ret.add(pipe2.getView());
        Pipe pipe3 = new Pipe();
        ret.add(pipe3.getView());
        Pipe pipe4 = new Pipe();
        ret.add(pipe4.getView());
        currPlayfield.addNode(p1);
        currPlayfield.addNode(p2);
        currPlayfield.addPipe(pipe1);
        currPlayfield.addPipe(pipe2);
        currPlayfield.addPipe(pipe3);
        currPlayfield.addPipe(pipe4);

        pipe1.setEndpoint(c1, 1);
        pipe1.setEndpoint(s1, 0);
        pipe2.setEndpoint(c1, 1);
        pipe2.setEndpoint(p2, 0);
        pipe3.setEndpoint(p1, 1);
        pipe3.setEndpoint(p2, 0);
        pipe4.setEndpoint(s1, 0);
        pipe4.setEndpoint(p1, 1);

        p1.Change(pipe4, pipe3);
        p2.Change(pipe3, pipe2);

        for(int i=0; i<_characters; i++) {
            Mechanic mech = new Mechanic(5, pipe1);
            characters.add(mech);
            ret.add(mech.getView());
            Nomad nom = new Nomad(5, p2);
            characters.add(nom);
            ret.add(nom.getView());
        }
        currPlayer=characters.get(0);
        currPlayer.setActive();
        step_count=0;
        return ret;
    }



    /**
     * A játék végeztével összeszámolja a csapatok által szerzett pontokat, továbbá eldönti, hogy melyik csapat nyert.
     * @return int 1 ha a mechanic csapat nyert, 0 ha a nomádok
     */
    public int GetResult(){
        int mech = currPlayfield.getMechanicPoints();
        int nomad = currPlayfield.getNomadPoints();
        return mech > nomad ? 1 : 0;
    }

    /**
     * A játszma végeztével leállítja a játékot.
     */
    public String EndGame(){

        String winMessage = GetResult() == 1 ? "Mechanic team wins. NYOMOD!!!!" : "Nomad team wins. NYOMOD!!!!";
        finished=true;
        return(winMessage);
    }

    /**
     * Egy kör végeztével levezényli a stepable interfészt megvalósító elemek lépését.
     * @return grafikus megjelenítés miatt szükséges - tervezői döntés csak az EndGame esetében van jelentősége a stringnek.
     */
    public String EndRound(){
        for(int i=0; i<this.currPlayfield.pipes.size(); i++) {
            this.currPlayfield.pipes.get(i).setHadwater(false);
        }
        currPlayfield.Step(true);
        if(round_count==all_rounds-1) {
            return EndGame();
        }
        else {
            currPlayer = characters.get(0);
            currPlayer.setActive();
            step_count = 0;
            round_count++;
            return "";
        }
    }

    /**
     * 
     * @return grafikus megjelenítés miatt szükséges - tervezői döntés csak az EndGame esetében van jelentősége a stringnek.
     */
    public String EndStep() {
        currPlayer.setMoves(currPlayer.getAllMoves());
        currPlayer.setNotActive();
        if(step_count<characters.size()-1) {
            currPlayer = characters.get(++step_count);
            currPlayer.setActive();
            return "";
        }
        else {
            return EndRound();
        }
    }

    /**
     * Karakter tömbhöz setter
     * @param character a hozzáadandó játékos
     */
    public void addCharacter(Character character){
        characters.add(character);
    }
    /**
     * currPlayfield változóhoz setter
     * @param playfield a beállítandó playfield
     */
    public void setCurrPlayfield(Playfield playfield){
        this.currPlayfield = playfield;
    }
}
