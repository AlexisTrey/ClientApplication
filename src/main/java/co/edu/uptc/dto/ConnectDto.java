package co.edu.uptc.dto;

public class ConnectDto {

    private String type;
    private String studentCode;

    public ConnectDto() {}
    public ConnectDto(String studentCode) {
        this.type        = "CONNECT";
        this.studentCode = studentCode;
    }

    public String getType()        { return type; }
    public void setType(String type) { this.type = type; }
    public String getStudentCode() { return studentCode; }
    public void setStudentCode(String c) { this.studentCode = c; }

}
