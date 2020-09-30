package Keywords.commands;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Comandos {
		
	protected static String url ="https://www.webmotors.com.br/";
	
	public static void acessaHomePage(){		
	
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\workplace_eclipse\\DesafioWebMotors\\src\\main\\resources\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.get(url);

	}
}
