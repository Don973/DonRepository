package com.shop.service.impl;

import com.shop.dao.ProductMapper;
import com.shop.domain.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductList() {

//        List<Product> productList = productMapper.selectByExample(null);

        List<Product> productList = productMapper.selectByExampleWithBLOBs(null);

        return productList;
    }

    @Override
    public Product getProductById(Integer id) {

        Product product = this.productMapper.selectByPrimaryKey(id);


        return product;
    }

    @Override
    public void updateItem(Product product) {
        int i = this.productMapper.updateByPrimaryKey(product);
    }
}
