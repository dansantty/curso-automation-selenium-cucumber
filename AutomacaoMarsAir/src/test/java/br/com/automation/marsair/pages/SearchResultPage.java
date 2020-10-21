package br.com.automation.marsair.pages;

import org.openqa.selenium.By;

import br.com.automation.marsair.actions.ActionsPage;

public class SearchResultPage extends ActionsPage {

	//Validando texto da pagina de resultados
	public String obterTextoSearch() {
		String texto = obterTexto(By.xpath("//div[@id='content']//h2"));
		return texto;
	}

	//Validando texto de retorno de busca
	public String obterTextoRetorno() {
		String texto = obterTexto(By.xpath("//div[@id='content']//p[1]"));
		return texto;
	}

	//Clicando no botão de retorno
	public void clicarBack() {
		clicarBotao(By.xpath("//div[@id='content']//p[2]//a"));
	}

}
