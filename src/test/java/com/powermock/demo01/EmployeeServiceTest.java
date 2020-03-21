package com.powermock.demo01;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {

    @Test
    public void testGetTotalEmployee() {
        final EmployeeDao employeeDao = new EmployeeDao();
        final EmployeeService service = new EmployeeService(employeeDao);

        int total = service.getTotalEmployee();
        assertEquals(10, total);
    }


}

