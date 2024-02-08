package com.example.tymeleaf.service.impl;

import com.example.tymeleaf.entity.Employee;
import com.example.tymeleaf.repository.EmployeeRepository;
import com.example.tymeleaf.service.EmployeeServices;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeServices {


    private final EmployeeRepository empRepo;

    @Override
    public List<Employee> getAllWithLimit(int offset, int limit) {
        if(getAllCount()<limit){
            limit = getAllCount();
        }
        return empRepo.findAll().subList(offset, limit);
    }

    @Override
    public int getAllCount() {
        return empRepo.findAll().size();
    }

    @Override
    public void save(Employee employee) {
        empRepo.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        Optional<Employee> optional = empRepo.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(
                    "Employee not found for id : " + id);
        }
        return employee;
    }

    @Override
    public void deleteViaId(long id) {
        empRepo.deleteById(id);
    }
}