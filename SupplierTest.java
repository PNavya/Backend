package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.model.Supplier;

public class SupplierTest {
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		SupplierDAO supplierDAO= (SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier= (Supplier) context.getBean("supplier");
		supplier.setId("S001");
		supplier.setName("Navya");
		supplier.setAddress("hyd");
		if(supplierDAO.save(supplier)==true)
		{
			System.out.println("Supplier created successfully");
		}
		else
		{
			System.out.println("Not able create the supplier");

		
		}

		
		
	}

}
