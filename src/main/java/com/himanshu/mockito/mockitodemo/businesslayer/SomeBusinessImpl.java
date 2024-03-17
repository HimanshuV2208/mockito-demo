package com.himanshu.mockito.mockitodemo.businesslayer;

import com.himanshu.mockito.mockitodemo.services.DataService;

public class SomeBusinessImpl {
    private final DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int value : data) {
            if (value > greatestValue) greatestValue = value;
        }
        return greatestValue;
    }
}
