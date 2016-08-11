package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.model.Product;

public class ProductTest {
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		ProductDAO productDAO= (ProductDAO) context.getBean("productDAO");
		Product product= (Product) context.getBean("product");
		product.setId("P001");
		product.setName("Navya");
		product.setDescription("This is product 001 description");
		product.setPrice(250);
		if(productDAO.save(product)==true)
		{
			System.out.println("Product created successfully");
		}
		else
		{
			System.out.println("Not able create the product");

		
		}

		
		
	}

}
