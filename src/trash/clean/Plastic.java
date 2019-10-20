package trash.clean;

import game.Assets;
import game.Constants;
import processing.core.PApplet;
import trash.ATrash;
import trash.ITrash;

public class Plastic extends ATrash implements ITrash {

    public Plastic(PApplet applet, int x, int y) {
        super(applet, Constants.Type.PLASTIC, x, y);
        image = Assets.getInstance().getPlastic();
    }

    @Override
    public void helpAround(ITrash cleaner) {
        if (cleaner instanceof Plastic) {
            efficiency *= 2;
        }
        else if (cleaner instanceof Glass) {
            efficiency *=.5;
        }
        else if (cleaner instanceof Paper) {
            efficiency *= 1.2;
        }
        else if (cleaner instanceof Waste) {
            efficiency *= 0.2;
        }
    }
}
