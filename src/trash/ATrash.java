package trash;

import game.PObject;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import trash.clean.*;
import trash.trash.Trash;

import static game.Constants.TRASH_SIZE;
import static game.Constants.Type;

public abstract class ATrash extends PObject implements ITrash {
    public PImage image;
    public Type type;
    public int percentage = 100;
    public double efficiency = 1;

    public ATrash(PApplet applet, Type type, int x, int y) {
        super(applet);
        this.pos = new PVector(x, y);
        this.type = type;
        width = TRASH_SIZE;
        height = TRASH_SIZE;
    }

    @Override
    public void move(int x, int y) {
        pos.x += x;
        pos.y += y;
    }

    @Override
    public void setPos(int x, int y) {
        pos.x = x;
        pos.y = y;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void update() { /* nothing */ }

    @Override
    public void workNext(Trash next) {
        if(next != null) {
            boolean removed = next.reduce(getType());
            if(removed) percentage -= 1;
        }
    }

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
            } else if (this instanceof Upgrade) {
                trash = new Upgrade(applet, (int) object.pos.x, (int) object.pos.y);
            }
        } return trash;
    }
}
