package Graphics;

import Game.Game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {
    private JPanel control;
    private Drawer canvas;
    private Color bgColor = new Color(255,238,203);
    private Game currentGame;

    private JMenuBar menuBar;

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
        this.menuBar=this.createMenuBar();
        this.menuBar.setBackground(bgColor);
        this.menuBar.setBorder(new LineBorder(bgColor));
        this.setJMenuBar(this.menuBar);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        var menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        var newGameMenuItem = new JMenuItem("Start new game", KeyEvent.VK_N);
        //actionlistener
        var exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        //kulturaltabb action listener
        exitMenuItem.addActionListener(e -> {
            this.dispose();
        });

        menu.add(newGameMenuItem);
        menu.add(exitMenuItem);

        return menuBar;
    }
}
