package co.edu.uptc.network.protocol;

import co.edu.uptc.pojo.GameOverReason;

public class Protocol {

    public static final String CONNECT      = "CONNECT";
    public static final String CONNECT_ACK  = "CONNECT_ACK";
    public static final String GAME_START   = "GAME_START";
    public static final String ROLE_ASSIGN  = "ROLE_ASSIGN";
    public static final String MOVE         = "MOVE";
    public static final String GAME_STATE   = "GAME_STATE";
    public static final String BLOCK        = "BLOCK";
    public static final String SCORE_UPDATE = "SCORE_UPDATE";
    public static final String ROLE_CHANGE  = "ROLE_CHANGE";
    public static final String PLAYER_DONE  = "PLAYER_DONE";
    public static final String GAME_END     = "GAME_END";
    public static final String DISCONNECT   = "DISCONNECT";

    public static final String REASON_SERVER_DECISION = GameOverReason.SERVER_DECISION.name();
    public static final String REASON_ALL_DONE        = GameOverReason.ALL_DONE.name();

    public static final String COURT_SIDE_LEFT  = "LEFT";
    public static final String COURT_SIDE_RIGHT = "RIGHT";

    private Protocol() {}
}
