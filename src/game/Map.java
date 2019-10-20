package game;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import trash.ITrash;
import trash.clean.Plastic;
import trash.trash.Trash;

import static game.Constants.*;

public class Map extends PObject {
    private PImage map;
    private Cell[][] cells = new Cell[COLUMNS][ROWS];

    Map(PApplet applet) {
        super(applet);
        map = Assets.getInstance().getBackground();
        pos = new PVector(-map.width / 2f, -map.height / 2f);
        width = map.width;
        height = map.height;

        for(int i = 0; i < COLUMNS; i++) {
            for(int j = 0; j < ROWS; j++) {
                cells[i][j] = new Cell(applet, null, i * TRASH_SIZE, j * TRASH_SIZE);
            }
        }

        // Load cities
        cells[45][29].setTrash(new Trash(applet, (int) cells[45][29].pos.x, (int) cells[45][29].pos.y));
        moveCells(-width / 2, -height / 2);
    }

    @Override
    public void update() {
        for(int i = 0; i < COLUMNS; i++) {
            for(int j = 0; j < ROWS; j++) {
                cells[i][j].update();
                ITrash trash = cells[i][j].getTrash();

                if(trash != null && !trash.isDead()) {
                    if(i+1 < COLUMNS) {
                        if (cells[i + 1][j].getTrash() instanceof Trash) trash.workNext((Trash) cells[i + 1][j].getTrash());
                        trash.helpAround(cells[i + 1][j].getTrash());
                    } if(i-1 >= 0) {
                        if (cells[i - 1][j].getTrash() instanceof Trash) trash.workNext((Trash) cells[i - 1][j].getTrash());
                        trash.helpAround(cells[i - 1][j].getTrash());
                    } if(j+1 < ROWS) {
                        if (cells[i][j + 1].getTrash() instanceof Trash) trash.workNext((Trash) cells[i][j + 1].getTrash());
                        trash.helpAround(cells[i][j + 1].getTrash());
                    } if(j-1 >= 0) {
                        if (cells[i][j - 1].getTrash() instanceof Trash) trash.workNext((Trash) cells[i][j - 1].getTrash());
                        trash.helpAround(cells[i][j - 1].getTrash());
                    }
                }
            }
        }
    }

    public void mouse(ITrash trash) {
        for(int i = 0; i < COLUMNS; i++) {
            for(int j = 0; j < ROWS; j++) {
                Cell cell = cells[i][j];
                if(isInRange(cell.pos.x, applet.mouseX - TRASH_SIZE, applet.mouseX) && isInRange(cell.pos.y, applet.mouseY - TRASH_SIZE, applet.mouseY)) {
                    ((PObject) trash).pos = new PVector(cell.pos.x, cell.pos.y);
                    cell.setTrash(trash);
                }
            }
        }
    }

    private void moveCells(int x, int y) {
        for(int i = 0; i < COLUMNS; i++) {
            for(int j = 0; j < ROWS; j++) {
                cells[i][j].move(x, y);
            }
        }
    }

    void move(Direction dir) {
        switch (dir) {
            case UP:
                if(pos.y < -MAP_OFFSET) {
                	pos.y += 40;
                    moveCells(0, 40);
                } break;
            case DOWN:
                if(pos.y > -map.height + HEIGHT + MAP_OFFSET) {
                	pos.y -= 40;
                	moveCells(0, -40);
                } break;
            case LEFT:
                if(pos.x < -MAP_OFFSET) {
                	pos.x += 40;
                	moveCells(40, 0);
                } break;
            case RIGHT:
                if(pos.x > -map.width + WIDTH + MAP_OFFSET) {
                	pos.x -= 40;
                	moveCells(-40, 0);
                } break;
        }
    }

    @Override
    public void render() {
        applet.image(map, pos.x, pos.y);
        for(int i = 0; i < COLUMNS; i++) {
            for(int j = 0; j < ROWS; j++) {
                cells[i][j].render();
            }
        }
        
    }
}
