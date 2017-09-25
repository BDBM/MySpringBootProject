package com.misl.semister;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SemisterController {
    @Autowired
    SemisterService semisterService;

    @RequestMapping("/semisters")
    public List<Semister> getAllSemister(){
        return semisterService.getAllSemisters();
    }
    @RequestMapping("/semisters/{id}")
    public Semister getSemisterById(@PathVariable int id){
        return semisterService.getSemisterById(id);
    }
    @RequestMapping(method=RequestMethod.POST,value="/semisters")
    public void addSemister(@RequestBody Semister semister){
        semisterService.addSemister(semister);
    }

    @RequestMapping(method=RequestMethod.PUT,value="/semisters/{id}")
    public void updateSemister(@RequestBody Semister semister,@PathVariable int id){
        semisterService.updateSemister(id, semister);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/semisters/{id}")
    public void deleteSemister(@PathVariable int id){
        semisterService.deleteSemister(id);
    }

}