package game;

import processing.core.PApplet;

import static game.Constants.HEIGHT;
import static game.Constants.WIDTH;

public class Introduction extends PObject {
    private boolean done = false;

    public Introduction(PApplet applet) {
        super(applet);
        width = WIDTH;
        height = HEIGHT;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        applet.fill(255);
        applet.noStroke();
        applet.rect(0, 0, width, height);
        applet.fill(0);
        applet.textFont(Assets.getInstance().getFont(), 32);
        applet.text("Welcome!", width / 2f, height / 2f);
        applet.textFont(Assets.getInstance().getFont(), 16);
        applet.text("Press space to continue!", width / 2f, 2 * height / 3f);
        applet.stroke(0);
    }

    public void key() {
        done = true;
    }

    public boolean isDone() {
        return done;
    }
}
