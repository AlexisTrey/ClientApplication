package co.edu.uptc.dto;

public class ConnectAckDto {
    private String  type;
    private boolean accepted;
    private String  message;
    private String  gameStatus;

    public ConnectAckDto() {}
    public ConnectAckDto(boolean accepted, String message) {
        this.type     = "CONNECT_ACK";
        this.accepted = accepted;
        this.message  = message;
    }
    public ConnectAckDto(boolean accepted, String message, String gameStatus) {
        this.type       = "CONNECT_ACK";
        this.accepted   = accepted;
        this.message    = message;
        this.gameStatus = gameStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
}
