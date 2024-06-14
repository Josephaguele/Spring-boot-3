package com.example.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository repository){
        this.runRepository = repository;
    }

    @GetMapping("/hello")
    String sayHello(){
        return "Hi saying hello controller";
    }

    @GetMapping("")
    private List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    private Run findById(@PathVariable Integer id){
       Optional<Run> run = runRepository.findById(id);
       if(run.isEmpty()){
           throw new RunNotFoundException();
       }
       else {
           return run.get();
       }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    private void create(@Valid @RequestBody Run run){
         runRepository.create(run);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    private void update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    private void delete( @PathVariable Integer id){
        runRepository.delete(id);
    }
}
