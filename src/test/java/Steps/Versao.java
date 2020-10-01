package Steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Versao {

	
	
	
	 @Given("que ja pesquisei pela modelo no campo de busca")
	    public void abrirBuscaVersao(DataTable data) {
		 Keywords.commands.Comandos.abrirPaginaBuscaVersao(data);	 
	    }
	 
	 @When("clico na opcao 'Todas as Versoes'")
	    public void clicaTodasVersoes(){
		 Keywords.commands.Comandos.clicarTodosVersoes();	 
	    }
	 
	 @When("seleciono a versao")
	    public void selecionaVersao(){
		 Keywords.commands.Comandos.selecionaVersao();	 
	    
	 }
	 @When("valido o retorno da versao se foi correto")
	    public void validaRetornoVersao(){
		 Keywords.commands.Comandos.validarVersao();	 
	    
	 }
	 

}
