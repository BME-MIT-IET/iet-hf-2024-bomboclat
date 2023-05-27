package Game;

import skeleton.*;
import Graphics.NomadView;
import Graphics.IView;

/**
 * A szabotőrt reprezentáló osztály
 */
public class Nomad extends Character{
    
    private NomadView nomadView;
    /**
     * Nomad default konstruktor
     */
    public Nomad() {
        nomadView = new NomadView();
        nomadView.setNomad(this);
    }

    /**
     * Nomad konstruktor
     * @param nMoves A szabotőr lépéseinek száma egy körben
     * @param nField A mező, amin a szabotőr áll
     */
    public Nomad(int nMoves, Field nField){
        super(nMoves, nField);
        nomadView = new NomadView();
        nomadView.setNomad(this);
    }
    @Override
    public void setActive() {
        nomadView.setSelected(true);
    }
    @Override
    public void setNotActive()
    {
        nomadView.setSelected(false);
    }

    /**
     * A szabotőr csúszóssá teszi a csövet, amin áll
     * @return Igaz, ha sikerült csúszóssá tenni a csövet
     */
    public boolean Lube(){
        boolean ret = this.field.Lube();
        return ret;
    }

    public void setView(NomadView view){
        nomadView = view;
    }

    public IView getView(){
        return nomadView;
    }
}
