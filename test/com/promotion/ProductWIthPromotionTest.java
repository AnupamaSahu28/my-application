package test.com.promotion;

import com.promotion.enumeration.Price;
import com.promotion.pojo.Cart;
import com.promotion.pojo.Product;
import com.promotion.pojo.Promotion;
import com.promotion.services.ProductWithPromotion;
import com.promotion.services.PromotionCalculation;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class ProductWIthPromotionTest {

    @Test
    public void withoutPromotion() {
        List<Cart> cartList = new ArrayList<>();
        List<Promotion> promotions = new ArrayList<>();

        cartList.add(new Cart(new Product(Price.A_Product.getProductName(), Price.A_Product.getPrice()), 1));
        cartList.add(new Cart(new Product(Price.B_Product.getProductName(), Price.B_Product.getPrice()), 1));
        cartList.add(new Cart(new Product(Price.C_Product.getProductName(), Price.C_Product.getPrice()), 1));

        PromotionCalculation promotionCalculation = new ProductWithPromotion();
        Integer totalPrice = promotionCalculation.calculate(promotions, cartList);
        assertTrue(totalPrice == 100);
    }

    @Test
    public void withPromotion() {
        List<Cart> cartList = new ArrayList<>();
        List<Promotion> promotions = new ArrayList<>();

        promotions.add(new Promotion(Price.A_Product.getProductName(), 3, 130));
        promotions.add(new Promotion(Price.B_Product.getProductName(), 2, 45));
        cartList.add(new Cart(new Product(Price.A_Product.getProductName(), Price.A_Product.getPrice()), 5));
        cartList.add(new Cart(new Product(Price.B_Product.getProductName(), Price.B_Product.getPrice()), 5));
        cartList.add(new Cart(new Product(Price.C_Product.getProductName(), Price.C_Product.getPrice()), 1));

        PromotionCalculation promotionCalculation = new ProductWithPromotion();
        Integer totalPrice = promotionCalculation.calculate(promotions, cartList);
        assertTrue(totalPrice == 370);
    }
    @Test
    public void promotionWithMultipleProduct() {
        List<Cart> cartList = new ArrayList<>();
        List<Promotion> promotions = new ArrayList<>();

        promotions.add(new Promotion(Price.A_Product.getProductName(), 3, 130));
        promotions.add(new Promotion(Price.B_Product.getProductName(), 2, 45));
        promotions.add(new Promotion(Price.C_Product.getProductName()+ "&" + Price.D_Product.getProductName(), 1, 30));
        cartList.add(new Cart(new Product(Price.A_Product.getProductName(), Price.A_Product.getPrice()), 3));
        cartList.add(new Cart(new Product(Price.B_Product.getProductName(), Price.B_Product.getPrice()), 5));
        cartList.add(new Cart(new Product(Price.C_Product.getProductName(), Price.C_Product.getPrice()), 1));
        cartList.add(new Cart(new Product(Price.D_Product.getProductName(), Price.D_Product.getPrice()), 1));

        PromotionCalculation promotionCalculation = new ProductWithPromotion();
        Integer totalPrice = promotionCalculation.calculate(promotions, cartList);
        assertTrue(totalPrice == 280);
    }
}
