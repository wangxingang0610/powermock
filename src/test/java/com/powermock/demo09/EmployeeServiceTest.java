package com.powermock.demo09;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Test
    public void testCreateEmployee() {
        //mock
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);

        try {
            //when
            PowerMockito.whenNew(EmployeeDao.class).withArguments(false, EmployeeDao.Dialect.MYSQL).thenReturn(employeeDao);

            Employee emp = new Employee();

            //调用
            EmployeeService employeeService = new EmployeeService();
            employeeService.createEmployee(emp);

            //verify
            Mockito.verify(employeeDao,Mockito.times(1)).insertEmploye(emp);
        }catch (Exception e){
            fail("error ! ! !");
        }
    }
}