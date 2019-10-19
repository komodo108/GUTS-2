import processing.core.PApplet;
import processing.core.PImage;

public class Paper extends ATrashCleaner implements ITrashCleaner {

    Paper(PApplet applet, int x, int y) {
        super(applet, x, y);
        image = Assets.getInstance().getPaper();
    }

    @Override
    public void workNext(Trash next) {

    }

    @Override
    public void helpAround(ITrashCleaner cleaner) {
        if (cleaner instanceof Paper) {
            efficiency *= 2;
        }
        else if (cleaner instanceof Plastic) {
            efficiency *=.5;
        }
        else if (cleaner instanceof Glass) {
            efficiency *= 1.2;
        }
        else if (cleaner instanceof Gwaste) {
            efficiency *= 0.2;
        }
    }

}
