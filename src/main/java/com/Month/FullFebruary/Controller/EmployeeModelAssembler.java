package com.Month.FullFebruary.Controller;

import com.Month.FullFebruary.Repository.Entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>>{

        @Override
        public EntityModel<Employee> toModel(Employee employee) {

            return EntityModel.of(employee, //
                    linkTo(methodOn(EController.class).one(employee.getId())).withSelfRel(),
                    linkTo(methodOn(EController.class).all()).withRel("employee"));
        }

    }

