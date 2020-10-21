package br.com.automation.marsair.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.automation.marsair.core.DriverFactory;
import br.com.automation.marsair.core.Properties;
import cucumber.api.java.After;

public class BaseTestUtils {

	DriverFactory driver = new DriverFactory();
	
	String testName = "Teste";

	@After
	public void finish() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(
				"target" + File.separator + "screenshot" + File.separator + testName + ".jpg"));

		if (Properties.FECHAR_BROWSER) {
			driver.killDriver();
		}
	}

}
