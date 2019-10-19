import processing.core.PApplet;
import processing.core.PImage;

public class Paper extends ATrashCleaner implements ITrashCleaner {

    Paper(PApplet applet) {
        super(applet);
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
    }

}
