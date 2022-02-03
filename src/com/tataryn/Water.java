package com.tataryn;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Water {
    private static final Semaphore hydrogenBarrier = new Semaphore(2);
    private static final Semaphore oxygenBarrier = new Semaphore(1);
    private static final CyclicBarrier waterBarrier = new CyclicBarrier(3, System.out::println);

    public static void releaseWater(String input) {
        String[] elements = input.split("");
        System.out.println(Arrays.toString(elements));
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals("H")) {
                new Hydrogen(hydrogenBarrier, waterBarrier).start();
            } else new Oxygen(oxygenBarrier, waterBarrier).start();
        }
    }
}
