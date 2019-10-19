import processing.core.PApplet;
import processing.core.PImage;

public class Glass extends ATrashCleaner implements ITrashCleaner {

    Glass(PApplet applet) {
        super(applet);
        image = Assets.getInstance().getGlass();
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
