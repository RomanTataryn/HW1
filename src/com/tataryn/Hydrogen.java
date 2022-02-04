package com.tataryn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Hydrogen extends Thread {
    private final Semaphore hydrogenBarrier;
    private final CyclicBarrier waterBarrier;

    public Hydrogen(Semaphore hydrogenBarrier, CyclicBarrier waterBarrier) {
        this.hydrogenBarrier = hydrogenBarrier;
        this.waterBarrier = waterBarrier;
    }

    private void releaseHydrogen() {
        System.out.print("H");
    }

    @Override
    public final void run() {
        try {
            hydrogenBarrier.acquire();
            waterBarrier.await();
            releaseHydrogen();
            hydrogenBarrier.release();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
