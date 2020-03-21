package com.powermock.demo04;


public class EmployeeService {

    public int getTotalEmployee() {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getTotal();
    }


}
