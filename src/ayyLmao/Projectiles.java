package ayyLmao;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Projectiles {
    public static boolean shootingReady = true;
    public static Projectiles projectylesInstance;
    ArrayList<Projectile> projectiles = new ArrayList<>();


    public Projectiles() {
        projectylesInstance = this;
    }

    public static Projectiles getInstance() {

        return projectylesInstance;
    }

    public void newProjectyle() {
        projectiles.add(new Projectile());

    }

    public void update() {
        /*for (Projectyle projectyle : projectyles) {
			projectyle.update();
		}*/
        Iterator<Projectile> iter = projectiles.iterator();

        while (iter.hasNext()) {
            shootingReady = false;

            Projectile tempProjectyle = iter.next();


            tempProjectyle.update();
        }

        if (projectiles == null || projectiles.isEmpty()) {
            shootingReady = false;
        } else if (projectiles.size() > 10) {


            projectiles.remove(projectiles.get(0));
            //System.out.println(projectiles.size());

        }
        shootingReady = true;

    }


    public Graphics2D render(Graphics2D g2d) {
		/*
		for (Projectyle projectyle : projectyles) {
			projectyle.render(g2d);
		}*/

        Iterator<Projectile> iter = projectiles.iterator();

        while (iter.hasNext()) {
            Projectile tempProjectyle = iter.next();
            tempProjectyle.render(g2d);
        }

        return g2d;
    }

    public ArrayList getProjectiles() {
        return projectiles;
    }
}
