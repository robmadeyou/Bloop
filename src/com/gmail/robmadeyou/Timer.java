package com.gmail.robmadeyou;

/**
 * Created by apex on 16/03/14.
 */
public class Timer {

    private long startTime = System.currentTimeMillis();
    private long duration;
    public Timer(long duration){
        this.duration = duration;
    }

    public boolean isDone(){
        return System.currentTimeMillis() - startTime >= duration;
    }
}
