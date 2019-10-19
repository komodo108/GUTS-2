import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Map extends PObject {
    enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

    private PImage map;
    private List<PObject> objects = new ArrayList<>();

    Map(PApplet applet) {
        super(applet);
        map = Assets.getInstance().getBackground();
        pos = new PVector(-map.width / 2f, -map.height / 2f);
    }

    @Override
    void update() {

    }

    void move(Direction dir) {
        switch (dir) {
            case UP:
                if(pos.y < -50) pos.y += 40;
                break;
            case DOWN:
                if(pos.y > -map.height + 650) pos.y -= 40;
                break;
            case LEFT:
                if(pos.x < -50) pos.x += 40;
                break;
            case RIGHT:
                if(pos.x > -map.width + 850) pos.x -= 40;
                break;
        }
        System.out.println(pos);
    }

    @Override
    void render() {
        applet.image(map, pos.x, pos.y);
    }
}
