package at.suizi.tools.presentationmode.logic.listener;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import at.suizi.tools.presentationmode.logic.TimeState;

public class GlobalMouseListener implements NativeMouseInputListener {

    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {
        TimeState.lastInteraction = System.currentTimeMillis();
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent e) {
        TimeState.lastInteraction = System.currentTimeMillis();
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {}

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {}

    @Override
    public void nativeMouseDragged(NativeMouseEvent e) {}
}
