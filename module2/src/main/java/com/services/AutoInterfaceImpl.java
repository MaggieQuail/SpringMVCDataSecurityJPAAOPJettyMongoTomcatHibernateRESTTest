package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.interfaces.AutoInterface;
import com.interfaces.IEntityRepository;
import com.model.Auto;

@Component
public class AutoInterfaceImpl implements AutoInterface {

    @Autowired
    private IEntityRepository repository;

    @Override
    public Auto someAutoMethod() {
        return repository.findByModel("Ferrari");
    }
}
