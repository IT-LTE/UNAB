-- 1) Crear la base de datos
DROP DATABASE IF EXISTS prevencion_riesgos;
CREATE DATABASE prevencion_riesgos
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_0900_ai_ci;

USE prevencion_riesgos;

-- ==========================================================
-- 1. CREACIÓN DE TABLAS (con PK y restricciones NN)
-- ==========================================================

CREATE TABLE cliente (
    rutcliente INT(9) PRIMARY KEY,
    nombres VARCHAR(30) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    afp VARCHAR(30),
    sistemasalud TINYINT,
    direccion VARCHAR(70),
    comuna VARCHAR(50),
    edad INT(3) NOT NULL
);

CREATE TABLE capacitacion (
    idcapacitacion INT(9) PRIMARY KEY,
    fecha DATE,
    hora TIME,
    lugar VARCHAR(50) NOT NULL,
    duracion INT(3),
    cantidadasistentes INT(5) NOT NULL,
    cliente_rutcliente INT(9) NOT NULL
);

CREATE TABLE asistentes (
    idasistente INT(9) PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    edad INT(3) NOT NULL,
    capacitacion_idcapacitacion INT(9) NOT NULL
);

CREATE TABLE accidente (
    accidenteid INT(9) PRIMARY KEY,
    dia DATE,
    hora TIME,
    lugar VARCHAR(50) NOT NULL,
    origen VARCHAR(100),
    consecuencias VARCHAR(100),
    cliente_rutcliente INT(9) NOT NULL
);

-- ==========================================================
-- 2. CREACIÓN DE LLAVES FORÁNEAS
-- ==========================================================

ALTER TABLE capacitacion
ADD CONSTRAINT fk_capacitacion_cliente
FOREIGN KEY (cliente_rutcliente)
REFERENCES cliente(rutcliente);

ALTER TABLE asistentes
ADD CONSTRAINT fk_asistente_capacitacion
FOREIGN KEY (capacitacion_idcapacitacion)
REFERENCES capacitacion(idcapacitacion);

ALTER TABLE accidente
ADD CONSTRAINT fk_accidente_cliente
FOREIGN KEY (cliente_rutcliente)
REFERENCES cliente(rutcliente);

-- ==========================================================
--   Requerimientos
-- ==========================================================

ALTER TABLE cliente
ADD CONSTRAINT uq_cliente_telefono UNIQUE (telefono);

ALTER TABLE cliente
ADD CONSTRAINT chk_cliente_sistemasalud
CHECK (sistemasalud IN (1, 2));

INSERT INTO cliente (rutcliente, nombres, apellidos, telefono, afp, sistemasalud, direccion, comuna, edad)
VALUES
(111111111, 'Juan', 'Perez', '987654321', 'Provida', 1, 'Calle 1', 'Santiago', 35),
(222222222, 'Maria', 'Lopez', '912345678', 'Habitat', 2, 'Calle 2', 'Puente Alto', 28),
(333333333, 'Carlos', 'Gomez', '923456789', 'Modelo', 1, 'Calle 3', 'La Florida', 40),
(444444444, 'Ana', 'Torres', '934567890', 'Cuprum', 2, 'Calle 4', 'Maipu', 50);

INSERT INTO accidente (accidenteid, dia, hora, lugar, origen, consecuencias, cliente_rutcliente)
VALUES
(1, '2025-01-10', '09:00:00', 'Santiago', 'Caída', 'Lesión leve', 111111111),
(2, '2025-01-15', '10:30:00', 'Puente Alto', 'Golpe', 'Contusión', 222222222),
(3, '2025-02-01', '11:00:00', 'La Florida', 'Falla eléctrica', 'Quemadura leve', 333333333),
(4, '2025-02-10', '08:45:00', 'Maipu', 'Resbalón', 'Fractura', 444444444),
(5, '2025-02-20', '14:15:00', 'Santiago', 'Explosión', 'Quemadura grave', 111111111),
(6, '2025-03-05', '16:00:00', 'Puente Alto', 'Caída', 'Lesión leve', 222222222),
(7, '2025-03-12', '17:30:00', 'La Florida', 'Incendio', 'Asfixia leve', 333333333);