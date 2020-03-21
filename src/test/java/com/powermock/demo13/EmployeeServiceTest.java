package com.powermock.demo13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Test
    public void testExist() {
        try {
            //mock spy
            EmployeeService employeeService = PowerMockito.spy(new EmployeeService());

            //
            PowerMockito.doNothing().when(employeeService,"checkExist","aaa");

            boolean aaa = employeeService.exist("aaa");
            assertTrue("aaa", aaa);


            //
            PowerMockito.verifyPrivate(employeeService).invoke("checkExist","aaa");
        }catch (Exception e){
            fail("error ! !");
        }
    }
}