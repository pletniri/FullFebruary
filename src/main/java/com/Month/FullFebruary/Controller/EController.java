package com.Month.FullFebruary.Controller;

import com.Month.FullFebruary.Repository.Entity.ERepository;
import com.Month.FullFebruary.Repository.Entity.Employee;
import com.Month.FullFebruary.Service.EService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//sends data back and forth in the Json format
//we define routs in this class

@RestController
@RequestMapping("/employee")
public class EController {

    private final ERepository eRepository;
    private final EService eService;

    //For HATEOAS
    private final EmployeeModelAssembler assembler;


    public EController(ERepository eRepository, EService eService, EmployeeModelAssembler assembler )
    {
        this.eRepository = eRepository;
        this.eService = eService;
        this.assembler = assembler;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<Employee> all(){

        return eService.all();

//HATEOAS Format
//        List<EntityModel<Item>> items = itemService.all().stream()
//                .map(assembler::toModel)
//                .collect(Collectors.toList());
//
//        return CollectionModel.of(items, linkTo(methodOn(ItemController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public Employee one( @PathVariable Integer id ){
        return eService.findById(id);

    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> save(@RequestBody EmployeeDto employeeDto )
    {
        EntityModel<Employee> entityModel = assembler.toModel(eService.save(new Employee(employeeDto)));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    //Delete an item by id
    @DeleteMapping( "/{id}" )
    public ResponseEntity<?> delete(@PathVariable Integer id )
    {
        eService.delete( id );
        return ResponseEntity.noContent().build();
    }

    //Update item information
    @PutMapping( "/{id}" )
    public ResponseEntity<?> update( @RequestBody EmployeeDto employeeDto, @PathVariable Integer id )
    {

        Employee newEmployee = new Employee(employeeDto);

        Employee updatedEmployee = eRepository.findById(id)
                .map(employee -> {
                    employee.setId(id);
                    employee.setName(newEmployee.getName());
                    employee.setImage(newEmployee.getImage());
                    employee.setPosition(newEmployee.getPosition());
                    return eService.save(employee);
                }).orElseGet(() -> {
                    newEmployee.setId(id);
                    return eRepository.save(newEmployee);
                });

        EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

}







//@RestController
//@RequestMapping("/api/employee")
//public class EController {
//
//    private final EService eService;
//
//    public EController(@Autowired EService eService) {
//        this.eService = eService;
//    }
//
//    @CrossOrigin("*")
//    @GetMapping
//    public List<Employee> getEmployees() {
//        return eService.all();
//    }
//
//    @CrossOrigin("*")
//    @PostMapping
//    public void addEmployee (@RequestBody Employee employee) {
//        eService.add(employee);
//
//    }
//}
