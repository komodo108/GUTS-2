package game;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

import static processing.core.PConstants.LEFT;

public class Info extends PObject {
    private PFont font;

    public Info(PApplet applet) {
        super(applet);
        this.font = Assets.getInstance().getFont();
        pos = new PVector(10, this.font.getSize() + 10);
    }

    @Override
    public void update() { /* nothing */ }

    @Override
    public void render() {
        applet.textFont(font, 16);
        applet.fill(170, 25, 25);
        applet.textAlign(LEFT);
        applet.text(Assets.getInstance().getInfo(), pos.x, pos.y);
    }
}
