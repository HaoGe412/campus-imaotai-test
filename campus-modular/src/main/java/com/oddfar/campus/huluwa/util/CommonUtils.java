package com.oddfar.campus.huluwa.util;

import java.util.Random;

public class CommonUtils {
    public CommonUtils() {
    }

    public static void sleepSeconds(int maxSeconds) {
        try {
            Thread.sleep((long) ((new Random()).nextInt(maxSeconds) * 1000));
        } catch (InterruptedException var2) {
        }

    }

    public static void sleepMicroSeconds(int maxMicroSeconds) {
        try {
            Thread.sleep((long) (new Random()).nextInt(maxMicroSeconds));
        } catch (InterruptedException var2) {
        }

    }
}