package com.woodlight.thread;

import com.woodlight.Color;
import com.woodlight.WoodLight;

public class LightThreadBackup extends Thread {
    public synchronized void run() {
        try {
            System.out.println(Color.GREEN + "Process watcher thread running...");
            WoodLight woodLight = new WoodLight();
            if (!woodLight.lightThread.isAlive()) {
                LightThread lightThreadFix = new LightThread();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
