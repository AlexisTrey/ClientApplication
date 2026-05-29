package co.edu.uptc.dto;

public class RoleAssignDto {
    private String      type;
    private String      role;
    private PositionDto position;

    public RoleAssignDto() {}

    public String getType()      { return type; }
    public void setType(String type) { this.type = type; }
    public String getRole()      { return role; }
    public void setRole(String role) { this.role = role; }
    public PositionDto getPosition()  { return position; }
    public void setPosition(PositionDto position) { this.position = position; }
}
