package com.promotion.pojo;

public class Promotion {
    private String productName;
    private Integer item;

    public Promotion(String productName, Integer item, Integer promotionPrice) {
        this.productName = productName;
        this.item = item;
        this.promotionPrice = promotionPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Integer promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    private Integer promotionPrice;
}
