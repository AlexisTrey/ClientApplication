package co.edu.uptc.view;

import co.edu.uptc.dto.PlayerDto;
import co.edu.uptc.util.Utilities;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {

    private List<PlayerDto> players = new ArrayList<>();

    public GamePanel() {
        setPreferredSize(new Dimension(
                Utilities.GAME_PANEL_WIDTH,
                Utilities.GAME_PANEL_HEIGHT));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        setFocusable(true);
    }

    public void updatePlayers(List<PlayerDto> players) {
        synchronized (this) {
            this.players = new ArrayList<>(players);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        drawZones(g2);
        drawCourt(g2);
        drawGrid(g2);
        drawPlayers(g2);
    }

    private void drawZones(Graphics2D g) {
        drawAttackerSpawnZone(g);
        drawDefenderSpawnZone(g);
        drawProtectedZones(g);
    }

    private void drawAttackerSpawnZone(Graphics2D g) {
        g.setColor(Utilities.COLOR_ATK_ZONE);
        int x = Utilities.ATK_SPAWN_COL_START * Utilities.CELL_SIZE;
        int w = (Utilities.ATK_SPAWN_COL_END - Utilities.ATK_SPAWN_COL_START + 1)
                * Utilities.CELL_SIZE;
        g.fillRect(x, 0, w, Utilities.GAME_PANEL_HEIGHT);
    }

    private void drawDefenderSpawnZone(Graphics2D g) {
        g.setColor(Utilities.COLOR_DEF_ZONE);
        int x = Utilities.DEF_SPAWN_COL * Utilities.CELL_SIZE;
        g.fillRect(x, 0, Utilities.CELL_SIZE, Utilities.GAME_PANEL_HEIGHT);
    }

    private void drawProtectedZones(Graphics2D g) {
        g.setColor(Utilities.COLOR_PROTECTED_ZONE);
        int x      = Utilities.COURT_COL_START * Utilities.CELL_SIZE;
        int w      = (Utilities.COURT_COL_END - Utilities.COURT_COL_START + 1)
                * Utilities.CELL_SIZE;
        int aboveH = Utilities.COURT_ROW_START * Utilities.CELL_SIZE;
        g.fillRect(x, 0, w, aboveH);
        int belowY = (Utilities.COURT_ROW_END + 1) * Utilities.CELL_SIZE;
        int belowH = Utilities.GAME_PANEL_HEIGHT - belowY;
        g.fillRect(x, belowY, w, belowH);
    }

    private void drawCourt(Graphics2D g) {
        int x = Utilities.COURT_COL_START * Utilities.CELL_SIZE;
        int y = Utilities.COURT_ROW_START  * Utilities.CELL_SIZE;
        int w = (Utilities.COURT_COL_END - Utilities.COURT_COL_START + 1)
                * Utilities.CELL_SIZE;
        int h = (Utilities.COURT_ROW_END - Utilities.COURT_ROW_START + 1)
                * Utilities.CELL_SIZE;
        g.setColor(Utilities.COLOR_COURT);
        g.fillRect(x, y, w, h);
        g.setColor(new Color(20, 60, 180));
        g.drawRect(x, y, w, h);
        drawCourtLabel(g, x, y, w, h);
    }

    private void drawCourtLabel(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI", Font.BOLD, 12));
        FontMetrics fm   = g.getFontMetrics();
        String      text = "GOAL";
        g.drawString(text, x + (w - fm.stringWidth(text)) / 2,
                y + (h + fm.getAscent()) / 2 - 4);
    }

    private void drawGrid(Graphics2D g) {
        g.setColor(Utilities.COLOR_GRID);
        for (int col = 0; col <= Utilities.GRID_COLS; col++) {
            int xLine = col * Utilities.CELL_SIZE;
            g.drawLine(xLine, 0, xLine, Utilities.GAME_PANEL_HEIGHT);
        }
        for (int row = 0; row <= Utilities.GRID_ROWS; row++) {
            int yLine = row * Utilities.CELL_SIZE;
            g.drawLine(0, yLine, Utilities.GAME_PANEL_WIDTH, yLine);
        }
    }

    private void drawPlayers(Graphics2D g) {
        synchronized (this) {
            for (PlayerDto p : players) drawPlayer(g, p);
        }
    }

    private void drawPlayer(Graphics2D g, PlayerDto p) {
        boolean isAttacker = "ATTACKER".equals(p.getRole());
        Color   color      = isAttacker
                ? Utilities.COLOR_ATTACKER
                : Utilities.COLOR_DEFENDER;
        int px   = p.getX() * Utilities.CELL_SIZE + 2;
        int py   = p.getY() * Utilities.CELL_SIZE + 2;
        int size = Utilities.CELL_SIZE - 4;
        g.setColor(color);
        g.fillRoundRect(px, py, size, size, 8, 8);
        g.setColor(color.darker());
        g.drawRoundRect(px, py, size, size, 8, 8);
        drawPlayerLabel(g, p.getCode(), px, py, size);
    }

    private void drawPlayerLabel(Graphics2D g, String code, int px, int py, int size) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI", Font.BOLD, 10));
        FontMetrics fm    = g.getFontMetrics();
        String      label = "P" + code;
        int         lx    = px + (size - fm.stringWidth(label)) / 2;
        int         ly    = py + (size + fm.getAscent()) / 2 - 2;
        g.drawString(label, lx, ly);
    }
}
