package co.edu.uptc.util;

import java.awt.*;

public class Utilities {
    public static final int CELL_SIZE          = 40;
    public static final int GRID_COLS          = 25;
    public static final int GRID_ROWS          = 15;
    public static final int GAME_PANEL_WIDTH   = GRID_COLS * CELL_SIZE;
    public static final int GAME_PANEL_HEIGHT  = GRID_ROWS * CELL_SIZE;
    public static final int INFO_PANEL_WIDTH   = 240;
    public static final int FRAME_WIDTH        = GAME_PANEL_WIDTH + INFO_PANEL_WIDTH + 16;
    public static final int FRAME_HEIGHT       = GAME_PANEL_HEIGHT + 62;

    public static final int COURT_COL_START    = 0;
    public static final int COURT_COL_END      = 1;
    public static final int COURT_ROW_START    = 5;
    public static final int COURT_ROW_END      = 9;

    public static final int ATK_SPAWN_COL_START = 23;
    public static final int ATK_SPAWN_COL_END   = 24;
    public static final int DEF_SPAWN_COL       = 2;

    public static final int DEFAULT_PORT        = 8080;
    public static final int DEFAULT_SPEED_MS    = 500;
    public static final int MAX_SCORE           = 10;
    public static final int ROLE_CHANGE_COUNT   = 3;

    public static final Color COLOR_ATTACKER        = new Color(0, 160, 0);
    public static final Color COLOR_DEFENDER        = new Color(200, 0, 0);
    public static final Color COLOR_COURT           = new Color(30, 90, 220, 200);
    public static final Color COLOR_ATK_ZONE        = new Color(0, 180, 0, 45);
    public static final Color COLOR_DEF_ZONE        = new Color(200, 0, 0, 45);
    public static final Color COLOR_PROTECTED_ZONE  = new Color(220, 180, 0, 45);
    public static final Color COLOR_GRID            = new Color(200, 200, 200);

    private Utilities() {}
}
