package com.restapi.simpleapi.repository;

import com.restapi.simpleapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemRepository extends JpaRepository<itemEntity, String>{

}
