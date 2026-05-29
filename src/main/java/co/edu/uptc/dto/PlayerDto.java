package co.edu.uptc.dto;

public class PlayerDto {
    private String studentCode;
    private String role;
    private int x;
    private int y;

    public PlayerDto() {}

    public PlayerDto(String studentCode,
                     String role,
                     int x,
                     int y) {

        this.studentCode = studentCode;
        this.role = role;
        this.x = x;
        this.y = y;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
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
