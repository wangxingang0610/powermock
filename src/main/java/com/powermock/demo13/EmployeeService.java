package com.powermock.demo13;

public class EmployeeService {

    public boolean exist(String userName) {
        checkExist(userName);
        return true;
    }

    private void checkExist(String userName) {
        throw new UnsupportedOperationException();
    }



}
