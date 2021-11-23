package com.promotion.pojo;

public class Cart {
    private Product product;
    private Integer numberProduct;

    public Cart(Product product, Integer numberProduct) {
        this.product = product;
        this.numberProduct = numberProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getNumberProduct() {
        return numberProduct;
    }

    public void setNumberProduct(Integer numberProduct) {
        this.numberProduct = numberProduct;
    }
}
