package br.com.automation.marsair.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
////////////////////////////////////////////////////////////////////////
		tags = { "@fluxo-total" },
////////////////////////////////////////////////////////////////////////
		// dryRun = false,
		// strict = false,
		plugin = { "pretty",
				   "html:target/report-html", 
				   "json:target/report.json", }, 
		
		monochrome = true, features = "src/test/resources/features",

		snippets = SnippetType.CAMELCASE,

		glue = { "br.com.automation.marsair.steps" })

public class ExecuteTest {

}
