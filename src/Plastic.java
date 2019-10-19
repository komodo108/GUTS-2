import processing.core.PApplet;
import processing.core.PImage;

public class Plastic extends ATrashCleaner implements ITrashCleaner {

    Plastic(PApplet applet, int x, int y) {
        super(applet, x, y);
        image = Assets.getInstance().getPlastic();
    }

    @Override
    public void workNext(Trash next) {

    }

    @Override
    public void helpAround(ITrashCleaner cleaner) {
        if (cleaner instanceof Plastic) {
            efficiency *= 2;
        }
        else if (cleaner instanceof Glass) {
            efficiency *=.5;
        }
        else if (cleaner instanceof Paper) {
            efficiency *= 1.2;
        }
        else if (cleaner instanceof Gwaste) {
            efficiency *= 0.2;
        }
    }
}
