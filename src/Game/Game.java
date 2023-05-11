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
    public void StartGame(String filepath){
        round_count = 0;
        
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
        int mechPoint = currPlayfield.getMechanicPoints();
        int nomadPoint = currPlayfield.getNomadPoints();

        String winMessage = mechPoint > nomadPoint ? "Mechanic team wins. NYOMOD!!!!" : "Nomad team wins. NYOMOD!!!!";

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
