package ayyLmao;

/**
 * Created by karel on 01.04.2016.
 */
public class Camera {

    public int WIDTH = MainApp.getWIDTH();
    public int HEIGHT = MainApp.getHEIGHT();
    public Alien alien;
    private double Y;
    private double X;


    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;

    private float interpolation;


    public Camera(Alien alien) {
        this.alien = alien;

    }


    public void move() {


        int dx = 0;
        int dy = 0;

        if (isRight()) {
            dx = 1;
        }
        if (isLeft()) {
            dx = -1;
        }
        if (isUp()) {
            dy = -1;
        }
        if (isDown()) {
            dy = 1;
        }


        int speed = 30;
        X = X + dx * speed * interpolation;
        Y = Y + dy * speed * interpolation;
        //System.out.println(X);

    }

    public double getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }


    public double getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
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

    public void setInterpolation(float interpolation) {
        this.interpolation = interpolation;
    }


}
