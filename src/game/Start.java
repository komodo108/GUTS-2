package game;

import processing.core.PApplet;

public class Start extends PApplet {

    public static void main(String[] args) {
        String[] pArgs = { "game.Main" };
        Main sketch = new Main();
        PApplet.runSketch(pArgs, sketch);
    }

}