package ayyLmao;

import ayyLmao.Level.Level;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


public class Projectile implements Colidable {
    MainApp mainApp;
    //Game game = Game.getInstance();
    Alien alien = Alien.getInstance();
    BufferedImage enemyImg;
    private double X = 0;
    private double Y = 0;
    private int frames = 0;
    private String name;
    private double angle;

    private int width = 30;
    private int height = 10;
    private float interpolation;
    private double lastUpdate;
    private double frequency = 60;
    private double BILLION = 1000000000;
    private double frameTime = BILLION / frequency;


    public Projectile() {
        X = alien.getX();
        Y = alien.getY();
        angle = alien.getAngle() + 4.7;

    }

    public void update() {
        animation();
        //System.out.println("Projectyle UPDATE");


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
        int speed = 30;
        X = X + speed * Math.cos(angle);
        Y = Y + speed * Math.sin(angle);
        System.out.println(Level.getX());

        //System.out.println(X);


    }

    public void render(Graphics2D g2d) {

		/*
        AffineTransform transform = g2d.getTransform();
        angle = Math.atan2(Y - MainApp.mouseY, X - MainApp.mouseX) - Math.PI / 2;

        g2d.rotate(angle, X + width / 2, Y + height / 2);

        //g2d.translate(X,Y);

        g2d.drawImage(alienImg, (int) X, (int) Y, mainApp);

        g2d.setColor(new Color(200, 20, 20));
        g2d.setTransform(transform);
        return g2d;*/

        g2d.setColor(new Color(20, 20, 20));
        AffineTransform transform = g2d.getTransform();


        g2d.rotate(angle, X + width / 2, Y + height / 2);
        g2d.fillRect((int) X, (int) Y, width, height);

        g2d.setTransform(transform);
        return g2d;

    }

    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(width, height);
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
