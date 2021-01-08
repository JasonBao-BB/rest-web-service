package com.example.restwebservice.controllers;

import com.example.restwebservice.model.PetOwner;
import com.example.restwebservice.services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Set;

/*
* localhost:8080/owners
* */
@RestController //combine @Controller + @ResponseBody:
@RequestMapping("/owners") //mapping url to class or method
public class PetOwnerController {

    private CRUDService ownerService;

    @Autowired
    public PetOwnerController(@Qualifier("petOwnerServiceImpl") CRUDService service) {
        this.ownerService = service;
    }

    //增删改查对应的url mapping

//    public Set<PetOwner> findAll(){
////        Set<PetOwner> petOwnerSet = ownerService.findAll();
////        return petOwnerSet;
//    }
    @RequestMapping(value = "/all", method = RequestMethod.GET) //localhost:8080/owners/all
    public ResponseEntity<Set<PetOwner>> findAll(){
        Set<PetOwner> petOwnerSet = ownerService.findAll();
        return new ResponseEntity<>(petOwnerSet, HttpStatus.OK);
    }

    @RequestMapping(value = "/owner/{id}", method = RequestMethod.GET) //localhost:8080/owners/owner/12
    public ResponseEntity<PetOwner> findById(@PathVariable("id") Long id){
        PetOwner owner = (PetOwner) ownerService.findById(id);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @RequestMapping(value = "/owner", method = RequestMethod.GET) //localhost:8080/owners/owner?id=12&username=1234&pwd=1234
    public ResponseEntity<PetOwner> findById2(@RequestParam(value = "id", required = false) Long id){
        PetOwner owner = (PetOwner) ownerService.findById(id);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @RequestMapping(value = "/owner", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> create(@RequestBody PetOwner petOwner){
        ownerService.save(petOwner);
        return new ResponseEntity<>("创建成功", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/owner/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PetOwner> updateOwner(@PathVariable ("id") Long id, @RequestBody PetOwner petOwner){

        PetOwner owner = (PetOwner) ownerService.findById(id);

        if (owner == null) {
            throw new RuntimeException("没找到这个对象");
        }

        owner.setFirstName(petOwner.getFirstName());
        owner.setLastName(petOwner.getLastName());

        ownerService.update(owner);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @RequestMapping(value = "/owner/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        ownerService.deleteById(id);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }
}
