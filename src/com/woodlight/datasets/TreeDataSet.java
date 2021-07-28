package com.woodlight.datasets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeDataSet extends TreeSet {
    public Object[] DataSet() {
        Set<Double> dataSet = new HashSet<Double>();
        TreeSet treeSet = new TreeSet();
        Object[] setArray = dataSet.toArray();
        return setArray;
    }
}
