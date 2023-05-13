package Game;

import skeleton.*;

/**
 * A szabotőrt reprezentáló osztály
 */
public class Nomad extends Character{
    
    /**
     * Nomad default konstruktor
     */
    public Nomad() {
    }

    /**
     * Nomad konstruktor
     * @param nMoves A szabotőr lépéseinek száma egy körben
     * @param nField A mező, amin a szabotőr áll
     */
    public Nomad(int nMoves, Field nField){
        super(nMoves, nField);
    }

    /**
     * A szabotőr csúszóssá teszi a csövet, amin áll
     * @return Igaz, ha sikerült csúszóssá tenni a csövet
     */
    public boolean Lube(){
        boolean ret = this.field.Lube();
        return ret;
    }
}
