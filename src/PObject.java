import processing.core.PApplet;
import processing.core.PVector;

public abstract class PObject {
    PApplet applet;
    PVector pos;

    PObject(PApplet applet) {
        this.applet = applet;
        this.pos = new PVector(0, 0);
    }

    abstract void update();
    abstract void render();
}
