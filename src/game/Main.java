package game;

import processing.core.PApplet;

import static game.Constants.*;

public class Main extends PApplet {
    private Map map;
    private Selector selector;

    @Override
    public void settings() {
        // Set the size
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        // Setup window options
        surface.setTitle(NAME);
        surface.setCursor(CROSS);

        Assets.getInstance().load(this);
        map = new Map(this);
        selector = new Selector(this);
    }

    @Override
    public void draw() {
        // Draw the background
        background(0);

        map.update();
        selector.update();

        map.render();
        selector.render();
    }

    @Override
    public void keyPressed() {
        switch (key) {
            // R to rest the game
            case 'r':
                // Reset
            case CODED:
                switch (keyCode) {
                    case UP:
                        map.move(Direction.UP);
                        break;
                    case DOWN:
                        map.move(Direction.DOWN);
                        break;
                    case LEFT:
                        map.move(Direction.LEFT);
                        break;
                    case RIGHT:
                        map.move(Direction.RIGHT);
                        break;
                }
        }
    }

    public void mouseMoved() {
        selector.updateSelected();
    }

    @Override
    public void mouseReleased() {
        if(selector.hasSelected()) map.mouse(selector.mouse());
        else selector.mouse();
    }
}
