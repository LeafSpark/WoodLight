package com.woodlight.system;

import com.woodlight.WoodLight;
import com.woodlight.annotation.Buggy;
import com.woodlight.annotation.Uncompleted;
import jdk.jfr.Experimental;
import org.apache.commons.lang3.SystemUtils;

@Buggy
@Uncompleted
@Experimental
public final class CheckSystem {
    public CheckSystem() {
        String system = SystemUtils.OS_NAME;
        if (system.contains("Windows XP")) {
            System.out.println("Windows XP Support will be dropped. Please upgrade to a newer Windows version.");
        }
        if (system.contains("Windows Vista")) {
            System.out.println("Windows Vista Support will be dropped. Please upgrade to a newer Windows version.");
        }
        if (system.contains("Windows 2000")) {
            System.out.println("Windows 2000 Support will be dropped. Please upgrade to a newer Windows version.");
        }
        if (system.contains("Windows NT")) {
            System.exit(0);
        }
        if (system.contains("Windows 10")) {
            System.out.println("You are good to go!");
        }
        if (system.contains("OS X")) {
            System.out.println("MacOS support is experimental, use at your own risk!");
        }
    }
}
