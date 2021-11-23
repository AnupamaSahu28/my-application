package com.promotion.services;

import com.promotion.pojo.Cart;
import com.promotion.pojo.Product;
import com.promotion.pojo.Promotion;

import java.util.List;
import java.util.Optional;

public class ProductWithPromotion implements PromotionCalculation{
    Integer totalPrice=0;
    @Override
    public Integer calculate(List<Promotion> promotions, List<Cart> cartList) {
        if (promotions.size() == 0) {
            for(Cart cart : cartList) {
                totalPrice += cart.getNumberProduct()* cart.getProduct().getPrice();
            }
        } else {
            for(Promotion promotion : promotions) {
                String promotionName = promotion.getProductName();
                if (!promotionName.contains("&")) {
                    Optional<Cart> optionCart = cartList.stream().filter(c -> c.getProduct()
                            .getProductName().equals(promotion.getProductName())).findFirst();
                    totalPrice += optionCart.get().getNumberProduct()/promotion.getItem()*promotion.getPromotionPrice()
                            + optionCart.get().getNumberProduct()%promotion.getItem()*optionCart.get().getProduct().getPrice();
                    cartList.remove(optionCart.get());
                } else {
                    String [] combineProductArr =  promotion.getProductName().split("&");
                    totalPrice += promotion.getPromotionPrice();
                    for(String name : combineProductArr) {
                        Optional<Cart> optionCart = cartList.stream().filter(cart -> cart.getProduct().getProductName().equals(name)).findFirst();
                        if (optionCart.get().getNumberProduct() > 1) {
                            totalPrice += optionCart.get().getNumberProduct()-promotion.getItem() * optionCart.get().getProduct().getPrice();
                        }
                        cartList.remove(optionCart.get());
                    }
                }
            }
            for(Cart cart : cartList) {
                totalPrice += cart.getNumberProduct()* cart.getProduct().getPrice();
            }
        }
        return totalPrice;
    }
}
