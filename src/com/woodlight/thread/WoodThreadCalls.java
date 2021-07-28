package com.woodlight.thread;

import com.woodlight.system.OperatingSystem;

public class WoodThreadCalls {

    public WoodThreadCalls() {

        LightThread lightThread = new LightThread();
        lightThread.start();

        // error handles

        if (!lightThread.isAlive()) {
            System.out.println("[WoodLight (Critical)]: LightThread has been killed! Ignore this if the program is closing. Otherwise this might be a critical error!\n");
            OperatingSystem osSys = new OperatingSystem();
            osSys.sysInfo();
        }

        if (!lightThread.isInterrupted()) {
            System.out.println("[WoodLight (Critical)]: LightThread has been interrupted! Ignore this if the program still works.");
        }
    }
}
