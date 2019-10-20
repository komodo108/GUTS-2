package trash.clean;

import game.Assets;
import game.Constants;
import processing.core.PApplet;
import trash.ATrash;
import trash.ITrash;
import trash.trash.Trash;

public class Upgrade extends ATrash {
    public Upgrade(PApplet applet, int x, int y) {
        super(applet, Constants.Type.UPGRADE, x, y);
        image = Assets.getInstance().getUpgrade();
    }

    @Override
    public void workNext(Trash next) { }

    @Override
    public void helpAround(ITrash cleaner) {
        // TODO: Increase effiency
        if(cleaner != null) cleaner.upgrade();
    }
}
