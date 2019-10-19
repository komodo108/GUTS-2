import processing.core.PApplet;
import processing.core.PImage;

public class Assets {
    private static Assets singleton = null;

    private Assets() { }

    public static Assets getInstance() {
        if (singleton == null) singleton = new Assets();
        return singleton;
    }

    private PImage background, plastic, glass, paper, gwaste;
    private PApplet applet;
    public final int ROWS = 51, COLUMNS = 78;

    public void load(PApplet applet) {
        // Setup assets
        this.applet = applet;
        background = applet.loadImage("../data/worldmap.png");
        plastic = applet.loadImage("../data/plastic.png");
        glass = applet.loadImage("../data/glass.png");
        paper = applet.loadImage("../data/paper.png");
        gwaste = applet.loadImage("../data/gwaste.png");
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

    public PImage getGwaste(){
        return gwaste;
    }

    public PImage getBackground() {
        return background;
    }
}
