package quote_details;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Quote_Runnable {
	
	@BeforeTest
	public static void launch() 
	{
		quote_function.launching();
	}
	@Test(priority=1)
	public static void login_fun() throws InterruptedException 
	{
		System.out.println("CASE1-LOGIN MODULE");
		System.out.println("******************");
		quote_function.login();
	}
	
	@Test(priority=2)
	public static void search_quote() throws InterruptedException, AWTException 
	{
		System.out.println("\nCASE2-QUOTATION SEARCH WITH VALID INPUT");
		System.out.println("******************************************");
		quote_function.quote_search();
	}
	
	@Test(priority=3)
	public static void search_fail() throws InterruptedException, AWTException 
	{
		System.out.println("\nCASE3-QUOTATION SEARCH WITH INVALID INPUT");
		System.out.println("********************************************");
		quote_function.search_failure();
	}
	
	@Test(priority=4)
	public static void result_search() throws InterruptedException, AWTException, ParseException 
	{
		System.out.println("\nCASE4-TO CHECK QUOTATION SEARCH RESULT DISPLAYED BASED ON DEADLINE DATE");
		System.out.println("*************************************************************************");
		quote_function.search_result();
	}
	
	@Test(priority=5)
	public static void details_quote() throws InterruptedException, AWTException
	{
		System.out.println("\nCASE5-VERIFY THE QUOTATION DETAILS");
		System.out.println("************************************");
		quote_function.quote_detail_page();
	}
	
	@Test(priority=6)
	public static void quote_detail_order()
	{
		System.out.println("\nCASE6-TO CHECK WHEATHER SUPPLIER DETAILS DISPLAYED BASED ON LOWEST PRICE");
		System.out.println("**************************************************************************");
		quote_function.details_page();
	}
	
	@Test(priority=7)
	public static void supplier_negotiate()
	{
		System.out.println("\nCASE7-TO CHECK WHEATHER FIRST TO QUOTE ONLY HAVE NEGOTIATE BUTTON ");
		System.out.println("**************************************************************************");
		quote_function.quote_negotiate();
	}

}
