-- =========================================
-- Crear base de datos y tabla
-- =========================================
CREATE DATABASE IF NOT EXISTS ventasdiarias1;
USE ventasdiarias1;

-- Borrar tabla si ya existía
DROP TABLE IF EXISTS ventas;

-- Crear tabla ventas
CREATE TABLE ventas (
    idventas INT PRIMARY KEY AUTO_INCREMENT,
    comprador VARCHAR(30) NOT NULL,
    vendedor  VARCHAR(30) NOT NULL,
    cantarticulos INT NOT NULL CHECK (cantarticulos >= 0),
    subtotal DECIMAL(10,2) NOT NULL CHECK (subtotal >= 0),
    impuesto DECIMAL(10,2) NOT NULL CHECK (impuesto >= 0),
    total DECIMAL(10,2) NOT NULL CHECK (total >= 0)
);

-- =========================================
-- Insertar datos de prueba
-- =========================================
INSERT INTO ventas (comprador, vendedor, cantarticulos, subtotal, impuesto, total) VALUES
('Lucas', 'Maria', 5, 1200, 228, 1428),
('Pedro', 'Sonia Garrido', 3, 5500, 1045, 6545),
('Lucas', 'Juan Perez', 1, 800, 152, 952),
('Ana', 'Maria', 2, 950, 181, 1131),
('Luis', 'Sonia Garrido', 4, 3000, 570, 3570),
('Carlos', 'Pedro Soto', 6, 7000, 1330, 8330),
('Lucas', 'Sonia Garrido', 3, 5200, 988, 6188),
('Miguel', 'Maria', 2, 1100, 209, 1309),
('Lucia', 'Juan Perez', 8, 9000, 1710, 10710);

-- ====================
--    Consultas
-- ====================
SELECT * 
FROM ventas
WHERE cantarticulos > 2;

SELECT idventas, comprador, cantarticulos
FROM ventas
WHERE subtotal < 1000;

SELECT total, impuesto, subtotal, cantarticulos, vendedor, comprador, idventas
FROM ventas
WHERE UPPER(vendedor) = 'SONIA GARRIDO'
  AND total >= 5000;

SELECT vendedor, comprador, total
FROM ventas
WHERE UPPER(comprador) = 'LUCAS'
   OR UPPER(vendedor) = 'MARIA';

SELECT *
FROM ventas
WHERE idventas IN (2, 5, 6, 9);