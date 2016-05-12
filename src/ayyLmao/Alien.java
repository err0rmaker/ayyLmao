package ayyLmao;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Alien implements Colidable {
    public static Alien instance;
    MainApp mainApp;
    BufferedImage alienImg;
    BufferedImage alienImg2;
    private double X = MainApp.getWIDTH() / 2;
    private double Y;
    private int frames = 0;
    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;


    private boolean onTheTop = false;
    private boolean onTheBottom = false;
    private boolean onTheLeft = false;


    private int speed = 60;


    private float interpolation;
    private double lastUpdate;
    private double frequency = 3;
    private double BILLION = 1000000000;
    private double frameTime = BILLION / frequency;
    private int width = 50;
    private int height = 50;


    private ArrayList<Frame> alienFrames = new ArrayList<Frame>();

    private Projectiles projectyles = new Projectiles();

    private double angle = 0;
    private int shots = 0;

    public Alien(MainApp mainApp) {


        instance = this;
        this.mainApp = mainApp;
        alienFrames.add(new Frame("alien.png", 1));
        alienFrames.add(new Frame("alien2.png", 1));
        X = MainApp.getWIDTH() / 2 - width;
        Y = MainApp.getHEIGHT() / 2 - height;


    }

    public static Alien getInstance() {
        return instance;

    }

    public Graphics2D render(Graphics2D g2d) {


        AffineTransform transform = g2d.getTransform();
        angle = Math.atan2(Y - MainApp.mouseY, X - MainApp.mouseX) - Math.PI / 2;

        g2d.rotate(angle, X + width / 2, Y + height / 2);

        //g2d.translate(X,Y);

        g2d.drawImage(alienImg, (int) X, (int) Y, mainApp);

        g2d.setColor(new Color(200, 20, 20));
        g2d.setTransform(transform);
        return g2d;

    }

    public void shoot() {
        shots++;
        System.out.println("shoooot" + shots);

        //if (Projectiles.shootingReady == true) {
        projectyles.newProjectyle();
        //} else {
        // System.out.println("Shooting not ready");

        //}


    }

    public void update() {

        //System.out.println("dank");
        animation();


        //System.out.println(X);
    }

    public void animation() {
        double now = System.nanoTime();
        if (now - lastUpdate > frameTime) {
            //System.out.println("animace"+frames);
            frames++;


            animate();

            lastUpdate = System.nanoTime();
        }


    }

    private void animate() {
        if (alienFrames.get(0).getFrames() == 2) {
            alienImg = alienFrames.get(0).getFrame();
            alienFrames.get(0).updated();

            alienFrames.get(1).reset();
        }
        if (alienFrames.get(1).getFrames() == 2) {
            alienImg = alienFrames.get(1).getFrame();
            alienFrames.get(1).updated();
            alienFrames.get(0).reset();
        }
        alienFrames.get(0).updated();
        alienFrames.get(1).updated();

    }

    public double getX() {
        return X;
    }

    public void setX(double d) {
        X = d;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getAngle() {

        return angle;
    }

    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(width, height);
        r.setLocation((int) X, (int) Y);

        return r;
    }

    @Override
    public boolean isOnTheTop() {
        return onTheTop;
    }

    @Override
    public void setOnTheTop(boolean b) {
        this.onTheTop = b;


    }

    @Override
    public boolean isOnTheBottom() {
        return onTheBottom;
    }

    @Override
    public void setOnTheBottom(boolean b) {
        this.onTheBottom = b;

    }

    @Override
    public boolean isOnTheLeft() {
        return onTheLeft;
    }

    @Override
    public void setOnTheLeft(boolean b) {
        this.onTheLeft = b;

    }

    @Override
    public boolean isOntheRight() {
        return false;
    }

    @Override
    public void setOnTheRight(boolean b) {
        this.onTheLeft = b;

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getInterpolation() {
        return interpolation;
    }

    public void setInterpolation(float interpolation) {
        this.interpolation = interpolation;
    }
}
