package ayyLmao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainApp extends JFrame {

    public static MainApp instance;
    public static boolean running = false;
    public static int WIDTH = 1280;
    public static int HEIGHT = 720;
    public static double mouseX;
    public static double mouseY;
    public static STATE State = STATE.GAME;
    Alien alien = new Alien(this);
    Enemies enemies = new Enemies(this);
    Menu menu = new Menu();
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    /**
     * Create the frame.
     */

    public MainApp() {


        instance = this;
        //WIDTH = this.width;
        //HEIGHT = this.height;
        //this.setUndecorated(true);

        this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setBounds(100, 100, 450, 300);
        this.setSize(WIDTH, HEIGHT);


        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        Game game = new Game(alien, enemies, menu);
        contentPane.add(game, BorderLayout.CENTER);
        game.setup();
        Thread t1 = new Thread(game);
        t1.start();
        running = true;
        game.setFocusable(true);
        game.addKeyListener(game);

        game.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (State == STATE.GAME) {
                        State = STATE.MENU;
                        System.out.println(State);
                    } else {
                        State = STATE.GAME;
                    }
                }


            }
        });

        this.addWindowListener(new WindowListener() {

            public void windowClosed(WindowEvent e) {
                running = false;

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

        });

    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        MainApp.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainApp frame = new MainApp();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static MainApp getInstance() {
        return instance;


    }

    public static boolean isRunning() {
        return running;
    }

    public void setRunning(boolean run) {
        running = run;
    }

    public enum STATE {
        MENU, GAME
    }


}
