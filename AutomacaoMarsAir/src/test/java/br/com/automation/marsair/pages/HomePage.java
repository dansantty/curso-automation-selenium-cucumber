package br.com.automation.marsair.pages;

import org.openqa.selenium.By;

import br.com.automation.marsair.actions.ActionsPage;
import br.com.automation.marsair.core.DriverFactory;

public class HomePage extends ActionsPage {

	//Acessando tela inicial
	public void acessarTelaHome() {
		DriverFactory.getDriver().get("https://marsair.thoughtworks-labs.net/danilobarbosa");
	}

	//Validando logo de tela
	public void verificarLogo() {
		verificarElementVisivel(By.xpath("//body[@id='app']/h1/a"));
	}

	//click para botão home
	public void clicarHome() {
		clicarBotao(By.xpath("//body[@id='app']/h1/a"));
	}

	//Validando texto de Bem Vindo
	public String obterTextoWelcome() {
		String texto = obterTexto(By.xpath("/html/body/div[1]/div/h2"));
		return texto;
	}

	//Validando texto destaque
	public String obterTextoDestaque() {
		String texto = obterTexto(By.xpath("//*[@id='content']/form/h3"));
		return texto;
	}

	//Selecionando no dropList dia de partida
	public void clicarSelectDeparting(String valor) {
		selecionarCombo("departing", valor);
	}

	//Selecionando no dropList dia de retorno
	public void clicarSelectReturn(String valor) {
		selecionarCombo("returning", valor);
	}

	//Digitando codigo promocional
	public void digitarCodigo(String texto) {
		escrever("promotional_code", texto);
	}

	//clicando no botão de busca
	public void clicarSearch() {
		clicarBotao(By.xpath("//*[@id='content']/form/dl[4]/dd/input"));
	}

	//Verificando o link para politica de privacidade
	public void verificarPolitica() {
		verificarElementVisivel(By.xpath("//*[@id=\"report_issue\"]/ul/li[3]/a"));
	}

}
