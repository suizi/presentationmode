package at.suizi.tools.presentationmode.logic;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class WakerThread implements Runnable {

    private Robot r = null;

    public WakerThread() {
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public void run() {
        if (System.currentTimeMillis() - TimeState.lastInteraction > 60000) {
            Point l = MouseInfo.getPointerInfo().getLocation();
            r.mouseMove(l.x, l.y);
        }
    }
}
