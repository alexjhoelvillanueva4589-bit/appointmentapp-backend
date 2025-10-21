package com.health.service.implementation;

import com.health.model.Family;
import com.health.repository.IFamilyRepository;
import com.health.repository.IGenericRepository;
import com.health.service.IFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService extends GenericService<Family, Integer> implements IFamilyService {

    @Autowired
    private IFamilyRepository repo;

    @Override
    protected IGenericRepository<Family, Integer> getRepo() {
        return repo;
    }
}
