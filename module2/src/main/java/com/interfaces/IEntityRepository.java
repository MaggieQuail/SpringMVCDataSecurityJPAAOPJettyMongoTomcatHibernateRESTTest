package com.interfaces;

import com.model.Auto;
import org.springframework.data.repository.CrudRepository;

//Spring Data test
public interface IEntityRepository extends CrudRepository<Auto, Long> {
    Auto findByModel(String name);


}
