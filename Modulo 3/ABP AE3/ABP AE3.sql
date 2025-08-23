-- ====================================
-- Creación de la base de datos
-- ====================================
CREATE SCHEMA IF NOT EXISTS `ABP_AE3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `ABP_AE3`;

-- ====================================
-- Tabla clientes
-- ====================================
CREATE TABLE IF NOT EXISTS `clientes` (
  `idcliente` INT NOT NULL,
  `nombres` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(50) NOT NULL,
  `rut` VARCHAR(12) NOT NULL,
  `direccion` VARCHAR(100) NULL,
  `telefono` VARCHAR(15) NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ====================================
-- Tabla ventas
-- ====================================
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

-- ====================================
-- Inserción de clientes
-- ====================================

INSERT INTO `clientes` (`idcliente`, `nombres`, `apellidos`, `rut`, `direccion`, `telefono`)
VALUES (1, 'Juan', 'Pérez', '11111111-1', 'Av. Principal 123', '987654321');

INSERT INTO `clientes` (`idcliente`, `nombres`, `apellidos`, `rut`, `direccion`, `telefono`)
VALUES (2, 'María', 'López', '22222222-2', 'Calle Secundaria 456', '912345678');

INSERT INTO `clientes` (`idcliente`, `nombres`, `apellidos`)
VALUES (3, 'Carlos', 'Soto');

-- ====================================
-- Inserción de ventas
-- ====================================
INSERT INTO `ventas` (`idventa`, `idcliente`, `cantarticulos`, `subtotal`, `impuesto`, `total`)
VALUES (101, 1, 3, 15000, 2850, NULL);

INSERT INTO `ventas` (`idventa`, `idcliente`, `cantarticulos`, `subtotal`, `impuesto`, `total`)
VALUES (102, 1, 1, 5000, 950, NULL);

INSERT INTO `ventas` (`idventa`, `idcliente`, `cantarticulos`, `subtotal`, `impuesto`, `total`)
VALUES (103, 2, 2, 8000, 1520, NULL);

INSERT INTO `ventas` (`idventa`, `idcliente`, `cantarticulos`, `subtotal`, `impuesto`, `total`)
VALUES (104, 3, 4, 12000, 2280, NULL);

INSERT INTO `ventas` (`idventa`, `idcliente`, `cantarticulos`, `subtotal`, `impuesto`, `total`)
VALUES (105, 2, 5, 25000, 4750, NULL);

-- ====================================
-- Actualizar el campo total = subtotal + impuesto
-- ====================================
UPDATE `ventas`
SET `total` = `subtotal` + `impuesto`;

-- ====================================
-- Eliminar cliente y sus ventas 
-- ====================================

DELETE FROM `clientes`
WHERE `idcliente` = 3;

DELETE FROM `ventas`
WHERE `idcliente` = 3;