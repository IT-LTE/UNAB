-- ====================================
-- Insertar registros en capacitacion
-- ====================================

INSERT INTO `capacitacion` (`idcapacitacion`, `fecha`, `hora`, `lugar`, `duracion`, `cantidadasistentes`, `cliente_rutcliente`) VALUES
(1, '2025-08-04', '09:00:00', 'Sala Norte', 60, 3, 11111111),
(2, '2025-08-05', '10:30:00', 'Sala Sur', 120, 2, 22222222),
(3, '2025-08-11', '14:00:00', 'Auditorio', 80, 4, 33333333),
(4, '2025-08-12', '08:00:00', 'Sala Este', 90, 1, 44444444),
(5, '2025-08-13', '16:00:00', 'Sala Oeste', 150, 5, 55555555);

-- ====================================
-- Insertar registros en asistentes
-- ====================================

INSERT INTO `asistentes` (`idasistente`, `nombres`, `edad`, `capacitacion_idcapacitacion`) VALUES
(1, 'Juan Pérez', 30, 1),
(2, 'María López', 25, 1),
(3, 'Carlos Soto', 28, 1),
(4, 'Ana Torres', 35, 2),
(5, 'Pedro Ramírez', 40, 2),
(6, 'Sofía Muñoz', 22, 3),
(7, 'Ricardo Díaz', 29, 3),
(8, 'Paula Morales', 33, 3),
(9, 'Esteban Silva', 27, 3),
(10, 'Camila Herrera', 26, 5);

-- ====================================
-- Completar tabla asistentes_a_capacitacion
-- ====================================
INSERT INTO `asistentes_a_capacitacion` (`asistentes_idasistente`, `capacitacion_idcapacitacion`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(6, 3),
(7, 3),
(8, 3),
(9, 3),
(10, 5);

-- ====================================
-- 1. Capacitaciones realizadas un lunes con duración menor a 90 minutos
-- ====================================

SELECT capacitacion.idcapacitacion,
       capacitacion.fecha,
       capacitacion.hora,
       capacitacion.lugar,
       capacitacion.duracion
FROM capacitacion
WHERE DAYOFWEEK(capacitacion.fecha) = 2
  AND capacitacion.duracion < 90;

-- ====================================
-- 2. Listado de asistentes 
-- ====================================

SELECT asistentes.nombres,
       capacitacion.cliente_rutcliente,
       capacitacion.lugar,
       capacitacion.duracion
FROM asistentes
JOIN capacitacion
  ON asistentes.capacitacion_idcapacitacion = capacitacion.idcapacitacion;

-- ====================================
-- 3. Capacitaciones donde cantidad asistentes no coincide con cantidad real de asistentes
-- ====================================

SELECT capacitacion.idcapacitacion,
       capacitacion.cliente_rutcliente,
       capacitacion.fecha,
       capacitacion.hora,
       capacitacion.cantidadasistentes,
       COUNT(asistentes.idasistente) AS cantidad_asistentes_reales
FROM capacitacion
LEFT JOIN asistentes
  ON capacitacion.idcapacitacion = asistentes.capacitacion_idcapacitacion
GROUP BY capacitacion.idcapacitacion, 
         capacitacion.cliente_rutcliente, 
         capacitacion.fecha, 
         capacitacion.hora, 
         capacitacion.cantidadasistentes
HAVING capacitacion.cantidadasistentes <> COUNT(asistentes.idasistente);

-- ====================================
-- 4. Capacitaciones con más de 3 asistentes reales
-- ====================================

SELECT capacitacion.lugar,
       capacitacion.duracion,
       capacitacion.fecha,
       capacitacion.hora,
       COUNT(asistentes.idasistente) AS cantidad_asistentes_reales
FROM capacitacion
JOIN asistentes
  ON capacitacion.idcapacitacion = asistentes.capacitacion_idcapacitacion
GROUP BY capacitacion.idcapacitacion,
         capacitacion.lugar,
         capacitacion.duracion,
         capacitacion.fecha,
         capacitacion.hora
HAVING COUNT(asistentes.idasistente) > 3;