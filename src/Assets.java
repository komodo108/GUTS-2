import processing.core.PApplet;
import processing.core.PImage;

public class Assets {
    private static Assets singleton = null;

    private Assets() { }

    public static Assets getInstance() {
        if (singleton == null) singleton = new Assets();
        return singleton;
    }

    private PImage background;
    private PApplet applet;

    public void load(PApplet applet) {
        // Setup assets
        this.applet = applet;
        background = applet.loadImage("../data/worldmap.jpg");
    }

    public PImage getBackground() {
        return background;
    }
}