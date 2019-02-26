import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;




public class TestAlert {

	//create method
	@Test
	public void deveInteragirComAlertSimples() throws InterruptedException {
		//set driver
		WebDriver driver = new FirefoxDriver();
		//resize the window
		//driver.manage().window().setSize(new Dimension (1200, 765));
		//get the url
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//find the element
		driver.findElement(By.id("alert")).click();
		//Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		//assert
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		//Thread.sleep(2000);
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		driver.quit();
	}

	//create test method
	@Test
	public void deveInteragirComAlertConfirm() throws InterruptedException {
	
		//set the driver
		WebDriver driver =new FirefoxDriver();
		//resize the page
		driver.manage().window().setSize(new Dimension (1200, 765));
		//get the url
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//find element
		WebElement alertConfirmButton = driver.findElement(By.id("confirm"));
		alertConfirmButton.click();
		
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		//Assert.assertEquals("Confirmado", alerta.getText());
		//driver.switchTo().alert().accept();
		//alert.accept();
		
		driver.quit();
		/*
		alertConfirmButton.click();
		texto = alertConfirmSimples.getText();
		Assert.assertEquals("Confirm Simples", texto);
		alertConfirmSimples.dismiss();
		//assert
		alertSimples.accept();
		Assert.assertEquals("Negado", alertSimples.getText());
		driver.switchTo().alert().accept();
		*/
		
		
	}
}
