package trash.trash;

import processing.core.PApplet;
import processing.core.PVector;
import trash.ITrash;
import trash.ATrash;

import java.util.ArrayList;
import java.util.List;

import static game.Constants.*;

public class Trash extends ATrash implements ITrash {
    private List<ATrashParticle> particles = new ArrayList<>();

    public Trash(PApplet applet, int x, int y) {
        super(applet, x, y);
        width = TRASH_SIZE;
        height = TRASH_SIZE;
    }

    @Override
    public void move(int x, int y) {
        pos.x += x;
        pos.y += y;
        for(ATrashParticle particle : particles) {
            particle.move(x, y);
        }
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
        List<ATrashParticle> add = new ArrayList<>();
        if((int) applet.random(10) == 0) {
            ATrashParticle particle = null;
            PVector place = new PVector(pos.x + applet.random(TRASH_SIZE), pos.y + applet.random(TRASH_SIZE));

            switch ((int) applet.random(4)) {
                case 0:
                    particle = new GlassParticle(applet, (int) place.x, (int) place.y);
                    break;
                case 1:
                    particle = new PlasticParticle(applet, (int) place.x, (int) place.y);
                    break;
                case 2:
                    particle = new PaperParticle(applet, (int) place.x, (int) place.y);
                    break;
                default:
                    particle = new WasteParticle(applet, (int) place.x, (int) place.y);
                    break;
            } add.add(particle);
        } for(ATrashParticle trash : particles) {
            trash.update();
        } particles.addAll(add);
    }

    @Override
    public void render() {
        for(ATrashParticle trash : particles) {
            trash.render();
        }
    }
}
