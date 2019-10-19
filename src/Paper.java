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

    }

    @Override
    public int getPercentage() {
        return 0;
    }

}
