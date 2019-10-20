package trash.trash;

import processing.core.PApplet;
import trash.ITrash;
import trash.ATrash;

import java.util.List;

import static game.Constants.*;

public class Trash extends ATrash implements ITrash {
    private List<ATrashParticle> particles;

    Trash(PApplet applet, int x, int y) {
        super(applet, x, y);
        width = TRASH_SIZE;
        height = TRASH_SIZE;
    }

    @Override
    public void move(int x, int y) {
        pos.x += x;
        pos.y += y;
    }

    @Override
    public void workNext(Trash next) { /* nothing */ }

    @Override
    public void helpAround(ITrash cleaner) { /* nothing */ }

    @Override
    public int getPercentage() {
        return -1;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void update() {
        for(ATrashParticle trash : particles) {
            trash.update();
        }
    }

    @Override
    public void render() {
        for(ATrashParticle trash : particles) {
            trash.render();
        }
    }
}
