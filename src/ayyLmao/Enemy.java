package ayyLmao;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy implements Colidable {
    MainApp mainApp;
    Game game;
    BufferedImage enemyImg;
    private double X = 0;
    private double Y = 0;
    private int width = 20;
    private int height = 20;
    private int frames = 0;
    private String name;
    private int speed = 6;

    private double lastUpdate;
    private double frequency = 3;
    private double BILLION = 1000000000;
    private double frameTime = BILLION / frequency;


    private ArrayList<Frame> enemyFrames = new ArrayList<Frame>();
    private boolean alive = true;


    public Enemy(String filename, String name, int speed, int X, int Y) {
        Random rn = new Random(1);
        game = Game.getInstance();

        this.X = X;
        this.Y = Y;
        this.setSpeed(speed);
        this.setName(name);
        enemyFrames.add(new Frame("zerg1.png", 1));
        enemyFrames.add(new Frame("zerg2.png", 1));
        enemyFrames.add(new Frame("explosion.png", 1));


        enemyImg = enemyFrames.get(0).getFrame();
    }

    public void render(Graphics2D g2d) {


        g2d.drawImage(enemyImg, (int) X, (int) Y, mainApp);


        return g2d;

    }

    public void update() {
        animation();
        if (isAlive()) {


            int rand = ThreadLocalRandom.current().nextInt(-10, 10);
            X = X + rand + speed * 0.001;
            rand = ThreadLocalRandom.current().nextInt(-10, 10);
            Y = Y + rand + speed * 0.001;
        }
    }

    public void animation() {
        double now = System.nanoTime();
        if (now - lastUpdate > frameTime) {
            frames++;


            animate();

            lastUpdate = System.nanoTime();
        }


    }

    public void animate() {
        if (isAlive()) {
            if (enemyFrames.get(0).getFrames() == 2) {
                enemyImg = enemyFrames.get(0).getFrame();
                enemyFrames.get(0).updated();

                enemyFrames.get(1).reset();
            }
            if (enemyFrames.get(1).getFrames() == 2) {
                enemyImg = enemyFrames.get(1).getFrame();
                enemyFrames.get(1).updated();
                enemyFrames.get(0).reset();
            }
            enemyFrames.get(0).updated();
            enemyFrames.get(1).updated();
        } else {


            enemyImg = enemyFrames.get(2).getFrame();

        }


    }

    public boolean isAlive() {
        return alive;

    }

    public double getX() {
        return X;
    }

    public void setX(double d) {
        X = d;
    }


    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setInterpolation(float interpolation) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void explode() {
        alive = false;

    }

    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(enemyImg.getWidth(), enemyImg.getHeight());
        r.setLocation((int) X + Game.getXd(), (int) Y + Game.getYd());

        return r;
    }

    @Override
    public boolean isOnTheTop() {
        return false;
    }

    @Override
    public void setOnTheTop(boolean b) {

    }

    @Override
    public boolean isOnTheBottom() {
        return false;
    }

    @Override
    public void setOnTheBottom(boolean b) {

    }

    @Override
    public boolean isOnTheLeft() {
        return false;
    }

    @Override
    public void setOnTheLeft(boolean b) {

    }

    @Override
    public boolean isOntheRight() {
        return false;
    }

    @Override
    public void setOnTheRight(boolean b) {

    }


}
