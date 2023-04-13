import java.util.ArrayList;
import java.util.List;

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
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game has been initialized");
        Main.tabCount++;
        round_count = 0;
        characters = new ArrayList<Character>();
        currPlayfield = null;
        Main.tabCount--;
    }

    /**
     * Elindítja a játékmenetet.
     */
    public void StartGame(){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::StartGame()");
        Main.tabCount++;
        Main.tabCount--;
    }

    /**
     * A játék végeztével összeszámolja a csapatok által szerzett pontokat, továbbá eldönti, hogy melyik csapat nyert.
     * @return int 1 ha a mechanic csapat nyert, 0 ha a nomádok
     */
    public int GetResult(){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::GetResult()");
        Main.tabCount++;
        int mech = currPlayfield.getMechanicPoints();
        int nomad = currPlayfield.getNomadPoints();
        Main.tabCount--;
        return mech > nomad ? 1 : 0;
    }

    /**
     * A játszma végeztével leállítja a játékot.
     */
    public void EndGame(){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::EndGame()");
        Main.tabCount++;
        Main.tabCount--;
    }

    /**
     * Egy kör végeztével levezényli a stepable interfészt megvalósító elemek lépését.
     */
    public void EndRound(){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::EndRound()");
        Main.tabCount++;
        currPlayfield.Step();
        round_count++;
        Main.tabCount--;
    }

    /**
     * Karakter tömbhöz setter
     * @param character a hozzáadandó játékos
     */
    public void addCharacter(Character character){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::setCharacters()");
        Main.tabCount++;
        characters.add(character);
        Main.tabCount--;
    }
    /**
     * currPlayfield változóhoz setter
     * @param playfield a beállítandó playfield
     */
    public void setCurrPlayfield(Playfield playfield){
        for(int i = 0; i < Main.tabCount; i++) { System.out.print("\t"); }
        System.out.println("Game::setCurrPlayfield()");
        Main.tabCount++;
        this.currPlayfield = playfield;
        Main.tabCount--;
    }
}
