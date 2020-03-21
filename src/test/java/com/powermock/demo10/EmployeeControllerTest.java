package com.powermock.demo10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * Arguments Matcher 使用
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeController.class)
public class EmployeeControllerTest {


    @Test
    public void testGetEmailWithMock1() {
        //mock对象
        EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);

        try {
            PowerMockito.when(employeeService.findEmailByUserName("wangxingang")).thenReturn("wangxg@163.com");
            PowerMockito.when(employeeService.findEmailByUserName("wxg")).thenReturn("wangxg@163.com");


            //构造
            PowerMockito.whenNew(EmployeeService.class).withNoArguments().thenReturn(employeeService);


            //调用
            EmployeeController employeeController = new EmployeeController();
            String email = employeeController.getEmail("wxg");
            assertEquals("wangxg@163.com", email);


            email = employeeController.getEmail("wangxingang");
            assertEquals("wangxg@163.com", email);



            //
//            employeeController.getEmail("test");
//            fail("should not process to here");
        } catch (Exception e) {
            assertTrue( e instanceof RuntimeException);
        }
    }



    @Test
    public void testGetEmailWithMock2() {
        //mock对象
        EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);

        try {
            PowerMockito.when(employeeService.findEmailByUserName(Mockito.argThat(new ArgumentMatcher<String>() {
                @Override
                public boolean matches(Object o) {

                    String arg = (String) o;
                    if (arg.equals("wangxingang") || arg.equals("wxg")) {
                        return true;
                    } else {
                        throw new RuntimeException();
                    }
                }
            }))).thenReturn("wangxg@163.com");


            //构造
            PowerMockito.whenNew(EmployeeService.class).withNoArguments().thenReturn(employeeService);


            //调用
            EmployeeController employeeController = new EmployeeController();
            String email = employeeController.getEmail("wxg");
            assertEquals("wangxg@163.com", email);

            //
            employeeController.getEmail("test");
            fail("should not process to here");
        } catch (Exception e) {
            assertTrue( e instanceof RuntimeException);
        }
    }





}