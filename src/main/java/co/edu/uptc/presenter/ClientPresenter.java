package co.edu.uptc.presenter;

import co.edu.uptc.dto.*;
import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.network.client.Connection;
import co.edu.uptc.network.protocol.MessageParser;
import co.edu.uptc.network.protocol.Protocol;
import co.edu.uptc.pojo.Direction;

import javax.swing.*;

public class ClientPresenter implements PresenterInterface {
    private ModelInterface model;
    private ViewInterface  view;
    private Connection connection;
    private String         studentCode;

    @Override public void setModel(ModelInterface model) { this.model = model; }
    @Override public void setView(ViewInterface view)    { this.view  = view;  }

    @Override
    public void onConnect(String host, int port, String studentCode) {
        this.studentCode = studentCode;
        this.connection  = new Connection(this);
        boolean ok = connection.connect(host, port, studentCode);
        if (!ok) {
            view.showConnectError("No se pudo conectar a " + host + ":" + port);
        }
    }

    @Override
    public void onDisconnect() {
        if (connection != null) connection.disconnect();
        SwingUtilities.invokeLater(() ->
                view.showConnectError("Conexión perdida con el servidor"));
    }

    @Override
    public void onMove(Direction direction) {
        if (connection == null || !model.isGameStarted()) return;
        String json = MessageParser.toJson(
                new MoveDto(studentCode, direction.name()));
        connection.send(json);
    }

    @Override
    public void onMessageReceived(String json) {
        String type = MessageParser.getType(json);
        switch (type) {
            case Protocol.CONNECT_ACK  -> handleConnectAck(json);
            case Protocol.GAME_START   -> handleGameStart(json);
            case Protocol.ROLE_ASSIGN  -> handleRoleAssign(json);
            case Protocol.GAME_STATE   -> handleGameState(json);
            case Protocol.SCORE_UPDATE -> handleScoreUpdate(json);
            case Protocol.ROLE_CHANGE  -> handleRoleChange(json);
            case Protocol.GAME_END     -> handleGameEnd();
        }
    }

    @Override
    public void refreshView() {
        SwingUtilities.invokeLater(() -> {
            view.updateGameState(model.getPlayers());
            view.updateMyInfo(model.getMyScore(), model.getMyRole());
            view.refresh();
        });
    }

    private void handleConnectAck(String json) {
        ConnectAckDto dto = MessageParser.fromJson(json, ConnectAckDto.class);
        SwingUtilities.invokeLater(() -> {
            if (dto.isAccepted()) {
                model.setMyCode(studentCode);
                view.showConnectSuccess("Conectado. Esperando inicio de partida...");
            } else {
                view.showConnectError("Rechazado: " + dto.getMessage());
            }
        });
    }

    private void handleGameStart(String json) {
        model.setGameStarted(true);
        SwingUtilities.invokeLater(() -> view.showGameView());
    }

    private void handleRoleAssign(String json) {
        RoleAssignDto dto = MessageParser.fromJson(json, RoleAssignDto.class);
        model.setMyRole(dto.getRole(),
                dto.getPosition().getX(), dto.getPosition().getY());
        refreshView();
    }

    private void handleGameState(String json) {
        GameStateDto dto = MessageParser.fromJson(json, GameStateDto.class);
        model.updateGameState(dto.getPlayers());
        refreshView();
    }

    private void handleScoreUpdate(String json) {
        ScoreUpdateDto dto = MessageParser.fromJson(json, ScoreUpdateDto.class);
        if (studentCode.equals(dto.getStudentCode())) {
            model.setMyScore(dto.getScore());
            model.setMyRole(dto.getRole(), 0, 0);
            refreshView();
        }
    }

    private void handleRoleChange(String json) {
        RoleChangeDto dto = MessageParser.fromJson(json, RoleChangeDto.class);
        if (studentCode.equals(dto.getStudentCode())) {
            model.setMyRole(dto.getNewRole(),
                    dto.getNewPosition().getX(), dto.getNewPosition().getY());
            refreshView();
        }
    }

    private void handleGameEnd() {
        model.setGameStarted(false);
        refreshView();
    }
}
