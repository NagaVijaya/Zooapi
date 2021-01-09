package com.zooapi.Zooapi;

import org.springframework.stereotype.Service;

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
}
