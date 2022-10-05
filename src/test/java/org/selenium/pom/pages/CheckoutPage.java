package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.UserLogin;

public class CheckoutPage extends BasePage {
	private final By billingFirstNameField = By.xpath("//input[@name='billing_first_name']");
	private final By billingLastNameField = By.xpath("//input[@name='billing_last_name']");
	private final By billingAddress1Field = By.xpath("//input[@name='billing_address_1']");
	private final By billingCityField = By.cssSelector("input[name='billing_city']");
	private final By billingPostcodeField = By.id("billing_postcode");
	private final By billingEmailField = By.id("billing_email");
	private final By placeOrderButton = By.xpath("//button[@id='place_order']");
	private final By orderSuccessMessage = By.cssSelector(".woocommerce-notice");
	private final By clickHereToLoginLink = By.linkText("Click here to login");
	private final By userNameField = By.id("username");
	private final By passwordField = By.id("password");
	private final By loginButton = By.xpath("//button[contains(@class,'login__submit')]");
	private final By overlayInCheckoutPage = By.cssSelector(".blockUI.blockOverlay");
	private final By countryDropdownLocator = By.id("billing_country");
	private final By stateDropDownLocator = By.id("billing_state");
	private final By directBanktransferRadioBtn = By.id("payment_method_bacs");

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public CheckoutPage enterBillingAddress(BillingAddress billingAddress) {
			enterTextInbillingFirstNameField(billingAddress.getFirstName()).
			enterTextInbillingLastNameField(billingAddress.getLastName()).
			selectCountry(billingAddress.getCountry()).
			enterTextInbillingAddress1Field(billingAddress.getBillingAddress1()).
			enterTextInbillingCityField(billingAddress.getBillingCity()).
			selectState(billingAddress.getState()).
			enterTextInbillingPostcodeField(billingAddress.getBillingPostCode()).
			enterTextInbillingEmailField(billingAddress.getEmail());
		return this;
	}
	
	public CheckoutPage loginWithExistingUser(UserLogin existingUser) {
		enterTextInUsernameField(existingUser.getUsername()).enterTextInPasswordField(existingUser.getPassword()).clickLoginButton();
		return this;
	}
	
	private CheckoutPage enterTextInbillingFirstNameField(String billingFirstName) {
		WebElement firstName = waitForElementToBeVisible(billingFirstNameField);
		firstName.clear();
		firstName.sendKeys(billingFirstName);
		return this;
	}

	private CheckoutPage enterTextInbillingLastNameField(String billingLastName) {
		WebElement lastName = waitForElementToBeVisible(billingLastNameField);
		lastName.clear();
		lastName.sendKeys(billingLastName);
		return this;
	}

	private CheckoutPage enterTextInbillingAddress1Field(String billingAddress1) {
		WebElement address1 = waitForElementToBeVisible(billingAddress1Field);
		address1.clear();
		address1.sendKeys(billingAddress1);
		return this;
	}

	private CheckoutPage enterTextInbillingCityField(String billingCity) {
		WebElement city = waitForElementToBeVisible(billingCityField);
		city.clear();
		city.sendKeys(billingCity);
		return this;
	}

	private CheckoutPage enterTextInbillingPostcodeField(String billingPostcode) {
		WebElement postCode = waitForElementToBeVisible(billingPostcodeField);
		postCode.clear();
		postCode.sendKeys(billingPostcode);
		return this;
	}

	private CheckoutPage enterTextInbillingEmailField(String billingEmail) {
		WebElement email = waitForElementToBeVisible(billingEmailField);
		email.clear();
		email.sendKeys(billingEmail);
		return this;
	}
	
	private CheckoutPage selectCountry(String countryName) {
		Select countryDropDown = new Select(driver.findElement(countryDropdownLocator));
		countryDropDown.selectByVisibleText(countryName);
		return this;
	}
	
	private CheckoutPage selectState(String stateName) {
		Select stateDropDown = new Select(driver.findElement(stateDropDownLocator));
		stateDropDown.selectByValue(stateName);
		return this;
	}

	public CheckoutPage selectDirectBankTransferOption() {
		WebElement directBankTransfer = wait.until(ExpectedConditions.elementToBeClickable(directBanktransferRadioBtn));
		if(!directBankTransfer.isSelected()) {
			directBankTransfer.click();
		}
		return this;
	}

	public CheckoutPage clickPlaceOrderButton() {
		waitForOverlaysToDisappear(overlayInCheckoutPage);
		driver.findElement(placeOrderButton).click();
		return this;
	}
	
	public String getOrderSuccessMessage() {
		return waitForElementToBeVisible(orderSuccessMessage).getText();
	}
	
	public CheckoutPage loginForExistingCustomer() {
		waitForElementToBeVisible(clickHereToLoginLink).click();
		return this;
	}
	
	private CheckoutPage enterTextInUsernameField(String userName) {
		WebElement username = waitForElementToBeVisible(userNameField);
		username.clear();
		username.sendKeys(userName);
		return this;
	}
	
	private CheckoutPage enterTextInPasswordField(String passwordStr) {
		WebElement password = waitForElementToBeVisible(passwordField);
		password.clear();
		password.sendKeys(passwordStr);
		return this;
	}
	
	private CheckoutPage clickLoginButton() {
		driver.findElement(loginButton).click();
		return this;
	}
}
