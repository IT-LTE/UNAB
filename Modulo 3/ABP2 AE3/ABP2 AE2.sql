-- ===================================
-- Creación de la base de datos
-- ===================================
CREATE SCHEMA IF NOT EXISTS `ABP2AE3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `ABP2AE3`;

-- ===================================
-- Tabla clientes
-- ===================================
CREATE TABLE IF NOT EXISTS `clientes` (
  `idcliente` INT NOT NULL,
  `nombres` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(50) NOT NULL,
  `rut` VARCHAR(12) NOT NULL,
  `direccion` VARCHAR(100) NULL,
  `telefono` VARCHAR(15) NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ===================================
-- Tabla ventas
-- ===================================
CREATE TABLE IF NOT EXISTS `ventas` (
  `idventa` INT NOT NULL,
  `idcliente` INT NOT NULL,
  `cantarticulos` INT NOT NULL,
  `subtotal` DECIMAL(10,2) NOT NULL,
  `impuesto` DECIMAL(10,2) NOT NULL,
  `total` DECIMAL(10,2) NULL,
  PRIMARY KEY (`idventa`),
  FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ===================================
-- INICIO DE LA TRANSACCIÓN
-- ===================================
START TRANSACTION;

-- ===================================
-- Inserción en clientes
-- ===================================
INSERT INTO clientes (idcliente, nombres, apellidos, rut)
VALUES (10, 'Lucía', 'Gómez', '10101010-0');

-- ===================================
-- Inserción de ventas
-- ===================================

INSERT INTO ventas (idventa, idcliente, cantarticulos, subtotal, impuesto, total)
VALUES (201, 10, 2, 10000, 1900, NULL);


INSERT INTO ventas
VALUES (202, 10, 1, 5000, 950, NULL);

COMMIT;

-- ===================================
-- Modificación del cliente
-- ===================================
UPDATE clientes
SET direccion = 'Calle Los Álamos 123',
    telefono = '987654321'
WHERE idcliente = 10;

-- ===================================
-- Deshacer los cambios de la última modificación
-- ===================================
ROLLBACK;