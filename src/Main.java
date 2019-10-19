import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {

    private Map map;

    @Override
    public void settings() {
        // Set the size
        size(800, 600);
    }

    @Override
    public void setup() {
        // Setup window options
        surface.setTitle("Trashy Game");
        surface.setCursor(CROSS);

        Assets.getInstance().load(this);
        map = new Map(this);
    }

    @Override
    public void draw() {
        // Draw the background
        background(0);
        map.update();
        map.render();
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
                        map.move(Map.Direction.UP);
                        break;
                    case DOWN:
                        map.move(Map.Direction.DOWN);
                        break;
                    case LEFT:
                        map.move(Map.Direction.LEFT);
                        break;
                    case RIGHT:
                        map.move(Map.Direction.RIGHT);
                        break;
                }
        }
    }

    @Override
    public void mouseReleased() {
        map.mouse(mouseX, mouseY);
    }
}
