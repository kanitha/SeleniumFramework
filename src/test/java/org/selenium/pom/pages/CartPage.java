package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
	//Page factory model
	@FindBy(xpath = "//td[@class='product-name']") private WebElement productName;
	
	@FindBy(css = ".checkout-button") @CacheLookup private WebElement checkOutButton;

	@FindBy(how = How.CSS, using = ".has-text-align-center") private WebElement cartHeadingText;
	
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLoaded(){
		return wait.until(ExpectedConditions.textToBePresentInElement(cartHeadingText, "Cart"));
	}
	
	public String getProductName() {
		return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
	}
	
	public CheckoutPage clickCheckoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButton)).click();
		return new CheckoutPage(driver);
	}
}
