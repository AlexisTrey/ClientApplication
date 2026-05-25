package co.edu.uptc.dto;

public class DisconnectDto {
    private String type;
    private String studentCode;

    public DisconnectDto() {}
    public DisconnectDto(String studentCode) {
        this.type        = "DISCONNECT";
        this.studentCode = studentCode;
    }

    public String getType()         { return type; }
    public void setType(String type) { this.type = type; }
    public String getStudentCode()  { return studentCode; }
    public void setStudentCode(String c) { this.studentCode = c; }
}
