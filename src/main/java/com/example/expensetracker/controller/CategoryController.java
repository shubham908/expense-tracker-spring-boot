package com.example.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensetracker.entity.Category;
import com.example.expensetracker.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value = "/list-categories", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> listCategories() {
		List<Category> categoryList = categoryService.listCategories();

		return new ResponseEntity<>(categoryList, HttpStatus.OK);
	}
}
