package co.edu.uptc.dto;

import java.util.List;

public class GameStateDto {
    private String          type;
    private List<PlayerDto> players;

    public GameStateDto() {}

    public String getType()             { return type; }
    public void setType(String type)    { this.type = type; }
    public List<PlayerDto> getPlayers() { return players; }
    public void setPlayers(List<PlayerDto> players) { this.players = players; }
}
