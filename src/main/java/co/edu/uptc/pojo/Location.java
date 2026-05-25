package co.edu.uptc.pojo;

public class Location {

    private int col;
    private int row;

    public Location() {}

    public Location(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() { return col; }
    public void setCol(int col) { this.col = col; }
    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Location other)) return false;
        return col == other.col && row == other.row;
    }

    @Override
    public int hashCode() {
        return 31 * col + row;
    }
}
