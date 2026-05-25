package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.pojo.Direction;

public class ClientPresenter implements PresenterInterface {
    @Override
    public void setModel(ModelInterface model) {

    }

    @Override
    public void setView(ViewInterface view) {

    }

    @Override
    public void onConnect(String host, int port, String studentCode) {

    }

    @Override
    public void onDisconnect() {

    }

    @Override
    public void onMove(Direction direction) {

    }

    @Override
    public void onMessageReceived(String json) {

    }

    @Override
    public void refreshView() {

    }
}
