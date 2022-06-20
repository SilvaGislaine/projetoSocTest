#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Busca blog
  Realizar a busca de um item no blog do soc

  @tag1
  Scenario: Busca do artigo 'socnet'
    Given que acessei a pagina do blog do soc
    When eu clicar no campo de busca
    And preencher o campo com socnet
    And efetuar o click do botao de busca
    Then deve retornar uma lista de artigos
    And o primeiro item seria conheca as vantagens de ser um credenciado da socnet
    
  Scenario: Busca de um credenciado
    Given que entrei na pagina do blog do soc
    And efetuar click funcionalidades
    And efetuar click na rede socnet
    When direcionado a pagina de socnet clicar busca de credenciados
    When efetuar click filtro empresa
    And efetuar click no campo busca
    And preencher campo busca perfil prime
    And efetuar click no botao de busca
    And deve retorna resultado
    Then efetuar click em saiba mais
    
