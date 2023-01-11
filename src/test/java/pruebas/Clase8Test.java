package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase8Test {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(dataProvider="Datos Login desde Excel")
	public void login(String email, String password) {
		// Paso 1 Hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnSignIn();
		
		// Paso 2 Ingresar email, password 
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		
		// Paso 3 Hacer clic en el botón
		login.clicEnLogin();
		
	}
	
	@DataProvider(name="Datos Login desde Excel")
	public Object[][] obtenerDatosLoginExcel() throws Exception {
		String rutaArchivo = "..\\EducacionIT-60413\\Datos\\Datos_Login.xlsx";
		String nombreHoja = "Hoja1";
		
		return DatosExcel.leerExcel(rutaArchivo, nombreHoja);
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosLogin() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "correo1@gmail.com";
		datos[0][1] = "43tre46t";
		
		datos[1][0] = "correo2@gmail.com";
		datos[1][1] = "45ryt54y5";
		
		datos[2][0] = "correo3@gmail.com";
		datos[2][1] = "7iu67udsfs";
		
		return datos;
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
