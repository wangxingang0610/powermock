package com.powermock.demo03;

public class EmployeeDao {

    public void addEmployee(Employee employee) {
        //模拟不能调用
        throw new UnsupportedOperationException();
    }
}
