package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;


public class MarcaSteps {

	 @Given("abri a pagina webmotors")
	    public void abrirPage(DataTable data) {
		 Keywords.commands.Comandos.acessaHomePage(data);	 
	    }
	 
	 @And("preencho o campo buscar")
	    public void preencheCampoBuscar() {
		 Keywords.commands.Comandos.preencheCampoBuscar();
		 
	    }
	 
	 @When("clico no 'Ok' para cookies")
	    public void clicaOkCookies(){
		 Keywords.commands.Comandos.clicarOkCookies();
		 
	    }
	 
	 @Then("valido se a busca foi correta")
	    public void validarBuscarMarca(){
		 Keywords.commands.Comandos.validarBusca();
	    }
	     

	   
	 @And("finalizo a aplicacao")
	    public void finalizar(){
		 Keywords.commands.Comandos.finalizar();
		 
	    }	 
	 
	 
	 
                                                 

}
