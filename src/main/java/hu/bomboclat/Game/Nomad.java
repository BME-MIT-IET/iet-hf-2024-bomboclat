package hu.bomboclat.Game;

import hu.bomboclat.Graphics.NomadView;
import hu.bomboclat.Graphics.IView;

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

    /**
     * Beállítja a mechanicView tagváltozó setSelected tagváltozóját true-ra.
     * Ezáltal az adott játékos egy piros téglalappal lesz körülvéve, ezzel jelezve, hogy ő az aktív játékos, aki léphet.
     * Felülírja az ős azonos nevű függvényét.
     */
    @Override
    public void setActive() {
        nomadView.setSelected(true);
    }

    /**
     * Beállítja a mechanicView tagváltozó setSelected tagváltozóját false-ra.
     * Így vizuálisan se lesz aktív az adott játékoshoz tartozó karakter.
     * Felülírja az ős azonos nevű függvényét.
     */
    @Override
    public void setNotActive()
    {
        nomadView.setSelected(false);
    }

    /**
     * A szabotőr csúszóssá teszi a csövet, amin áll
     * @return Igaz, ha sikerült csúszóssá tenni a csövet
     */
    @Override
    public boolean Lube(){
        boolean ret = this.field.Lube();
        if(ret){
            moves--;
        }
        return ret;
    }

    /**
     * A nomadView tagváltozó értékét állítja be.
     * @param view beállítandó view objektum.
     */
    public void setView(NomadView view){
        nomadView = view;
    }

    /**
     * @return visszaadja a nomadView tagváltozóban tárolt objektumot (annak referenciáját.)
     */
    public IView getView(){
        return nomadView;
    }
}
