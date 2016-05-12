package ayyLmao.Level.Entities;

import ayyLmao.Frame;
import ayyLmao.Level.Level;
import ayyLmao.MainApp;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by karel on 31.03.2016.
 */
public abstract class LevelEntity {


    protected int width;
    protected int height;
    protected double X;
    protected double Y;
    protected String name;
    protected MainApp mainApp;
    //protected ArrayList<String>sprites = new ArrayList<String>();
    protected String[] sprites;
    protected ArrayList<Frame> frames = new ArrayList<Frame>();
    BufferedImage image;


    public LevelEntity() {
    }

    public LevelEntity(String[] sprites, String name, int X, int Y, Level level) {
        this.X = X + level.getX();
        this.Y = Y + level.getY();
        this.sprites = sprites;
        this.mainApp = MainApp.getInstance();
        this.name = name;


    }

    public void addSprites() {

        for (String filename : sprites) {
            frames.add(new Frame(filename, 1));
            System.out.println(name);
        }

    }

    public ArrayList getFrames() {
        return frames;
    }


}
