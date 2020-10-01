package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Modelo {
	
	
	 @Given("que ja pesquisei pela marca no campo de busca")
	    public void abrirPageBuscaFeita(DataTable data) {
		 Keywords.commands.Comandos.abrirPaginaBuscaFeita(data);
	    }
	
	 @When("clico na opcao 'Todos os modelos'")
	    public void clicaropcaoTodosModelos() {
		 Keywords.commands.Comandos.clicarTodosModelos();
	    }
	
	 @And("seleciono o modelo")
	    public void selecionaModelo() {
		 Keywords.commands.Comandos.selecionaModelo();
	    }
	 
	 @Then("valido o retorno de modelo foi correto")
	    public void validaModelo() {
		 Keywords.commands.Comandos.validarModelo();
	    }
	 
	
}
