package co.edu.uptc.view;

import co.edu.uptc.components.button.CustomButton;
import co.edu.uptc.components.fonts.AppFonts;
import co.edu.uptc.components.input.CustomInput;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.util.Utilities;

import javax.swing.*;
import java.awt.*;

public class ConnectPanel extends JPanel {

    private PresenterInterface presenter;
    private CustomInput inputHost;
    private CustomInput inputPort;
    private CustomInput inputCode;
    private JLabel lblStatus;
    private CustomButton btnConnect;

    public ConnectPanel() {
        setLayout(new GridBagLayout());
        add(buildCard(), new GridBagConstraints());
    }

    private JPanel buildCard() {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180)),
                BorderFactory.createEmptyBorder(30, 40, 30, 40)));
        card.add(buildTitle());
        card.add(Box.createVerticalStrut(20));
        card.add(buildForm());
        card.add(Box.createVerticalStrut(16));
        card.add(buildButtonRow());
        card.add(Box.createVerticalStrut(10));
        card.add(buildStatusRow());
        return card;
    }

    private JLabel buildTitle() {
        JLabel title = new JLabel("Conectar al Servidor");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setAlignmentX(CENTER_ALIGNMENT);
        return title;
    }

    private JPanel buildForm() {
        JPanel form = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 4));
        inputHost = new CustomInput("IP:", 320, 180);
        inputPort = new CustomInput("Puerto:", 320, 80);
        inputCode = new CustomInput("Código estudiantil:", 320, 180);
        form.add(inputHost);
        form.add(inputPort);
        form.add(inputCode);
        return form;
    }

    private JPanel buildButtonRow() {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnConnect = new CustomButton("Conectar")
                .onClick(e -> handleConnect());
        btnConnect.setPreferredSize(new Dimension(160, 38));
        row.add(btnConnect);
        return row;
    }

    private JPanel buildStatusRow() {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblStatus = new JLabel(" ");
        lblStatus.setFont(AppFonts.BODY);
        row.add(lblStatus);
        return row;
    }

    private void handleConnect() {
        if (!validateFields())
            return;
        btnConnect.setEnabled(false);
        lblStatus.setForeground(new Color(0, 120, 0));
        lblStatus.setText("Conectando...");
        String host = parseHost();
        int port = parsePort();
        String code = inputCode.getValue();
        presenter.onConnect(host, port, code);
    }

    private boolean validateFields() {
        boolean ok = true;
        if (inputCode.getValue().isBlank()) {
            inputCode.showError("Campo requerido");
            ok = false;
        } else {
            inputCode.clearError();
        }
        return ok;
    }

    private String parseHost() {
        String val = inputHost.getValue();
        return val.isBlank() ? "127.0.0.1" : val;
    }

    private int parsePort() {
        try {
            String val = inputPort.getValue();
            return val.isBlank() ? Utilities.DEFAULT_PORT
                    : Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return Utilities.DEFAULT_PORT;
        }
    }

    public void showError(String message) {
        btnConnect.setEnabled(true);
        lblStatus.setForeground(Color.RED);
        lblStatus.setText(message);
    }

    public void showSuccess(String message) {
        btnConnect.setEnabled(false);
        lblStatus.setForeground(new Color(0, 120, 0));
        lblStatus.setText(message);
    }

    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }
}