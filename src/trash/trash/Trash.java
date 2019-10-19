package trash.trash;

import game.PObject;
import processing.core.PApplet;

import java.util.List;

public class Trash extends PObject {

    private List<ATrash> particles;

    Trash(PApplet applet) {
        super(applet);
    }

    @Override
    public void update() {
        for(ATrash trash : particles) {
            trash.update();
        }
    }

    @Override
    public void render() {
        for(ATrash trash : particles) {
            trash.render();
        }
    }
}
