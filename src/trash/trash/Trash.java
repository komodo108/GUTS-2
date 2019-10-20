package trash.trash;

import game.Assets;
import processing.core.PApplet;
import processing.core.PVector;
import trash.ATrash;
import trash.ITrash;

import java.util.ArrayList;
import java.util.List;

import static game.Constants.TRASH_SIZE;
import static game.Constants.Type;
import static game.Constants.Type.OTHER;
import static game.Constants.Type.WASTE;

public class Trash extends ATrash implements ITrash {
    private List<ATrashParticle> particles = new ArrayList<>();

    public Trash(PApplet applet, int x, int y) {
        super(applet, OTHER, x, y);
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

    public boolean reduce(Type type) {
        boolean did = false;
        List<ATrashParticle> removed = new ArrayList<>();
        for(ATrashParticle particle : particles) {
            if(particle.getType().equals(type) || (int) applet.random(15) == 0) {
                switch (particle.getType()) {
                    case WASTE:
                        if ((int) applet.random(5) == 0) {
                            removed.add(particle);
                            Assets.getInstance().addMoney(10);
                            did = true;
                        }
                        break;
                    case PAPER: case PLASTIC: case GLASS:
                        if ((int) applet.random(15) == 0) {
                            removed.add(particle);
                            Assets.getInstance().addMoney(30);
                            did = true;
                        }
                        break;
                }
            }
        } particles.removeAll(removed);
        return did;
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
        ATrashParticle particle = null;
        if((int) applet.random(10) == 0 && particles.size() < 30) {
            PVector place = new PVector(pos.x + applet.random(TRASH_SIZE), pos.y + applet.random(TRASH_SIZE));

            switch ((int) applet.random(20)) {
                case 0: case 1: case 2: case 3:
                    particle = new GlassParticle(applet, (int) place.x, (int) place.y);
                    break;
                case 4: case 5: case 6: case 7:
                    particle = new PlasticParticle(applet, (int) place.x, (int) place.y);
                    break;
                case 8: case 9: case 10: case 11:
                    particle = new PaperParticle(applet, (int) place.x, (int) place.y);
                    break;
                default:
                    particle = new WasteParticle(applet, (int) place.x, (int) place.y);
                    break;
            } particles.add(particle);
        }

        double money = 0;
        for(ATrashParticle trash : particles) {
            if((int) applet.random(15) == 0) money += trash.getType().equals(WASTE) ? 0.1 : 0.3;
            trash.update();
        } Assets.getInstance().addMoney((int) -money);
    }

    @Override
    public void render() {
        for(ATrashParticle trash : particles) {
            trash.render();
        }
    }
}
