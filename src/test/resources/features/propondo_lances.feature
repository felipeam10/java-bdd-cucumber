Feature: Propondo Lances ao leilao

  Scenario: Propondo um unico lance valido
    Given um lance valido
    When propoe ao leilao
    Then o lance eh aceito

  Scenario: Propondo varios lances validos
    Given um lance de 10.0 reais do usuario "Felipe"
    And um lance de 15.0 reais do usuario "Lidiane"
    When propoe varios lances ao leilao
    Then os lances sao aceitos

  Scenario Outline: : Propondo um lance invalido
    Given um lance invalido de <valor> reais
    When propoe um leilao
    Then o lance nao eh aceito

    Examples:
      | valor |
      |     0 |
      |    -1 |
