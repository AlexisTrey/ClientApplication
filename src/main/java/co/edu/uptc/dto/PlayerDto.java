package co.edu.uptc.dto;

public class PlayerDto {
    private String studentCode;
    private String role;
    private PositionDto location;
    private int score;

    public PlayerDto() {
    }

    public PlayerDto(String studentCode, String role, int x, int y, int score) {
        this.studentCode = studentCode;
        this.role = role;
        this.location = new PositionDto(x, y);
        this.score = score;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String s) {
        this.studentCode = s;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String r) {
        this.role = r;
    }

    public PositionDto getLocation() {
        return location;
    }

    public void setLocation(PositionDto l) {
        this.location = l;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int s) {
        this.score = s;
    }

    public int getX() {
        return location != null ? location.getX() : 0;
    }

    public int getY() {
        return location != null ? location.getY() : 0;
    }
}
