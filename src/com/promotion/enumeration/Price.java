package com.promotion.enumeration;

public enum Price {
    A_Product("A", 50),
    B_Product("B", 30),
    C_Product("C", 20),
    D_Product("D", 15);
    //Instance variable
    private Integer price;
    private String productName;
    //Constructor to initialize the instance variable
    Price(String productName, Integer price) {
        this.productName = productName;
        this.price = price;
    }
    public Integer getPrice() {
        return this.price;
    }
    public String getProductName() {
        return this.productName;
    }
}
