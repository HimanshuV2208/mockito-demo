package com.himanshu.mockito.mockitodemo.businesslayer;

import com.himanshu.mockito.mockitodemo.services.DataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Tests are written using stubs
//For all cases, we need to define different stubs
//If definition of the service changes, every stub has to be modified

class SomeBusinessImplStubTest {

    @Test
    void findGreatestFromAllData_basicScenario(){
        DataService dataService = new DataServiceStub1();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
        int result = businessImpl.findGreatestFromAllData();
        assertEquals(25, result);
    }

    @Test
    void findGreatestFromAllData_oneElementOnly(){
        DataService dataService = new DataServiceStub2();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
        int result = businessImpl.findGreatestFromAllData();
        assertEquals(200, result);
    }

    @Test
    void findGreatestFromAllData_emptyArray(){
        DataService dataService = new DataServiceStub3();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
        int result = businessImpl.findGreatestFromAllData();
        assertEquals(Integer.MIN_VALUE, result);
    }

}

class DataServiceStub1 implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {10, 5, 25, 2};
    }
}

class DataServiceStub2 implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {200};
    }
}

class DataServiceStub3 implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}