package ayyLmao;

import java.awt.*;
import java.util.ArrayList;

public interface Colidable {
    ArrayList<Rectangle> colliders = new ArrayList<>();
    int colliderWidth = 5;


    Rectangle getBounds();

    boolean isOnTheTop();

    void setOnTheTop(boolean b);

    boolean isOnTheBottom();

    void setOnTheBottom(boolean b);

    boolean isOnTheLeft();

    void setOnTheLeft(boolean b);

    boolean isOntheRight();

    void setOnTheRight(boolean b);

}
