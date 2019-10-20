package trash.trash;

import game.PObject;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class ATrashParticle extends PObject {
    ATrashParticle(PApplet applet, int x, int y) {
        super(applet);
        pos = new PVector(x, y);
        width = (int) applet.random(5);
        height = (int) applet.random(5);
    }

    void move(int x, int y) {
        pos.x += x;
        pos.y += y;
    }

    @Override
    public void update() { }
}
