import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class TestCadastro {
	
	@Test
	public void deveInteragirComCadastro() {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension (1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Douglas");
		Assert.assertEquals("Douglas", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Cardoso");
		Assert.assertEquals("Cardoso", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));		
		Select combo = new Select(element);
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		
		element = driver.findElement(By.id("elementosForm:esportes"));
		combo = new Select(element);
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Corrida");
		Assert.assertEquals(2, combo.getAllSelectedOptions().size());
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().contains("Douglas"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().contains("Cardoso"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().contains("Masculino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().contains("Carne"));
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().contains("Superior"));
		Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().contains("Futebol Corrida"));
				
		driver.quit();
	}

}
