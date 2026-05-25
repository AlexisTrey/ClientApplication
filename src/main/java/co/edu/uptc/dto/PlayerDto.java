package co.edu.uptc.dto;

public class PlayerDto {
    private String code;
    private String role;
    private int    x;
    private int    y;

    public PlayerDto() {
    }

    public PlayerDto(String code, String role, int x, int y) {
        this.code = code;
        this.role = role;
        this.x = x;
        this.y = y;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
