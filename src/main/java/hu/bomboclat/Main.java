package hu.bomboclat;

import javax.swing.*;
import java.awt.*;
import hu.bomboclat.Graphics.GameFrame;

public class Main {
    
    public static void main(String[] args){
        //CommandInterpreter c = new CommandInterpreter();
        //c.main(args);

        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame("Sivatagi vízhálózat");
            frame.setMinimumSize(new Dimension(1400, 800));
            frame.setPreferredSize(new Dimension(1400, 800));
            frame.pack();
            frame.setVisible(true);
        });
    }
}
