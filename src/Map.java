import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Map extends PObject {
    enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

    private PImage map;

    Map(PApplet applet) {
        super(applet);
        map = Assets.getInstance().getBackground();
    }

    @Override
    void update() {

    }

    void move(Direction dir) {
        switch (dir) {
            case UP:
                pos.x += 10;
                break;
            case DOWN:
                pos.x -= 10;
                break;
            case LEFT:
                pos.y += 10;
                break;
            case RIGHT:
                pos.y -= 10;
                break;
        }
    }

    @Override
    void render() {
        applet.image(map, pos.x, pos.y);
    }
}
