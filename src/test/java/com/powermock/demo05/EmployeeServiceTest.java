package com.powermock.demo05;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.fail;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Test
    public void testCreateEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee();
        employeeService.createEmployee(employee);
    }


    @Test
    public void testCreateEmployeeWithMock() {
        //mock
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);

        try {
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();

            PowerMockito.doNothing().when(employeeDao).addEmployee(employee);
            EmployeeService employeeService = new EmployeeService();
            employeeService.createEmployee(employee);

            Mockito.verify(employeeDao, Mockito.times(1)).addEmployee(employee);

        } catch (Exception e) {
            fail();
        }


    }


}

