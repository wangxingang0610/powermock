package com.powermock.demo02;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * 获取所有员工的数量. * @return
     */
    public int getTotalEmployee() {
        return employeeDao.getTotal();
    }
}
