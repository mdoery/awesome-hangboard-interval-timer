package com.mdoery.hangboardintervaltimer;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


/**
 */
public class StopWatch extends Observable implements Callable {
    private ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
    public StopWatch() {
    }
    public ScheduledFuture start(int delay, TimeUnit timeUnit) {
        //ses.schedule(this, 10, TimeUnit.SECONDS);
        ScheduledFuture result = ses.schedule(this, delay, timeUnit);
        setChanged();
        return result;
    }
    public void stop() {
    }

    @Override
    public Object call() throws Exception {
        System.out.println("You have been called");
        this.notifyObservers();
        return this;
    }
}
