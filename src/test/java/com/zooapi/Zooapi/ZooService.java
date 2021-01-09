package com.zooapi.Zooapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ZooService {


    private ZooRepository zooRepository;

    public ZooService(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    public Zoo addAnimalToZoo(Zoo zoo) {
        return zooRepository.save(zoo);
    }

    public List<Zoo> getListOfAnimals() {
              return  zooRepository.findAll();
    }
}
