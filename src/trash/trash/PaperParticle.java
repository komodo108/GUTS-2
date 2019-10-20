package trash.trash;

import game.Constants;
import processing.core.PApplet;

public class PaperParticle extends ATrashParticle {
    PaperParticle(PApplet applet, int x, int y) {
        super(applet, Constants.Type.PAPER, x, y);
    }

    @Override
    public void render() {
        applet.noStroke();
        applet.fill(255);
        applet.rect(pos.x, pos.y, width, height);
        applet.stroke(0);
    }
}
