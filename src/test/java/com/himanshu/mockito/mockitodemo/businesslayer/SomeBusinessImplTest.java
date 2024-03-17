package com.himanshu.mockito.mockitodemo.businesslayer;

import com.himanshu.mockito.mockitodemo.services.DataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessImplTest {

    @Test
    void findGreatestFromAllData_basicScenario(){
        DataService dataServiceMock = mock(DataService.class);
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {10, 25, 2});
        assertEquals(25, businessImpl.findGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllData_oneElementOnly(){
        DataService dataServiceMock = mock(DataService.class);
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {200});
        assertEquals(200, businessImpl.findGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllData_emptyArray(){
        DataService dataServiceMock = mock(DataService.class);
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findGreatestFromAllData());
    }

}
