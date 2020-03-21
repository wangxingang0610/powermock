package com.powermock.demo03;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    public void createEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }
}
