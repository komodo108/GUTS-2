import processing.core.PApplet;
import processing.core.PImage;

public class Paper extends PObject implements ITrashCleaner {
    private PImage paper;

    Plastic(PApplet applet) {
        super(applet);
        paper = Assets.getInstance().getPaper();
    }

    @Override
    void update() {

    }

    @Override
    void render() {
        applet.image(paper, pos.x, pos.y); //scaled
    }

    @Override
    public void workNext(Trash next) {

    }

    @Override
    public void helpAround(ITrashCleaner cleaner) {

    }

    @Override
    public int getPercentage() {
        return 0;
    }

}
