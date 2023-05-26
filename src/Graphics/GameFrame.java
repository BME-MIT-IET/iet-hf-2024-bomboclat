package Graphics;

import Game.Game;
import Game.Mechanic;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {
    private JPanel control;
    private Drawer canvas;
    private Color bgColor = new Color(255, 238, 203);
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

        this.control = new JPanel();
        this.control.setLayout(new BorderLayout());
        //init canvas
        this.menuBar = this.createMenuBar();
        this.menuBar.setBackground(bgColor);
        this.menuBar.setBorder(new LineBorder(bgColor));
        this.setJMenuBar(this.menuBar);

        this.currentGame = new Game();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        var menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        var newGameMenuItem = new JMenuItem("Start new game", KeyEvent.VK_N);
        JPanel p = new JPanel(new BorderLayout(5, 5));
        JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
        labels.add(new JLabel("Mechanic: ", SwingConstants.TRAILING));
        labels.add(new JLabel("Nomad: ", SwingConstants.TRAILING));
        p.add(labels, BorderLayout.LINE_START);
        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField mechanics = new JTextField();
        controls.add(mechanics);
        JTextField nomads = new JTextField();
        controls.add(nomads);
        p.add(controls, BorderLayout.CENTER);
        UIManager.put("OptionPane.noButtonText", "Cancel");
        UIManager.put("OptionPane.yesButtonText", "StartNewGame");
        newGameMenuItem.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, p, "", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                int mNum = Integer.parseInt(mechanics.getText());
                int nNum = Integer.parseInt(nomads.getText());
                if (mNum == nNum)
                    currentGame.StartGame(nNum);
                else {
                    JOptionPane.showMessageDialog(this, "The number of Mechanics must equal the number of Nomads!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
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


