package trash.clean;

import game.PObject;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public abstract class ATrashCleaner extends PObject implements ITrashCleaner {
    PImage image;
    int percentage = 100;
    double efficiency = 1;

    ATrashCleaner(PApplet applet, int x, int y) {
        super(applet);
        this.pos = new PVector(x, y);
    }

    @Override
    public void move(int x, int y) {
        pos.x += x;
        pos.y += y;
    }

    @Override
    public void update() { }

    @Override
    public void render() {
        applet.image(image, pos.x, pos.y); //scaled
    }

    @Override
    public int getPercentage() {
        return percentage;
    }

    public boolean isdead() {
        return (percentage <= 0);
    }
}
