package trash.clean;

import game.Assets;
import game.Constants;
import processing.core.PApplet;
import trash.ATrash;
import trash.ITrash;

public class Waste extends ATrash implements ITrash {

    public Waste(PApplet applet, int x, int y) {
        super(applet, Constants.Type.WASTE, x, y);
        image = Assets.getInstance().getWaste();
    }

    @Override
    public void helpAround(ITrash cleaner) {
        if (cleaner instanceof Waste) {
            efficiency *= 2;
        } else if (cleaner instanceof Glass) {
            efficiency *=.5;
        } else if (cleaner instanceof Paper) {
            efficiency *= 1.2;
        } else if (cleaner instanceof Plastic) {
            efficiency *= 0.2;
        }
    }
}