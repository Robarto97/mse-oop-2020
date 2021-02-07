package Final.FinalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Robart Petrov
 *
 */
public class Selenium {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My\\Desktop\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1400,800");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.monster.com/jobs/q-administrative-jobs?jobid=f67acfbc-bfff-46bf-9c8f-f8e70b3b3721");
		WebElement findElement = driver.findElement(
				By.cssSelector("#JobDescription > table:nth-child(1) > tbody > tr > td > div > b:nth-child(1)"));
		System.out.println(findElement.getText());
	}

}
