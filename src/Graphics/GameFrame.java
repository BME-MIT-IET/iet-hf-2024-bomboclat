package Graphics;

import Game.Game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JPanel control;
    private Drawer canvas;
    private Color bgColor = new Color(255,238,203);
    private Game currentGame;

    public GameFrame(String title) {
        super(title);
        this.initFrame();
    }

    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setLayout(new BorderLayout());
        this.getContentPane().setBackground(bgColor);

        this.control=new JPanel();
        this.control.setLayout(new BorderLayout());
        //init canvas
    }

}
