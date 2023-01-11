package Edit.EducacionIT_60413;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Utilities.CapturaEvidencia;

public class Clase5 {
	String url  = "http://automationpractice.pl";
	WebDriver driver;
	File pantalla;
	String rutaEvidencias = "..\\EducacionIT-60413\\Evidencias\\";
	String nombreDocumento = "Evidencias de Prueba - AutomationPractice.docx";
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Ir a Contactanos", priority=1)
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(
				rutaEvidencias + nombreDocumento, 
				"Documento de Evidencias - AutomationPractice", 
				18);
		
		// Capturar Evidencia en Documento
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				rutaEvidencias + "img.jpg", 
				rutaEvidencias + nombreDocumento, 
				"Pantalla Inicial");
		
		// Hacer clic en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		// Capturar Evidencia en Documento
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				rutaEvidencias + "img.jpg", 
				rutaEvidencias + nombreDocumento, 
				"Paso 1 - Luego de hacer clic en Contact us");
		
		// Completar el formulario
		Select lista = new Select(driver.findElement(By.id("id_contact")));
		lista.selectByVisibleText("Customer service");
		
		Faker faker = new Faker();
		String email = faker.internet().emailAddress(); // Genera un correo aleatorio
		//int numeroAleatorio = faker.random().nextInt(1, 9999);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		
		driver.findElement(By.name("id_order")).sendKeys("123ABC");
		
		driver.findElement(By.cssSelector("#fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.tagName("textarea")).sendKeys("Mensaje de Contacto con la Empresa");
		
		// Capturar Evidencia en Documento
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				rutaEvidencias + "img.jpg", 
				rutaEvidencias + nombreDocumento, 
				"Paso 2 - Luego de completar el formulario");
		
		// Hacer clic en el botón Send
		driver.findElement(By.id("submitMessage")).click();
		
		// Capturar Evidencia en Documento
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				rutaEvidencias + "img.jpg", 
				rutaEvidencias + nombreDocumento, 
				"Paso 3 - Luego de enviar el formulario de contacto");
	}
	
	@Test(description="CP02 - Buscar Palabra", priority=2)
	public void buscarPalabra() throws IOException {
		// Captura de Evidencia
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencias + "01_pantallaprincipal.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Captura de Evidencia
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencias + "02_palabraBuscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Captura de Evidencia
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencias + "03_resultadoObtenido.jpg"));
		
		String urlEsperada = "http://automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String tituloEsperado = "Search - My Store";
		String urlObtenida = driver.getCurrentUrl();
		String tituloObtenido = driver.getTitle();
		
		Assert.assertEquals(urlObtenida, urlEsperada);
		Assert.assertEquals(tituloObtenido, tituloEsperado);
		
		/*
		Assert.assertNotEquals("", "");
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertNull(tituloObtenido);
		Assert.assertNotNull(tituloObtenido);
		*/
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
