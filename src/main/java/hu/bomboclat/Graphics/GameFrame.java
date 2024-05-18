package hu.bomboclat.Graphics;

import hu.bomboclat.Game.Game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

/**
 * A felhaszáló által látható ablakot megvalósító osztály
 */
public class GameFrame extends JFrame {

    /**
     * A játékhoz tartozó gombokat tartalmazó panel
     */
    private JPanel control;
    /**
     * Rajzolási felület
     */
    private Drawer canvas = new Drawer();
    /**
     * A rajzolási felület alap-/háttérszíne
     */
    private Color bgColor = new Color(255, 238, 203);
    /**
     * Aktuális Game objektumot tároló változó
     */
    public Game currentGame;

    /**
     * Menüt tartalmazó tagváltozó, annak megjelenítéséért felel.
     */
    private JMenuBar menuBar;

    /**
     * A játék lényegi felületét tartalmazó panel (ahol megjelennek az objektumok, játékosok)
     */
    private JPanel board;

    /**
     * Gombok a különböző játékkal kapcsolatos akciók megvalósításához, elsütéséhez.
     */
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
    private JButton changePump;
    private JLabel infoLabel;

    /**
     * GameFrame konstruktor
     */
    public GameFrame(String title) {
        super(title);
        this.initFrame();
    }

    /**
     * Elvégzi az ablak inicializálását.
     * Ennek lépései vázlatosan:
     * - Beállítja a játékhoz tartozó ikont.
     * - Beállítja a control panelt, amely majd az akcióval kapcsolatos gombokat fogja tartalmazni.
     * - Beállítja a gombokat.
     * - Beállítja a menubar-t egy külön függvény meghívásával.
     * - Beállítja a board panelt.
     * Beállítás alatt érteni kell az elemek megfelelő elhelyezését, skálázását, illetve az eseménykezelők hozzárendelését az elemekhez is.
     * Például ez a gombok esetén az adott gombhoz tartozó akciót indítja el, amely a backend-ben folytatja futását.
     * (röviden: Lube gombra kattintva meghívódik az aktív játékos Lube függvénye)
     */
    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        URL url = ClassLoader.getSystemResource("Images/deserticon.jpg");
        Toolkit kit = Toolkit.getDefaultToolkit();
        if(url != null) {
            Image img = kit.createImage(url);
            this.setIconImage(img);
        }
        setLayout(new BorderLayout());
        this.getContentPane().setBackground(bgColor);

        this.control = new JPanel();
        this.control.setLayout(new BoxLayout(this.control, BoxLayout.Y_AXIS));
        control.setMinimumSize(new Dimension(400, 800));
        control.setPreferredSize(new Dimension(400, 800));
        control.setBackground(new Color(255, 238, 203));

        this.infoLabel = new JLabel();
        this.infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        control.add(infoLabel, BorderLayout.NORTH);

