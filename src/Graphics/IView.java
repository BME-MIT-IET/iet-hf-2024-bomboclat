package Graphics;
import java.awt.Graphics;

/**
 * A megjelenítést kezelő interfész.
 */
public interface IView {
   public void Update(Graphics g);
   public int GetPlayerPositionX();
   public int GetPlayerPositionY();
}
