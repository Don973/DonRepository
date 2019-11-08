package com.shop.service;

import com.shop.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProductList();

    Product getProductById(Integer id);

    public void updateItem(Product product);
}
