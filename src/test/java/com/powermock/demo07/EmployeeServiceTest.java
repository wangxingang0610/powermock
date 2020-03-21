package com.powermock.demo07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 *
 * Mockito.verify(employeeDao, Mockito.never()).saveEmployee(employee); Mockito.verify(employeeDao,
 * Mockito.atLeastOnce()).saveEmployee(employee); Mockito.verify(employeeDao,
 * Mockito.times(1)).saveEmployee(employee); Mockito.verify(employeeDao,
 * Mockito.atMost(1)).saveEmployee(employee); Mockito.verify(employeeDao,
 * Mockito.atLeast(1)).saveEmployee(employee);
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {


    @Test
    public void testSaveOrUpdateWithMockLessZero() {
        //mock
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);

        try {
            //局部变量
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);

            Employee emp = new Employee();
            PowerMockito.when(employeeDao.getCount(emp)).thenReturn(0L);

            //调用
            EmployeeService employeeService = new EmployeeService();
            employeeService.saveOrUpdate(emp);

            Mockito.verify(employeeDao).saveEmployee(emp);
            Mockito.verify(employeeDao, Mockito.never()).updateEmployee(emp);


        }catch (Exception e){
            fail("error ! ! !");
        }

    }



    @Test
    public void testSaveOrUpdateWithMockMoreThanZero() {
        //mock
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);

        try {
            //局部变量
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);

            Employee emp = new Employee();
            PowerMockito.when(employeeDao.getCount(emp)).thenReturn(1L);

            //调用
            EmployeeService employeeService = new EmployeeService();
            employeeService.saveOrUpdate(emp);

            Mockito.verify(employeeDao, Mockito.never()).saveEmployee(emp);
            Mockito.verify(employeeDao).updateEmployee(emp);


        }catch (Exception e){
            fail("error ! ! !");
        }

    }











}