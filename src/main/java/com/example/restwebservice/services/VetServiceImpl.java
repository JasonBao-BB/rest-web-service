package com.example.restwebservice.services;

import com.example.restwebservice.model.PetOwner;
import com.example.restwebservice.model.Vet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class VetServiceImpl implements CRUDService<Vet, Long> {

    private final Map<Long, Vet> map = new HashMap<>();

    @Override
    public Set<Vet> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public Vet findById(Long id) {
        return map.get(id);
    }

    @Override
    public Vet save(Vet object) {
        map.put(object.getId(), object);
        return object;
    }

    @Override
    public void delete(Vet object) {
        map.remove(object);
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public Vet update(Vet object) {//user/id  Object
        map.put(object.getId(), object);
        return object;
    }
}
