Feature: Propondo Lances ao leilao

  Scenario: Propondo um unico lance valido
    Given um lance valido
    When propoe ao leilao
    Then o lance eh aceito

  Scenario: Propondo varios lances validos
    Given varios lances validos
    When propoe varios lances ao leilao
    Then os lances sao aceitos