package com.enotes.service.serviceimpl;

import com.enotes.entity.Category;
import com.enotes.repository.CategoryRepository;
import com.enotes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public Boolean SavedCategory(Category category) {
        Category savedCategory= repository.save(category);
        category.setCreatedBy(1);
        category.setCreatedAt(new Date());
        if(ObjectUtils.isEmpty(savedCategory))
        {
            return false;
        }
        return true;
    }

    @Override
    @GetMapping("category")
    public List<Category> getAllCategory() {
        List<Category>categories =repository.findAll();
        return categories;
    }
}
