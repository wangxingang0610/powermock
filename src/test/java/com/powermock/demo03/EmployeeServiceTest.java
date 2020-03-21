package com.powermock.demo03;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;


public class EmployeeServiceTest {

    @Test
    public void testCreateEmployee() {
        //mock对象
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);

        Employee employee = new Employee();

        //when
        PowerMockito.doNothing().when(employeeDao).addEmployee(employee);

        EmployeeService employeeService = new EmployeeService(employeeDao);
        employeeService.createEmployee(employee);

        //verify 校验
        //校验被 mock 出来的对象中的某个方法是否被调用
        Mockito.verify(employeeDao,Mockito.times(1)).addEmployee(employee);

    }
}