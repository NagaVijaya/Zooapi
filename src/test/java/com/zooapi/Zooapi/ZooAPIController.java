package com.zooapi.Zooapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
