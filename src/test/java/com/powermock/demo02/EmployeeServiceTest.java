package com.powermock.demo02;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;


public class EmployeeServiceTest {

    @Test
    public void testGetTotalEmployee() {

        //mock 模拟的对象
        EmployeeDao employeeDao = mock(EmployeeDao.class);

        //录制
        when(employeeDao.getTotal()).thenReturn(10);

        //播放
        EmployeeService employeeService = new EmployeeService(employeeDao);
        int total = employeeService.getTotalEmployee();
        Assert.assertEquals(10,total);

    }
}