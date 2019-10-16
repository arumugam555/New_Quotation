package quote_details;

import org.openqa.selenium.By;

public class locators {
	
	    //login
		public static By uname_xpath=By.xpath("//*[@id=\"login_email\"]");
		public static By pwd_xpath=By.xpath("//*[@id=\"login_passwd\"]");
		public static By signin_xpath=By.xpath("//*[@id=\"SubmitDashLogin\"]");
		
		//search
		public static By menu_xpath=By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[2]/ul/li[5]/div/a");
		public static By search_xpath=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/table/thead/tr/th[7]/input");
		public static By search_res_cname=By.className("name");
		public static By deadline=By.className("deadline");
		
		//search_failure
		public static By result_xpath=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/table/tbody/tr/td/div");
		
		//search_result
		public static By action_btn=By.xpath("//*[@id=\"156_id\"]/td[7]");
		public static By pro_name=By.xpath("//*[@id=\"156_id\"]/td[3]");
		public static By ref_no=By.xpath("//*[@id=\"156_id\"]/td[1]");
		public static By pro_qty=By.xpath("//*[@id=\"156_id\"]/td[4]");
		public static By pro_dead_date=By.xpath("//*[@id=\"156_id\"]/td[4]");
		public static By pro_pay=By.xpath("//*[@id=\"156_id\"]/td[5]");
		public static By quote_button=By.xpath("//*[@id=\"156_id\"]/td[7]/button");
		//search_result_compare
		public static By dpro_name=By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[1]/p[1]");
		public static By dref_no=By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[1]/p[2]");
		public static By dpro_qty=By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/p[2]");
		public static By dpro_dead_date=By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/p[2]");
		public static By dpro_pay=By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/p[2]");
		
		//supplier details
		public static By dsupp_price=By.xpath("//td[@data-title='Price']");
		
		//Quote Accept and Negotiate
		public static By supp_negotiate=By.className("button-black");

}
