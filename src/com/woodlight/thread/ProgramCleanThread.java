package com.woodlight.thread;

import com.woodlight.WoodLight;
import com.woodlight.system.OperatingSystem;

import java.util.Arrays;

public class ProgramCleanThread extends Thread {
    public void run() {
        try {
            System.out.println("Program Shutdown thread running... exiting in 3 seconds");
            sleep(1000);
            System.out.println("WoodLight windows open: " + Arrays.toString(WoodLight.getWindows()));
            sleep(2000);
        } catch (Exception cleanException) {
            cleanException.printStackTrace();
            System.out.println("--------------------------");
            OperatingSystem osInfo = new OperatingSystem();
            osInfo.sysInfo();
        }
    }
}
