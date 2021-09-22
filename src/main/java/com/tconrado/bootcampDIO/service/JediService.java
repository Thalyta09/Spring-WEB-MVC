package com.tconrado.bootcampDIO.service;

import com.tconrado.bootcampDIO.exception.JediNotFoundException;
import com.tconrado.bootcampDIO.model.Jedi;
import com.tconrado.bootcampDIO.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    private JediRepository repository;

    public List<Jedi> findAll(){

        return repository.findAll();
    }

    public Jedi findById(final Long id){

        final Optional<Jedi> jedi = repository.findById(id);

        if(jedi.isPresent()){
            return jedi.get();
        }else{
            throw new JediNotFoundException();
        }
    }

    public Jedi createJedi(final Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi updateJedi(final Long id, final Jedi body){

        final Optional<Jedi> buscaJedi = repository.findById(id);
        final Jedi jedi;

        if(buscaJedi.isPresent()){
            jedi = buscaJedi.get();
        }else{
            throw new JediNotFoundException();
        }

        jedi.setName(body.getName());
        jedi.setLastName(body.getLastName());

        return repository.save(jedi);
    }

    public void deleteJedi(final Long id){

        final Jedi jedi = findById(id);
        repository.delete(jedi);
    }
}
