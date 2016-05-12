package ayyLmao;

import ayyLmao.Level.Level;
import ayyLmao.Level.Levels;
import ayyLmao.MainApp.STATE;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game extends Canvas implements KeyListener, Runnable, MouseMotionListener, MouseListener {

    public static Game game;
    public static int Xd;
    private static int Yd;
    final int TICKS_PER_SECOND = 60;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;
    double interpolation = 0;
    double dt = 0;
    private MainApp mainApp;
    private BufferStrategy strategy;
    private Alien alien;
    private Levels levels = new Levels();
    private int frameCount = 0;
    private Enemies enemies;
    private Menu menu;
    private Camera camera;
    private Projectiles projectiles = Projectiles.getInstance();
    private int levelId;
    private ArrayList<Rectangle> colliders = new ArrayList<Rectangle>();
    private int levelX = Level.getX();
    private int levelY = Level.getY();
    private int shots = 0;

    public Game(Alien alien, Enemies enemies, Menu menu) {
        this.alien = alien;
        this.enemies = enemies;
        this.menu = menu;

        mainApp = MainApp.getInstance();
        game = this;

        camera = new Camera(alien);

        addMouseMotionListener(this);
        addMouseListener(this);
        addColliders();


    }

    public static int getXd() {
        return Xd;
    }

    public static void setXd(int xd) {
        Xd = xd;
    }

    public static int getYd() {
        return Yd;
    }

    public static void setYd(int yd) {
        Yd = yd;
    }

    public static Game getInstance() {
        return game;
    }

    public void setup() {

        this.createBufferStrategy(2);
        if (strategy == null) {
            strategy = this.getBufferStrategy();
        }


    }

    public void render(float interpolation) {


        camera.setInterpolation(interpolation);
        Graphics2D g2d = (Graphics2D) strategy.getDrawGraphics();
        g2d.clearRect(0, 0, getWidth(), getHeight());
        if (MainApp.State == STATE.GAME) {


            //g2d = renderColliders(g2d);

            Xd = (int) camera.getX() + Level.getX();
            Yd = (int) camera.getY() + Level.getY();
            //System.out.println(Xd + "XD");
            //System.out.println(Yd + "YD");
            g2d.translate(Level.getY() - camera.getX(), Level.getY() - camera.getY());
            g2d = levels.render(g2d);
            g2d = enemies.render(g2d);
            //g2d = projectiles.render(g2d);
            // g2d = alien.render(g2d);


            g2d.translate(Xd, Yd);
            g2d = projectiles.render(g2d);
            g2d = alien.render(g2d);
            //g2d = enemies.render(g2d);


        }


        if (MainApp.State == STATE.MENU) {
            g2d = menu.render(g2d);
        }


        g2d.dispose();


        strategy.show();
        frameCount++;
        Toolkit.getDefaultToolkit().sync();


    }

    public void update() {
        // System.out.println("Alien X" + alien.getX());
        //System.out.println("Alien X" + alien.getX());

        alien.update();
        enemies.update();
        projectiles.update();
        levels.update();
        camera.move();
        colisions();
    }

    public void colisions() {

        ArrayList<Enemy> enemiesArr = enemies.getEnemies();
        ArrayList<Projectile> projectilesArr = projectiles.getProjectiles();

/*
        for(int i = 0 ; i < colliders.size(); i++){
            if ( colliders.get(i).intersects(alien.getBounds())){
                switch(i){
                    case 0:
                        alien.setOnTheLeft(true);
                        alien.setLeft(false);
                        break;
                    case 1:
                        alien.setOnTheTop(true);
                        alien.setUp(false);
                        break;

                    case 2:
                        alien.setOnTheBottom(true);
                        alien.setDown(false);
                        break;

                    case 3:
                        alien.setOnTheRight(true);
                        alien.setRight(false);
                        break;



                }
            }else{
                switch(i){
                    case 0:
                        alien.setOnTheLeft(false);
                        //alien.setLeft(true);
                        break;
                    case 1:
                        alien.setOnTheTop(false);
                        //alien.setUp(true);
                        break;

                    case 2:
                        alien.setOnTheBottom(false);
                        //alien.setDown(true);
                        break;

                    case 3:
                        alien.setOnTheRight(false);
                        //alien.setRight(true);
                        break;



                }
            }

        }


        /*for (Rectangle collider : colliders) {
            if ( collider.intersects(alien.getBounds())){

        }
        }*/


        for (Enemy enemy : enemiesArr) {
            for (Projectile projectil : projectilesArr) {


                if (enemy.getBounds().intersects(projectil.getBounds())) {
                    enemy.explode();

                }
            }
        }


    }

    public void addColliders() {
        //left collider
        int colliderWidth = 5;
        colliders.add(new Rectangle(0, 0, colliderWidth, mainApp.getHeight()));
        //top collider
        colliders.add(new Rectangle(0, 0, mainApp.getWidth(), colliderWidth));

        //bottom collider
        colliders.add(new Rectangle(0, mainApp.getHeight() - colliderWidth * 2, mainApp.getWidth(), colliderWidth));
        //right collider
        colliders.add(new Rectangle(mainApp.getWidth() - colliderWidth * 2, 0, colliderWidth, mainApp.getHeight()));
        System.out.println("adding colliders");


    }

    public Graphics2D renderColliders(Graphics2D g2d) {
        //System.out.println("rendering colliders");
        g2d.setColor(new Color(255, 50, 255));
        for (Rectangle collider : colliders) {
            g2d.fill(collider);
        }

        return g2d;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            camera.setLeft(false);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            camera.setRight(false);

        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            camera.setUp(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            camera.setDown(false);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println(e.getKeyCode());

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            camera.setLeft(true);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            camera.setRight(true);

        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            camera.setUp(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            camera.setDown(true);
        }
    }

    @Override
    public void run() {

        gameloop();

    }

    public void gameloop() {
        final double GAME_HERTZ = 30;
        final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;


        final int MAX_UPDATES_BEFORE_RENDER = 2;
        double lastUpdateTime = System.nanoTime();

        double lastRenderTime = System.nanoTime();

        final double TARGET_FPS = 60;
        final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;

        int lastSecondTime = (int) (lastUpdateTime);


        while (MainApp.running) {
            double now = System.nanoTime();
            int updateCount = 0;
            while (now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER) {

                update();
                lastUpdateTime += TIME_BETWEEN_UPDATES;
                updateCount++;

            }


            if (now - lastUpdateTime > TIME_BETWEEN_UPDATES) {
                lastUpdateTime = now - TIME_BETWEEN_UPDATES;


            }
            float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES));
            render(interpolation);
            lastRenderTime = now;
            lastRenderTime = now;

            int thisSecond = (int) (lastUpdateTime / 1000000000);


            if (thisSecond > lastSecondTime) {
                int fps = frameCount;
                System.out.println("FPS: " + fps);
                frameCount = 0;
                lastSecondTime = thisSecond;
            }
            while (now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
                Thread.yield();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }

                now = System.nanoTime();

            }
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        MainApp.mouseX = e.getPoint().getX();
        MainApp.mouseY = e.getPoint().getY();
        //System.out.println(e.getPoint().getX());

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        alien.shoot();
        shots++;
        System.out.println("Alien shoot" + shots);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
}