-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS banco CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE banco;

-- Crear la tabla personas
CREATE TABLE personas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    edad INT,
    direccion VARCHAR(255),
    genero VARCHAR(255),
    identificacion VARCHAR(255),
    nombre VARCHAR(255),
    telefono VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Crear la tabla clientes
CREATE TABLE clientes (
    id BIGINT NOT NULL,
    estado BIT DEFAULT 0,
    contrasena VARCHAR(255),
    PRIMARY KEY (id),
    CONSTRAINT FK_persona_cliente FOREIGN KEY (id) REFERENCES personas (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Crear la tabla cuentas
CREATE TABLE cuentas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cliente_id BIGINT NOT NULL,
    numero_cuenta VARCHAR(255) NOT NULL UNIQUE,
    tipo_cuenta VARCHAR(255),
    saldo_inicial DECIMAL(38,2),
    estado BIT DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT FK_cliente_cuenta FOREIGN KEY (cliente_id) REFERENCES clientes (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Crear la tabla movimientos
CREATE TABLE movimientos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cuenta_id BIGINT,
    fecha DATE,
    saldo DECIMAL(38,2),
    valor DECIMAL(38,2),
    tipo_movimiento VARCHAR(255),
    PRIMARY KEY (id),
    CONSTRAINT FK_cuenta_movimiento FOREIGN KEY (cuenta_id) REFERENCES cuentas (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
