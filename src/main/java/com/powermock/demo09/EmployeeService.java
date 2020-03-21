package com.powermock.demo09;

public class EmployeeService {

    public void createEmployee(final Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao(false, EmployeeDao.Dialect.MYSQL);
        employeeDao.insertEmploye(employee);
    }
}
