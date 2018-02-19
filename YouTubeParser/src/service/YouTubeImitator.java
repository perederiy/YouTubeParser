package service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import model.Orators;

public class YouTubeImitator {
	
	public static final String URL = "https://www.youtube.com";
	
	public static WebDriver getWebDriver() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + System.getProperty("file.separator") + "chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		WebDriver chromeDriver = new ChromeDriver(options);
		
		chromeDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		
		return chromeDriver;
		
	}
	

	public ArrayList<Orators> searchOratorsParts(String urlYT, String number) {

		ArrayList<Orators> list = new ArrayList<Orators>();
		
		if(urlYT == "") {
			return null;
		}else {
			
			WebDriver driver = getWebDriver();
			driver.get(urlYT);
			Timer.getTimeInSec(5);
			
			for(int i=0; i<Integer.parseInt(number); i++) {
			JavascriptExecutor jsp = (JavascriptExecutor)driver;
			jsp.executeScript("window.scrollBy(0,10000)", "");
			Timer.getTimeInSec(5);
			}
			
			WebElement content = driver.findElement(By.id("contents"));
			List<WebElement> elements = content.findElements(By.id("dismissable"));
			for (WebElement element : elements) {
				Orators orators = new Orators(); 
				WebElement metaElement = element.findElement(By.id("meta"));
				WebElement aElement = metaElement.findElement(By.id("video-title"));
				 String name = aElement.getText();
				 String url = aElement.getAttribute("href");
				 	if(!aElement.getAttribute("href").contains(URL)) {
				 		url = URL + url;
				 	}
				 	orators.setName(name);
				 	orators.setUrl(url);
				 	list.add(orators);
				 	
			}
			
			Timer.getTimeInSec(Integer.parseInt(number)*3);
			driver.quit();
		}
	return list;
	}
	
}
