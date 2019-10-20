package game;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import trash.ITrash;
import trash.trash.Trash;

import java.util.ArrayList;
import java.util.List;

import static game.Constants.*;

public class Map extends PObject {
    private PImage map;
    private Cell[][] cells = new Cell[COLUMNS][ROWS];
    private List<Holder> to_add = new ArrayList<>();

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
        String[] lines = Assets.getInstance().getPositions();
        for(String position : lines) {
            String[] words = position.split(" ");
            int i1 = Integer.parseInt(words[1]);
            int i2 = Integer.parseInt(words[2]);
            to_add.add(new Holder(i1, i2));
        } moveCells(-width / 2, -height / 2);
        move(12, 26); //Look over EU
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

        if((int) applet.random((int) (500 / Assets.getInstance().getMultiplyer())) == 0) {
            int index = (int) applet.random(to_add.size());
            Holder held = to_add.get(index);
            Cell cell = cells[held.getI1()][held.getI2()];
            cell.setTrash(new Trash(applet, (int) cell.pos.x, (int) cell.pos.y));
            Assets.getInstance().setInfo("CITY SPAWNING: [" + held.getI1() + ", " + held.getI2() + "]");
        }
    }

    public void mouse(ITrash trash, int price) {
        for(int i = 0; i < COLUMNS; i++) {
            for(int j = 0; j < ROWS; j++) {
                Cell cell = cells[i][j];
                if(isInRange(cell.pos.x, applet.mouseX - TRASH_SIZE, applet.mouseX) && isInRange(cell.pos.y, applet.mouseY - TRASH_SIZE, applet.mouseY)) {
                    if(Assets.getInstance().getMoney() >= price && !(cell.getTrash() instanceof Trash)) {
                        ((PObject) trash).pos = new PVector(cell.pos.x, cell.pos.y);
                        Assets.getInstance().addMoney(-price);
                        cell.setTrash(trash);
                    }
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

    private void setPosCells(int x, int y) {
        for(int i = 0; i < COLUMNS; i++) {
            for(int j = 0; j < ROWS; j++) {
                cells[i][j].setPos(i * TRASH_SIZE, j * TRASH_SIZE);
            }
        }
    }

    void move(int x, int y) {
        pos.x = -width / 2f;
        pos.y = -height / 2f;
        setPosCells(0, 0);
        moveCells(-width / 2, -height / 2);

        for(int i = 0; i < Math.abs(x); i++) {
            move(x > 0 ? Direction.LEFT : Direction.RIGHT);
        } for(int i = 0; i < Math.abs(y); i++) {
            move(y > 0 ? Direction.UP : Direction.DOWN);
        }
    }

    void move(Direction dir) {
        switch (dir) {
            case UP:
                if(pos.y < -MAP_OFFSET) {
                	pos.y += STEP_SIZE;
                    moveCells(0, STEP_SIZE);
                } break;
            case DOWN:
                if(pos.y > -map.height + HEIGHT + MAP_OFFSET) {
                	pos.y -= STEP_SIZE;
                	moveCells(0, -STEP_SIZE);
                } break;
            case LEFT:
                if(pos.x < -MAP_OFFSET) {
                	pos.x += STEP_SIZE;
                	moveCells(STEP_SIZE, 0);
                } break;
            case RIGHT:
                if(pos.x > -map.width + WIDTH + MAP_OFFSET) {
                	pos.x -= STEP_SIZE;
                	moveCells(-STEP_SIZE, 0);
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
