package trash;

import game.Constants;
import trash.trash.Trash;

public interface ITrash {
    void move(int x, int y);
    void setPos(int x, int y);

    // get upgraded!
    void upgrade();

    // Works on destroying some of the trash
    void workNext(Trash next);

    // Helps units around it
    // e.g. glass cleaner is good at helping cardboard
    void helpAround(ITrash cleaner);

    // Returns how damaged this unit is, destroyed when 0
    int getPercentage();

    // Returns if we are dead
    boolean isDead();

    // update the game.PObject
    void update();

    // render the game.PObject
    void render();

    // Returns a copy of trash
    ITrash copy();

    // Returns the type
    Constants.Type getType();

    double getEffiency();

}
