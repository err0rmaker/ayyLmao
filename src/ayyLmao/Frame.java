package ayyLmao;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame {
    private BufferedImage img;
    private int frames;

    public Frame(String filename, int frames) {
        this.setImg(img);
        this.setFrames(frames);
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public BufferedImage getFrame() {
        return img;
    }

    public void updated() {
        frames++;
    }

    public void reset() {
        frames = 0;
    }

}
