package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Movement;

public interface PresenterInterface {

    void setModel(ModelInterface model);
    void setView(ViewInterface view);
    void onConnect(String host, int port, String studentCode);
    void onDisconnect();
    void onMove(Movement movement);
    void onMessageReceived(String json);
    void onLeaveGame();
    void refreshView();

}
