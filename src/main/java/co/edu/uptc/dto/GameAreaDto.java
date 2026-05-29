package co.edu.uptc.dto;

public class GameAreaDto {
    private int width;
    private int height;

    public GameAreaDto() {}
    public GameAreaDto(int width, int height) { this.width = width; this.height = height; }

    public int getWidth()  { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}
