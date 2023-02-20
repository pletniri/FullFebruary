package com.Month.FullFebruary.Service;

public class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(Integer id) {
        super("Could not find item " + id);
    }
}

