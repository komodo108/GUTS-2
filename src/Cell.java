import processing.core.PApplet;
import processing.core.PVector;

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

    @Override
    void update() {
        if(trash != null) trash.update();
    }

    @Override
    void render() {
        applet.fill(0, 0);
        applet.rect(pos.x, pos.y, 64, 64);
        if(trash != null) trash.render();
    }
}
