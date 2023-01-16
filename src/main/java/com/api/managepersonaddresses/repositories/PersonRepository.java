package com.api.managepersonaddresses.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.managepersonaddresses.models.PersonModel;


public interface PersonRepository extends JpaRepository<PersonModel, Integer> {
  
  boolean existsByName(String name);

  Optional<PersonModel> findById(Integer id);

}
