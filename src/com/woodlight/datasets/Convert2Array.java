package com.woodlight.datasets;

import org.apache.commons.math3.complex.ComplexUtils;

import java.lang.reflect.Array;
import java.util.Set;

public class Convert2Array {
    public Set convertArray(double[] set) {
        Set output = null;
        for (int i = 0; i <= set.length; i++) {
            output.add(set[i]);
        }
        return output;
    }
}
