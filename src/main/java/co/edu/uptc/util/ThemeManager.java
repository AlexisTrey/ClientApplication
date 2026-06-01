package co.edu.uptc.util;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class ThemeManager {

    public static final String LIGHT = "light";
    public static final String DARK = "dark";

    private ThemeManager() {
    }

    public static void applyByKey(String key) {
        try {
            if (DARK.equals(key))
                UIManager.setLookAndFeel(new FlatDarkLaf());
            else
                UIManager.setLookAndFeel(new FlatLightLaf());
            com.formdev.flatlaf.FlatLaf.updateUI();
        } catch (Exception e) {
            System.err.println("Error applying theme: " + e.getMessage());
        }
    }

}
