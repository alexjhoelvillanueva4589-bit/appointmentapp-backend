package com.health.service.implementation;

import com.health.model.Category;
import com.health.repository.ICategoryRepository;
import com.health.repository.IGenericRepository;
import com.health.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends GenericService<Category, Integer> implements ICategoryService {

    @Autowired
    private ICategoryRepository repo;

    @Override
    protected IGenericRepository<Category, Integer> getRepo() {
        return repo;
    }
}
