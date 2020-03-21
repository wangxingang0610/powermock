package com.powermock.demo06;

public class EmployeeService {


    public int getEmployeeCount() {
        return EmployeeUtils.getEmployeeCount();
    }

    public void createEmployee(Employee employee) {
        EmployeeUtils.persistenceEmployee(employee);
    }

}
