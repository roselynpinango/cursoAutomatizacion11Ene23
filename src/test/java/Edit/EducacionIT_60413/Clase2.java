package Edit.EducacionIT_60413;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase2 {
	// Sección 1: Atributos o variables de uso común
	String url = "http://automationpractice.pl";
	
	// Sección 2: Métodos (procedimientos o funciones)
	@Test
	public void hacerBusquedaEnChrome() 
	{
		// Paso 1: Configurar el navegador que queremos utilizar
		WebDriver navegador = new ChromeDriver();
								//FirefoxDriver, EdgeDriver, OperaDriver, SafariDriver
		
		// Paso 2: Abrir el navegador en la url que vamos a probar
		navegador.get(url);
		navegador.manage().deleteAllCookies(); // Borra las cookies antes de la prueba
		navegador.manage().window().maximize(); // Maximiza la ventana
		
		// Paso 3: Escribir la palabra que vamos a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 4: Hacer la búsqueda (clic en la lupa o presionando ENTER)
		txtBuscador.sendKeys(Keys.ENTER); // Simula que presionas la tecla ENTER
		
		System.out.println("Título de la Página: " + navegador.getTitle());
		System.out.println("URL Actual: " + navegador.getCurrentUrl());
		
		// Paso 5: Cerrar el navegador
		
	}
	
	@Test
	public void hacerBusquedaEnFirefox() 
	{
		// Paso 1: Configurar el navegador que queremos utilizar
		WebDriver navegador = new FirefoxDriver();
								//FirefoxDriver, EdgeDriver, OperaDriver, SafariDriver
		
		// Paso 2: Abrir el navegador en la url que vamos a probar
		navegador.get(url);
		
		// Paso 3: Escribir la palabra que vamos a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 4: Hacer la búsqueda (clic en la lupa o presionando ENTER)
		txtBuscador.sendKeys(Keys.ENTER); // Simula que presionas la tecla ENTER
		
		// Paso 5: Cerrar el navegador
		
	}
	
	@Test
	public void hacerBusquedaEnEdge() 
	{
		// Paso 1: Configurar el navegador que queremos utilizar
		WebDriver navegador = new EdgeDriver();
								//FirefoxDriver, EdgeDriver, OperaDriver, SafariDriver
		
		// Paso 2: Abrir el navegador en la url que vamos a probar
		navegador.get(url);
		
		// Paso 3: Escribir la palabra que vamos a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 4: Hacer la búsqueda (clic en la lupa o presionando ENTER)
		txtBuscador.sendKeys(Keys.ENTER); // Simula que presionas la tecla ENTER
		
		// Paso 5: Cerrar el navegador
		
	}
}
