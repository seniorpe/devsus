Feature: Crear clientes

  Scenario: Crear un cliente con nombre Jose Lema
    Given url 'http://localhost:8081/clientes'
    And header Content-Type = 'application/json'
    And request { "nombre": "Jose Lema", "genero": "Masculino", "edad": 25, "identificacion": "X-74857458-Z", "direccion": "Otavalo sn y principal", "telefono": "098254785", "contrasena": "1234", "estado": true }
    When method post
    Then status 201
    And match response == { "id": "#notnull", "nombre": "Jose Lema", "genero": "Masculino", "edad": 25, "identificacion": "X-74857458-Z", "direccion": "Otavalo sn y principal", "telefono": "098254785", "contrasena": "1234", "estado": true }

  Scenario: Crear un cliente con nombre Marianela Montalvo
    Given url 'http://localhost:8081/clientes'
    And header Content-Type = 'application/json'
    And request { "nombre": "Marianela Montalvo", "genero": "Femenino", "edad": 30, "identificacion": "X-74857458-Z", "direccion": "Amazonas y NNUU", "telefono": "097548965", "contrasena": "5678", "estado": true }
    When method post
    Then status 201
    And match response == { "id": "#notnull", "nombre": "Marianela Montalvo", "genero": "Femenino", "edad": 30, "identificacion": "X-74857458-Z", "direccion": "Amazonas y NNUU", "telefono": "097548965", "contrasena": "5678", "estado": true }

  Scenario: Crear un cliente con nombre Juan Osorio
    Given url 'http://localhost:8081/clientes'
    And header Content-Type = 'application/json'
    And request { "nombre": "Juan Osorio", "genero": "Masculino", "edad": 30, "identificacion": "X-74857458-Z", "direccion": "13 junio y Equinoccial", "telefono": "098874587", "contrasena": "1245", "estado": true }
    When method post
    Then status 201
    And match response == { "id": "#notnull", "nombre": "Juan Osorio", "genero": "Masculino", "edad": 30, "identificacion": "X-74857458-Z", "direccion": "13 junio y Equinoccial", "telefono": "098874587", "contrasena": "1245", "estado": true }
