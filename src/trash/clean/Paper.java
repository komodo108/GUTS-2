package trash.clean;

import game.Assets;
import game.Constants;
import processing.core.PApplet;
import trash.ATrash;
import trash.ITrash;

public class Paper extends ATrash implements ITrash {

    public Paper(PApplet applet, int x, int y) {
        super(applet, Constants.Type.PAPER, x, y);
        image = Assets.getInstance().getPaper();
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
