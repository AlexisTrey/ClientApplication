package co.edu.uptc.dto;

public class GameAreaDto {
    private int width;
    private int height;
    private int heightCourt;

    public GameAreaDto() {
    }

    public GameAreaDto(int width, int height, int heightCourt) {
        this.width = width;
        this.height = height;
        this.heightCourt = heightCourt;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeightCourt() {
        return heightCourt;
    }

    public void setHeightCourt(int h) {
        this.heightCourt = h;
    }
}
