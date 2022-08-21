package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String ParentWin = driver.getWindowHandle();
		
		System.out.println("Before clicking tab button " + ParentWin);
		
		WebElement Tab = driver.findElement(By.id("tabButton"));
		Tab.click();
		
		System.out.println("After clicking the tab button");
		
		Set<String> allWins = driver.getWindowHandles();
		
		for (String Win : allWins) {
			
			System.out.println(Win);
			
			if(!Win.equals(ParentWin)) {
		//	}else {
				driver.switchTo().window(Win);
			}
		}
		
		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println(childHeader.getText());
	   // driver.close();
	    driver.switchTo().window(ParentWin);
		WebElement WinBtn = driver.findElement(By.id("windowButton"));
		//System.out.println(childHeader.getText());
		WinBtn.click();  //two tab and one new window should open
	
		driver.quit();  //it will close all windows whereas driver.close() will close only the particular window
	
	}

}
