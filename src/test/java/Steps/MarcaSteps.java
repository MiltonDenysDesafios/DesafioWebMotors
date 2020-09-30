package Steps;

import cucumber.api.java.en.Given;

public class MarcaSteps {

	 @Given("abri a pagina webmotors")
	    public void abrirPage() {
		 Keywords.commands.Comandos.acessaHomePage();
	    }
}
