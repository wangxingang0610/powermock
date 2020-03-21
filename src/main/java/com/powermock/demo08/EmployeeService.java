package com.powermock.demo08;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void createEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }
}
