package co.edu.uptc.pojo;

public class Player {
    private String studentCode;
    private int shortId;
    private Location location;
    private Role role;
    private int score;
    private int progressCount;

    public Player() {
    }

    public Player(String studentCode, int shortId) {
        this.studentCode = studentCode;
        this.shortId = shortId;
        this.score = 0;
        this.progressCount = 0;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public int getShortId() {
        return shortId;
    }

    public void setShortId(int shortId) {
        this.shortId = shortId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getProgressCount() {
        return progressCount;
    }

    public void setProgressCount(int progressCount) {
        this.progressCount = progressCount;
    }
}
