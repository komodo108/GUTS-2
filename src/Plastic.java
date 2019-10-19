import processing.core.PApplet;
import processing.core.PImage;

public class Plastic extends PObject {
    private PImage plastic;

    Plastic(PApplet applet) {
        super(applet);
        plastic = Assets.getInstance().getPlastic();
    }

    @Override
    void update() {

    }

    @Override
    void render() {
        applet.image(plastic, pos.x, pos.y);
    }
}
