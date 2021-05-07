package com.simplilearn.service;

import java.math.BigDecimal;
import java.util.Map;

import com.simplilearn.exception.NotEnoughProductsInStockException;
import com.simplilearn.model.Product;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();
}
