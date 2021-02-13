package com.example.expensetracker.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensetracker.entity.Category;
import com.example.expensetracker.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	private final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	public CategoryService(final CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> listCategories() {
		LOGGER.info("Returning list of categories");

		return categoryRepository.findAll();
	}
}
