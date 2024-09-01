Feature: Crear cuentas

  Scenario: Crear una cuenta para el cliente Jose Lema
    Given url 'http://localhost:8082/cuentas'
    And header Content-Type = 'application/json'
    And request { "cliente": "Jose Lema", "numeroCuenta": "478758", "tipoCuenta": "Ahorros", "saldoInicial": 2000, "estado": true }
    When method post
    Then status 201
    And match response.id == '#notnull'

  Scenario: Crear una cuenta para el cliente Marianela Montalvo
    Given url 'http://localhost:8082/cuentas'
    And header Content-Type = 'application/json'
    And request { "cliente": "Marianela Montalvo", "numeroCuenta": "225487", "tipoCuenta": "Corriente", "saldoInicial": 100, "estado": true }
    When method post
    Then status 201
    And match response.id == '#notnull'

  Scenario: Crear una cuenta para el cliente Juan Osorio
    Given url 'http://localhost:8082/cuentas'
    And header Content-Type = 'application/json'
    And request { "cliente": "Juan Osorio", "numeroCuenta": "495878", "tipoCuenta": "Ahorros", "saldoInicial": 0, "estado": true }
    When method post
    Then status 201
    And match response.id == '#notnull'

  Scenario: Crear una cuenta para el cliente Marianela Montalvo (segunda cuenta)
    Given url 'http://localhost:8082/cuentas'
    And header Content-Type = 'application/json'
    And request { "cliente": "Marianela Montalvo", "numeroCuenta": "496825", "tipoCuenta": "Ahorros", "saldoInicial": 540, "estado": true }
    When method post
    Then status 201
    And match response.id == '#notnull'