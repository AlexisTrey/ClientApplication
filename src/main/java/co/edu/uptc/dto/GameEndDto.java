package co.edu.uptc.dto;

public class GameEndDto {
    private String type;
    private String reason;

    public GameEndDto() {
    }

    public GameEndDto(String reason) {
        this.type = "GAME_END";
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
