package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Direction;

public interface PresenterInterface {

    void setModel(ModelInterface model);
    void setView(ViewInterface view);
    void onConnect(String host, int port, String studentCode);
    void onDisconnect();
    void onMove(Direction direction);
    void onMessageReceived(String json);
    void refreshView();

}
