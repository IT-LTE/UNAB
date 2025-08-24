-- ========== --
-- Consulta A --
-- ========== --
SELECT
	a.asistnombrecompleto AS nombrecompleto_asistentes,
	a.asistedad AS edad_asistentes,
	a.asistcorreo AS correo_asistentes,
	c.idcapacitacion,
	c.capfecha AS fecha_capacitacion,
	c.caplugar AS lugar_capacitacion
	FROM Asistentes AS a
	JOIN Capacitacion AS c ON c.idcapacitacion = a.Capacitacion_idcapacitacion
	WHERE Cliente_rutcliente = 888888888;
    
-- ========== --
-- Consulta B --
-- ========== --
SELECT
	v.idvisita AS visita_id,
	v.visfecha AS fecha_visita,
	v.vishora AS hora_visita,
	v.vislugar AS lugar_visita,
	ch.cheqnombre AS nombre_chequeo,
	vc.estado AS estado_cumplimiento
	FROM Visita AS v
	JOIN Cliente AS cl
	ON v.Cliente_rutcliente = cl.rutcliente
	JOIN Visita_Chequeo AS vc
	ON v.idvisita = vc.idvisita
	JOIN Chequeos AS ch
	ON vc.idchequeo = ch.idchequeo
	WHERE cl.clicomuna LIKE '%Valparaíso%';

-- ========== --
-- Consulta C --
-- ========== --
SELECT
	a.idaccidente,
	a.accifecha AS fecha_accidente,
	a.accihora AS hora_accidente,
	a.accilugar AS lugar_accidente,
	a.acciorigen AS origen_accidente,
	a.acciconsecuencias AS consecuencias_accidente,
	c.clinombres AS nombre_cliente,
	c.cliapellidos AS apellido_cliente,
	c.rutcliente AS rut_cliente,
	c.clitelefono AS telefono_cliente
	FROM Accidente AS a
	JOIN Cliente AS c
	ON a.Cliente_rutcliente = c.rutcliente;