package com.woodlight.editor.tools;
@Deprecated
public class MainThread extends Thread {

    @Override
    public void run() {
        while (true) {
            //System.out.println("This is MainThread task running..."); commented out because spammy and can cause memory leaks
            try {
                Thread.sleep(17500);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
