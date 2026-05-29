package co.edu.uptc.model;

import co.edu.uptc.dto.PlayerDto;
import co.edu.uptc.interfaces.ModelInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientModel implements ModelInterface {
    private final List<PlayerDto> players =
            Collections.synchronizedList(new ArrayList<>());
    private String  myCode;
    private String  myRole;
    private int     myScore;
    private boolean gameStarted;

    @Override
    public void updateGameState(List<PlayerDto> incoming) {
        synchronized (players) {
            players.clear();
            players.addAll(incoming);
        }
    }

    @Override
    public void setMyRole(String role, int col, int row) {
        this.myRole = role;
    }

    @Override
    public void setMyScore(int score) {
        this.myScore = score;
    }

    @Override
    public List<PlayerDto> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public String getMyRole() { return myRole; }

    @Override
    public int getMyScore()   { return myScore; }

    @Override
    public boolean isGameStarted() { return gameStarted; }

    @Override
    public void setGameStarted(boolean started) { this.gameStarted = started; }

    @Override
    public String getMyCode() { return myCode; }

    @Override
    public void setMyCode(String code) { this.myCode = code; }
}
