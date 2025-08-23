-- ======================================
-- MySQL Workbench Forward Engineering
-- ======================================
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- ======================================
-- Schema capacitacion_riesgo
-- ======================================
USE `capacitacion_riesgo`;

-- ======================================
-- Convertir llaves primarias en autonuméricas
-- ======================================
ALTER TABLE asistentes MODIFY id_asistente INT NOT NULL AUTO_INCREMENT;
ALTER TABLE accidentes MODIFY id_accidente INT NOT NULL AUTO_INCREMENT;
ALTER TABLE capacitaciones MODIFY id_capacitacion INT NOT NULL AUTO_INCREMENT;

-- ======================================
-- Insertar 3 capacitaciones sin asignar id_capacitacion
-- ======================================
INSERT INTO capacitaciones (nombre_capacitacion, fecha, descripcion)
VALUES ('Prevención de Incendios', '2023-06-01', 'Capacitación sobre uso de extintores');

INSERT INTO capacitaciones (nombre_capacitacion, fecha, descripcion)
VALUES ('Primeros Auxilios', '2023-07-10', 'Atención inmediata de emergencias menores');

INSERT INTO capacitaciones (nombre_capacitacion, fecha, descripcion)
VALUES ('Seguridad en Alturas', '2023-08-20', 'Medidas de seguridad para trabajos en altura');

-- ======================================
-- Insertar 5 asistentes sin asignar id_asistente
-- ======================================
INSERT INTO asistentes (run, nombres, apellidos, fecha_nacimiento, correo_electronico)
VALUES ('11111111-1', 'Carlos', 'González', '1990-01-01', 'carlos.gonzalez@mail.com');

INSERT INTO asistentes (run, nombres, apellidos, fecha_nacimiento, correo_electronico)
VALUES ('22222222-2', 'María', 'López', '1992-05-15', 'maria.lopez@mail.com');

INSERT INTO asistentes (run, nombres, apellidos, fecha_nacimiento, correo_electronico)
VALUES ('33333333-3', 'Pedro', 'Soto', '1985-03-20', 'pedro.soto@mail.com');

INSERT INTO asistentes (run, nombres, apellidos, fecha_nacimiento, correo_electronico)
VALUES ('44444444-4', 'Ana', 'Martínez', '1998-11-11', 'ana.martinez@mail.com');

INSERT INTO asistentes (run, nombres, apellidos, fecha_nacimiento, correo_electronico)
VALUES ('55555555-5', 'Jorge', 'Ramírez', '1987-07-07', 'jorge.ramirez@mail.com');

-- ======================================
-- Restricción única sobre nombres en asistentes
-- ======================================
ALTER TABLE asistentes ADD CONSTRAINT unique_nombres UNIQUE (nombres);

-- ======================================
-- Actualizar fecha y hora nulas en capacitaciones
-- ======================================
UPDATE capacitaciones
SET fecha = '2020-01-01', descripcion = 'Actualizado por sistema'
WHERE fecha IS NULL;

-- ======================================
-- Eliminar capacitaciones sin asistentes
-- ======================================
DELETE FROM capacitaciones
WHERE id_capacitacion NOT IN (
    SELECT DISTINCT id_capacitacion FROM asistente_a_capacitacion
);