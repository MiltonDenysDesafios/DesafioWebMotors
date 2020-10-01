@marca
Feature: Marca

	@marca_busca
  Scenario: Busca Marca
   Given abri a pagina webmotors
   |MARCA	|
   |FIAT	|
    When clico no 'Ok' para cookies
    And preencho o campo buscar 
    Then valido se a busca foi correta
  	And finalizo a aplicacao


	@modelo_busca
  Scenario: Busca Modelo
   Given que ja pesquisei pela marca no campo de busca
   |MARCA			|MODELO	|
   |CHEVROLET	|AGILE	|
   When clico na opcao 'Todos os modelos'
   And seleciono o modelo
   Then valido o retorno de modelo foi correto 
   And finalizo a aplicacao
   
   
  