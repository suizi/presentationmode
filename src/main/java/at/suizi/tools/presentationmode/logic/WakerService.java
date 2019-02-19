package at.suizi.tools.presentationmode.logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jnativehook.NativeHookException;

import at.suizi.tools.presentationmode.logic.listener.GlobalListenerComponent;

public class WakerService {

    private ScheduledExecutorService service = null;
    private GlobalListenerComponent globalListener = null;

    public WakerService() {
        globalListener = new GlobalListenerComponent();
    }

    public void stayAwake() {
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            globalListener.start();
            service.scheduleAtFixedRate(new WakerThread(), 60, 60, TimeUnit.SECONDS);
            System.out.println("Activated!");
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            if (globalListener != null) {
                globalListener.stop();
            }
            if (service != null) {
                service.shutdownNow();
                System.out.println("Disabled!");
            }
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }
}
