package co.edu.uptc;

import co.edu.uptc.presenter.Runner;
import co.edu.uptc.util.ThemeManager;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThemeManager.applyByKey(ThemeManager.LIGHT);
            new Runner().start();
        });
    }

}
