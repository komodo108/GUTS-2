package game;

import processing.core.PApplet;
import processing.core.PImage;

public class Assets {
    private static Assets singleton = null;

    private Assets() { }

    public static Assets getInstance() {
        if (singleton == null) singleton = new Assets();
        return singleton;
    }

    private PImage background, plastic, glass, paper, waste;
    private String[] positions;
    private PApplet applet;

    public void load(PApplet applet) {
        // Setup assets
        this.applet = applet;
        background = applet.loadImage("../data/worldmap.png");
        plastic = applet.loadImage("../data/plastic.png");
        glass = applet.loadImage("../data/glass.png");
        paper = applet.loadImage("../data/paper.png");
        waste = applet.loadImage("../data/waste.png");
        positions = applet.loadStrings("../data/coordinates.txt");
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

    public PImage getWaste(){
        return waste;
    }

    public String[] getPositions() {
        return positions;
    }

    public PImage getBackground() {
        return background;
    }
}