package ayyLmao;

import java.awt.*;


public class Menu {
    private Rectangle playButton = new Rectangle(MainApp.WIDTH / 2 + 120, 150, 100, 50);
    private Rectangle settingsButton = new Rectangle(MainApp.WIDTH / 2 + 120, MainApp.HEIGHT + MainApp.HEIGHT / 3, 100, 50);
    private Rectangle quitButton = new Rectangle(MainApp.WIDTH / 2 + 120, MainApp.HEIGHT + MainApp.HEIGHT / 3 * 2, 100, 50);

    Menu() {

    }

    public Graphics2D render(Graphics2D g2d) {
        g2d.setColor(new Color(0, 255, 255));
        //g2d.setFont("");
        g2d.fillRect(0, 0, MainApp.WIDTH, MainApp.HEIGHT);
        g2d.setColor(new Color(255, 255, 255));
        g2d.fill(playButton);
        g2d.fill(settingsButton);
        g2d.fill(quitButton);

        return g2d;
    }
}

