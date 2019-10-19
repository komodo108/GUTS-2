import processing.core.PApplet;
import processing.core.PImage;

public class Assets {
    private static Assets singleton = null;

    private Assets() { }

    public static Assets getInstance() {
        if (singleton == null) singleton = new Assets();
        return singleton;
    }

    private PImage background, plastic;
    private PApplet applet;
    public final int ROWS = 51, COLUMNS = 78;

    public void load(PApplet applet) {
        // Setup assets
        this.applet = applet;
        background = applet.loadImage("../data/worldmap.jpg");
        plastic = applet.loadImage("../data/plastic.jpg");
    }

    public PImage getPlastic(){
        return plastic;
    }

    public PImage getBackground() {
        return background;
    }
}
