package com.enotes.service;

import com.enotes.entity.Category;

import java.util.List;

public interface CategoryService {

     Boolean  SavedCategory(Category category);
     List<Category> getAllCategory();

}
