package Assignment;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Assignment_Fitpeo {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
       //************ 1.Navigation to Fitpeo Homepage **********		
		driver.get("https://www.fitpeo.com");
		Thread.sleep(2000);
		
		//************ 2.Navigation to Fitpeo Homepage **********		
		driver.navigate().to("https://fitpeo.com/revenue-calculator");
		
		//************ 3.Scroll down to the slider **********		
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);		
		
		//************ 4.Adjust slider value 820  **********		
       WebElement slider=driver.findElement(By.xpath("//span[@data-index='0']"));         
	    Actions ac = new Actions(driver);
        ac.dragAndDropBy(slider, 93,0).perform();	
		Thread.sleep(2000);		

	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_RIGHT); 
	    r.keyRelease(KeyEvent.VK_RIGHT);
	    r.keyPress(KeyEvent.VK_RIGHT); 
	    r.keyRelease(KeyEvent.VK_RIGHT);
	    r.keyPress(KeyEvent.VK_RIGHT); 
	    r.keyRelease(KeyEvent.VK_RIGHT);
        Thread.sleep(1000);
	  	
        
		//********** 5.Update text field of value 560 **********		
	    driver.findElement(By.id(":R57alklff9da:")).clear();
        Thread.sleep(1000);
	    driver.findElement(By.id(":R57alklff9da:")).sendKeys("560");

	    JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,200)");
	    
        
		//*********** 6.Validate slider value **********		
        String slider_value = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[2]/p[2]")).getText();
        System.out.println("validate the slider value is reflected as entered value = " + slider_value);
        Thread.sleep(3000);

        
		//************ 7.Select CPT codes **********		        
        JavascriptExecutor jsc = (JavascriptExecutor)driver;
        jsc.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);

        //click on CPT-99091
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input")).click();
        Thread.sleep(2000);
        // click on CPT-99453
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]/input")).click();
        Thread.sleep(2000);
        JavascriptExecutor jjs = (JavascriptExecutor)driver;
        jjs.executeScript("window.scrollBy(0,400)");
        // click on CPT-99454
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]/input")).click();
        Thread.sleep(1000);
        JavascriptExecutor jss = (JavascriptExecutor)driver;
        jss.executeScript("window.scrollBy(0,800)");     
        // click on CPT-99474
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label/span[1]/input")).click();
        Thread.sleep(1000);

        
		//************ 8.validate Total Recurring Reimbursement ***********		   
        String data = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[3]/p[2]")).getText();
        System.out.println("Total Recurring Reimbursement =" + data); 
        Thread.sleep(2000);

        
		//************ 9.Total Recurring Reimbursement for all patients per month **********		              
        driver.findElement(By.id(":R57alklff9da:")).clear();
        Thread.sleep(1000);
	    driver.findElement(By.id(":R57alklff9da:")).sendKeys("820");
	    Thread.sleep(1000);

	    JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("window.scrollBy(0,300)");
        
        String Total_data = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[3]/p[2]")).getText();
        System.out.println("Total Recurring Reimbursement for all patients per monthh =" + Total_data); 
	    Thread.sleep(3000);

        driver.close();
	}
}