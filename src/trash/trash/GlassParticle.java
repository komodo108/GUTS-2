package trash.trash;

import game.Constants;
import processing.core.PApplet;

public class GlassParticle extends ATrashParticle {
    GlassParticle(PApplet applet, int x, int y) {
        super(applet, x, y);
    }

    @Override
    public void render() {
        applet.fill(0, 255, 0);
        applet.rect(pos.x, pos.y, width, height);
    }
}
