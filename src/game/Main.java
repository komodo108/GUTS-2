package game;

import processing.core.PApplet;

import static game.Constants.*;

public class Main extends PApplet {
    private Map map;
    private Selector selector;
    private Money money;
    private Info info;
    private Introduction intro;

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
        Assets.getInstance().setFont(createFont("Consolas", 12, true));

        intro = new Introduction(this);
        Assets.getInstance().setMoney(2000);
    }

    public void startGame() {
        map = new Map(this);
        selector = new Selector(this);
        info = new Info(this);
        money = new Money(this);
    }

    @Override
    public void draw() {
        // Draw the background
        background(0);

        if(intro != null) {
            intro.update();
            intro.render();
            if(intro.isDone()) {
                startGame();
                intro = null;
            }
        } else {
            map.update();
            selector.update();
            money.update();
            info.update();

            map.render();
            selector.render();
            money.render();
            info.render();
        }
    }

    @Override
    public void keyPressed() {
        if(intro == null) {
            switch (key) {
                // R to rest the game
                case 'r':
                    // Reset
                    map = null;
                    selector = null;
                    money = null;
                    intro = new Introduction(this);
                    break;

                case '1':
                    map.move(12, 26); //Spain
                    break;
                case '2':
                    map.move(66, 24); //US
                    break;
                case '3':
                    map.move(-2, -14);
                    break;
                // TODO: Add more

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
        } else {
            if(key == ' ') {
                intro.key();
            }
        }
    }

    public void mouseMoved() {
        if(intro == null) selector.updateSelected();
    }

    @Override
    public void mouseReleased() {
        if(intro == null) {
            if (selector.hasSelected()) map.mouse(selector.mouse(), selector.getPrice());
            else selector.mouse();
        }
    }
}
