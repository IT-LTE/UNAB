
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

USE capacitacion_riesgo;

-- =============================
-- Iniciar la transacción
-- =============================
START TRANSACTION;

-- =============================
-- Insertar una capacitación 
-- =============================
INSERT INTO capacitaciones (nombre_capacitacion, fecha)
VALUES ('Capacitación Básica en Riesgos', '2025-08-23');

COMMIT;

-- =============================
-- Habilitar auto-commit nuevamente
-- =============================
SET AUTOCOMMIT = 1;

-- =============================
-- Insertar 2 asistentes 
-- =============================
INSERT INTO asistentes (correo_electronico, fecha_nacimiento, apellidos, nombres, run)
VALUES ('asistente1@mail.com', '1990-01-01', 'Pérez', 'Juan', '11111111-1');

INSERT INTO asistentes (correo_electronico, fecha_nacimiento, apellidos, nombres, run)
VALUES ('asistente2@mail.com', '1992-02-02', 'Gómez', 'María', '22222222-2');

-- =============================
-- Actualizar la capacitación 
-- =============================
UPDATE capacitaciones
SET descripcion = 'Curso introductorio obligatorio'
WHERE nombre_capacitacion = 'Capacitación Básica en Riesgos';

-- =============================
-- Eliminar los asistentes 
-- =============================
DELETE FROM asistentes
WHERE run IN ('11111111-1', '22222222-2');

-- =============================
-- Deshacer los cambios realizados
-- =============================
ROLLBACK;

-- Restaurar configuración
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;