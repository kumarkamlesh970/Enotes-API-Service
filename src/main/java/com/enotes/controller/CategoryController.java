package com.enotes.controller;

import com.enotes.entity.Category;
import com.enotes.service.serviceimpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CategoryController {

     @Autowired
     private CategoryServiceImpl categoryService;

    @PostMapping ("/save")
    public ResponseEntity<?>saveCategory(@RequestBody Category category) {

      Boolean saveCategory =categoryService.SavedCategory(category);
      if(saveCategory) {
          return new ResponseEntity<>("saved", HttpStatus.CREATED);
      }else {
          return new ResponseEntity<>("not saved ",HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?>getAllCategory() {

        List<Category> allCategory = categoryService.getAllCategory();
        if (CollectionUtils.isEmpty(allCategory)) {
            return ResponseEntity.noContent().build();

        } else {
            return new ResponseEntity<>(allCategory,HttpStatus.OK);
        }
    }
}
