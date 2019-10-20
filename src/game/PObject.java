package game;

import processing.core.PApplet;
import processing.core.PVector;

import static game.Constants.*;

public abstract class PObject {
    public PApplet applet;
    public PVector pos;
    public int width, height;

    public PObject(PApplet applet) {
        this.applet = applet;
        this.pos = new PVector(0, 0);
    }

    public abstract void update();
    public abstract void render();

    public boolean isInside(PObject other) {
        boolean xOverlap = isInRange(this.pos.x, other.pos.x, other.pos.x + other.width) ||
                isInRange(other.pos.x, this.pos.x, this.pos.x + this.width);

        boolean yOverlap = isInRange(this.pos.y, other.pos.y, other.pos.y + other.height) ||
                isInRange(other.pos.y, this.pos.y, this.pos.y + this.height);

        return xOverlap && yOverlap;
    }

    public boolean isMouseInside() {
        return isInRange(applet.mouseX, pos.x, pos.x + width) && isInRange(applet.mouseY, pos.y, pos.y + height);
    }

}
