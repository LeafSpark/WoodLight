package com.woodlight.system;

import org.apache.commons.lang3.SystemUtils;

public class OperatingSystem {
    public void getOS() {
        String os = SystemUtils.OS_NAME;
        System.out.println(os);
    }

    public void sysInfo() {

        boolean isCompatibleJavaVersion = false;

        if (SystemUtils.IS_JAVA_15) {
            isCompatibleJavaVersion = true;
        }

        if (SystemUtils.IS_JAVA_1_8) {
            isCompatibleJavaVersion = true;
        }

        if (SystemUtils.IS_JAVA_11) {
            isCompatibleJavaVersion = true;
        }

        System.out.println("OS Info...");
        System.out.println("IS_OS_WINDOWS: " + SystemUtils.IS_OS_WINDOWS);
        System.out.println("IS_OS_MACOS: " + SystemUtils.IS_OS_MAC);
        System.out.println("IS_OS_LINUX: " + SystemUtils.IS_OS_LINUX);
        System.out.println("IS_OS_UNIX: " + SystemUtils.IS_OS_UNIX);
        System.out.println("OS_VERSION: " + SystemUtils.OS_VERSION);
        System.out.println("OS_NAME: " + SystemUtils.OS_NAME);
        System.out.println("IS_COMPATIBLE_JAVA_VERSION: " + isCompatibleJavaVersion);
        System.out.println("HOSTNAME: " + SystemUtils.getHostName());
        System.out.println("USERNAME: " + SystemUtils.getUserName());
        System.out.println("JAVA_COMPILER: " + SystemUtils.JAVA_COMPILER);
        System.out.println("JAVA_CLASSPATH: " + SystemUtils.JAVA_CLASS_PATH);
        System.out.println("JAVA_HOME: " + SystemUtils.getJavaHome());
        System.out.println("JAVA_VM_VERSION: " + SystemUtils.JAVA_VM_VERSION);
    }
}
