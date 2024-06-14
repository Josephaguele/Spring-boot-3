package com.example.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.chrono.ChronoPeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll (){
        return runs;
    }

    Optional<Run> findById(Integer id){
       return runs.stream()
               .filter(run -> run.id() == id)
               .findFirst();
    }

    void createRun (Run run){
         runs.add(run);
    }

    // Find the Run in the db
        // have a method that finds something in the db
        // the method has to find it by its id
    // if the run exists
    // replace the found item with the new item.
        // locate the index of the existing run and replace with the run

    void update(Run run, Integer id){
        Optional<Run>  existingRun = findById(id);
        if (existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()),run );
        }
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init(){
         runs.add(new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now(), 5, Location.INDOOR));
         runs.add(new Run(2, "Hull City run", LocalDateTime.now(), LocalDateTime.now(), 8, Location.OUTDOOR));
         runs.add(new Run(3, "London Marathon", LocalDateTime.now(), LocalDateTime.now(), 9, Location.OUTDOOR));
    }
}
