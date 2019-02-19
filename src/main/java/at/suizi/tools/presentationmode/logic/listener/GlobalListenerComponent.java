package at.suizi.tools.presentationmode.logic.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class GlobalListenerComponent {

    private GlobalKeyListener keyListener;
    private GlobalMouseListener mouseListener;

    public GlobalListenerComponent() {
        keyListener = new GlobalKeyListener();
        mouseListener = new GlobalMouseListener();

        // deactivate console log spamming
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);
    }

    public void start() throws NativeHookException {
        GlobalScreen.registerNativeHook();

        GlobalScreen.addNativeKeyListener(keyListener);
        GlobalScreen.addNativeMouseListener(mouseListener);
    }

    public void stop() throws NativeHookException {
        GlobalScreen.unregisterNativeHook();
    }
}
