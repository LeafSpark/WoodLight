package com.woodlight.editor;
@Deprecated
public class ThreadDebug extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(17500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        System.out.println("LeafEdit error!");
    }
}

