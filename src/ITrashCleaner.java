public interface ITrashCleaner {

    enum Type {
        PLASTIC,
        NORMAL,
        GLASS,
        CARDBOARD
    }

    // Works on destroying some of the trash
    void workNext(Trash next);

    // Helps units around it
    // e.g. glass cleaner is good at helping cardboard
    void helpAround(ITrashCleaner cleaner);

    // Returns how damaged this unit is, destroyed when 0
    int getPercentage();

    // update the PObject
    void update();

    // render the PObject
    void render();

}
