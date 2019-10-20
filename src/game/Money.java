package game;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

import static game.Constants.WIDTH;
import static processing.core.PConstants.RIGHT;

public class Money extends PObject {
    private PFont font;

    public Money(PApplet applet) {
        super(applet);
        this.font = Assets.getInstance().getFont();
        pos = new PVector(WIDTH - 10, this.font.getSize() + 10);
        Assets.getInstance().addMoney(100);
    }

    @Override
    public void update() { /* nothing */ }

    @Override
    public void render() {
        applet.textFont(font, 16);
        applet.fill(25, 170, 25);
        applet.textAlign(RIGHT);
        applet.text("$" + Assets.getInstance().getMoney(), pos.x, pos.y);
    }
}
