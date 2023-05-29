package Graphics;

import Game.Field;
import Game.Nomad;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A Nomad típusú objektumok kirajzolásáért felelős osztály
 */
public class NomadView implements IView{
    /**
     * A szabotőr, akit megjelenít
     */
    private Nomad nomad;
    /**
     * A megjelenítési pozíció x koordinátája
     */
    private int x;
    /**
     * A megjelenítési pozíció y koordinátája
     */
    private int y;
    /**
     * Az adott karakter épp irányítás alatt áll-e
     */
    private boolean selected;

    /**
     * NomadView konstruktor
     */
    public NomadView(){
        x = y = 0;
        nomad = null;
    }

    /**
     * A nomad tagváltozóhoz setter
     * @param n a beállítandó Nomad típusú objektum referenciája
     */
    public void setNomad(Nomad n){
        nomad = n;
    }

    /**
     * A nomad tagváltozóhoz getter
     * @return a nomad tagváltozó referenciája
     */
    public Nomad getNomad(){
        return nomad;
    }


    /**
     * Az Update metódus felüldefiniálása (IView implementálása miatt)
     * Elvégzi a szerelőt reprezentáló kép kirajzolását.
     * Ehhez lekéri az objektumhoz tartozó backend-beli mechanic aktuális fieldjét.
     * Majd ettől a field-től lekérdezi a field-hez tartozó frontend/view objektumot és lekéri annak x,y koordinátáját.
     * A kapott koordináták alapján elvégzi a kirajzolást.
     */
    @Override
    public void Update(Graphics g) {
        x = nomad.getField().getView().getPlayerPositionX();
        y = nomad.getField().getView().getPlayerPositionY();
        String imageName = "Nomad";
        if(selected){
            imageName = imageName.concat("-selected");
        }
        try{
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("Images\\" + imageName + ".png"));
            int offsetX = image.getWidth();
            int offsetY = image.getHeight();
            g.drawImage(image, x - offsetX + 25, y - offsetY + 25, null);
        }
        catch(IOException e){
            
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
