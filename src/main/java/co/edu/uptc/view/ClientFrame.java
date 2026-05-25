package co.edu.uptc.view;

import co.edu.uptc.dto.PlayerDto;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.pojo.Direction;
import co.edu.uptc.util.ThemeManager;
import co.edu.uptc.util.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ClientFrame extends JFrame implements ViewInterface {

    private static final String CARD_CONNECT = "CONNECT";
    private static final String CARD_GAME = "GAME";

    private static ClientFrame instance;
    private PresenterInterface presenter;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private ConnectPanel connectPanel;
    private GamePanel gamePanel;
    private InfoPanel infoPanel;
    private boolean gameActive;

    private ClientFrame() {
        initFrame();
        addComponents();
        registerGlobalKeyDispatcher();
    }

    public static ClientFrame getInstance() {
        if (instance == null) instance = new ClientFrame();
        return instance;
    }

    private void initFrame() {
        setTitle("Combat Game — Cliente");
        setSize(Utilities.FRAME_WIDTH, Utilities.FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
    }

    private void addComponents() {
        addMenuBar();
        buildCardPanel();
        add(cardPanel, BorderLayout.CENTER);
    }

    private void buildCardPanel() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        connectPanel = new ConnectPanel();
        cardPanel.add(connectPanel, CARD_CONNECT);
        cardPanel.add(buildGameCard(), CARD_GAME);
    }

    private JPanel buildGameCard() {
        JPanel gameCard = new JPanel(new BorderLayout());
        gamePanel = new GamePanel();
        infoPanel = new InfoPanel();
        gameCard.add(gamePanel, BorderLayout.CENTER);
        gameCard.add(infoPanel, BorderLayout.EAST);
        return gameCard;
    }

    private void registerGlobalKeyDispatcher() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(e -> {
                    if (gameActive && e.getID() == KeyEvent.KEY_PRESSED)
                        handleKeyPress(e.getKeyCode());
                    return false;
                });
    }

    private void handleKeyPress(int keyCode) {
        if (presenter == null) return;
        switch (keyCode) {
            case KeyEvent.VK_UP -> presenter.onMove(Direction.UP);
            case KeyEvent.VK_DOWN -> presenter.onMove(Direction.DOWN);
            case KeyEvent.VK_LEFT -> presenter.onMove(Direction.LEFT);
            case KeyEvent.VK_RIGHT -> presenter.onMove(Direction.RIGHT);
        }
    }

    private void addMenuBar() {
        JMenuBar bar = new JMenuBar();
        bar.add(buildThemeMenu());
        setJMenuBar(bar);
    }

    private JMenu buildThemeMenu() {
        JMenu menu = new JMenu("Tema");
        JMenuItem light = new JMenuItem("Claro");
        JMenuItem dark = new JMenuItem("Oscuro");
        light.addActionListener(e -> ThemeManager.applyByKey(ThemeManager.LIGHT));
        dark.addActionListener(e -> ThemeManager.applyByKey(ThemeManager.DARK));
        menu.add(light);
        menu.add(dark);
        return menu;
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
        connectPanel.setPresenter(presenter);
    }

    @Override
    public void start() {
        cardLayout.show(cardPanel, CARD_CONNECT);
        setVisible(true);
    }

    @Override
    public void refresh() {
        gamePanel.repaint();
    }

    @Override
    public void showGameView() {
        gameActive = true;
        cardLayout.show(cardPanel, CARD_GAME);
    }

    @Override
    public void showConnectError(String message) {
        connectPanel.showError(message);
    }

    @Override
    public void showConnectSuccess(String message) {
        connectPanel.showSuccess(message);
    }

    @Override
    public void updateGameState(List<PlayerDto> players) {
        gamePanel.updatePlayers(players);
    }

    @Override
    public void updateMyInfo(int score, String role) {
        infoPanel.updateMyInfo(score, role);
    }
}