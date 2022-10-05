package org.selenium.pom.objects;

import java.io.IOException;

import org.selenium.pom.utils.JacksonUtils;

public class Products {
	private int productId;
	private String productName;
	
	public Products() {}
	
	public Products(int productId, String productNamesDataSourceFileName) throws IOException {
		Products[] products = JacksonUtils.deserializeJson(productNamesDataSourceFileName, Products[].class);
		for(Products product: products) {
			if(product.getProductId() == productId) {
				this.productId = productId;
				this.productName = product.getProductName();
			}
		}
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}	
}
