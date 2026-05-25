package co.edu.uptc.network.client;

import co.edu.uptc.dto.ConnectDto;
import co.edu.uptc.dto.DisconnectDto;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.network.protocol.MessageParser;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Connection {

    private Socket socket;
    private PrintWriter writer;
    private PresenterInterface presenter;
    private String             studentCode;

    public Connection(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    public boolean connect(String host, int port, String studentCode) {
        this.studentCode = studentCode;
        try {
            socket = new Socket(host, port);
            writer = new PrintWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream(), StandardCharsets.UTF_8), true);
            startListener();
            send(MessageParser.toJson(new ConnectDto(studentCode)));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void send(String json) {
        if (writer != null) writer.println(json);
    }

    public void disconnect() {
        send(MessageParser.toJson(new DisconnectDto(studentCode)));
        closeSocket();
    }

    private void startListener() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
        ServerListener listener = new ServerListener(reader, presenter);
        Thread thread = new Thread(listener);
        thread.setDaemon(true);
        thread.start();
    }

    private void closeSocket() {
        try { if (socket != null) socket.close(); }
        catch (IOException ignored) {}
    }
}
