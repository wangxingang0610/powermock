package com.powermock.demo06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeUtils.class)
public class EmployeeServiceTest {

    /**
     * Exception
     */
    @Test
    public void testGetEmployeeCount() {
        EmployeeService employeeService = new EmployeeService();
        int count = employeeService.getEmployeeCount();
        assertEquals(2, count);

    }

    /**
     * Exception
     */
    @Test
    public void testCreateEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee();
        employeeService.createEmployee(employee);
        assertTrue(true);
    }



    @Test
    public void testGetEmployeeCountWithMock() {
        //mock static
        PowerMockito.mockStatic(EmployeeUtils.class);

        //when
        PowerMockito.when(EmployeeUtils.getEmployeeCount()).thenReturn(10);

        //调用
        EmployeeService employeeService = new EmployeeService();
        int count = employeeService.getEmployeeCount();

        //断言
        assertEquals(10, count);

    }


    @Test
    public void testCreateEmployeeWithMock() {
        //mock static
        PowerMockito.mockStatic(EmployeeUtils.class);

        //when
        Employee emp = new Employee();
        PowerMockito.doNothing().when(EmployeeUtils.class);

        //调用
        EmployeeService employeeService = new EmployeeService();
        employeeService.createEmployee(emp);

        //verify
        PowerMockito.verifyStatic();

    }
}