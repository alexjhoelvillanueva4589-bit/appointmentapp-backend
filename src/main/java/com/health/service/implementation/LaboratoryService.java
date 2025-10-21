package com.health.service.implementation;

import com.health.model.Laboratory;
import com.health.repository.ILaboratoryRepository;
import com.health.repository.IGenericRepository;
import com.health.service.ILaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratoryService extends GenericService<Laboratory, Integer> implements ILaboratoryService {

    @Autowired
    private ILaboratoryRepository repo;

    @Override
    protected IGenericRepository<Laboratory, Integer> getRepo() {
        return repo;
    }
}
