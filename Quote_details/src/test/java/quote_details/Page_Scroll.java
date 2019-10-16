package quote_details;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Page_Scroll {
	
	public static void page_up() throws InterruptedException, AWTException {
		
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_PAGE_UP);
		  robot.keyRelease(KeyEvent.VK_PAGE_UP);
		  Thread.sleep(2000);
		
	}

}
