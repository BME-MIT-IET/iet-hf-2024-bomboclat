package Game;

import java.util.ArrayList;
import java.util.List;

import skeleton.*;


/**
* Felelőssége a játék lebonyolítása, illetve a főbb események kezelése.
 */
public class Game {
    //A játék köreinek számát tárolja.
    int round_count;
    //A játékosokat tároló változó
    List<Character> characters;
    //A pályát tároló változó.
    Playfield currPlayfield;


    /**
     * Game konstruktor
     */
    public Game(){
        round_count = 0;
        characters = new ArrayList<Character>();
        currPlayfield = null;
    }

    /**
     * Elindítja a játékmenetet.
     */        
    public void StartGame(int _characters){
        round_count = 0;
        currPlayfield = new Playfield();

        City c1 = new City();
        Source s1 = new Source();
        
        Pump p1 = new Pump();
        Pump p2 = new Pump();
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Pipe pipe4 = new Pipe();

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
            characters.add(new Mechanic(5, p1));
            characters.add(new Nomad(5, p2));
        }
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
    public void EndGame(){
        String winMessage = GetResult() == 1 ? "Mechanic team wins. NYOMOD!!!!" : "Nomad team wins. NYOMOD!!!!";

        System.out.println(winMessage);
    }

    /**
     * Egy kör végeztével levezényli a stepable interfészt megvalósító elemek lépését.
     */
    public void EndRound(){
        currPlayfield.Step(true);
        round_count++;
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
