package com.lee.learning.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author libin
 * @date 2020-12-07 19:24
 */
public class CalculateTask implements Callable<Integer> {

    private Integer number;
    private CountDownLatch countDownLatch;

    public CalculateTask(Integer num, CountDownLatch countDownLatch) {
        this.number = num;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;

        if (number == 0 || number == 1) {
            result = 1;
        }else {
            for (int i = 2; i < number; i++) {
                result *= i;
            }
        }
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
        countDownLatch.countDown();


        return result;
    }
}
