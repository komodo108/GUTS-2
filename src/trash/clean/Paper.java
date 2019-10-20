package trash.clean;

import game.Assets;
import processing.core.PApplet;
import trash.ATrash;
import trash.ITrash;
import trash.trash.Trash;

public class Paper extends ATrash implements ITrash {

    public Paper(PApplet applet, int x, int y) {
        super(applet, x, y);
        image = Assets.getInstance().getPaper();
    }

    @Override
    public void workNext(Trash next) {

    }

    @Override
    public void helpAround(ITrash cleaner) {
        if (cleaner instanceof Paper) {
            efficiency *= 2;
        }
        else if (cleaner instanceof Plastic) {
            efficiency *=.5;
        }
        else if (cleaner instanceof Glass) {
            efficiency *= 1.2;
        }
        else if (cleaner instanceof Waste) {
            efficiency *= 0.2;
        }
    }

}
