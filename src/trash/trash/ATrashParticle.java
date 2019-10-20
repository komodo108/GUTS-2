package trash.trash;

import game.Constants;
import game.PObject;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class ATrashParticle extends PObject {
    Constants.Type type;

    ATrashParticle(PApplet applet, Constants.Type type, int x, int y) {
        super(applet);
        pos = new PVector(x, y);
        this.type = type;
        width = (int) applet.random(5);
        height = (int) applet.random(5);
    }

    Constants.Type getType() {
        return type;
    }

    void move(int x, int y) {
        pos.x += x;
        pos.y += y;
    }

    void setPos(int x, int y) {
        pos.x = x;
        pos.y = y;
    }

    @Override
    public void update() { }
}
