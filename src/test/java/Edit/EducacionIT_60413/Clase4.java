package Edit.EducacionIT_60413;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clase4 {
	String url = "http://automationpractice.pl";
	
	@Test
	public void registrarUsuario() {
		// Sección 1 - Inicialización del Navegador
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url); // = driver.get(url);
		driver.manage().window().maximize();
		
		// Sección 2 - Hacer clic en el link "Sign In"
		WebElement lnkSignIn = driver.findElement(By.partialLinkText("Sign"));
		lnkSignIn.click();
		
		// Otra forma de hacerlo
		// driver.findElement(By.partialLinkText("Sign")).click();
		
		// Sección 3 - Completar el correo y hacer clic en Create an Account
		String email = "correo" + Math.random() + "@gmail.com";
		System.out.println(email);
		
		driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		// Espera
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("id_gender")));
		
		// Sección 4 - Completar el formulario y el botón Register 
		driver.findElement(By.name("id_gender")).click(); // Radio button "Mr."
		driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Tito"); // Firstname
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Lopez"); // Lastname
		
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.clear(); // Limpiar el campo
		txtEmail.sendKeys(email); // Email
		
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("1q2w3e4r5t"); // Password
		
		Select dias = new Select(driver.findElement(By.name("days")));
		dias.selectByValue("18"); // Día
		
		Select meses = new Select(driver.findElement(By.id("months")));
		meses.selectByVisibleText("June "); // Mes
		
		Select anios = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		anios.selectByIndex(30); // Año
		
		driver.findElement(By.id("newsletter")).click(); // Check Newletter
		driver.findElement(By.cssSelector("#optin")).click(); // Check Offers 
		
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click(); // Botón Register
	}
}
