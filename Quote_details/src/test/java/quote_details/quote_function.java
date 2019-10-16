package quote_details;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class quote_function {
	
	public static WebDriver driver;
	public static void launching()
	{
		System.setProperty("webdriver.chrome.driver", User_Input.chrome_path);
		driver=new ChromeDriver();
		driver.get(User_Input.url);
		driver.manage().window().maximize();
	}
	
	public static void login() throws InterruptedException
	{
		driver.findElement(locators.uname_xpath).sendKeys(User_Input.login_uname);
		driver.findElement(locators.pwd_xpath).sendKeys(User_Input.login_pwd);
		driver.findElement(locators.signin_xpath).click();
		Thread.sleep(1000);
		String actualurl=User_Input.url;
		String expectedurl=driver.getCurrentUrl();
		if(actualurl.equals(expectedurl))
		{
		  System.out.println("Login Failed");
		}
		else
		{
		   System.out.println("Login successfully");
		   Thread.sleep(1000);
		}
		driver.findElement(locators.menu_xpath).click();
		Thread.sleep(2000);
		
	}
	
	public static void quote_search() throws InterruptedException, AWTException
	{
		
		driver.findElement(locators.search_xpath).sendKeys(User_Input.search_input);
		driver.findElement(locators.search_xpath).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	     JavascriptExecutor jse = (JavascriptExecutor)driver;
	     for (int second = 0;; second++) 
	     {
	        if(second >=20)
	        {
	          break;
	        }
	        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        Thread.sleep(2000);
	     }
		Page_Scroll.page_up();
		
		List<WebElement> name = driver.findElements(locators.search_res_cname);

		  for (WebElement result:name) {
		       
			  System.out.println(result.getText());
			  Assert.assertTrue(result.getText().indexOf(User_Input.search_input)!=-1? true: false);

		  }		 
		
	}
	
    public static void search_failure() throws InterruptedException, AWTException {
    	  
    	  Thread.sleep(2000);
		   
    	  Page_Scroll.page_up();
		  
		  Thread.sleep(2000);
    	
		  driver.findElement(locators.search_xpath).clear();
		  
		  driver.findElement(locators.search_xpath).sendKeys("wertyui");
		  
		  driver.findElement(locators.search_xpath).sendKeys(Keys.ENTER);
		  
		  String noresult="No Quotations Found!";
		  Thread.sleep(3000);
		  //WebElement result_no=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/table/tbody/tr/td/div"));
		  String nores_text=driver.findElement(locators.result_xpath).getText();
		  Thread.sleep(2000);
		  System.out.println(nores_text);
		  
		  if(nores_text.contains(noresult)) {
			  
			  System.out.println("Success");
		  }else {
			  System.out.println("Not Success");
		  }
    }
	
	public static void search_result() throws ParseException, InterruptedException, AWTException {
		  driver.findElement(locators.search_xpath).clear();
		  driver.navigate().refresh();
          DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
          Thread.sleep(2000);
		  Date date = new Date();
		  String cdate1= dateFormat.format(date);
		  Date cdate2=dateFormat.parse(cdate1);
		  
		  Thread.sleep(2000);
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  for (int second = 0;; second++) 
		  {
		      if(second >=20)
		      {
		        break;
		      }
		      jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		      Thread.sleep(2000);
		   }
		  Page_Scroll.page_up();
		  
		  List<WebElement> deadline_date = driver.findElements(By.className("deadline"));
		  int i=0;
		  
		  for (WebElement result:deadline_date) 
		  {
			  
			  String date_dead=result.getText();
			  
			  i=i+1;			  
			  SimpleDateFormat dateFormat1 = new SimpleDateFormat("d, MMM yyyy"); 
			  Date varDate1=dateFormat1.parse(date_dead); 
			  dateFormat1=new SimpleDateFormat("dd-MM-yyyy"); 
			  String Final_admitDT=dateFormat1.format(varDate1);			  
			  Date varDate2=dateFormat1.parse(Final_admitDT);  
			  
			  System.out.println(varDate2);
		  
		        if (varDate2.before(cdate2)) 
		        { 
		        		 
		        	WebElement ref_num=driver.findElement(By.xpath(User_Input.beforexpath+i+User_Input.afterxpath));
		        	System.out.println("Ref Num of No and Recevied Quotations="+ref_num.getText()); 
		        		 
		        }
		        
		        if (varDate2.after(cdate2)) 
		        { 					  
			            
		        	 WebElement ref_num1=driver.findElement(By.xpath(User_Input.beforexpath+i+User_Input.afterxpath));
				     System.out.println("Ref Num of Awating Quotation="+ref_num1.getText());
			    } 
		        
		        if (varDate2.equals(cdate2)) 
		        { 					  
		            
	        	      WebElement ref_num2=driver.findElement(By.xpath(User_Input.beforexpath+i+User_Input.afterxpath));
					  System.out.println("Ref Num of Awating Quotation="+ref_num2.getText());
		       } 			  
		  }	
	}
	
	public static void quote_detail_page() throws InterruptedException, AWTException
	{
		  Thread.sleep(2000);
		  Page_Scroll.page_up();
		  Thread.sleep(3000);
		  WebElement action_btn= driver.findElement(locators.action_btn);
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", action_btn);
		  Thread.sleep(2000);
		  String product_name=driver.findElement(locators.pro_name).getText();
		  String reference_no=driver.findElement(locators.ref_no).getText();
		  String product_qty=driver.findElement(locators.pro_qty).getText();
		  String product_date=driver.findElement(locators.pro_dead_date).getText();
		  String product_payment=driver.findElement(locators.pro_pay).getText();
		  
		  System.out.println(product_name);
		  System.out.println(reference_no);
		  System.out.println(product_qty);
		  System.out.println(product_date);
		  System.out.println(product_payment);
		  
		  driver.findElement(locators.quote_button).click();	 
		  Thread.sleep(5000);
		  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		  driver.switchTo().window(tabs2.get(1));
		  Thread.sleep(3000);
		  
		  String prodet_name=driver.findElement(locators.dpro_name).getText();
		  String prodet_refno=driver.findElement(locators.dref_no).getText();
		  String prodet_qty=driver.findElement(locators.dpro_pay).getText();
		  String prodet_date=driver.findElement(locators.dpro_dead_date).getText();
		  String prodet_payment=driver.findElement(locators.dpro_pay).getText();
		  
		  
		  if(product_name.equals(prodet_name)) 
		  {
			    System.out.println("Product name is Matching");
		  } else 
		  {
			    System.out.println("Product name is not Matching");
		  }
		  
		  if(reference_no.equals(prodet_refno)) 
		  {
			   System.out.println("Reference Number is Matching");
		  } else 
		  {
				System.out.println("Reference Number is not Matching");
		  }
		  
		  if(product_qty.equals(prodet_qty)) 
		  {
			   System.out.println("Quantity is Matching");
		  } else 
		  {
				System.out.println("Quantity is not Matching");
		  }
		  
		  if(product_date.equals(prodet_date)) 
		  {
			   System.out.println("Dead Line is Matching");
		  } else 
		  {
				System.out.println("Dead Line is not Matching");
		  }
		  
		  if(product_payment.equals(prodet_payment)) 
		  {
			   System.out.println("Payment Method is Matching");
		  } else 
		  {
				System.out.println("Payment Method is not Matching");
		  }
	}
	
	public static void details_page() 
	{
		List<WebElement> price = driver.findElements(locators.dsupp_price);
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price)
		{
			
			if(e.getText().equals(User_Input.not_app)) {
				
				prices.remove(e.getText());
				
			}else {
				//
				String quote_price=e.getText();
				String fin_price=quote_price.substring(3);
				//int final_price=Integer.parseInt(fin_price);  
				System.out.println(fin_price);
				prices.add(fin_price);
			}
		   
		}
		List<String> sortedPrices = new ArrayList<String>(prices);
		Collections.sort(sortedPrices);
		if(sortedPrices.equals(prices)) {
			
			System.out.println("Supplier Quote details displayed based on minimum price");
		}else {
			
			System.out.println("Not Successfull some error occured");
		}
		
	}
	
	public static void quote_negotiate() {
		List<WebElement> button_text = driver.findElements(locators.supp_negotiate);
		//int counts=0;
		for (WebElement btn_txt : button_text)
		{
			System.out.println(btn_txt.getText());
			/*String nego_txt=btn_txt.getText();
			if(nego_txt.equals(User_Input.negotiate_txt)) {
				counts=counts+1;
				System.out.println("Total Count of Negotiate Button is:"+counts);
			}*/
			//System.out.println(driver.findElement(By.className("action")).getText());
		}
	}

}
