package com.powermock.demo06;

public class EmployeeUtils {

    public static int getEmployeeCount() {
        //模拟不能正常返回数据
        throw new UnsupportedOperationException();
    }

    public static void persistenceEmployee(Employee employee) {
        //模拟不能正常返回数据
        throw new UnsupportedOperationException();
    }

}
