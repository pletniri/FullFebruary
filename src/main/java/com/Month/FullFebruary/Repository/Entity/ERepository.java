package com.Month.FullFebruary.Repository.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ERepository extends JpaRepository<Employee, Integer> {

    }
