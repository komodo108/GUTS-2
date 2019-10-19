import processing.core.PApplet;
import processing.core.PImage;

public class Map extends PObject {
    private PImage map;

    Map(PApplet applet) {
        super(applet);
        map = Assets.getInstance().getBackground();
    }

    @Override
    void update() {

    }

    @Override
    void render() {
        applet.image(map, 0, 0);
    }
}
