package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
	private final By searchField = By.id("woocommerce-product-search-field-0");
	private final By searchButton = By.cssSelector("button[value='Search']");
	private final By searchResultsTitle = By.xpath("//h1[contains(text(),'Search results: ')]");
	private final By viewCartLink = By.linkText("View cart");
	
	public StorePage(WebDriver driver) {
		super(driver);
	}
	
	public StorePage search(String searchText) {
		if(isLoaded()) {
			waitForElementToBeVisible(searchButton);
			enterTextInSearchField(searchText).clickSearchButton();
		}
		return this;
	}

	private boolean isLoaded() {
		return wait.until(ExpectedConditions.urlContains("/store"));
	}

	public String getSearchResultsTitle() {
		return waitForElementToBeVisible(searchResultsTitle).getText();
	}

	private StorePage enterTextInSearchField(String searchText) {
		driver.findElement(searchField).sendKeys(searchText);
		return this;
	}
	
	private StorePage clickSearchButton() {
		driver.findElement(searchButton).submit();
		return this;
	}
	
	private By getAddToCartButtonElement(String productName) {
		return By.xpath("//a[@aria-label='Add “" +productName+ "” to your cart']");
	}
	
	public StorePage clickAddToCartButton(String productName) {
		By addToCartButton = getAddToCartButtonElement(productName);
		driver.findElement(addToCartButton).click();
		return this;
	}
	
	public CartPage clickViewCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
		return new CartPage(driver);
	}
}
