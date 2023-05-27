package Graphics;

import Game.Game;
import Game.Mechanic;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {
    private JPanel control;
    private Drawer canvas = new Drawer();
    private Color bgColor = new Color(255, 255, 255);
    private Game currentGame;
    private JMenuBar menuBar;
    private JPanel board;
    private JButton drill;
    private JButton fix;
    private JButton glue;
    private JButton lube;
    private JButton move;
    private JButton pickUpPipe;
    private JButton pickUpPump;
    private JButton placePipe;
    private JButton placePump;
    private JButton exit;

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
        this.control.setLayout(new BoxLayout(this.control, BoxLayout.Y_AXIS));
        control.setMinimumSize(new Dimension(400, 800));
        control.setPreferredSize(new Dimension(400, 800));
        //TEMP
        control.setBackground(new Color(255,255,255));

        this.drill = new JButton("Drill");
        this.drill.setMaximumSize(new Dimension(175, 50));
        this.drill.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.drill.setForeground(new Color(0,0,0));
        this.drill.setBackground(new Color(255,255,255));
        this.drill.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.drill.setFocusPainted(false);
        //actionlistener TODO
        control.add(drill);
        control.add(Box.createVerticalStrut(40));

        this.fix = new JButton("Fix");
        this.fix.setMaximumSize(new Dimension(175, 50));
        this.fix.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.fix.setForeground(new Color(0,0,0));
        this.fix.setBackground(new Color(255,255,255));
        this.fix.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.fix.setFocusPainted(false);
        //actionlistener TODO
        control.add(fix);
        control.add(Box.createVerticalStrut(40));

        this.glue = new JButton("Glue");
        this.glue.setMaximumSize(new Dimension(175, 50));
        this.glue.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.glue.setForeground(new Color(0,0,0));
        this.glue.setBackground(new Color(255,255,255));
        this.glue.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.glue.setFocusPainted(false);
        //actionlistener TODO
        control.add(glue);
        control.add(Box.createVerticalStrut(40));

        this.lube = new JButton("Lube");
        this.lube.setMaximumSize(new Dimension(175, 50));
        this.lube.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lube.setForeground(new Color(0,0,0));
        this.lube.setBackground(new Color(255,255,255));
        this.lube.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.lube.setFocusPainted(false);
        //actionlistener TODO
        control.add(lube);
        control.add(Box.createVerticalStrut(40));

        this.move = new JButton("Move");
        this.move.setMaximumSize(new Dimension(175, 50));
        this.move.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.move.setForeground(new Color(0,0,0));
        this.move.setBackground(new Color(255,255,255));
        this.move.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.move.setFocusPainted(false);
        //actionlistener TODO
        control.add(move);
        control.add(Box.createVerticalStrut(40));

        this.pickUpPipe = new JButton("Pick Up Pipe");
        this.pickUpPipe.setMaximumSize(new Dimension(175, 50));
        this.pickUpPipe.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.pickUpPipe.setForeground(new Color(0,0,0));
        this.pickUpPipe.setBackground(new Color(255,255,255));
        this.pickUpPipe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.pickUpPipe.setFocusPainted(false);
        //actionlistener TODO
        control.add(pickUpPipe);
        control.add(Box.createVerticalStrut(40));

        this.pickUpPump = new JButton("Pick Up Pump");
        this.pickUpPump.setMaximumSize(new Dimension(175, 50));
        this.pickUpPump.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.pickUpPump.setForeground(new Color(0,0,0));
        this.pickUpPump.setBackground(new Color(255,255,255));
        this.pickUpPump.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.pickUpPump.setFocusPainted(false);
        //actionlistener TODO
        control.add(pickUpPump);
        control.add(Box.createVerticalStrut(40));

        this.placePipe = new JButton("Place Pipe");
        this.placePipe.setMaximumSize(new Dimension(175, 50));
        this.placePipe.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.placePipe.setForeground(new Color(0,0,0));
        this.placePipe.setBackground(new Color(255,255,255));
        this.placePipe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.placePipe.setFocusPainted(false);
        //actionlistener TODO
        control.add(placePipe);
        control.add(Box.createVerticalStrut(40));

        this.placePump = new JButton("Place Pump");
        this.placePump.setMaximumSize(new Dimension(175, 50));
        this.placePump.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.placePump.setForeground(new Color(0,0,0));
        this.placePump.setBackground(new Color(255,255,255));
        this.placePump.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.placePump.setFocusPainted(false);
        //actionlistener TODO
        control.add(placePump);
        control.add(Box.createVerticalStrut(40));

        this.exit = new JButton("Exit");
        this.exit.setMaximumSize(new Dimension(175, 50));
        this.exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.exit.setForeground(new Color(0,0,0));
        this.exit.setBackground(new Color(255,255,255));
        this.exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.exit.setFocusPainted(false);
        this.exit.addActionListener(e -> {this.currentGame.EndStep();this.canvas.revalidate();this.canvas.repaint();});
        control.add(exit);
        control.add(Box.createVerticalStrut(40));
        add(control, BorderLayout.EAST);

        this.menuBar = this.createMenuBar();
        this.menuBar.setBackground(bgColor);
        this.menuBar.setBorder(new LineBorder(bgColor));
        this.setJMenuBar(this.menuBar);

        this.board=new JPanel(new BorderLayout());
        board.setMinimumSize(new Dimension(1000, 800));
        board.setPreferredSize(new Dimension(1000, 800));
        board.add(canvas, BorderLayout.CENTER);
        add(board, BorderLayout.WEST);

    }

    private void startGame(int num) {
        currentGame = new Game();
        canvas.setViewables(currentGame.StartGame(num));
        canvas.revalidate();
        canvas.repaint();

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
                    startGame(nNum);
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


