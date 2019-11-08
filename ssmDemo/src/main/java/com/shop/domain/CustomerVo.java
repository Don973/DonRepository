package com.shop.domain;

import java.util.Arrays;
import java.util.List;

public class CustomerVo {
    private User user;
    private Product product;
    private String [] ids;
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CustomerVo{" +
                "user=" + user +
                ", product=" + product +
                ", ids=" + Arrays.toString(ids) +
                ", products=" + products +
                '}';
    }
}