        this.changePump = new JButton("Change Pump");
        this.changePump.setName("ChangePump");
        this.changePump.setMaximumSize(new Dimension(175, 50));
        this.changePump.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.changePump.setForeground(new Color(0,0,0));
        this.changePump.setBackground(new Color(255,255,255));
        this.changePump.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.changePump.setFocusPainted(false);
        this.changePump.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){this.canvas.setWantsToChange(currentGame.getCurrPlayer());
            this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));}});
        control.add(changePump);
        control.add(Box.createVerticalStrut(40));

        this.drill = new JButton("Drill");
        this.drill.setName("Drill");
        this.drill.setMaximumSize(new Dimension(175, 50));
        this.drill.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.drill.setForeground(new Color(0,0,0));
        this.drill.setBackground(new Color(255,255,255));
        this.drill.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.drill.setFocusPainted(false);
        this.drill.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){this.currentGame.getCurrPlayer().DrillPipe(true); this.canvas.revalidate();this.canvas.repaint();
            this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));}});
        control.add(drill);
        control.add(Box.createVerticalStrut(40));

        this.fix = new JButton("Fix");
        this.fix.setName("Fix");
        this.fix.setMaximumSize(new Dimension(175, 50));
        this.fix.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.fix.setForeground(new Color(0,0,0));
        this.fix.setBackground(new Color(255,255,255));
        this.fix.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.fix.setFocusPainted(false);
        this.fix.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){(this.currentGame.getCurrPlayer()).Fix(); this.canvas.revalidate();this.canvas.repaint();
            this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));}});
        control.add(fix);
        control.add(Box.createVerticalStrut(40));

        this.glue = new JButton("Glue");
        this.glue.setName("Glue");
        this.glue.setMaximumSize(new Dimension(175, 50));
        this.glue.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.glue.setForeground(new Color(0,0,0));
        this.glue.setBackground(new Color(255,255,255));
        this.glue.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.glue.setFocusPainted(false);
        this.glue.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){this.currentGame.getCurrPlayer().Glue(); this.canvas.revalidate();this.canvas.repaint();
            this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));}});
        control.add(glue);
        control.add(Box.createVerticalStrut(40));

        this.lube = new JButton("Lube");
        this.lube.setName("Lube");
        this.lube.setMaximumSize(new Dimension(175, 50));
        this.lube.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lube.setForeground(new Color(0,0,0));
        this.lube.setBackground(new Color(255,255,255));
        this.lube.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.lube.setFocusPainted(false);
        this.lube.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){this.currentGame.getCurrPlayer().Lube(); this.canvas.revalidate();this.canvas.repaint();
            this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));}});
        control.add(lube);
        control.add(Box.createVerticalStrut(40));

        this.move = new JButton("Move");
        this.move.setName("Move");
        this.move.setMaximumSize(new Dimension(175, 50));
        this.move.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.move.setForeground(new Color(0,0,0));
        this.move.setBackground(new Color(255,255,255));
        this.move.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.move.setFocusPainted(false);
        this.move.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){canvas.setWantsToMove(currentGame.getCurrPlayer()); this.currentGame.getCurrPlayer().setMoves(currentGame.getCurrPlayer().getMoves()-1);
            this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));}});
        control.add(move);
        control.add(Box.createVerticalStrut(40));

        this.pickUpPipe = new JButton("Pick Up Pipe");
        this.pickUpPipe.setName("Pick Up Pipe");
        this.pickUpPipe.setMaximumSize(new Dimension(175, 50));
        this.pickUpPipe.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.pickUpPipe.setForeground(new Color(0,0,0));
        this.pickUpPipe.setBackground(new Color(255,255,255));
        this.pickUpPipe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.pickUpPipe.setFocusPainted(false);
        this.pickUpPipe.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){this.currentGame.getCurrPlayer().PickUpPipe(); this.canvas.revalidate();this.canvas.repaint();
            this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));}});
        control.add(pickUpPipe);
        control.add(Box.createVerticalStrut(40));

        this.pickUpPump = new JButton("Pick Up Pump");
        this.pickUpPump.setName("Pick Up Pump");
        this.pickUpPump.setMaximumSize(new Dimension(175, 50));
        this.pickUpPump.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.pickUpPump.setForeground(new Color(0,0,0));
        this.pickUpPump.setBackground(new Color(255,255,255));
        this.pickUpPump.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.pickUpPump.setFocusPainted(false);
        this.pickUpPump.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){this.currentGame.getCurrPlayer().PickUpPump(); this.canvas.revalidate();this.canvas.repaint();
            this.infoLabel.setText("Round: "+ (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));}});
        control.add(pickUpPump);
        control.add(Box.createVerticalStrut(40));

        this.placePipe = new JButton("Place Pipe");
        this.placePipe.setName("Place Pipe");
        this.placePipe.setMaximumSize(new Dimension(175, 50));
        this.placePipe.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.placePipe.setForeground(new Color(0,0,0));
        this.placePipe.setBackground(new Color(255,255,255));
        this.placePipe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.placePipe.setFocusPainted(false);
        this.placePipe.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){this.currentGame.getCurrPlayer().PlacePipe(); this.canvas.revalidate();this.canvas.repaint();
            this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));}});
        control.add(placePipe);
        control.add(Box.createVerticalStrut(40));

        this.placePump = new JButton("Place Pump");
        this.placePump.setName("Place Pump");
        this.placePump.setMaximumSize(new Dimension(175, 50));
        this.placePump.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.placePump.setForeground(new Color(0,0,0));
        this.placePump.setBackground(new Color(255,255,255));
        this.placePump.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.placePump.setFocusPainted(false);
        this.placePump.addActionListener(e -> {if(currentGame.getCurrPlayer().getMoves()>0){this.currentGame.getCurrPlayer().PlacePump(); this.canvas.revalidate();this.canvas.repaint();
            this.infoLabel.setText("Round: "+ (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves())); }});
        control.add(placePump);
        control.add(Box.createVerticalStrut(40));

        this.exit = new JButton("Pass");
        this.exit.setName("Pass");
        this.exit.setMaximumSize(new Dimension(175, 50));
        this.exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.exit.setForeground(new Color(0,0,0));
        this.exit.setBackground(new Color(255,255,255));
        this.exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.exit.setFocusPainted(false);
        this.exit.addActionListener(e -> {String temp = currentGame.EndStep();this.canvas.revalidate();this.canvas.repaint();
            this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));
            if (this.currentGame.isFinished()) {
                JOptionPane.showMessageDialog(this, temp, "Win", JOptionPane.PLAIN_MESSAGE);
            }});
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

    /**
     * Elvégzi a játék elindítását.
     * Létrehoz egy új játékot, majd a canvas (újra-)beállításával elindítja a játékot a megfelelő paraméterezéssel.
     * @param num az játékban résztvevő karakterek száma (ennek igazából a 2-szerese. num darab szerelő és num darab nomád)
     */
    private void startGame(int num) {
        currentGame = new Game(10, this);
        canvas.setViewables(currentGame.StartGame(num));
        canvas.revalidate();
        canvas.repaint();
        this.infoLabel.setText("Round: "+  (currentGame.getRound_count()+1) +", Player: "+ (currentGame.getStep_count()+1) +", Turn: "+ (5-currentGame.getCurrPlayer().getMoves()));
    }

    /**
     * Elvégzi a menü beállítását, illetve kezeli azt is, hogy mi történik, ha a "Start new game"-re rákattint a felhasználó.
     * Ilyenkor létrehoz egy új ablakot, amelyben bekéri a szerelők és a nomádok számát. Az ablakban az OK-ra kattintva indítható új játék
     * A CANCEL-re kattintva az akció meghiúsul.
     * Az új játék indításval kapcsolatos problémákat kezeli (pl.: Nem lehet a szerelők és nomádok száma különböző)
     * @return a beállított JMenuBar objektum
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        var menu = new JMenu("Menu");
        menu.setName("MenuButton");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        var newGameMenuItem = new JMenuItem("Start new game", KeyEvent.VK_N);
        newGameMenuItem.setName("NewGameMenuButton");
        JPanel p = new JPanel(new BorderLayout(5, 5));
        JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
        labels.add(new JLabel("Mechanic: ", SwingConstants.TRAILING));
        labels.add(new JLabel("Nomad: ", SwingConstants.TRAILING));
        p.add(labels, BorderLayout.LINE_START);
        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField mechanics = new JTextField();
        mechanics.setName("NumberOfMechanics");
        controls.add(mechanics);
        JTextField nomads = new JTextField();
        nomads.setName("NumberOfNomads");
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
        exitMenuItem.setName("ExitButton");
        exitMenuItem.addActionListener(e -> {
            this.dispose();
        });

        menu.add(newGameMenuItem);
        menu.add(exitMenuItem);

        return menuBar;
    }

    /**
     * @return Visszaadja a canvas tagváltozóban tárolt értéket.
     */
    public Drawer getCanvas(){
        return canvas;
    }

}


