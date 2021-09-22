package com.tconrado.bootcampDIO.rest;

import com.tconrado.bootcampDIO.model.Jedi;
import com.tconrado.bootcampDIO.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class JediResource {

    @Autowired
    private JediService service;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi() {

        return service.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {

        final Jedi jedi = service.findById(id);
        return ResponseEntity.ok(jedi);
    }

    @PostMapping("/api/jedi")
    public ResponseEntity<Jedi> createJedi(@Valid @RequestBody Jedi body){

        Jedi jedi = service.createJedi(body);
        return new ResponseEntity<>(jedi, HttpStatus.CREATED);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi body){

        final Jedi jedi = service.updateJedi(id, body);
        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> deleteJedi(@PathVariable("id") Long id){

        service.deleteJedi(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
