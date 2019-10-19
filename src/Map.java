import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Map extends PObject {
    enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

    private PImage map;
    private final int ROWS = Assets.getInstance().ROWS, COLUMNS = Assets.getInstance().COLUMNS;
    private Cell[][] cells = new Cell[ROWS][COLUMNS];

    Map(PApplet applet) {
        super(applet);
        map = Assets.getInstance().getBackground();
        pos = new PVector(-map.width / 2f, -map.height / 2f);

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                cells[i][j] = new Cell(applet, null, i*64, j*64);
            }
        }
    }

    @Override
    void update() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                cells[i][j].update();
            }
        }
    }

    void move(Direction dir) {
        switch (dir) {
            case UP:
                if(pos.y < -50) {
                	pos.y += 40;
                	applet.rect(pos.x, pos.y, 64, 64);
                }
                break;
            case DOWN:
                if(pos.y > -map.height + 650) {
                	pos.y -= 40;
                	applet.rect(pos.x, pos.y, 64, 64);
                }
                break;
            case LEFT:
                if(pos.x < -50) {
                	pos.x += 40;
                	applet.rect(pos.x, pos.y, 64, 64);
                }
                break;
            case RIGHT:
                if(pos.x > -map.width + 850) {
                	pos.x -= 40;
                	applet.rect(pos.x, pos.y, 64, 64);
                }
                break;
        }
        
        System.out.println(pos);
    }

    @Override
    void render() {
        applet.image(map, pos.x, pos.y);
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                cells[i][j].render();
            }
        }
        
    }
}
