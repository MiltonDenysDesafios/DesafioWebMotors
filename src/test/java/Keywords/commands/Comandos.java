package Keywords.commands;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.lang.Object;
import javax.xml.datatype.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import ru.stqa.selenium.factory.WebDriverPool;
import org.openqa.selenium.support.FindBy;


public class Comandos{
		
	protected static String url ="https://www.webmotors.com.br/";
	protected static List<Map<String, String>> issue_info;
	private static WebDriver driver;


	
	
	public static void acessaHomePage(DataTable data){		
		issue_info =  data.asMaps(String.class, String.class);

		//WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\workplace_eclipse\\DesafioWebMotors\\src\\main\\resources\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();		
        driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	
	public static void preencheCampoBuscar() {
		String marca = issue_info.get(0).get("MARCA");
		String buscar = "//*[@id=\"searchBar\"]";
		preencher(buscar,marca);
		
	}
	
	
	public static void finalizar() {
		
		driver.quit();
	}
	
	public static void preencher(String xpath,String value){
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Element = driver.findElement(By.xpath(xpath));
		Element.sendKeys(value);
		
	}
	
	public static void clicarOkCookies() {
		
		String cookies = "//*[@id='root']/div[3]/div[2]/button";
		clicar(cookies);
	}
	
	public static void clicar(String xpath) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Element = driver.findElement(By.xpath(xpath));
		Element.click();
		//driver.findElement(By.xpath(xpath)).click();
		

		//WebElement Element = findElement(By.xpath(xpath));

	}
	
	
	
	
}
