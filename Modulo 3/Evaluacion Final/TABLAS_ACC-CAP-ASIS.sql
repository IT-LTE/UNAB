
CREATE DATABASE IF NOT EXISTS capacitacion_riesgo;
USE capacitacion_riesgo;

-- Tabla Asistentes
CREATE TABLE asistentes (
    id_asistente INT AUTO_INCREMENT PRIMARY KEY,
    run VARCHAR(12) NOT NULL UNIQUE,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL
);

-- Tabla Capacitaciones
CREATE TABLE capacitaciones (
    id_capacitacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre_capacitacion VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    descripcion TEXT
);

-- Relación Asistente a Capacitaciones (N a N)
CREATE TABLE asistente_a_capacitacion (
    id_asistente INT,
    id_capacitacion INT,
    PRIMARY KEY (id_asistente, id_capacitacion),
    FOREIGN KEY (id_asistente) REFERENCES asistentes(id_asistente),
    FOREIGN KEY (id_capacitacion) REFERENCES capacitaciones(id_capacitacion)
);

-- Tabla Accidentes
CREATE TABLE accidentes (
    id_accidente INT AUTO_INCREMENT PRIMARY KEY,
    id_asistente INT NOT NULL,
    fecha DATE NOT NULL,
    descripcion TEXT,
    gravedad ENUM('LEVE','MODERADO','GRAVE') NOT NULL,
    FOREIGN KEY (id_asistente) REFERENCES asistentes(id_asistente)
);

-- Insertar Asistentes
INSERT INTO asistentes (run, nombres, apellidos, fecha_nacimiento, correo_electronico) VALUES
('11.111.111-1', 'Carlos', 'Pérez', '1990-05-10', 'carlos.perez@mail.com'),
('22.222.222-2', 'María', 'González', '1985-11-20', 'maria.gonzalez@mail.com'),
('33.333.333-3', 'Pedro', 'Ramírez', '1992-03-15', 'pedro.ramirez@mail.com');

-- Insertar Capacitaciones
INSERT INTO capacitaciones (nombre_capacitacion, fecha, descripcion) VALUES
('Capacitación en Seguridad', '2025-08-01', 'Medidas básicas de seguridad en el trabajo'),
('Capacitación en Riesgo Eléctrico', '2025-08-05', 'Prevención de riesgos eléctricos'),
('Capacitación en Ergonomía', '2025-08-10', 'Buenas prácticas ergonómicas');

-- Insertar Asistente a Capacitaciones
INSERT INTO asistente_a_capacitacion (id_asistente, id_capacitacion) VALUES
(1,1), (1,2), (2,1), (2,3), (3,2), (3,3);

-- Insertar Accidentes
INSERT INTO accidentes (id_asistente, fecha, descripcion, gravedad) VALUES
(1, '2025-07-01', 'Caída en pasillo', 'LEVE'),
(2, '2025-07-10', 'Accidente con maquinaria', 'GRAVE'),
(3, '2025-07-15', 'Golpe en brazo derecho', 'MODERADO');

-- CONSULTAS

-- a) Capacitaciones de un asistente (ejemplo con RUN específico)
SELECT 
    CONCAT(a.nombres, ' ', a.apellidos) AS nombre_completo,
    TIMESTAMPDIFF(YEAR, a.fecha_nacimiento, CURDATE()) AS edad,
    a.correo_electronico,
    c.nombre_capacitacion,
    c.fecha
FROM asistentes a
JOIN asistente_a_capacitacion ac ON a.id_asistente = ac.id_asistente
JOIN capacitaciones c ON ac.id_capacitacion = c.id_capacitacion
WHERE a.run = '11.111.111-1';

-- b) (Se omite, no aplica a este conjunto de tablas)

-- c) Accidentes registrados con datos de asistentes
SELECT 
    a.nombres,
    a.apellidos,
    a.run,
    a.correo_electronico,
    acc.fecha,
    acc.descripcion,
    acc.gravedad
FROM accidentes acc
JOIN asistentes a ON acc.id_asistente = a.id_asistente;
