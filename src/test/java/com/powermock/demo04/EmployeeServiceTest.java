package com.powermock.demo04;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

    /**
     * 传统 测试失败
     */
    @Test
    public void testGetTotalEmployee()  {
        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.getTotalEmployee();
        Assert.assertEquals(0, result);
    }



    //TODO wangxg
    @Test
    public void testGetTotalEmployeeWithMock() {

        //mock
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);

        try {
            //局部变量
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);

            //when
            PowerMockito.when(employeeDao.getTotal()).thenReturn(10);

            EmployeeService employeeService = new EmployeeService();
            int total = employeeService.getTotalEmployee();

            //断言
            assertEquals(10, total);
        } catch (Exception e) {
            fail();
        }

    }



}

