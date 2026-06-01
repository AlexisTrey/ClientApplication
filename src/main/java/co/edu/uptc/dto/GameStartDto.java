package co.edu.uptc.dto;

public class GameStartDto {
    private String type;
    private int speed;
    private GameAreaDto gameArea;

    public GameStartDto() {
    }

    public GameStartDto(int speed, GameAreaDto gameArea) {
        this.type = "GAME_START";
        this.speed = speed;
        this.gameArea = gameArea;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public GameAreaDto getGameArea() {
        return gameArea;
    }

    public void setGameArea(GameAreaDto g) {
        this.gameArea = g;
    }
}
