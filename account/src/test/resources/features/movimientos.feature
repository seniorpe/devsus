Feature: Registrar movimientos en cuentas

  Scenario: Registrar un retiro en la cuenta 478758
    Given url 'http://localhost:8082/movimientos'
    And header Content-Type = 'application/json'
    And request { "numeroCuenta": "478758", "tipoMovimiento": "Retiro", "valor": 575 }
    When method post
    Then status 201
    And match response.id == '#notnull'

  Scenario: Registrar un depósito en la cuenta 225487
    Given url 'http://localhost:8082/movimientos'
    And header Content-Type = 'application/json'
    And request { "numeroCuenta": "225487", "tipoMovimiento": "Deposito", "valor": 600 }
    When method post
    Then status 201
    And match response.id == '#notnull'

  Scenario: Registrar un depósito en la cuenta 495878
    Given url 'http://localhost:8082/movimientos'
    And header Content-Type = 'application/json'
    And request { "numeroCuenta": "495878", "tipoMovimiento": "Deposito", "valor": 150 }
    When method post
    Then status 201
    And match response.id == '#notnull'

  Scenario: Registrar un retiro en la cuenta 496825
    Given url 'http://localhost:8082/movimientos'
    And header Content-Type = 'application/json'
    And request { "numeroCuenta": "496825", "tipoMovimiento": "Retiro", "valor": 540 }
    When method post
    Then status 201
    And match response.id == '#notnull'
