Feature: Crear cuentas

  Scenario: Crear una cuenta corriente para el cliente Jose Lema
    Given url 'http://localhost:8082/cuentas'
    And header Content-Type = 'application/json'
    And request { "cliente": "Jose Lema", "numeroCuenta": "585545", "tipoCuenta": "Corriente", "saldoInicial": 1000, "estado": true }
    When method post
    Then status 201
    And match response.id == '#notnull'
