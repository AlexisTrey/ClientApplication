package co.edu.uptc.network.client;

import co.edu.uptc.interfaces.PresenterInterface;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerListener implements Runnable {

    private final BufferedReader reader;
    private final PresenterInterface presenter;

    public ServerListener(BufferedReader reader, PresenterInterface presenter) {
        this.reader    = reader;
        this.presenter = presenter;
    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                presenter.onMessageReceived(line);
            }
        } catch (IOException e) {
            presenter.onDisconnect();
        }
    }
}