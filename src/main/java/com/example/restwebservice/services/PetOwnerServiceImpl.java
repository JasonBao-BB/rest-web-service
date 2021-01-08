package com.example.restwebservice.services;

import com.example.restwebservice.model.PetOwner;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class PetOwnerServiceImpl implements CRUDService<PetOwner, Long>{

    private final Map<Long, PetOwner> map = new HashMap<>();

    @Override
    public Set<PetOwner> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public PetOwner findById(Long id) {
        return map.get(id);
    }


    @Override
    public PetOwner save(PetOwner object) {
        map.put(object.getId(), object);
        return object;
    }

    @Override
    public void delete(PetOwner object) {
        map.remove(object);
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public PetOwner update(PetOwner object) {

        map.put(object.getId(), object);

        return null;
    }
}
