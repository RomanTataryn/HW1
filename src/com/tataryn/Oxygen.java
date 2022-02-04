package com.tataryn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Oxygen extends Thread {
    private final Semaphore oxygenBarrier;
    private final CyclicBarrier waterBarrier;

    public Oxygen(Semaphore oxygenBarrier, CyclicBarrier waterBarrier) {
        this.oxygenBarrier = oxygenBarrier;
        this.waterBarrier = waterBarrier;
    }

    private void releaseOxygen() {
        System.out.print("O");
    }

    @Override
    public final void run() {
        try {
            oxygenBarrier.acquire();
            waterBarrier.await();
            releaseOxygen();
            oxygenBarrier.release();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
