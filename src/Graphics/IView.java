package Graphics;
import java.awt.Graphics;

import Game.Field;

/**
 * A megjelenítést kezelő interfész.
 */
public interface IView {
   public void Update(Graphics g);
   public Field getField();
   public int getPlayerPositionX();
   public int getPlayerPositionY();
}
