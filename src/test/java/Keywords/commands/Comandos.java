package Keywords.commands;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

import java.lang.Object;
import javax.xml.datatype.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import ru.stqa.selenium.factory.WebDriverPool;
import org.openqa.selenium.support.FindBy;


public class Comandos{
		
	protected static String url ="https://www.webmotors.com.br/";
	protected static List<Map<String, String>> issue_info;
	private static WebDriver driver;
	protected static List<WebElement> listOfElements;


	
	
	public static void abrirPaginaBuscaFeita(DataTable data) {
		acessaHomePage(data);
		clicarOkCookies();
		preencheCampoBuscar();
		
	}
	
	
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
	
	
	public static void clicarTodosModelos() {
		String todosModelos = "//*[@id=\"root\"]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div[2]";
		clicar(todosModelos);
	}
	
	
	
	public static void listarElementos(String xpath,String tag,String modelo) {

		WebElement Table = driver.findElement(By.xpath(xpath));
		List<WebElement> rows_table = Table.findElements(By.tagName(tag));
		for(int i=0;i<rows_table.size();i++) {
			if(rows_table.get(i).equals(modelo));
			rows_table.get(i).click();
			break;
			
		}
	}
	
	
	public static void selecionaModelo() {
		String modelo = issue_info.get(0).get("MODELO");
		String listaModelo = "//*[@id=\"root\"]/main/div[1]/div[2]/div/div[3]/div/div[5]";
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buscar)));
		//clicar(buscar);
		listarElementos(listaModelo,"a",modelo);
		
	}
	
	public static void preencheCampoBuscar() {
		String marca = issue_info.get(0).get("MARCA");
		String buscar = "//*[@id=\"searchBar\"]";
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buscar)));
		clicar(buscar);
		selecionaPrimeiraOpcaoDropDown(buscar,marca);
		
	}
	
	
		
	
	
	public static void validarBusca() {
		String nomeMarca = issue_info.get(0).get("MARCA");
		String xpathNome = "//*[@id=\"root\"]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div[1]";
		String xpathValida = driver.findElement(By.xpath(xpathNome)).getText();
		try {
			Assert.assertEquals(xpathValida, nomeMarca);
			System.out.println("Busca da marca "+nomeMarca+" validada com sucesso");
		}catch(Exception e){
			System.out.println("Busca da marca"+nomeMarca+"não validada com sucesso");
		}
				
		
	}
	
	public static void validarModelo() {
		String nomeModelo = issue_info.get(0).get("MODELO");
		String xpathNome = "//*[@id=\"root\"]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div[2]";
		String xpathValida = driver.findElement(By.xpath(xpathNome)).getText();
		try {
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathNome)));
			Assert.assertEquals(nomeModelo, xpathValida);
			System.out.println("Busca da marca "+nomeModelo+" validada com sucesso");
		}catch(Exception e){
			System.out.println("Busca da marca"+nomeModelo+"não validada com sucesso");
		}
				
		
	}
	
	
	public static void selecionaPrimeiraOpcaoDropDown(String xpath, String marca) {
		preencher(xpath,marca);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String multiSelect = Keys.chord(Keys.DOWN,Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"WhiteBox\"]/div[1]/div[2]/div/div/div/div/div/div[1]/a/div[2]")));
		
		driver.findElement(By.xpath(xpath)).sendKeys(multiSelect);
			
	}
	
	
	public static void finalizar() {
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.quit();

		}catch(Exception e) {
			
		}
	}
	
	
	public static void preencher(String xpath,String value){
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Element = driver.findElement(By.xpath(xpath));
		Element.sendKeys(value);
		
	}
	
	public static void clicarOkCookies() {
		
		String cookies = "//*[@id='root']/div[3]/div[2]/button";
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cookies)));
		clicar(cookies);
	}
	
	public static void clicar(String xpath) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Element = driver.findElement(By.xpath(xpath));
		Element.click();
	

	}
	
	
	
	
}
