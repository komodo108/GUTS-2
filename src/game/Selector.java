package game;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;
import trash.ITrash;
import trash.clean.Glass;
import trash.clean.Paper;
import trash.clean.Plastic;
import trash.clean.Waste;

import java.util.ArrayList;
import java.util.List;

import static game.Constants.*;
import static processing.core.PConstants.RIGHT;

public class Selector extends PObject {
    private ITrash selected;
    private int selected_price, price;

    private PFont font;
    private List<ITrash> items = new ArrayList<>();
    private List<Integer> prices = new ArrayList<>();

    public Selector(PApplet applet) {
        super(applet);
        pos = new PVector((WIDTH / 2f) - TRASH_SIZE * (5 / 2f), HEIGHT - TRASH_SIZE);
        width = TRASH_SIZE * 5;
        height = TRASH_SIZE;
        font = Assets.getInstance().getFont();
        selected = null;

        items.add(new Glass(applet, (int) ((WIDTH / 2f) - TRASH_SIZE * (5 / 2f)), HEIGHT - TRASH_SIZE));
        prices.add(50);
        items.add(new Plastic(applet, (int) ((WIDTH / 2f) - TRASH_SIZE * (3 / 2f)), HEIGHT - TRASH_SIZE));
        prices.add(50);
        items.add(new Paper(applet, (int) ((WIDTH / 2f) - TRASH_SIZE * (1 / 2f)), HEIGHT - TRASH_SIZE));
        prices.add(50);
        items.add(new Waste(applet, (int) ((WIDTH / 2f) + TRASH_SIZE * (1 / 2f)), HEIGHT - TRASH_SIZE));
        prices.add(20);

        prices.add(100);
    }

    @Override
    public void update() { }

    public ITrash mouse() {
        if(selected != null) {
            ITrash trash = selected.copy();
            price = selected_price;
            selected_price = 0;
            selected = null;
            return trash;
        } else {
            int i = 0;
            for(ITrash trash : items) {
                if(((PObject) trash).isMouseInside() && Assets.getInstance().getMoney() >= price) {
                    selected = trash.copy();
                    selected_price = prices.get(i);
                } i++;
            }
        } return null;
    }

    boolean hasSelected() {
        return (selected != null);
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void render() {
        applet.textFont(font, 12);
        applet.textAlign(RIGHT);
        if(selected != null) selected.render();

        int i = 0;
        for(ITrash trash : items) {
            PObject trashO = (PObject) trash;
            applet.rect(trashO.pos.x, trashO.pos.y, trashO.width, trashO.height);
            trash.render();

            applet.fill(25, 170, 25);
            applet.text("$" + prices.get(i), trashO.pos.x + TRASH_SIZE, trashO.pos.y + font.getSize());
            applet.fill(0, 0);
            i++;
        } applet.rect(pos.x, pos.y, width, height);
    }

    public void updateSelected() {
        if(selected != null) {
            PObject object = (PObject) selected;
            object.pos = new PVector(applet.mouseX - (object.width / 2f), applet.mouseY - (object.height / 2f));
        }
    }
}
