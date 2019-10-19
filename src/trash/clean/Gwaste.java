package trash.clean;

import game.Assets;
import processing.core.PApplet;
import trash.trash.Trash;

public class Gwaste extends ATrashCleaner implements ITrashCleaner {

    public Gwaste(PApplet applet, int x, int y) {
        super(applet, x, y);
        image = Assets.getInstance().getGwaste();
    }

    @Override
    public void workNext(Trash next) {

    }

    @Override
    public void helpAround(ITrashCleaner cleaner) {
        if (cleaner instanceof Gwaste) {
            efficiency *= 2;
        }
        else if (cleaner instanceof Glass) {
            efficiency *=.5;
        }
        else if (cleaner instanceof Paper) {
            efficiency *= 1.2;
        }
        else if (cleaner instanceof Plastic) {
            efficiency *= 0.2;
        }
    }
}