@marca
Feature: Marca

  Scenario: Marca
   Given abri a pagina webmotors
   |MARCA	|
   |FIAT	|
    And clico no 'Ok' para cookies
    And preencho o campo buscar 
    Then valido se a busca foi correta
  	Then finalizo a aplicacao

