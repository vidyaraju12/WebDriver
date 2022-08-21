package Phase1Project;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement Search = driver.findElement(By.id("twotabsearchtextbox"));
		Search.sendKeys("Samsung");

		WebElement submit = driver.findElement(By.id("nav-search-submit-button"));
		submit.click();

		List<WebElement> Product = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2/a"));
		System.out.println("Total Product links are " + Product.size());	
		List<WebElement> Price = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']"));

		for(int i=0;i<Product.size();i++) {
			System.out.println(Product.get(i).getText()+ "Price :Rupees");
			System.out.println(Price.get(i).getText());
		}

		String Validate = Product.get(0).getText();
		System.out.println(Validate);

		Product.get(0).click();

		String ParentWin = driver.getWindowHandle();

		Set<String> allWins = driver.getWindowHandles();
		System.out.println("Before clicking tab button " + ParentWin);
		for (String Win : allWins) {

			System.out.println(Win);

			if(!Win.equals(ParentWin)) {
				//	}else {
				driver.switchTo().window(Win);
			}
		}

		WebElement NewTab = driver.findElement(By.xpath("//div[@id='title_feature_div']//span"));
		String NewString = NewTab.getText();
		System.out.println(NewString);

		if(NewString.equals(Validate)) {
			System.out.println("Received Expected Result");
		}else {
			System.out.println("Incorrect result");
		}

	}

}
