package com.powermock.demo11;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Test
    public void testGetEmailWithMock() {

        //mock 对象
        EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);

        try {
            PowerMockito.when(employeeService.findEmailByUserName(Mockito.anyString())).then(new Answer<String>() {
                @Override
                public String answer(InvocationOnMock invocation) throws Throwable {
                    //mock方法传递的入参
                    String arg = (String) invocation.getArguments()[0];
                    //获取哪个真实的方法调用改mock接口
                    Object o = invocation.callRealMethod();
                    //获取是哪个mock方法被调用了
                    Method method = invocation.getMethod();
                    //获取mock之后的对象
                    Object mock = invocation.getMock();
                    if (arg.equals("wangxingang") || arg.equals("wxg")) {
                        return "wangxingang@163.com";
                    } else if (arg.equals("LiLi")) {
                        return "LiLi@163.com";
                    } else {
                        throw new RuntimeException("runtime exception");
                    }
                }
            });

            //
            PowerMockito.whenNew(EmployeeService.class).withNoArguments().thenReturn(employeeService);

            //调用
            EmployeeController employeeController = new EmployeeController();
            String email = employeeController.getEmail("wangxingang");
            //断言
            Assert.assertEquals("wangxingang@163.com", email);

            email = employeeController.getEmail("LiLi");
            Assert.assertEquals("LiLi@163.com", email);


//            email = employeeController.getEmail("marry");
//            fail("should not process to here !");


        } catch (Exception e) {
            Assert.assertTrue(e instanceof RuntimeException);
        }


    }
}