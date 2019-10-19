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
        } moveCells(-map.width / 2, -map.height / 2);
    }

    @Override
    void update() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                cells[i][j].update();
            }
        }
    }

    public void mouse(int x, int y) {
        cells[0][0].cool();
    }

    void moveCells(int x, int y) {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                cells[i][j].move(x, y);
            }
        }
    }

    void move(Direction dir) {
        switch (dir) {
            case UP:
                if(pos.y < -50) {
                	pos.y += 40;
                    moveCells(0, 40);
                } break;
            case DOWN:
                if(pos.y > -map.height + 650) {
                	pos.y -= 40;
                	moveCells(0, -40);
                } break;
            case LEFT:
                if(pos.x < -50) {
                	pos.x += 40;
                	moveCells(40, 0);
                } break;
            case RIGHT:
                if(pos.x > -map.width + 850) {
                	pos.x -= 40;
                	moveCells(-40, 0);
                } break;
        }
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
