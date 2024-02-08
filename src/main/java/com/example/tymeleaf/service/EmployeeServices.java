package com.example.tymeleaf.service;

import com.example.tymeleaf.entity.Employee;
import java.util.List;

public interface EmployeeServices {
    List<Employee> getAllWithLimit(int offset, int limit);
    int getAllCount();

    void save(Employee employee);

    Employee getById(Long id);

    void deleteViaId(long id);
}