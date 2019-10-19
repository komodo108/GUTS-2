import processing.core.PApplet;
import processing.core.PImage;

public class Glass extends PObject implements ITrashCleaner {
    private PImage glass;

    Plastic(PApplet applet) {
        super(applet);
        glass = Assets.getInstance().getGlass();
    }

    @Override
    void update() {

    }

    @Override
    void render() {
        applet.image(glass, pos.x, pos.y); //scaled
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
