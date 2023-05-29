package Graphics;
import java.awt.Graphics;

import Game.Field;

/**
 * A megjelenítést kezelő interfész.
 */
public interface IView {
   /**
    * Ezt megvalósítva végzendő el a g objektumra varó rajzolás.
    * @param g
    */
   public void Update(Graphics g);
   /**
    * Ezt megvalósítva végzendő el a g objektumra varó rajzolás.
    * @return Field - a visszatérítendő Field objektum
    */
   public Field getField();
   public int getPlayerPositionX();
   public int getPlayerPositionY();
}
