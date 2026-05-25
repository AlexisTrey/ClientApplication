package co.edu.uptc.model;

import co.edu.uptc.dto.PlayerDto;
import co.edu.uptc.interfaces.ModelInterface;

import java.util.List;

public class ClientModel implements ModelInterface {
    @Override
    public void updateGameState(List<PlayerDto> players) {

    }

    @Override
    public void setMyRole(String role, int col, int row) {

    }

    @Override
    public void setMyScore(int score) {

    }

    @Override
    public List<PlayerDto> getPlayers() {
        return List.of();
    }

    @Override
    public String getMyRole() {
        return "";
    }

    @Override
    public int getMyScore() {
        return 0;
    }

    @Override
    public boolean isGameStarted() {
        return false;
    }

    @Override
    public void setGameStarted(boolean started) {

    }

    @Override
    public String getMyCode() {
        return "";
    }

    @Override
    public void setMyCode(String code) {

    }
}
