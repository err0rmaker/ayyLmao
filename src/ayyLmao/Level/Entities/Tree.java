package ayyLmao.Level.Entities;

import ayyLmao.Level.Level;

import java.awt.*;

/**
 * Created by karel on 31.03.2016.
 */
public class Tree extends LevelEntity implements IEntity {
    public Tree(String[] sprites, String name, int X, int Y, Level level) {
        super(sprites, name, X, Y, level);
        super.addSprites();
        frames = super.getFrames();
        image = frames.get(0).getFrame();
    }

    @Override
    public Graphics2D render(Graphics2D g2d) {
        g2d.drawImage(image, (int) X, (int) Y, mainApp);
        return g2d;
    }

    @Override
    public String getName() {
        return name;
    }
}
