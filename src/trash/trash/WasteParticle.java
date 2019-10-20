package trash.trash;

import game.Constants;
import processing.core.PApplet;

public class WasteParticle extends ATrashParticle {
    WasteParticle(PApplet applet, int x, int y) {
        super(applet, Constants.Type.WASTE, x, y);
    }

    @Override
    public void render() {
        applet.noStroke();
        applet.fill(100);
        applet.rect(pos.x, pos.y, width, height);
        applet.stroke(0);
    }
}
