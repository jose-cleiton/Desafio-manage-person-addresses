package com.api.managepersonaddresses.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.managepersonaddresses.models.PersonModel;


public interface PersonRepository extends JpaRepository<PersonModel, Long> {
  
  boolean existsByName(String name);

  Optional<PersonModel> findById(Long id);

}
