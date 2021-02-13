package com.example.expensetracker.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Category Controllers")
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@ApiOperation(value = "Get list of Expense Categories", response = Iterable.class)
	@RequestMapping(value = "/list-categories", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> listCategories() {
		List<Category> categoryList = categoryService.listCategories();

		return new ResponseEntity<>(categoryList, HttpStatus.OK);
	}
}
