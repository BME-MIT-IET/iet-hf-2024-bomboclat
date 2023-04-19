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
        for(int i = 0; i < TesterMain.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game has been initialized");
        TesterMain.tabCount++;
        round_count = 0;
        characters = new ArrayList<Character>();
        currPlayfield = null;
        TesterMain.tabCount--;
    }

    /**
     * Elindítja a játékmenetet.
     */
    public void StartGame(){
        for(int i = 0; i < TesterMain.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::StartGame()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    /**
     * A játék végeztével összeszámolja a csapatok által szerzett pontokat, továbbá eldönti, hogy melyik csapat nyert.
     * @return int 1 ha a mechanic csapat nyert, 0 ha a nomádok
     */
    public int GetResult(){
        for(int i = 0; i < TesterMain.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::GetResult()");
        TesterMain.tabCount++;
        int mech = currPlayfield.getMechanicPoints();
        int nomad = currPlayfield.getNomadPoints();
        TesterMain.tabCount--;
        return mech > nomad ? 1 : 0;
    }

    /**
     * A játszma végeztével leállítja a játékot.
     */
    public void EndGame(){
        for(int i = 0; i < TesterMain.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::EndGame()");
        TesterMain.tabCount++;
        TesterMain.tabCount--;
    }

    /**
     * Egy kör végeztével levezényli a stepable interfészt megvalósító elemek lépését.
     */
    public void EndRound(){
        for(int i = 0; i < TesterMain.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::EndRound()");
        TesterMain.tabCount++;
        currPlayfield.Step();
        round_count++;
        TesterMain.tabCount--;
    }

    /**
     * Karakter tömbhöz setter
     * @param character a hozzáadandó játékos
     */
    public void addCharacter(Character character){
        for(int i = 0; i < TesterMain.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::setCharacters()");
        TesterMain.tabCount++;
        characters.add(character);
        TesterMain.tabCount--;
    }
    /**
     * currPlayfield változóhoz setter
     * @param playfield a beállítandó playfield
     */
    public void setCurrPlayfield(Playfield playfield){
        for(int i = 0; i < TesterMain.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::setCurrPlayfield()");
        TesterMain.tabCount++;
        this.currPlayfield = playfield;
        TesterMain.tabCount--;
    }
}
