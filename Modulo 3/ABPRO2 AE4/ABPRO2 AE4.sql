-- =========================================
-- Tabla CLIENTE
-- =========================================
ALTER TABLE cliente 
  ADD COLUMN direccion VARCHAR(150) AFTER correo_electronico,
  DROP COLUMN telefono_fijo;

-- =========================================
-- Tabla CAPACITACION
-- =========================================
ALTER TABLE capacitacion
  ADD COLUMN modalidad ENUM('PRESENCIAL','ONLINE') NOT NULL DEFAULT 'PRESENCIAL' AFTER fecha;

-- =========================================
-- Tabla ASISTENTE
-- =========================================
ALTER TABLE asistente
  DROP COLUMN correo_electronico;

ALTER TABLE asistente
  ADD COLUMN estado_asistencia ENUM('PRESENTE','AUSENTE','JUSTIFICADO') DEFAULT 'PRESENTE';

-- =========================================
-- Tabla ACCIDENTE
-- =========================================
ALTER TABLE accidente
  ADD COLUMN lugar VARCHAR(100) AFTER fecha,
  DROP COLUMN descripcion;

-- =========================================
-- Tabla VISITA
-- =========================================
CREATE TABLE IF NOT EXISTS visita (
  id_visita INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  fecha DATE NOT NULL,
  motivo VARCHAR(200),
  PRIMARY KEY (id_visita),
  FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

-- Confirmar los cambios
COMMIT;