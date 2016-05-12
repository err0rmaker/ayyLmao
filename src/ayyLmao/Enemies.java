package ayyLmao;

import java.awt.*;
import java.util.ArrayList;

public class Enemies {
    private ArrayList<Enemy> enemiesArr = new ArrayList<Enemy>();

    public Enemies(MainApp mainApp) {

        enemiesArr.add(new Enemy("zerg1.png", "ZERG", 1500, 100, 10));
        enemiesArr.add(new Enemy("zerg1.png", "ZERG", 600, 30, 100));
        enemiesArr.add(new Enemy("zerg2.png", "ZERG", 20, 60, 300));
        enemiesArr.add(new Enemy("zerg2.png", "ZERG", 700, 300, 400));
        enemiesArr.add(new Enemy("zerg1.png", "ZERG", 1500, 1000, 8000));
        enemiesArr.add(new Enemy("zerg1.png", "ZERG", 2000, 2000, 100));
        enemiesArr.add(new Enemy("zerg2.png", "ZERG", 200, 606, 2000));
        enemiesArr.add(new Enemy("zerg2.png", "ZERG", 700, 300, 1000));

    }

    public Graphics2D render(Graphics2D g2d) {
        for (Enemy e : enemiesArr) {
            e.render(g2d);
        }

        return g2d;
    }

    public void update() {
        for (Enemy e : enemiesArr) {
            e.update();
        }
    }

    public ArrayList getEnemies() {
        return enemiesArr;
    }

}
