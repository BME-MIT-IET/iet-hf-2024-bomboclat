package Graphics;

import Game.Field;
import Game.Nomad;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NomadView implements IView{
    //A szabotőr, akit megjelenít
    private Nomad nomad;
    //A megjelenítési pozíció x koordinátája
    private int x;
    //A megjelenítési pozíció y koordinátája
    private int y;
    //Az adott karakter épp irányítás alatt áll-e
    private boolean selected;

    public NomadView(){
        x = y = 0;
        nomad = null;
    }

    public void setNomad(Nomad n){
        nomad = n;
    }

    public Nomad getNomad(){
        return nomad;
    }


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

    @Override
    public Field getField() {
        return null;
    }
}
