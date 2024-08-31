package com.stt.loginTests;

import com.stt.automation.BaseSTT;
import com.stt.pages.LoginPage;
import com.stt.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseSTT {
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void initializePages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Parameters({"username", "password"})
    @Test
    public void verifyLoginSuccess(String un, String pwd) {
        loginPage.login(un, pwd);
        Assert.assertEquals(productsPage.getNumberOfProducts(), 6);
    }
}
