package com.zooapi.Zooapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZooAPIController {

    private  ZooService zooService;

    public ZooAPIController(ZooService zooService){
        this.zooService = zooService;
    }

    @PostMapping("/api/zoo")
    public Zoo addAnimalToZoo(@RequestBody Zoo zoo){

        return zooService.addAnimalToZoo(zoo);
    }

    @GetMapping("/api/zoo")
    public List<Zoo> listOfAnimals(){

        return zooService.getListOfAnimals();
    }

}
