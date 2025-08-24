CREATE DATABASE IF NOT EXISTS Asesorias_Prevencion_Riesgos 
CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE Asesorias_Prevencion_Riesgos;

CREATE TABLE Usuarios (
	idusuario INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	usunombre VARCHAR(30) NOT NULL,
	usuapellido VARCHAR(30) NOT NULL,
	usufechanacimiento DATE NOT NULL,
	usurun VARCHAR(10) NOT NULL UNIQUE
	);

CREATE TABLE Cliente (
	rutcliente INT PRIMARY KEY NOT NULL,
	clinombres VARCHAR(30) NOT NULL,
	cliapellidos VARCHAR(50) NOT NULL,
	clitelefono VARCHAR(20) NOT NULL,
	cliafp VARCHAR(30),
	clisistemasalud INT,
	clidireccion VARCHAR(100),
	clicomuna VARCHAR(50) NOT NULL,
	cliedad INT NOT NULL,
	Usuarios_idusuario INT NOT NULL, 
	CONSTRAINT fk_Cliente_idusuario FOREIGN KEY (Usuarios_idusuario) REFERENCES Usuarios (idusuario)
	);

CREATE TABLE Visita (
    idvisita INT AUTO_INCREMENT PRIMARY KEY,
    visfecha DATE NOT NULL,
    vishora TIME,
    vislugar VARCHAR(50) NOT NULL, 
    viscomentarios VARCHAR(250) NOT NULL, 
    Cliente_rutcliente INT NOT NULL,
    CONSTRAINT fk_Visita_Cliente FOREIGN KEY (cliente_rutcliente) REFERENCES Cliente (rutcliente)
	);

CREATE TABLE Chequeos (
	idchequeo INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
    cheqnombre VARCHAR (40)
    );

CREATE TABLE Visita_Chequeo (
	idvisita INT NOT NULL,
    idchequeo INT NOT NULL,
    PRIMARY KEY (idvisita, idchequeo),
    estado ENUM ('cumple', 'cumple con observaciones', 'no se cumple') NOT NULL, 
    visita_idvisita INT NOT NULL,
    CONSTRAINT fk_visita_chequeo_visita FOREIGN KEY (idvisita) REFERENCES Visita(idvisita),
    CONSTRAINT fk_visita_chequeo_chequeo FOREIGN KEY (idchequeo) REFERENCES Chequeos(idchequeo)
	);

CREATE TABLE Administrativos (
	idadministrativo INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	adminrun VARCHAR(10) NOT NULL UNIQUE,
	adminnombres VARCHAR(30) NOT NULL,
	adminapellidos VARCHAR(50) NOT NULL,
	admincorreo VARCHAR(50) NOT NULL,
	adminarea VARCHAR(50) NOT NULL,
	Usuarios_idusuario INT NOT NULL,
	CONSTRAINT fk_Administrativos_Usuarios FOREIGN KEY (Usuarios_idusuario) REFERENCES Usuarios (idusuario)
	);

CREATE TABLE Profesionales (
	idprofesional INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	profrun VARCHAR (10) NOT NULL UNIQUE,
	profnombres VARCHAR(30) NOT NULL,
	profapellidos VARCHAR(50) NOT NULL,
	proftelefono VARCHAR(20),
	proftitulo VARCHAR(50),
	profproyecto VARCHAR(100), 
	Usuarios_idusuario INT NOT NULL,
	CONSTRAINT fk_Profesionales_Usuarios FOREIGN KEY (Usuarios_idusuario) REFERENCES Usuarios (idusuario)
	);

CREATE TABLE Asesorias (
	idasesoria INT PRIMARY KEY AUTO_INCREMENT,
    asesfecha DATE NOT NULL,
    asesmotivo VARCHAR (100) NOT NULL,
    Profesional_idprofesional INT NOT NULL,
    Cliente_rutcliente INT NOT NULL,
    CONSTRAINT fk_Asesorias_Profesionales FOREIGN KEY (Profesional_idprofesional) REFERENCES Profesionales (idprofesional),
    CONSTRAINT fk_Asesorias_Cliente FOREIGN KEY (Cliente_rutcliente) REFERENCES Cliente (rutcliente)
    );

CREATE TABLE Recomendaciones (
	idrecomendacion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    recactividad VARCHAR (50) NOT NULL,
    recdescripcion VARCHAR (100) NOT NULL, 
    recdias INT NOT NULL,
    Asesorias_idasesoria INT NOT NULL,
    CONSTRAINT fk_Recomendaciones_Asesorias FOREIGN KEY (Asesorias_idasesoria) REFERENCES Asesorias (idasesoria)
    );
    
CREATE TABLE Pagos_clientes (
	idPagos_clientes INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    pagofecha DATE NOT NULL,
    pagomonto INT NOT NULL, 
    pagomes DATE NOT NULL,
    pagoaño YEAR NOT NULL, 
    Cliente_rutcliente INT NOT NULL, 
    CONSTRAINT fk_Pagos_clientes_Cliente FOREIGN KEY (Cliente_rutcliente) REFERENCES Cliente (rutcliente)
    );

CREATE TABLE Capacitacion (
    idcapacitacion INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    capfecha DATE NOT NULL,
    caphora TIME,
    caplugar VARCHAR (100) NOT NULL,
	capduracion INT, 
    Cliente_rutcliente INT NOT NULL,
    CONSTRAINT fk_Capacitacion_Cliente1 FOREIGN KEY (Cliente_rutcliente) 
    REFERENCES Cliente (rutcliente)
    );

CREATE TABLE Asistentes (
	idasistentes INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    asistnombrecompleto VARCHAR (100) NOT NULL,
    asistedad INT NOT NULL, 
    asistcorreo VARCHAR (70),
    asisttelefono VARCHAR (20),
    Capacitacion_idcapacitacion INT NOT NULL, 
    CONSTRAINT fk_Asistentes_Capacitacion FOREIGN KEY (Capacitacion_idcapacitacion) 
    REFERENCES Capacitacion (idcapacitacion)
    );

CREATE TABLE Accidente (
	idaccidente INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    accifecha DATE NOT NULL,
    accihora TIME,
    accilugar VARCHAR(150) NOT NULL,
    acciorigen VARCHAR (100), 
	acciconsecuencias VARCHAR (100),
    Cliente_rutcliente INT NOT NULL,
    CONSTRAINT fk_Accidente_Cliente1 FOREIGN KEY (Cliente_rutcliente)
    REFERENCES Cliente (rutcliente)
    );    
