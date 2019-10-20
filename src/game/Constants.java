package game;

public final class Constants {
    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public enum Type {
        PLASTIC, WASTE, GLASS, PAPER, OTHER
    }

    public static boolean isInRange(float value, float min, float max) {
        return (value >= min) && (value <= max);
    }
    public static boolean isInXRange(float value, float min, float max) {
        return (value >= min) && (value < max);
    }

    public static final String NAME = "Trashy Game";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final int MAP_OFFSET = 30;
    public static final int TRASH_SIZE = 64;

    public static final int ROWS = 51;
    public static final int COLUMNS = 78;
}
