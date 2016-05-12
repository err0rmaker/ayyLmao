package ayyLmao.Level;

import ayyLmao.Alien;
import ayyLmao.Game;
import ayyLmao.Level.Entities.Explosive;
import ayyLmao.Level.Entities.House;
import ayyLmao.Level.Entities.IEntity;
import ayyLmao.Level.Entities.Tree;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by karel on 31.03.2016.
 */
public class Level {


    public static int Y = 0;
    public static int X = 0;

    private int width = 2000;
    private int height = 2000;
    private IEntity iEntity;
    private ArrayList<IEntity> entityArrayList = new ArrayList<>();
    private ArrayList<Rectangle> colliders = new ArrayList<>();


    public Level(int width, int height, String name, int levelId) {


        this.width = width;
        this.height = height;
        Game game = Game.getInstance();
        Alien alien = Alien.getInstance();

        int speed = alien.getSpeed();
        float interpolation = alien.getInterpolation();
        //addColliders();
        lvlEntitiesInnit();

    }

    public static int getX() {
        return X;
    }

    public static void setX(int x) {
        Y = x;
    }

    public static int getY() {
        return Y;
    }

    public static void setY(int y) {
        Y = y;
    }

    public void addColliders() {
        //left collider
        int colliderWidth = 5;
        colliders.add(new Rectangle(0, 0, colliderWidth, height));
        //top collider
        colliders.add(new Rectangle(0, 0, width, colliderWidth));

        //bottom collider
        colliders.add(new Rectangle(width, height - colliderWidth, width, colliderWidth));
        //right collider
        colliders.add(new Rectangle(width - colliderWidth, 0, colliderWidth, height));


    }

    public void lvlEntitiesInnit() {


        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive2.png"}, "Explosive_01", 900, 500, this));
        entityArrayList.add(new House(new String[]{"Assets/sprites/levelObjects/house1.png", "Assets/sprites/levelObjects/house1.png"}, "House_01", X + 0, Y + 0, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive1.png"}, "House_01", 1500, 1500, this));
        entityArrayList.add(new Tree(new String[]{"Assets/sprites/levelObjects/tree1.png", "Assets/sprites/levelObjects/tree2.png"}, "Tree_01", 200, 200, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive2.png"}, "Explosive_01", 900, 500, this));
        entityArrayList.add(new House(new String[]{"Assets/sprites/levelObjects/house1.png", "Assets/sprites/levelObjects/house1.png"}, "House_01", 0, 0, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive1.png"}, "House_01", 1000, 1500, this));
        entityArrayList.add(new Tree(new String[]{"Assets/sprites/levelObjects/tree1.png", "Assets/sprites/levelObjects/tree2.png"}, "Tree_01", 200, 200, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive2.png"}, "Explosive_01", 900, 500, this));
        entityArrayList.add(new House(new String[]{"Assets/sprites/levelObjects/house1.png", "Assets/sprites/levelObjects/house1.png"}, "House_01", 0, 0, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive1.png"}, "House_01", 500, 100, this));
        entityArrayList.add(new Tree(new String[]{"Assets/sprites/levelObjects/tree1.png", "Assets/sprites/levelObjects/tree2.png"}, "Tree_01", 200, 200, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive2.png"}, "Explosive_01", 2000, 500, this));
        entityArrayList.add(new House(new String[]{"Assets/sprites/levelObjects/house1.png", "Assets/sprites/levelObjects/house1.png"}, "House_01", 0, 0, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive1.png"}, "House_01", 250, 10000, this));
        entityArrayList.add(new Tree(new String[]{"Assets/sprites/levelObjects/tree1.png", "Assets/sprites/levelObjects/tree2.png"}, "Tree_01", 200, 200, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive2.png"}, "Explosive_01", 506, 500, this));
        entityArrayList.add(new House(new String[]{"Assets/sprites/levelObjects/house1.png", "Assets/sprites/levelObjects/house1.png"}, "House_01", X + 0, Y + 0, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive1.png"}, "House_01", 2500, 1500, this));
        entityArrayList.add(new Tree(new String[]{"Assets/sprites/levelObjects/tree1.png", "Assets/sprites/levelObjects/tree2.png"}, "Tree_01", 200, 200, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive2.png"}, "Explosive_01", 900, 500, this));
        entityArrayList.add(new House(new String[]{"Assets/sprites/levelObjects/house1.png", "Assets/sprites/levelObjects/house1.png"}, "House_01", 0, 0, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive1.png"}, "House_01", 2000, 700, this));
        entityArrayList.add(new Tree(new String[]{"Assets/sprites/levelObjects/tree1.png", "Assets/sprites/levelObjects/tree2.png"}, "Tree_01", 200, 200, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive2.png"}, "Explosive_01", 800, 1500, this));
        entityArrayList.add(new House(new String[]{"Assets/sprites/levelObjects/house1.png", "Assets/sprites/levelObjects/house1.png"}, "House_01", 0, 0, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive1.png"}, "House_01", 200, 1000, this));
        entityArrayList.add(new Tree(new String[]{"Assets/sprites/levelObjects/tree1.png", "Assets/sprites/levelObjects/tree2.png"}, "Tree_01", 200, 200, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive2.png"}, "Explosive_01", 200, 1500, this));
        entityArrayList.add(new House(new String[]{"Assets/sprites/levelObjects/house1.png", "Assets/sprites/levelObjects/house1.png"}, "House_01", 0, 0, this));
        entityArrayList.add(new Explosive(new String[]{"Assets/sprites/levelObjects/explosive1.png", "Assets/sprites/levelObjects/explosive1.png"}, "House_01", 250, 1100, this));
        entityArrayList.add(new Tree(new String[]{"Assets/sprites/levelObjects/tree1.png", "Assets/sprites/levelObjects/tree2.png"}, "Tree_01", 200, 200, this));


    }

    public void render(Graphics2D g2d) {
        g2d.translate(0, 0);
        g2d.setColor(new Color(200, 200, 20));
        g2d.fillRect(X, Y, width, height);

        for (IEntity entity : entityArrayList) {
            entity.render(g2d);

        }
        //renderColliders(g2d);

        return g2d;

    }

    public Graphics2D renderColliders(Graphics2D g2d) {

        g2d.setColor(new Color(50, 50, 255));
        for (Rectangle collider : colliders) {
            g2d.fill(collider);
        }

        return g2d;

    }

    public void update() {


        for (IEntity entity : entityArrayList) {


        }

    }


}
