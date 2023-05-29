package Graphics;
import Game.Field;
import Game.Mechanic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A szerelő megjelnítéséért felelős osztály
 */
public class MechanicView implements IView{
    //A szerelő, akit megjelenít
    private Mechanic mechanic;
    //A megjelenítési pozíció x koordinátája
    private int x;
    //A megjelenítési pozíció y koordinátája
    private int y;
    //Az adott karakter épp irányítás alatt áll-e
    private boolean selected;

    /**
     * Default konstruktor
     */
    public MechanicView(){
        x = 0;
        y = 0;
        selected = false;
        mechanic = null;
    }

    /**
     * A megjelenített szerelő settere
     * @param m A megjeleníteni kívánt szerelő
     */
    public void setMechanic(Mechanic m){
        mechanic = m;
    }

    /**
     * A megejelíntett szerelő gettere
     */
    public Mechanic getMechanic(){
        return mechanic;
    }

    @Override
    public void Update(Graphics g) {
        x = mechanic.getField().getView().getPlayerPositionX();
        y = mechanic.getField().getView().getPlayerPositionY();
        String imageName = "Mechanic";
        if(selected){
            imageName = imageName.concat("-selected");
        }
        if(mechanic.GetPumpInHand() != null){
            imageName = imageName.concat("-pump");
        }
        if(mechanic.GetPipeInHand() != null){
            imageName = imageName.concat("-pipe");
        }
        
        try{
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("Images\\" + imageName + ".png"));
            int offsetX = image.getWidth();
            int offsetY = image.getHeight();
            g.drawImage(image, x - offsetX + 25, y - offsetY + 25, null);
        }
        catch(IOException e){  
            System.out.println("Nem lehet betölteni a képet!");
        }
        
    }

    /**
     * A megjelenítési pozíció x koordinátájának gettere
     */
    @Override
    public int getPlayerPositionX() {
        return x;
    }
    /**
     * A megjelenítési pozíció y koordinátájának gettere
     */
    @Override
    public int getPlayerPositionY() {
       return y;
    }

    /**
     * A kijelölt állapot settere
     * @param value igaz, ha az adott szerelő épp ki van jelölve, hamis ha nem
     */
    public void setSelected(boolean value){
        selected = value;

    }

    /**
     * A kijelölt állapot gettere
     * @return
     */
    public boolean isSelected(){
        return selected;
    }

    /**
     * Nem térít vissza semmit, hiszen játékos View-jához nem tartozik Field típusú objektum.
     */
    @Override
    public Field getField() {
        return null;
    }
}
