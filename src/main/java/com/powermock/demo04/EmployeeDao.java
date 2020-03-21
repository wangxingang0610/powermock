package com.powermock.demo04;


public class EmployeeDao {

    public int getTotal() {
        //模拟不能调用
        throw new UnsupportedOperationException();
    }
}
