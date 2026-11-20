package com.vingapfc.superapp.productservice.service;

import com.vingapfc.superapp.productservice.client.CategoryClient;
import com.vingapfc.superapp.productservice.client.CategoryClient.CategoryDto;
import com.vingapfc.superapp.productservice.entity.Product;
import com.vingapfc.superapp.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryClient categoryClient;

    public ProductService(ProductRepository productRepository, CategoryClient categoryClient) {
        this.productRepository = productRepository;
        this.categoryClient = categoryClient;
    }

    public record ProductResponse(
            Long id,
            String name,
            Double price,
            Long categoryId,
            String categoryName
    ) {
    }

    public ProductResponse create(Product request) {
        CategoryDto category = categoryClient.getCategoryById(request.getCategoryId());
        if (category == null) {
            throw new IllegalArgumentException("Không tìm thấy Category với id = " + request.getCategoryId());
        }

        request.setId(null);
        Product saved = productRepository.save(request);
        return toResponse(saved, category.name());
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(product -> {
                    CategoryDto category = categoryClient.getCategoryById(product.getCategoryId());
                    String categoryName = (category != null) ? category.name() : null;
                    return toResponse(product, categoryName);
                })
                .toList();
    }

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Product với id = " + id));

        CategoryDto category = categoryClient.getCategoryById(product.getCategoryId());
        String categoryName = (category != null) ? category.name() : null;
        return toResponse(product, categoryName);
    }

    private ProductResponse toResponse(Product product, String categoryName) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategoryId(),
                categoryName
        );
    }
    public ProductResponse update(Long id, Product request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Product với id = " + id));

        CategoryDto category = categoryClient.getCategoryById(request.getCategoryId());
        if (category == null) {
            throw new IllegalArgumentException("Không tìm thấy Category với id = " + request.getCategoryId());
        }

        existing.setName(request.getName());
        existing.setPrice(request.getPrice());
        existing.setCategoryId(request.getCategoryId());

        Product updated = productRepository.save(existing);
        return toResponse(updated, category.name());
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Không tìm thấy Product với id = " + id);
        }
        productRepository.deleteById(id);
    }
}
