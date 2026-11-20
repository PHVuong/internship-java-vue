package com.vingapfc.superapp.productservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CategoryClient {

    private final RestClient restClient;

    public CategoryClient(@Value("${category.service.url}") String categoryServiceUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(categoryServiceUrl)
                .build();
    }

    public CategoryDto getCategoryById(Long categoryId) {
        return restClient.get()
                .uri("/api/categories/{id}", categoryId)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new IllegalArgumentException("Không tìm thấy Category với id = " + categoryId);
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new IllegalStateException("Lỗi từ category-service khi lấy Category id = " + categoryId);
                })
                .body(CategoryDto.class);
    }

    public record CategoryDto(Long id, String name, String description) {
    }
}