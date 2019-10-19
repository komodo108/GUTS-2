import processing.core.PApplet;
import processing.core.PVector;

public class Cell extends PObject {

    private ITrashCleaner trash;
    boolean cool = false;

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
    }
    
    @Override
    void update() {
        if(trash != null) trash.update();
    }

    public void cool() {
        cool = true;
    }

    @Override
    void render() {
        if(!cool) applet.fill(0, 0);
        else applet.fill(255, 0, 0, 255);
        applet.rect(pos.x, pos.y, 64, 64);
        if(trash != null) trash.render();
    }
}
