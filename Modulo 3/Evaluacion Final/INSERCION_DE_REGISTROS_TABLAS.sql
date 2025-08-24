INSERT INTO usuarios (usunombre, usuapellido, usufechanacimiento, usurun)
	VALUES
	('Aquiles','Bailo', '1982-04-15', '11111111-1'),
	('Elsa','Pato', '1978-07-17','22222222-2'),
	('Juan','Alcachofa', '1969-03-18','33333333-3'),
	('Barren','Henituse', '2000-06-19', '44444444-4'),
	('Leylin','Farlier', '1991-06-17', '55555555-5'),
	('Barnie','Eldinosaurio', '1989-01-19', '66666666-6'),
	('Ester','Egalo', '1985-09-13', '77777777-7'),
	('Teodora','Villavicencio', '1982-09-12', '88888888-8'),
	('Martin','Rojas', '1986-08-28', '99999999-9');

INSERT INTO cliente (rutcliente, clinombres, cliapellidos, clitelefono, cliafp, clisistemasalud, clidireccion, clicomuna, cliedad, Usuarios_idusuario)
	VALUES 
	('333333333','Juan','Alcachofa','+56933333333', 'Modelo', 1, 'Monte 123', 'Valparaiso', 46, 3),
	('888888888','Teodora','Villavicencio','+56988888888', 'Uno', 2, 'Catrina 123', 'Huechuraba', 32, 8),
	('999999999','Martin','Rojas','+56999999999', 'Modelo', 2, 'Bandera 123', 'Valparaiso', 29, 9);

INSERT INTO Visita (visfecha, vishora, vislugar, viscomentarios, Cliente_rutcliente)
	VALUES
    ('2025-08-08', '09:30:00', 'Sucursal San Miguel', 'Chequeo de extintores y señalética', 333333333),
	('2025-08-14', '10:45:00', 'Bodega principal', 'Charla de Ley Karin (Ley 21.643)', 888888888),
	('2025-08-23', '14:30:00', 'Oficina Central', 'Revisión semestral de equipos eléctricos', 999999999);

INSERT INTO Chequeos (cheqnombre)
	VALUES 
    ('Revisión de extintores'),
    ('Uso de elementos de protección personal'),
    ('Inspección de instalaciones eléctricas');

INSERT INTO Visita_Chequeo (idvisita, idchequeo, estado, visita_idvisita)
	VALUES
    (1 , 1, 'cumple', 1),
    (2 , 2, 'cumple con observaciones', 2),
    (3 , 3, 'no se cumple', 3);

INSERT INTO administrativos (adminrun, adminnombres, adminapellidos, admincorreo, adminarea, Usuarios_idusuario)
	VALUES 
	('11111111-1','Aquiles','Bailo','aquiles@gmail.com', 'Recursos Humanos', 1),
	('44444444-4','Barren','Henituse','barren@gmail.com', 'Logistica',  4),
	('55555555-5','Leylin','Farlier','leylin@gamil.com', 'Financiera', 5);
  
INSERT INTO profesionales (profrun, profnombres, profapellidos, proftelefono, proftitulo, profproyecto, Usuarios_idusuario)
	VALUES 
	('22222222-2','Elsa','Pato','+56922222222','Ingeniero en prevención de riesgos','Proyecto Zoo', 2),
	('66666666-6','Barnie','Eldinosaurio','+56966666666', 'Arquitecto', 'Proyecto Jurassic Park', 6),
	('77777777-7','Ester','Egalo','+56977777777', 'Ingeniera civil', 'Proyecto Alpla', 7);  
  
INSERT INTO asesorias (asesfecha, asesmotivo, Profesional_idprofesional, Cliente_rutcliente)
	VALUES
    ('2025-08-23', 'Prevención de riesgos eléctricos, asesoría enfocada en uso seguro de herramientas eléctricas.', 2, '333333333'),
    ('2025-08-14', 'Revisión de cumplimiento de Ley Karin (Ley 21.643)', '2', '888888888'),
    ('2025-08-07', 'Prevención de accidentes por mal uso de elementos de protección personal', '3', '999999999');

INSERT INTO recomendaciones (recactividad, recdescripcion, recdias, Asesorias_idasesoria)
	VALUES
    ('Mantenimiento eléctrico preventivo', 'Revisar todas las instalaciones y reemplazar cables defectuosos', 7, 1),
	('Establecer protocolos de denuncia', 'Crear procedimientos claros para reportar casos de estrés laboral y acoso', 5, 2),
    ('Capacitación en uso de EPP', 'Capacitar al personal sobre el uso adecuado de EPP', 3 , 3);

INSERT INTO Pagos_clientes (pagofecha, pagomonto, pagomes, pagoaño, Cliente_rutcliente)
VALUES
	('2025-08-05', 350000, 'septiembre', '2025', '333333333'),
	('2025-08-12', 200000, 'agosto', '2025', '888888888'),
	('2025-08-20', 175000, 'octubre', '2025', '999999999');

INSERT INTO capacitacion (capfecha, caphora, caplugar, capduracion, Cliente_rutcliente)    
	VALUES 
    ('2025-08-14', '11:00', 'Metro Salvador, Triana 853, Providencia, sala 203', 60, '333333333'),
    ('2025-08-18', '14:00', 'Presidente Riesco 5400, Las Condes, Departamento 1501 ', 50,'888888888'),
    ('2025-08-23', '16:00', 'Dieciocho 267, piso 3, Santiago', 90, '999999999');
    
INSERT INTO asistentes (idasistentes, asistnombrecompleto, asistedad, asistcorreo, asisttelefono, Capacitacion_idcapacitacion)
	VALUES 
    ('24', 'Karla Gomez', 37, 'karlagomez37@gmail.com', '954125899', '1'),
    ('35', 'Jose Torres', 30, 'josetorres30@gmail.com', '952414457', '1'),
    ('37', 'Maria Diaz', 40, 'mariadiaz40@gmail.com', '944475584', '1'),
    ('21', 'Marta Aravena', 36, 'martaaravena36@gmail.com', '952474788', '2'),
    ('23', 'Diego Guzman', 33, 'diegoguzman33@gmail.com', '956474259', '2'),
    ('31', 'Paola Garrido', 29, 'paolagarrido29@gmail.com', '985144457', '2'),
    ('15', 'Mario Silva', 25, 'mariosilva25@gmail.com', '954752248', '3'),
    ('18', 'Patricio Rojas', 25, 'patriciorojas25@gmail.com', '945152255', '3'),
    ('7', 'Ignacio Flores', 25, 'ignacioflores@gmail.com', '941444585', '3');
    
INSERT INTO accidente (idaccidente, accifecha, accihora, accilugar, acciorigen, acciconsecuencias, Cliente_rutcliente)
	VALUES 
    (142, '2025-08-17', '14:45', 'Edificio Altos de San Francisco, Santiago', 'Caida de material desde altura',
	'Perdida momentanea de conocimiento del trabajador, pequeño sangrado. No tuvo mayores problemas', 333333333),
	(158, '2025-08-12', '09:15', 'Casino de empleados en las dependencias de la empresa GND, San Miguel',
	'Al lavar su taza después de desayunar, esta se rompe sola al ejercer presión mientras la limpiaba',
	'Sangrado profundo, derivada a urgencia. Empleada termina con 5 puntos.', 888888888),
	(163, '2025-08-07', '11:45', 'Salida de Metro Santa Lucia, Santiago',
	'Al salir del metro, el empleado se cae por las escaleras al doblarse el pie.',
	'Trabajador termina con un esguince en su pie derecho, con reposo de 7 dias', 999999999);
