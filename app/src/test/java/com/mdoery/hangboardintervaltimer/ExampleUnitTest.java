package com.mdoery.hangboardintervaltimer;

import org.junit.Test;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /**
     * This method blocks for 4 seconds to allow the Coach to run a set of 3 1-second intervals.
     * @throws InterruptedException
     */
    @Test
    public void stopWatchRunsFor3Intervals() throws InterruptedException {
        long l = java.lang.System.currentTimeMillis(); // for debugging if needed
        Coach c = new Coach();
        // add three one-second intervals
        c.addInterval(1);
        c.addInterval(1);
        c.addInterval(1);
        // start interval training
        c.startTraining();
        // Block for 4 seconds while waiting for the 3 seconds of interval training to finish.
        CountDownLatch cdl = new CountDownLatch(1);
        cdl.await(4, TimeUnit.SECONDS);
        long timeTrained = c.getTrainingTime();
        long l1 = java.lang.System.currentTimeMillis(); // for debugging if needed
        long elapsedSec = (l1 - l)/1000; // for debugging if needed
        assertEquals(3, timeTrained);
        assertTrue(c.isFinished());
    }
    /**
     * This method blocks for 4 seconds to allow the Coach to run a set of 2 intervals.
     * @throws InterruptedException
     */
    @Test
    public void stopWatchRunsFor2Intervals() throws InterruptedException {
        Coach c = new Coach();
        // add two intervals
        c.addInterval(1);
        c.addInterval(2);
        // start interval training
        c.startTraining();
        // Block for 4 seconds while waiting for the 3 seconds of interval training to finish.
        CountDownLatch cdl = new CountDownLatch(1);
        cdl.await(4, TimeUnit.SECONDS);
        long timeTrained = c.getTrainingTime();
        assertEquals(3, timeTrained);
        assertTrue(c.isFinished());
    }

}