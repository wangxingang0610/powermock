package com.powermock.demo09;

public class EmployeeDao {

    public enum Dialect {
        MYSQL,
        ORACLE
    }

    public EmployeeDao(boolean lazy, Dialect dialect) {
        throw new UnsupportedOperationException();
    }

    public void insertEmploye(Employee employee) {
        throw new UnsupportedOperationException();
    }
}
