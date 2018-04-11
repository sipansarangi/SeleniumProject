package renewbuy_Script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utility.DriverHelper;

public class HemlataTest extends DriverHelper { 
	@Test()
	public void tets022() throws InterruptedException, IOException 
	    
	{
		   driver.findElement(By.xpath("//*[@id='loginform']//*[@id='email']")).click();
	       driver.findElement(By.xpath("//*[@id='loginform']//*[@id='email']")).sendKeys("twinkle@gmail.com");
	       driver.findElement(By.xpath("//*[@id='loginform']//*[@id='password']")).click();
	       driver.findElement(By.xpath("//*[@id='loginform']//*[@id='password']")).sendKeys("Test@123");
	       Thread.sleep(3000);
	       driver.findElement(By.xpath("//*[@id='loginform']/button")).click();
	}

}
