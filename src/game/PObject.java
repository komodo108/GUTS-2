package game;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class PObject {
    public PApplet applet;
    public PVector pos;

    public PObject(PApplet applet) {
        this.applet = applet;
        this.pos = new PVector(0, 0);
    }

    public abstract void update();
    public abstract void render();
}
