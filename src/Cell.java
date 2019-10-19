public class Cell {

    private ITrashCleaner trash;

    public Cell(ITrashCleaner trash) {
        this.trash = trash;
    }

    public Cell() {
        this.trash = null;
    }

    public void setTrash(ITrashCleaner trash) {
        this.trash = trash;
    }

    public ITrashCleaner getTrash() {
        return trash;
    }
}
