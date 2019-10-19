import processing.core.PApplet;
import processing.core.PImage;

public class Assets {
    private static Assets singleton = null;

    private Assets() { }

    public static Assets getInstance() {
        if (singleton == null) singleton = new Assets();
        return singleton;
    }

    private PImage background, plastic, glass, paper;
    private PApplet applet;
    public final int ROWS = 78, COLUMNS = 51;

    public void load(PApplet applet) {
        // Setup assets
        this.applet = applet;
        background = applet.loadImage("../data/worldmap.png");
        plastic = applet.loadImage("../data/plastic.jpg");
        glass = applet.loadImage("../data/glass.jpg");
        paper = applet.loadImage("../data/paper.jpg");
    }

    public PImage getPlastic(){
        return plastic;
    }

    public PImage getGlass(){
        return glass;
    }

    public PImage getPaper(){
        return paper;
    }

    public PImage getBackground() {
        return background;
    }
}
