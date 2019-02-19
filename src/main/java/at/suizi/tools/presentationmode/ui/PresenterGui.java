package at.suizi.tools.presentationmode.ui;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.IOException;

import javax.imageio.ImageIO;

import at.suizi.tools.presentationmode.logic.WakerService;

public class PresenterGui {

    private static final String PROGRAM_NAME = "Presentation-Mode";
    private static final String STATUS_ENABLED = ": active";
    private static final String STATUS_DISABLED = ": idle";

    private WakerService service;

    private Image idle;
    private Image on;
    private TrayIcon trayIcon;

    public PresenterGui() throws IOException {

        service = new WakerService();

        final PopupMenu popup = new PopupMenu();
        idle = ImageIO.read(this.getClass().getClassLoader().getResource("at/hsol/tools/presentationmode/ui/icon-idle.png"));
        on = ImageIO.read(this.getClass().getClassLoader().getResource("at/hsol/tools/presentationmode/ui/icon-on.png"));
        trayIcon = new TrayIcon(idle);

        final SystemTray tray = SystemTray.getSystemTray();

        CheckboxMenuItem cb1 = new CheckboxMenuItem("Activate presentation-mode");
        cb1.addItemListener(e -> {
            if (e.getStateChange() == 1) {
                trayIcon.setImage(on);
                trayIcon.setToolTip(PROGRAM_NAME + STATUS_ENABLED);
                service.stayAwake();
            } else {
                trayIcon.setImage(idle);
                trayIcon.setToolTip(PROGRAM_NAME + STATUS_DISABLED);
                service.stop();
            }
        });
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(e -> {
            service.stop();
            tray.remove(trayIcon);
        });

        popup.add(cb1);
        popup.addSeparator();
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);
        trayIcon.setToolTip(PROGRAM_NAME + STATUS_DISABLED);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }

}
