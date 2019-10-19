import processing.core.PApplet;

public abstract class PObject {
    PApplet applet;

    PObject(PApplet applet) {
        this.applet = applet;
    }

    abstract void update();
    abstract void render();
}
