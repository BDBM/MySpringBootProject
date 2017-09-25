package com.misl.semister;


import org.springframework.data.repository.CrudRepository;

public interface SemisterRepository extends CrudRepository<Semister, Integer> {

    Semister findById(int id);

}