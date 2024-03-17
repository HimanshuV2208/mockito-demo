package com.himanshu.mockito.mockitodemo.businesslayer;

import com.himanshu.mockito.mockitodemo.services.DataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void findGreatestFromAllData_basicScenario() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{10, 25, 2});
        assertEquals(25, businessImpl.findGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllData_oneElementOnly() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{200});
        assertEquals(200, businessImpl.findGreatestFromAllData());
    }

    @Test
    void findGreatestFromAllData_emptyArray() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, businessImpl.findGreatestFromAllData());
    }

}
