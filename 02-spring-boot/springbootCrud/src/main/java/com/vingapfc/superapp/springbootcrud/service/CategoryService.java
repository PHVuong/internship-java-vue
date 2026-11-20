package com.vingapfc.superapp.springbootcrud.service;

import com.vingapfc.superapp.springbootcrud.entity.Category;
import com.vingapfc.superapp.springbootcrud.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Category với id: " + id));
    }

    public Category create(Category category) {
        category.setId(null);
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category categoryRequest) {
        Category existing = findById(id);
        existing.setName(categoryRequest.getName());
        existing.setDescription(categoryRequest.getDescription());
        return categoryRepository.save(existing);
    }

    public void deleteById(Long id) {
        Category existing = findById(id);
        categoryRepository.delete(existing);
    }
}