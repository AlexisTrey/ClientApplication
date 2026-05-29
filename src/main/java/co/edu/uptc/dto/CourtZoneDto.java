package co.edu.uptc.dto;

public class CourtZoneDto {
    private int col;
    private int row;
    private int width;
    private int height;

    public CourtZoneDto() {}
    public CourtZoneDto(int col, int row, int width, int height) {
        this.col = col; this.row = row; this.width = width; this.height = height;
    }

    public int getCol()    { return col; }
    public void setCol(int col) { this.col = col; }
    public int getRow()    { return row; }
    public void setRow(int row) { this.row = row; }
    public int getWidth()  { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}
