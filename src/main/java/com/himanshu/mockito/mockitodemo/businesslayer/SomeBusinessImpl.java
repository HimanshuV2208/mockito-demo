package com.himanshu.mockito.mockitodemo.businesslayer;

import com.himanshu.mockito.mockitodemo.services.DataService;

public class SomeBusinessImpl {
    private DataService dataService;

    public int findGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int value : data) {
            if (value > greatestValue) greatestValue = value;
        }
        return greatestValue;
    }
}
