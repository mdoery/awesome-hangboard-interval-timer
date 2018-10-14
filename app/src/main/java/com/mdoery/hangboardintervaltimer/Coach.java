package com.mdoery.hangboardintervaltimer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

/**
 * The Coach is like a real-life coach. It starts and stops the stopwatch, makes a little noise
 * when each interval starts or stops, etc.
 */
public class Coach implements Observer {
    private boolean started = false;
    private long startTime = java.lang.System.currentTimeMillis();
    private long endTime = 0;
    private long trainingTime = 0;
    private ArrayList<Integer> intervals = new ArrayList<Integer>();
    private StopWatch sw;
    public Coach() {
        sw = new StopWatch();
        sw.addObserver(this);
    }

    private void setTrainingTime(long t) {
        trainingTime = t;
    }

    private void addTrainingTime(long t) {
        trainingTime += t;
    }

    public void printTime() {
        long t = (java.lang.System.currentTimeMillis() - startTime)/1000;
        System.out.println("time: " + t);
    }

    public void addInterval(int nSeconds) {
        intervals.add(nSeconds);
    }

    public void printTrainingTime() {
        long t = (endTime - startTime)/1000;
        System.out.println("time: " + t);
    }
    /**
     * Starts the timer. StopWatch will run for input nSeconds.
     */
    public void startTraining() {
        if (!started) {
            started = true;
            startTime = java.lang.System.currentTimeMillis();
            setTrainingTime(0);
        }
        if (intervals.size() > 0) {
            int nSeconds = intervals.remove(0);
            System.out.println(intervals.size() + " nSeconds of training: " + nSeconds);
            if (nSeconds > 0) {
                addTrainingTime(nSeconds);
                sw.start(nSeconds, TimeUnit.SECONDS);
            }
        } else {
            System.out.println("** Done training? **");
            endTime = java.lang.System.currentTimeMillis();
            printTrainingTime();
        }
    }

    /**
     * Stops the timer. StopWatch will turn off.
     */
    public void stopTimer() {
    }

    /**
     * Pauses the timer for delay seconds.
     * @param delay number of seconds to pause the timer
     */
    public void pauseTimer(int delay) {
    }

    /**
     * Plays the noise given by the input id.
     * @param id
     */
    public void playNoise(int id) {

    }

    @Override
    public void update(Observable o, Object arg) {
        printTime();
        // start the next training interval
        startTraining();
    }

    public boolean isFinished() {
        return intervals.size() == 0;
    }

    public long getTrainingTime() {
        return trainingTime;
    }
}
