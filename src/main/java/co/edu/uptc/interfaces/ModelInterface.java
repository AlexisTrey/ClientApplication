package co.edu.uptc.interfaces;

import co.edu.uptc.dto.PlayerDto;

import java.util.List;

public interface ModelInterface {

    void updateGameState(List<PlayerDto> players);
    void setMyRole(String role, int col, int row);
    void setMyScore(int score);
    List<PlayerDto> getPlayers();
    String getMyRole();
    int getMyScore();
    boolean isGameStarted();
    void setGameStarted(boolean started);
    String getMyCode();
    void setMyCode(String code);
    void setGameStatus(String status);
    String getGameStatus();

}
