package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> Rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("Total num of rows are " + Rows.size());
		
		List<WebElement> Columns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println("Total num of columns are " + Columns.size());
		
		WebElement Data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]/td[1]"));
		System.out.println("The required data is " + Data.getText());
       
//		for(WebElement row: Rows) {
//			List<WebElement> AllCell = row.findElements(By.tagName("td"));
//			
//			for(WebElement cell: AllCell) {
//				//List<WebElement> AllCell = row.findElements(By.tagName("td"));
//				System.out.print(cell.getText() + "\t");
//			}
//			System.out.println();
//			
//		}	
		
		for(int row=1; row<=Rows.size();row++) {
			for(int col=1; col<=Columns.size(); col++) {
				
				WebElement cell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + row + "]/*[" + col+ "]"));
				System.out.print(cell.getText() + "\t");
				
			}
			System.out.println();
		}
		
		String Company = "Island Trading";
				//WebElement Country = driver.findElement(By.xpath("//table[@id='customers')/tbody/)
		String Xpath = "//td[text()='" + Company + "']/following-sibling::td[2]";
		WebElement Country = driver.findElement(By.xpath(Xpath));
		System.out.println("The country is "+Country.getText());
		
		
	}

}
