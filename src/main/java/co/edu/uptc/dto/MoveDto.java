package co.edu.uptc.dto;

public class MoveDto {
    private String type;
    private String studentCode;
    private String movement;

    public MoveDto() {
    }

    public MoveDto(String studentCode, String movement) {
        this.type = "MOVE";
        this.studentCode = studentCode;
        this.movement = movement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String s) {
        this.studentCode = s;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String m) {
        this.movement = m;
    }
}
