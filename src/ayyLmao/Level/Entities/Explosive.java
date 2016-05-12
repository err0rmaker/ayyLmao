package ayyLmao.Level.Entities;


import ayyLmao.Frame;
import ayyLmao.Level.Level;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by karel on 31.03.2016.
 */
public class Explosive extends LevelEntity implements IEntity {

    public Explosive(String[] sprites, String name, int X, int Y, Level level) {
        super(sprites, name, X, Y, level);
        super.addSprites();
        ArrayList<Frame> frames = super.getFrames();
        image = frames.get(0).getFrame();


    }


    @Override
    public Graphics2D render(Graphics2D g2d) {
        //g2d.setColor(new Color(100,100,100));
        //g2d.fillRect((int)X,(int)Y,50,200);
        g2d.drawImage(image, (int) X, (int) Y, mainApp);

        return g2d;
    }

    @Override
    public String getName() {
        return name;
    }
}
