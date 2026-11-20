package com.vingapfc.superapp.springbootcrud.controller;

import com.vingapfc.superapp.springbootcrud.entity.Category;
import com.vingapfc.superapp.springbootcrud.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController = @Controller + @ResponseBody: nhận HTTP request và tự chuyển dữ liệu trả về thành JSON
@RestController
// Đường dẫn gốc cho toàn bộ endpoint của Category
@RequestMapping("/api/categories")
public class CategoryController {

    // Tầng nghiệp vụ; dùng final để đảm bảo dependency được khởi tạo đầy đủ qua constructor
    private final CategoryService categoryService;

    // Spring tự động inject CategoryService vào controller khi khởi tạo bean
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // [READ ALL] GET /api/categories -> trả về danh sách tất cả danh mục (HTTP 200 OK)
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    // [READ ONE] GET /api/categories/{id} -> lấy chi tiết 1 danh mục theo id trên URL (HTTP 200 OK)
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    // [CREATE] POST /api/categories -> đọc JSON body thành Category, tạo mới và trả về HTTP 201 Created
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category created = categoryService.create(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // [UPDATE] PUT /api/categories/{id} -> lấy id trên URL + JSON body mới để cập nhật (HTTP 200 OK)
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        Category updated = categoryService.update(id, category);
        return ResponseEntity.ok(updated);
    }

    // [DELETE] DELETE /api/categories/{id} -> xóa danh mục theo id và trả về HTTP 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}