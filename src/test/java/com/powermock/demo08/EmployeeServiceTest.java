package com.powermock.demo08;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeDao.class)
public class EmployeeServiceTest {


    @Test
    public void testCreateEmployee() {

        //1、mock
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);

        Employee emp = new Employee();
        //2、when
        PowerMockito.when(employeeDao.insertEmployee(emp)).thenReturn(true);

        //3、调用
        EmployeeService employeeService = new EmployeeService(employeeDao);
        employeeService.createEmployee(emp);

        //4、verify
        Mockito.verify(employeeDao,Mockito.times(1)).insertEmployee(emp);


    }
}