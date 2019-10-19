import processing.core.PApplet;
import processing.core.PImage;

public class Plastic extends PObject implements ITrashCleaner {
    private PImage plastic;

    Plastic(PApplet applet) {
        super(applet);
        plastic = Assets.getInstance().getPlastic();
    }

    @Override
    void update() {

    }

    @Override
    public void uodate() {

    }

    @Override
    public void render() {
        applet.image(plastic, pos.x, pos.y); //scaled
    }

    @Override
    public void workNext(Trash next) {

    }

    @Override
    public void helpAround(ITrashCleaner cleaner) {

    }

    @Override
    public int getPercentage() {
        return 0;
    }
}
