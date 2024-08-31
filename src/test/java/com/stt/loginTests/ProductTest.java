package com.stt.loginTests;

import com.stt.automation.BaseSTT;
import com.stt.pages.LoginPage;
import com.stt.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductTest extends BaseSTT {

    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void initializePages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void addProductToCart(){
        productsPage.selectProductAndAddToCart("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(productsPage.getCartBadge(),"2");
    }
}
