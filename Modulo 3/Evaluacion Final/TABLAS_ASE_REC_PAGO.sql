-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- ==========================
-- Tabla Clientes
-- ==========================
CREATE TABLE IF NOT EXISTS clientes (
  id_cliente INT NOT NULL AUTO_INCREMENT,
  run VARCHAR(12) NOT NULL UNIQUE,
  nombres VARCHAR(50) NOT NULL,
  apellidos VARCHAR(50) NOT NULL,
  correo_electronico VARCHAR(100) NOT NULL,
  telefono VARCHAR(20),
  PRIMARY KEY (id_cliente)
) ENGINE=InnoDB;

-- ==========================
-- Tabla Asesorías
-- ==========================
CREATE TABLE IF NOT EXISTS asesorias (
  id_asesoria INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  fecha DATE NOT NULL,
  tema VARCHAR(100) NOT NULL,
  descripcion TEXT,
  PRIMARY KEY (id_asesoria),
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
) ENGINE=InnoDB;

-- ==========================
-- Tabla Pagos
-- ==========================
CREATE TABLE IF NOT EXISTS pagos (
  id_pago INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  fecha_pago DATE NOT NULL,
  monto DECIMAL(10,2) NOT NULL,
  metodo_pago ENUM('EFECTIVO','TRANSFERENCIA','TARJETA') NOT NULL,
  PRIMARY KEY (id_pago),
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
) ENGINE=InnoDB;

-- ==========================
-- Tabla Recomendaciones
-- ==========================
CREATE TABLE IF NOT EXISTS recomendaciones (
  id_recomendacion INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  fecha DATE NOT NULL,
  recomendacion TEXT NOT NULL,
  PRIMARY KEY (id_recomendacion),
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
) ENGINE=InnoDB;

-- ==========================
-- Inserciones de ejemplo
-- ==========================
INSERT INTO clientes (run, nombres, apellidos, correo_electronico, telefono)
VALUES ('12345678-9', 'Luis', 'Betancourt', 'luis@mail.com', '987654321');

INSERT INTO clientes (run, nombres, apellidos, correo_electronico, telefono)
VALUES ('98765432-1', 'Fernanda', 'Ramírez', 'fernanda@mail.com', '912345678');


INSERT INTO asesorias (id_cliente, fecha, tema, descripcion)
VALUES (1, '2025-08-23', 'Prevención de riesgos eléctricos', 'Asesoría enfocada en uso seguro de herramientas eléctricas.');


INSERT INTO pagos (id_cliente, fecha_pago, monto, metodo_pago)
VALUES (1, '2025-08-23', 50000, 'TRANSFERENCIA');


INSERT INTO recomendaciones (id_cliente, fecha, recomendacion)
VALUES (1, '2025-08-23', 'Se recomienda capacitar al personal en primeros auxilios cada 6 meses.');

-- ==========================
-- Consultas 
-- ==========================

SELECT c.nombres, c.apellidos, a.tema, a.fecha, a.descripcion
FROM asesorias a
JOIN clientes c ON a.id_cliente = c.id_cliente;

SELECT c.nombres, c.apellidos, p.monto, p.metodo_pago, p.fecha_pago
FROM pagos p
JOIN clientes c ON p.id_cliente = c.id_cliente
WHERE c.run = '12345678-9';

SELECT c.nombres, c.apellidos, r.recomendacion, r.fecha
FROM recomendaciones r
JOIN clientes c ON r.id_cliente = c.id_cliente;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;