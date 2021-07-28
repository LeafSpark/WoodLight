package com.woodlight.editor.tools;
@Deprecated
public class ThreadManager {

    public ThreadManager() {
        System.out.println(Thread.currentThread());
    }

}
@Deprecated
class NewThread {
    NewThread() {
        System.out.println("new thread activated");
    }
}
