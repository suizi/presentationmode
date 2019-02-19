package at.suizi.tools.presentationmode.logic.listener;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import at.suizi.tools.presentationmode.logic.TimeState;

public class GlobalKeyListener implements NativeKeyListener {

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        TimeState.lastInteraction = System.currentTimeMillis();
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {}

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {}
}
