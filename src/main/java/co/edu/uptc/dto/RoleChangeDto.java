package co.edu.uptc.dto;

public class RoleChangeDto {
    private String type;
    private String studentCode;
    private String newRole;
    private PositionDto newPosition;

    public RoleChangeDto() {
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

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getNewRole() {
        return newRole;
    }

    public void setNewRole(String newRole) {
        this.newRole = newRole;
    }

    public PositionDto getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(PositionDto newPosition) {
        this.newPosition = newPosition;
    }
}
