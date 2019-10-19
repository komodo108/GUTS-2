import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {

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
    }

    @Override
    public void draw() {
        // Draw the background
        background(0);
    }

    @Override
    public void keyReleased() {
        switch (key) {
            // R to rest the game
            case 'r':
                // Reset
        }
    }

    @Override
    public void mouseReleased() {

    }
}
