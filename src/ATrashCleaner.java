import processing.core.PApplet;
import processing.core.PImage;

public abstract class ATrashCleaner extends PObject implements ITrashCleaner {
    PImage image;
    int percentage = 100;
    double efficiency = 1;

    ATrashCleaner(PApplet applet) {
        super(applet);
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
