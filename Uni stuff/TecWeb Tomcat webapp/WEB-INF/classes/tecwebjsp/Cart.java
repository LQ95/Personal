package tecwebjsp;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
class Product{
	private String Name;
	private float Price;
	
	public Product(){
		Name="";
		Price=0.00f;
	}
	
	public void setPrice(float p){
		Price=p;
	}
	
	public void setName(String n){
		Name=n;
	}
	
	public float getPrice(){
		return Price;
	}
	
	public String getName(){
		return Name;
	}
	
	public String toString(){
		return Name +", "+ Price;
	}
}

public class Cart{
	private Product[] Products;
	private int numberOfItems;
	
	public void setProducts(Product[] ProductList)
	{
		Products=ProductList;
	}
	
	public Cart(){
		Products=new Product[300];
		numberOfItems=0;
	}
	
	public void addProduct(Product P)
	{
		if(numberOfItems<Products.length){
			Products[numberOfItems]=P;
			setnumberOfItems(numberOfItems=+ 1);
		}
	}
	
	public void print(HttpServletResponse response)throws IOException{
		int i;
		PrintWriter out = response.getWriter();
		for(i=0;i<numberOfItems;i++){
		out.println(Products[i].toString());
		out.println("<br>");
		}
	}
	
	public void setnumberOfItems(int index){
		numberOfItems=index;
	}
	
	public int getnumberOfItems(){
		return numberOfItems;
	}
}

