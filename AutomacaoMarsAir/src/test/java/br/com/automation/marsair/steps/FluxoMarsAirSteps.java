package br.com.automation.marsair.steps;

import java.io.IOException;

import org.junit.Assert;

import br.com.automation.marsair.pages.HomePage;
import br.com.automation.marsair.pages.SearchResultPage;
import br.com.automation.marsair.utils.BaseTestUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class FluxoMarsAirSteps extends BaseTestUtils {

	HomePage home = new HomePage();
	SearchResultPage search = new SearchResultPage();

	private String tipo;

	@Before
	public void setup() {
		home.acessarTelaHome();
	}

	@After
	public void tearDown() throws IOException {
		finish();
	}

	@Dado("^que eu esteja na pagina de pesquisa da plataforma (.*)$")
	public void queEuEstejaNaPaginaDePesquisaDaPlataforma(String string) {
		tipo = string;
		string = "Book a ticket to the red planet now!";

		home.verificarLogo();

		String texto = home.obterTextoDestaque();
		Assert.assertEquals("Texto não corresponde", string, texto);
	}

	@Quando("^eu selecionar meu mes e dia de partida$")
	public void euSelecionarMeuMesEDiaDePartida() {

		if (tipo.equals("sucesso")) {
			home.clicarSelectDeparting("July");
		} else if (tipo.equals("sem sucesso")) {
			home.clicarSelectDeparting("December");
		} else if (tipo.equals("invalida")) {
			home.clicarSelectDeparting("December");
		} else if (tipo.equals("desconto valido")) {
			home.clicarSelectDeparting("December");
		} else if (tipo.equals("desconto invalido")) {
			home.clicarSelectDeparting("December");
		}

	}

	@Quando("^meu mes dia de retorno respeitando o intervalo superior a (\\d+) ano$")
	public void meuMesDiaDeRetornoRespeitandoOIntervaloSuperiorAAno(Integer int1) {
		home.clicarSelectReturn("July (next year)");
	}

	@Quando("^clicar no botao de pesquisa$")
	public void clicarNoBotaoDePesquisa() {
		home.clicarSearch();
	}

	@Então("^quero receber o retorno do servico com a mensagem (.*)$")
	public void queroReceberORetornoDoServicoComAMensagem(String esperado) {
		String texto = search.obterTextoRetorno();
		String paginaResult = search.obterTextoSearch();

		Assert.assertEquals("Retorno não bate com esperado", esperado, texto);
		Assert.assertEquals("Não está na página de resultados", "Search Results", paginaResult);

	}

	@Quando("^meu dia de retorno que nao tenha assentos disponiveis$")
	public void meuDiaDeRetornoQueNaoTenhaAssentosDisponiveis() {
		home.clicarSelectReturn("December (next year)");
	}

	@Quando("^meu mes  e dia de retorno inferior a (\\d+) ano da partida$")
	public void meuMesEDiaDeRetornoInferiorAAnoDaPartida(Integer int1) {
		home.clicarSelectReturn("July (next year)");
	}

	@Dado("^que eu esteja na pagina de pesquisa da plataforma$")
	public void queEuEstejaNaPaginaDePesquisaDaPlataforma() {
		String string = "Book a ticket to the red planet now!";

		home.verificarLogo();

		String texto = home.obterTextoDestaque();
		Assert.assertEquals("Texto não corresponde", string, texto);
	}

	@Quando("^eu nao selecionar nenhuma data de partida$")
	public void euNaoSelecionarNenhumaDataDePartida() {
		home.clicarSelectDeparting("");
	}

	@Quando("^nenhuma data de retorno$")
	public void nenhumaDataDeRetorno() {
		home.clicarSelectReturn("");
	}

	@Quando("^eu selecionar a data de partida superior a data retorno$")
	public void euSelecionarADataDePartidaSuperiorADataRetorno() {

	}

	@Quando("^meu mes e dia de retorno$")
	public void meuMesEDiaDeRetorno() {
		if (tipo.equals("desconto valido")) {
			home.clicarSelectReturn("December (next year)");
		} else if (tipo.equals("desconto invalido")) {
			home.clicarSelectReturn("December (next year)");
		}
	}

	@Quando("^digitar meu codigo de desconto valido no formato (.*) (.*)$")
	public void digitarMeuCodigoDeDescontoValidoNoFormato(String string, String codigo) {

		home.digitarCodigo(codigo);

	}

}
