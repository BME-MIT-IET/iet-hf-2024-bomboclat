package hu.bomboclat.Graphics;
import java.awt.Graphics;
import java.io.Serializable;

import hu.bomboclat.Game.Field;

/**
 * A megjelenítést kezelő interfész.
 */
public interface IView extends Serializable {
   /**
    * Ezt megvalósítva végzendő el a g objektumra varó rajzolás.
    * @param g
    */
   public void Update(Graphics g);
   /**
    * A megvalósító osztály visszaadja a hozzátartozó/vele összerendelt Field típusú objektumot (pl.: PumpView a hozzá tartozó Pump-ot)
    * @return Field - a visszatérítendő Field objektum
    */
   public Field getField();
   /**
    * A megvalósító osztály visszaadja a játékos megjelenítési pozíciójának x koordinátáját.
    * @return x koordináta
    */
   public int getPlayerPositionX();
   /**
    * A megvalósító osztály visszaadja a játékos megjelenítési pozíciójának y koordinátáját.
    * @return y koordináta
    */
   public int getPlayerPositionY();
}
