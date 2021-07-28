package com.woodlight.thread;

import com.woodlight.WoodLight;
import com.woodlight.system.OperatingSystem;

public class LightThread extends Thread {
    public synchronized void run() {
        try {
            System.out.println("WoodLight Backup thread running, is closed when program exits.");
        } catch (Exception exception) {
            WoodLight woodLight = new WoodLight();
            if (woodLight.STACK_TRACES) {
                exception.printStackTrace();
            }
            java.util.logging.Logger logger = java.util.logging.Logger.getAnonymousLogger();
            logger.info("\n[WoodLight]: An error has occurred! Rerunning program...");
        }
    }
}
