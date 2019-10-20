package trash.trash;

import game.Constants;
import processing.core.PApplet;

public class PlasticParticle extends ATrashParticle {
    PlasticParticle(PApplet applet, int x, int y) {
        super(applet, Constants.Type.PLASTIC, x, y);
    }

    @Override
    public void render() {
        applet.noStroke();
        applet.fill(60, 0, 255);
        applet.rect(pos.x, pos.y, width, height);
        applet.stroke(0);
    }
}
