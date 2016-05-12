package ayyLmao.Level;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by karel on 31.03.2016.
 */
public class Levels {

    private ArrayList<Level> levelsArrayList = new ArrayList<Level>();
    private int levelID;

    /**
     * TODO add level selector into menu
     * temporary
     */
    public Levels() {


        levelsArrayList.add(new Level(3000, 3000, "level_01", 1));
        //temp
        levelID = 0;


    }

    public Graphics2D render(Graphics2D g2d) {

        g2d.setBackground(new Color(30, 60, 100));


        levelsArrayList.get(levelID).render(g2d);


        return g2d;
    }

    public void update() {
        levelsArrayList.get(levelID).update();


    }
}
