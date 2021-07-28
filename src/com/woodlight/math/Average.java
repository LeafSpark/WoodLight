package com.woodlight.math;

public class Average {
    public final long average(long[] array) {
        double temp = 0D;
        for (int i = 0; i <= array.length; i++) {
            temp = temp + array[i] + array[i + 1];
        }
        return (long) (temp / array.length);
    }
}
