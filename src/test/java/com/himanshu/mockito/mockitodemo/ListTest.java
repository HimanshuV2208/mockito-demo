package com.himanshu.mockito.mockitodemo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void simple_test(){
        List<Integer> listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);
        assertEquals(3, listMock.size());
    }

    @Test
    void complex_test(){
        List<Integer> listMock = mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(2);
        assertEquals(3, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    void specific_parameters_test(){
        List<String> listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Some String");
        assertEquals("Some String", listMock.get(0));
        assertNull(listMock.get(1));
    }

    @Test
    void generic_parameters_test(){
        List<String> listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("Some Other String");
        assertEquals("Some Other String", listMock.get(0));
        assertNotNull(listMock.get(1));
        assertEquals("Some Other String", listMock.get(11));
    }

}
