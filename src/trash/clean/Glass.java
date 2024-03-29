package trash.clean;

import game.Assets;
import game.Constants;
import processing.core.PApplet;
import trash.ATrash;
import trash.ITrash;

public class Glass extends ATrash implements ITrash {
    public Glass(PApplet applet, int x, int y) {
        super(applet, Constants.Type.GLASS, x, y);
        image = Assets.getInstance().getGlass();
    }

    @Override
    public void helpAround(ITrash cleaner) {
        if (cleaner instanceof Glass) {
            efficiency *= 2;
        }
        else if (cleaner instanceof Paper) {
            efficiency *=.5;
        }
        else if (cleaner instanceof Plastic) {
            efficiency *= 1.2;
        }
        else if (cleaner instanceof Waste) {
            efficiency *= 0.2;
        }
    }

}
