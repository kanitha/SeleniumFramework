package org.selenium.pom.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	private final String baseUrl = "https://askomdch.com";
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	public void load(String endPoint) {
		driver.get(baseUrl + endPoint);
	}
	
	public void waitForOverlaysToDisappear(By overlayBlocksOrIcons) {
		List<WebElement> overlays = driver.findElements(overlayBlocksOrIcons);
		System.out.println("overlays found "+overlays.size());
		if(overlays.size()>0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("Overlays are invisible");
		} else {
			System.out.println("Overlays are not present in the current context");
		}
	}
	
	public WebElement waitForElementToBeVisible(By elementLocator) {
		WebElement webElement= wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return webElement;
	}
}
