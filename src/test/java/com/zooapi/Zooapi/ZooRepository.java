package com.zooapi.Zooapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ZooRepository extends JpaRepository<Zoo, UUID> {

}
