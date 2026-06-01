package co.edu.uptc.interfaces;

import co.edu.uptc.dto.PlayerDto;

import java.util.List;

public interface ViewInterface {

    void setPresenter(PresenterInterface presenter);
    void start();
    void refresh();
    void showGameView();
    void showConnectError(String message);
    void showConnectSuccess(String message);
    void updateGameState(List<PlayerDto> players);
    void updateMyInfo(int score, String role);
    void setGameStatus(String status);
    void showLeaveButton();

}
