import processing.core.PApplet;

import java.util.List;

public class Trash extends PObject {

    private List<ATrash> particles;

    Trash(PApplet applet) {
        super(applet);
    }

    @Override
    void update() {
        for(ATrash trash : particles) {
            trash.update();
        }
    }

    @Override
    void render() {
        for(ATrash trash : particles) {
            trash.render();
        }
    }
}
