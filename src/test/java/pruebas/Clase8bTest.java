package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Clase8bTest {
	String url = "https://demo.guru99.com/test/table.html";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void mostrarValoresTabla() {
		System.out.println("Fila 1 - Columna 2 (2): " + driver.findElement(By.xpath("//td[contains(text(),'2')]")).getText());
		System.out.println("Fila 1 - Columna 3 (3): " + driver.findElement(By.xpath("//td[contains(text(),'3')]")).getText());
		System.out.println("Fila 4 - Columna 3 (8): " + driver.findElement(By.xpath("//tbody/tr[4]/td[3]")).getText());
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
