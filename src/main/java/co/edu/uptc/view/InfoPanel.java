package co.edu.uptc.view;

import co.edu.uptc.components.fonts.AppFonts;
import co.edu.uptc.util.Utilities;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private JLabel lblRole;
    private JLabel lblScore;
    private JLabel lblStatus;

    public InfoPanel() {
        setPreferredSize(new Dimension(
                Utilities.INFO_PANEL_WIDTH,
                Utilities.GAME_PANEL_HEIGHT));
        setBorder(BorderFactory.createTitledBorder("Mi Información"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addPlayerSection();
        addHorizontalSeparator();
        addScoreSection();
        addHorizontalSeparator();
        addStatusSection();
        add(Box.createVerticalGlue());
    }

    private void addPlayerSection() {
        add(buildRow(createLabel("ROL:", AppFonts.BODY_BOLD)));
        lblRole = new JLabel("---");
        lblRole.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblRole.setAlignmentX(CENTER_ALIGNMENT);
        add(lblRole);
    }

    private void addScoreSection() {
        add(buildRow(createLabel("PUNTAJE:", AppFonts.BODY_BOLD)));
        lblScore = new JLabel("0");
        lblScore.setFont(new Font("Segoe UI", Font.BOLD, 52));
        lblScore.setAlignmentX(CENTER_ALIGNMENT);
        add(lblScore);
    }

    private void addStatusSection() {
        add(buildRow(createLabel("Estado:", AppFonts.BODY_BOLD)));
        lblStatus = new JLabel("Conectado");
        lblStatus.setFont(AppFonts.BODY);
        add(buildRow(lblStatus));
    }

    public void updateMyInfo(int score, String role) {
        lblScore.setText(String.valueOf(score));
        if (role != null) {
            lblRole.setText(role);
            lblRole.setForeground(roleColor(role));
        }
    }

    public void setStatus(String message) {
        lblStatus.setText(message);
    }

    private Color roleColor(String role) {
        return "ATTACKER".equals(role)
                ? Utilities.COLOR_ATTACKER
                : Utilities.COLOR_DEFENDER;
    }

    private void addHorizontalSeparator() {
        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setMaximumSize(new Dimension(Utilities.INFO_PANEL_WIDTH - 20, 8));
        add(sep);
        add(Box.createVerticalStrut(6));
    }

    private JPanel buildRow(JComponent component) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 4));
        panel.setOpaque(false);
        panel.setMaximumSize(new Dimension(Utilities.INFO_PANEL_WIDTH, 60));
        panel.add(component);
        return panel;
    }

    private JLabel createLabel(String text, Font font) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(font);
        return lbl;
    }
}