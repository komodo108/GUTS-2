package trash.trash;

import game.PObject;
import processing.core.PApplet;
import processing.core.PVector;
import trash.clean.ITrashCleaner;

public abstract class ATrash extends PObject {
    ITrashCleaner.Type type;
    PVector colour;

    ATrash(PApplet applet, ITrashCleaner.Type type) {
        super(applet);
        this.type = type;
    }
}
