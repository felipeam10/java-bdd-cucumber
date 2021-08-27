Feature: Apenas usuarios cadastrados podem se logar

  Scenario: Um usuario valido consegue se logar
    Given o usuario valido
    When realiza login
    Then eh redirecionado para a pagina de leiloes


  Scenario: Um usuario invalido não consegue se logar
    Given o usuario invalido
    When tenta se logar
    Then continua na página de login