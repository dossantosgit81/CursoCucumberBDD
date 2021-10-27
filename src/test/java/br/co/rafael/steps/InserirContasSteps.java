package br.co.rafael.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class InserirContasSteps {
	
	private WebDriver driver;
	
	@Dado("que desejo adicionar uma conta")
	public void queDesejoAdicionarUmaConta() {
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
		driver.findElement(By.id("email")).sendKeys("rm@gmail.com");
		driver.findElement(By.name("senha")).sendKeys("carreta");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Contas")).click();
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("adiciono a conta {string}")
	public void adicionoAConta(String string) {
		driver.findElement(By.id("nome")).sendKeys(string);
		driver.findElement(By.tagName("button")).click();
	}

	
	@Então("recebo a mensagem {string}")
	public void receboA(String string) {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		Assert.assertEquals(string, texto);
	}
	
	
	@After(order=1, value= "@funcionais")
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target//screenshot//" 
					+ cenario.getName()
					+ "."
					+ cenario.getLine()
					+ ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order=0, value="@funcionais")
	public void fecharBrowser() {
		driver.quit();
		System.out.println("Terminando");
	}
}
