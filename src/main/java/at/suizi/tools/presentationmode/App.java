package at.suizi.tools.presentationmode;

import java.io.IOException;

import javax.swing.SwingUtilities;

import at.suizi.tools.presentationmode.ui.PresenterGui;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new PresenterGui();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
