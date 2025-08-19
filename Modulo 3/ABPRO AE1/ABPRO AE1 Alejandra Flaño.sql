-- 1) Crear la base de datos 
DROP DATABASE IF EXISTS capacitacionesriesgos;
CREATE DATABASE capacitacionesriesgos
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_0900_ai_ci;

-- 2) Acceder a la base de datos
USE capacitacionesriesgoscapacitacion;

-- 3) Crear tabla Capacitacion
DROP TABLE IF EXISTS Capacitacion;
CREATE TABLE Capacitacion (
  identificador     INT PRIMARY KEY AUTO_INCREMENT,
  rut_cliente       VARCHAR(15) NOT NULL,
  dia               VARCHAR(10) NOT NULL,
  hora              CHAR(5)     NOT NULL,
  lugar             VARCHAR(50) NOT NULL,
  duracion          INT         NOT NULL,
  cant_asistentes   INT         NULL,
  
  CONSTRAINT chk_dia CHECK (LOWER(dia) IN ('lunes','martes','miercoles','jueves','viernes','sabado','domingo')),
  CONSTRAINT chk_hora CHECK (hora REGEXP '^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$'),
  CONSTRAINT chk_duracion CHECK (duracion > 0),
  CONSTRAINT chk_asistentes CHECK (cant_asistentes IS NULL OR cant_asistentes >= 0)
) ENGINE=InnoDB;


CREATE INDEX idx_cap_rut ON Capacitacion(rut_cliente);
CREATE INDEX idx_cap_dia ON Capacitacion(dia);
CREATE INDEX idx_cap_lugar ON Capacitacion(lugar);

-- 4) Insertar al menos 10 registros de ejemplo
INSERT INTO Capacitacion (rut_cliente, dia, hora, lugar, duracion, cant_asistentes) VALUES
('1-9',       'lunes',      '09:00', 'La Florida', 60,  35),
('2-7',       'miercoles',  '10:30', 'La Florida', 45,  28),
('12.345.678-5','viernes',  '14:00', 'Providencia', 90,  20),
('9.876.543-2', 'jueves',   '08:15', 'Santiago',    30,  12),
('7.654.321-K', 'lunes',    '16:45', 'Maipu',       25,  55),
('3.456.789-1', 'martes',   '11:00', 'La Florida',  80,   8),
('22.222.222-2','viernes',  '13:30', 'Puente Alto', 120, 60),
('2-7',         'viernes',  '07:45', 'La Florida',  20,  70),
('1-9',         'miercoles','18:00', 'La Florida',  60,  40),
('11.111.111-1','lunes',    '12:20', 'Nunoa',       50,  25),
('4.444.444-4', 'miercoles','09:30', 'Santiago',    35,   5),
('5.555.555-5', 'viernes',  '17:05', 'Providencia', 75,  15);

-- 5) CONSULTAS SOLICITADAS
SELECT identificador, hora, dia, rut_cliente
FROM Capacitacion;

SELECT *
FROM Capacitacion
WHERE duracion = 60
  AND cant_asistentes > 30;

SELECT 
  cant_asistentes, duracion, lugar, hora, dia, rut_cliente, identificador
FROM Capacitacion
WHERE rut_cliente IN ('1-9', '2-7')
  AND lugar = 'La Florida';

SELECT identificador, duracion, cant_asistentes
FROM Capacitacion
WHERE (duracion > 30 AND duracion < 90)
   OR (cant_asistentes < 10);

SELECT identificador, dia, cant_asistentes, duracion, hora, lugar
FROM Capacitacion
WHERE dia IN ('lunes','miercoles','viernes')
  AND cant_asistentes > 50
  AND duracion < 30;
