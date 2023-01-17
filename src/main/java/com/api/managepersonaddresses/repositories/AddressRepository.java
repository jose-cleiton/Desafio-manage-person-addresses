package com.api.managepersonaddresses.repositories;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.api.managepersonaddresses.models.AddressModel;
import com.api.managepersonaddresses.models.PersonModel;


@Component
public interface AddressRepository extends JpaRepository<AddressModel, Long> { 

  List<AddressModel> findByPerson(PersonModel person);

  AddressModel findByPersonAndMain(Long personId, boolean main);

  Optional<AddressModel> findByPersonIdAndMainTrue(Long personId);
  List<AddressModel> findByPersonIdAndMainFalse(Long personId); 
  
}