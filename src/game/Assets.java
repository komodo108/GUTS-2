package game;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.sound.SoundFile;

public class Assets {
    private static Assets singleton = null;

    private Assets() { }

    public static Assets getInstance() {
        if (singleton == null) singleton = new Assets();
        return singleton;
    }

    private PImage background, plastic, glass, paper, waste, upgrade, slide1, slide2, slide3, gameover;
    private String[] positions;
    private PFont font;
    private PApplet applet;
    private SoundFile sound;

    private int money = 2000;
    private String info = "";
    private int wave = 0;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void setMoney(int money) { this.money = money; }

    public int getMoney() {
        return money;
    }

    public int getWave() {
        return wave;
    }

    public double getMultiplyer() {
        switch (wave) {
            case 0: case 1:
                return 0.4;
            case 2: case 3: case 4: case 5:
                return 0.5;
            case 6: case 7: case 8: case 9:
                return 0.6;
            case 10: case 11: case 12: case 13:
                return 0.7;
            case 14: case 15: case 16: case 17:
                return 0.8;
            case 18: case 19: case 20: case 21:
                return 0.9;
            default:
                return 1;
        }
    }

    public void nextWave() {
        this.wave += 1;
    }

    public void load(PApplet applet) {
        // Setup assets
        this.applet = applet;

        background = applet.loadImage("../data/worldmap.png");
        plastic = applet.loadImage("../data/plastic.png");
        glass = applet.loadImage("../data/glass.png");
        paper = applet.loadImage("../data/paper.png");
        waste = applet.loadImage("../data/waste.png");
        upgrade = applet.loadImage("../data/upgrade.png");

        slide1 = applet.loadImage("../data/slide1.png");
        slide2 = applet.loadImage("../data/slide2.png");
        slide3 = applet.loadImage("../data/slide3.png");
        gameover = applet.loadImage("../data/gameover.png");
        positions = applet.loadStrings("../data/coordinates.txt");

        sound = new SoundFile(this.applet, "../data/music.mp3");
        sound.play();
    }

    public PImage getPlastic(){
        return plastic;
    }

    public PImage getGlass(){
        return glass;
    }

    public PImage getGameOver() {
        return gameover;
    }

    public PImage getPaper(){
        return paper;
    }

    public PImage getWaste(){
        return waste;
    }

    public PImage getUpgrade() {
        return upgrade;
    }

    public PImage getSlide1() {
        return slide1;
    }

    public PImage getSlide2() {
        return slide2;
    }

    public PImage getSlide3() {
        return slide3;
    }

    public void setFont(PFont font) {
        this.font = font;
    }

    public PFont getFont() {
        return font;
    }

    public String[] getPositions() {
        return positions;
    }

    public PImage getBackground() {
        return background;
    }
}
