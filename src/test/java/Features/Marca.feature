@marca
Feature: Marca

	@marca_busca
  Scenario: Busca Marca
   Given abri a pagina webmotors
   |MARCA	|
   |HONDA	|
    When clico no 'Ok' para cookies
    And preencho o campo buscar 
    Then valido se a busca foi correta
  	And finalizo a aplicacao


	@modelo_busca
  Scenario: Busca Modelo
   Given que ja pesquisei pela marca no campo de busca
   |MARCA			|MODELO		|
   |HONDA			|ACCORD		|
   When clico na opcao 'Todos os modelos'
   And seleciono o modelo
   Then valido o retorno se modelo foi correto 
   And finalizo a aplicacao
   
   
   	@versao_busca
  Scenario: Busca Versao
   Given que ja pesquisei pela modelo no campo de busca
   |MARCA	|MODELO		|VERSAO															|
   |HONDA	|ACCORD		|2.0 LX 16V GASOLINA 4P AUTOMATICO	|
   When clico na opcao 'Todas as Versoes'
   And seleciono a versao
   Then valido o retorno da versao se foi correto 
   And finalizo a aplicacao
   
   
  