package co.edu.uptc.dto;

import java.util.List;

public class GameStateDto {
    private String type;
    private List<PlayerDto> playersList;

    public GameStateDto() {
    }

    public GameStateDto(List<PlayerDto> playersList) {
        this.type = "GAME_STATE";
        this.playersList = playersList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PlayerDto> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<PlayerDto> l) {
        this.playersList = l;
    }
}
