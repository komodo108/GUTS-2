package game;

import processing.core.PApplet;
import processing.core.PVector;
import trash.ITrash;

import static game.Constants.TRASH_SIZE;

public class Cell extends PObject {

    private ITrash trash;

    public Cell(PApplet applet, ITrash trash, int x, int y) {
        super(applet);
        this.trash = trash;
        this.pos = new PVector(x, y);
        this.width = TRASH_SIZE;
        this.height = TRASH_SIZE;
    }

    public void setTrash(ITrash trash) {
        this.trash = trash;
    }

    public ITrash getTrash() {
        return trash;
    }

    public void move(int x, int y) {
        pos.x += x;
        pos.y += y;
        if(trash != null) trash.move(x, y);
    }
    
    @Override
    public void update() {
        if(trash != null) {
            trash.update();
            if(trash.isDead()) trash = null;
        }
    }

    @Override
    public void render() {
        applet.fill(0, 0);
        //applet.rect(pos.x, pos.y, 64, 64);
        if(trash != null) trash.render();
    }
}
