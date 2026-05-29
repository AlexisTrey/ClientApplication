package co.edu.uptc.dto;

public class ConnectAckDto {
    private String  type;
    private boolean accepted;
    private String  message;

    public ConnectAckDto() {}

    public String getType()      { return type; }
    public void setType(String type) { this.type = type; }
    public boolean isAccepted()  { return accepted; }
    public void setAccepted(boolean accepted) { this.accepted = accepted; }
    public String getMessage()   { return message; }
    public void setMessage(String message) { this.message = message; }
}
