package com.example.restwebservice.bootstap;

import com.example.restwebservice.model.PetOwner;
import com.example.restwebservice.services.PetOwnerServiceImpl;
import com.example.restwebservice.services.VetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private PetOwnerServiceImpl ownerService;
    private VetServiceImpl vetService;

    @Autowired
    public DataLoader(PetOwnerServiceImpl ownerService, VetServiceImpl vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hellooooo");
        PetOwner owner1 = new PetOwner();
        owner1.setId(1L);
        owner1.setFirstName("Alex");
        owner1.setLastName("Chang");

        PetOwner owner2 = new PetOwner();
        owner2.setId(2L);
        owner2.setFirstName("Hurry");
        owner2.setLastName("Up");

        PetOwner owner3 = new PetOwner();
        owner3.setId(3L);
        owner3.setFirstName("Haha");
        owner3.setLastName("Han");

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

        System.out.println("数据加载完毕");
    }
}
