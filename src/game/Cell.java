package game;

import processing.core.PApplet;
import processing.core.PVector;
import trash.clean.ITrashCleaner;

public class Cell extends PObject {

    private ITrashCleaner trash;

    public Cell(PApplet applet, ITrashCleaner trash, int x, int y) {
        super(applet);
        this.trash = trash;
        this.pos = new PVector(x, y);
    }

    public void setTrash(ITrashCleaner trash) {
        this.trash = trash;
    }

    public ITrashCleaner getTrash() {
        return trash;
    }

    public void move(int x, int y) {
        pos.x += x;
        pos.y += y;
        if(trash != null) trash.move(x, y);
    }
    
    @Override
    public void update() {
        if(trash != null) trash.update();
    }

    @Override
    public void render() {
        applet.fill(0, 0);
        applet.rect(pos.x, pos.y, 64, 64);
        if(trash != null) trash.render();
    }
}
