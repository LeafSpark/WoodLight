package com.woodlight.editor.tools;

import com.woodlight.editor.tools.MainThread;
@Deprecated
public class ThreadCaller {

    public ThreadCaller() {
        MainThread mainThread = new MainThread();
        System.out.println(mainThread.getUncaughtExceptionHandler());
        System.out.println(mainThread.getState());
    }
}
//lol its so simple