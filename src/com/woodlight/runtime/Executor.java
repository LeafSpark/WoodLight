package com.woodlight.runtime;

import org.apache.commons.lang3.SystemUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Executor {
    public void execClass(String exe) throws IOException {
        System.out.println("WoodRuntime 11 running.");
        Runtime.getRuntime().exec(SystemUtils.getUserDir() + "\\" + exe, null, new File(SystemUtils.getUserName()));
    }
}
