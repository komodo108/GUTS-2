import processing.core.PApplet;

public class Start extends PApplet {

    /**
     * Start off the application
     * @param args the arguments
     */
    public static void main(String[] args) {
        String[] pArgs = { "Main" };
        Main sketch = new Main();
        PApplet.runSketch(pArgs, sketch);
    }

}