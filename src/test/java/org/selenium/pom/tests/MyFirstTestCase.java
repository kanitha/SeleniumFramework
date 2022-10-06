 package org.selenium.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Products;
import org.selenium.pom.objects.UserLogin;
import org.selenium.pom.pages.*;
import org.selenium.pom.utils.JacksonUtils;
import java.io.IOException;

public class MyFirstTestCase extends BaseTest{
	
	@Test
	public void guestCheckoutUsingDirectBankTransfer() throws IOException {
		
		String searchFor = "Blue";
		BillingAddress billingAddress = JacksonUtils.deserializeJson("MyBillingAddress.json", BillingAddress.class);
		Products product = new Products(1215, "Products.json");
		
		StorePage storePage = new HomePage(driver).
								loadPage("/").
								navigateToStoreUsingMenu().
								search(searchFor);		
		
		Assert.assertTrue(storePage.getSearchResultsTitle().contains(searchFor));
		storePage.clickAddToCartButton(product.getProductName());

		CartPage cartPage = storePage.clickViewCartButton();
		if(cartPage.isLoaded()) {
			Assert.assertEquals(cartPage.getProductName(), product.getProductName());
		}
		
		CheckoutPage checkoutPage = cartPage.
										clickCheckoutButton().
										enterBillingAddress(billingAddress).
										selectDirectBankTransferOption().
										clickPlaceOrderButton();
		
		Assert.assertEquals(checkoutPage.getOrderSuccessMessage(), "Thank you. Your order has been received.");
	}
	
	@Test(enabled=true)
	public void loginAndGuestCheckoutUsingDirectBankTransfer() throws IOException {
		
		String searchFor = "Blue";
		BillingAddress billingAddress = JacksonUtils.deserializeJson("MyBillingAddress.json", BillingAddress.class);
		Products product = new Products(1215, "Products.json");
		UserLogin testUser = new UserLogin("automation@test.com", "automation");
		
		StorePage storePage = new HomePage(driver).
								loadPage("/").
								navigateToStoreUsingMenu().
								search(searchFor);
		
		Assert.assertTrue(storePage.getSearchResultsTitle().contains(searchFor));
		storePage.clickAddToCartButton(product.getProductName());

		CartPage cartPage = storePage.clickViewCartButton();
		if(cartPage.isLoaded()) {
			Assert.assertEquals(cartPage.getProductName(),product.getProductName());
		}
		
		CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
		checkoutPage.loginForExistingCustomer().
					loginWithExistingUser(testUser).
					enterBillingAddress(billingAddress).
					selectDirectBankTransferOption().
					clickPlaceOrderButton();
		
		Assert.assertEquals(checkoutPage.getOrderSuccessMessage(), "Thank you. Your order has been received.");
	}
}
