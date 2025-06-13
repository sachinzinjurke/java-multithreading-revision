package com.home.thread.common;

public class LongWrapper {

    private long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue(){
        return l;
    }

    public synchronized void incrementValue(){
        l=l+1L;
    }
}
