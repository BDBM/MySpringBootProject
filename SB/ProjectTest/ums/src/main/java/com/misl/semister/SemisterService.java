package com.misl.semister;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SemisterService {

    @Autowired
    SemisterRepository semisterRepository;

    public List<Semister> getAllSemisters(){
        List<Semister> semisters= new ArrayList<>();
        semisterRepository.findAll().forEach(semisters::add);
        return semisters;
    }

    public Semister getSemisterById(int id){
        return semisterRepository.findOne(id);
    }

    public void addSemister(Semister semister){
        semisterRepository.save(semister);
    }
    public void updateSemister(int id,Semister semister){
        semisterRepository.save(semister);
    }

    public void deleteSemister(int id){
        semisterRepository.delete(id);
    }


}