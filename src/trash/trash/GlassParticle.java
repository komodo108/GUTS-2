package trash.trash;

import game.Constants;
import processing.core.PApplet;

public class GlassParticle extends ATrashParticle {
    GlassParticle(PApplet applet, int x, int y) {
        super(applet, Constants.Type.GLASS, x, y);
    }

    @Override
    public void render() {
        applet.noStroke();
        applet.fill(0, 255, 0);
        applet.rect(pos.x, pos.y, width, height);
        applet.stroke(0);
    }
}
