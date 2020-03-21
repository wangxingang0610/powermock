package com.powermock.demo10;

public class EmployeeController {

    public String getEmail(final String userName) {
        EmployeeService employeeService = new EmployeeService();
        String email = employeeService.findEmailByUserName(userName);
        return email;
    }
}
