package trash.clean;

import trash.trash.Trash;

public interface ITrashCleaner {

    enum Type {
        PLASTIC,
        NORMAL,
        GLASS,
        CARDBOARD
    }

    void move(int x, int y);

    // Works on destroying some of the trash
    void workNext(Trash next);

    // Helps units around it
    // e.g. glass cleaner is good at helping cardboard
    void helpAround(ITrashCleaner cleaner);

    // Returns how damaged this unit is, destroyed when 0
    int getPercentage();

    // update the game.PObject
    void update();

    // render the game.PObject
    void render();

}
