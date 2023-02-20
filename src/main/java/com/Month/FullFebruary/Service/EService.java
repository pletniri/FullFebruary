package com.Month.FullFebruary.Service;

import com.Month.FullFebruary.Repository.Entity.ERepository;
import com.Month.FullFebruary.Repository.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//it is managing the database. interacts with database, handles the logic of interracting with database.
// hybernate translates our data into MySQL data
@Service
public class EService {

    private final ERepository eRepository;

    public EService(ERepository eRepository )
    {
        this.eRepository = eRepository;
    }


    public Employee save(Employee employee)
    {
        //TODO implement this method
        Employee newEmployee = this.eRepository.save(employee);
        return newEmployee;
    }


    public void delete(Integer id)
    {
        //TODO implement this method
        this.eRepository.deleteById(id);
    }


    public List<Employee> all()
    {
        //TODO implement this method
        return eRepository.findAll();
    }


    public Employee findById (Integer id)
    {
        //TODO implement this method
        Employee employee = eRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return employee;
    }
}
