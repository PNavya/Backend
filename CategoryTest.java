package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

public class CategoryTest {
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		CategoryDAO categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
		Category category= (Category) context.getBean("category");
		category.setId("CG001");
		category.setName("Navya");
		category.setDescription("This is category 001 description");
		if(categoryDAO.save(category)==true)
		{
			System.out.println("Category created successfully");
		}
		else
		{
			System.out.println("Not able create the category");

		
		}

		
		
	}

}
