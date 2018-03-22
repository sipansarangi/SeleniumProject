package renewbuy_Script;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HemlataTest {
	@Test()
	public void tets022() throws InterruptedException 
	    
	{
		   WebDriver driver = new FirefoxDriver();
		   driver.get("https://testlink.renewbuy.com");
		   driver.findElement(By.id("tl_login")).sendKeys("admin");
	       driver.findElement(By.id("tl_password")).sendKeys("admin");
	       driver.findElement(By.xpath("//*[@type='submit']")).click();
	       Thread.sleep(3000);
	       driver.findElement(By.xpath("html/body/div[3]/div[2]/a[1]")).click();
	}

}
