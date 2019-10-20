package game;

import processing.core.PApplet;

import static game.Constants.HEIGHT;
import static game.Constants.WIDTH;

public class Introduction extends PObject {
    private int slide = 0;

    public Introduction(PApplet applet) {
        super(applet);
        width = WIDTH;
        height = HEIGHT;
    }

    @Override
    public void update() { }

    public void gameOver() {
        slide = -1;
    }

    @Override
    public void render() {
        switch (slide) {
            case -1:
                applet.image(Assets.getInstance().getGameOver(), 0, 0);
                break;
            case 0:
                applet.image(Assets.getInstance().getSlide1(), 0, 0);
                break;
            case 1:
                applet.image(Assets.getInstance().getSlide2(), 0, 0);
                break;
            case 2:
                applet.image(Assets.getInstance().getSlide3(), 0, 0);
                break;
        }
    }

    public void key() {
        if(slide >= 0) slide++;
    }

    public boolean isDone() {
        return slide >= 3;
    }

    public boolean isGameOver() {
        return slide == -1;
    }
}
