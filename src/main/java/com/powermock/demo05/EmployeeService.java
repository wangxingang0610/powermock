package com.powermock.demo05;


public class EmployeeService {

    public void createEmployee(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.addEmployee(employee);
    }


}
