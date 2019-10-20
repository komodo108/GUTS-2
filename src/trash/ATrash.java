package trash;

import game.PObject;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import trash.clean.Glass;
import trash.clean.Waste;
import trash.clean.Paper;
import trash.clean.Plastic;
import trash.trash.Trash;

import static game.Constants.*;

public abstract class ATrash extends PObject implements ITrash {
    public PImage image;
    public int percentage = 100;
    public double efficiency = 1;

    public ATrash(PApplet applet, int x, int y) {
        super(applet);
        this.pos = new PVector(x, y);
        width = TRASH_SIZE;
        height = TRASH_SIZE;
    }

    @Override
    public void move(int x, int y) {
        pos.x += x;
        pos.y += y;
    }

    @Override
    public void update() { /* nothing */ }

    @Override
    public void render() {
        applet.image(image, pos.x, pos.y, TRASH_SIZE, TRASH_SIZE);
    }

    @Override
    public int getPercentage() {
        return percentage;
    }

    @Override
    public boolean isDead() {
        return (percentage <= 0);
    }

    @Override
    public ITrash copy() {
        ITrash trash = null;
        if(!(this instanceof Trash)) {
            PObject object = (PObject) this;
            if(this instanceof Glass) {
                trash = new Glass(applet, (int) object.pos.x, (int) object.pos.y);
            } else if (this instanceof Waste) {
                trash = new Waste(applet, (int) object.pos.x, (int) object.pos.y);
            } else if (this instanceof Paper) {
                trash = new Paper(applet, (int) object.pos.x, (int) object.pos.y);
            } else if (this instanceof Plastic) {
                trash = new Plastic(applet, (int) object.pos.x, (int) object.pos.y);
            }
        } return trash;
    }
}
