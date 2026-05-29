package co.edu.uptc.dto;

public class MoveDto {
    private String type;
    private String studentCode;
    private String direction;

    public MoveDto() {}
    public MoveDto(String studentCode, String direction) {
        this.type        = "MOVE";
        this.studentCode = studentCode;
        this.direction   = direction;
    }

    public String getType()         { return type; }
    public void setType(String type) { this.type = type; }
    public String getStudentCode()  { return studentCode; }
    public void setStudentCode(String c) { this.studentCode = c; }
    public String getDirection()    { return direction; }
    public void setDirection(String direction) { this.direction = direction; }
}
