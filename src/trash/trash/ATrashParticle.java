package trash.trash;

import game.Constants;
import game.PObject;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class ATrashParticle extends PObject {
    Constants.Type type;
    PVector colour;

    ATrashParticle(PApplet applet, Constants.Type type) {
        super(applet);
        this.type = type;
    }
}
