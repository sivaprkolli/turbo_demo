package com.stt.pages;

import com.stt.utilities.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    WebDriver driver;
    SeleniumActions seleniumActions;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
        PageFactory.initElements(driver, this);
    }

    By products= By.cssSelector(".inventory_item_name ");

    @FindBy(css = ".inventory_item_name ")
    private List<WebElement> productsList;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    public int getNumberOfProducts(){
        return seleniumActions.getNumberOfElements(productsList);
    }

    public void selectProductAndAddToCart(String product){
        String addToCartButton = "//div[text()='%s']/ancestor::div[@class='inventory_item_label']/following-sibling::div/button";
        driver.findElement(By.xpath(String.format(addToCartButton, product))).click();
    }

    public String getCartBadge(){
        return seleniumActions.getTextMessage(cartBadge);
    }

}
