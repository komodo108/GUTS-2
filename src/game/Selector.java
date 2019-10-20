package game;

import processing.core.PApplet;
import processing.core.PVector;
import trash.ITrash;
import trash.clean.Glass;
import trash.clean.Waste;
import trash.clean.Paper;
import trash.clean.Plastic;

import java.util.ArrayList;
import java.util.List;

import static game.Constants.*;

public class Selector extends PObject {
    private ITrash selected;
    private List<ITrash> items = new ArrayList<>();

    public Selector(PApplet applet) {
        super(applet);
        pos = new PVector((WIDTH / 2f) - TRASH_SIZE * (5 / 2f), HEIGHT - TRASH_SIZE);
        width = TRASH_SIZE * 5;
        height = TRASH_SIZE;

        items.add(new Glass(applet, (int) ((WIDTH / 2f) - TRASH_SIZE * (5 / 2f)), HEIGHT - TRASH_SIZE));
        items.add(new Plastic(applet, (int) ((WIDTH / 2f) - TRASH_SIZE * (3 / 2f)), HEIGHT - TRASH_SIZE));
        items.add(new Paper(applet, (int) ((WIDTH / 2f) - TRASH_SIZE * (1 / 2f)), HEIGHT - TRASH_SIZE));
        items.add(new Waste(applet, (int) ((WIDTH / 2f) + TRASH_SIZE * (1 / 2f)), HEIGHT - TRASH_SIZE));
        selected = null;
    }

    @Override
    public void update() {

    }

    public ITrash mouse() {
        if(selected != null) {
            ITrash trash = selected.copy();
            selected = null;
            return trash;
        } else {
            for(ITrash trash : items) {
                if(((PObject) trash).isMouseInside()) {
                    selected = trash.copy();
                }
            }
        } return null;
    }

    public boolean hasSelected() {
        return (selected != null);
    }

    @Override
    public void render() {
        if(selected != null) selected.render();
        for(ITrash trash : items) {
            PObject trashO = (PObject) trash;
            applet.rect(trashO.pos.x, trashO.pos.y, trashO.width, trashO.height);
            trash.render();
        } applet.rect(pos.x, pos.y, width, height);
    }

    public void updateSelected() {
        if(selected != null) {
            PObject object = (PObject) selected;
            object.pos = new PVector(applet.mouseX - (object.width / 2f), applet.mouseY - (object.height / 2f));
        }
    }
}
