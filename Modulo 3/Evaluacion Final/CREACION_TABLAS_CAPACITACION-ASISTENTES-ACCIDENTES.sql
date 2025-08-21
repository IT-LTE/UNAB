CREATE TABLE Capacitacion (
    idcapacitacion INT PRIMARY KEY NOT NULL,
    capfecha DATE NOT NULL,
    caphora DATE,
    caplugar VARCHAR (100) NOT NULL,
	capduracion INT, 
    Cliente_rutcliente INT NOT NULL,
    CONSTRAINT fk_Capacitacion_Cliente1 FOREIGN KEY (Cliente_rutcliente) 
    REFERENCES Cliente (rutcliente)
    );

CREATE TABLE Asistentes (
	idasistentes INT PRIMARY KEY NOT NULL,
    asistnombrecompleto VARCHAR (100) NOT NULL,
    asistedad INT NOT NULL, 
    asistcorreo VARCHAR (70),
    asisttelefono VARCHAR (20),
    Capacitacion_idcapacitacion INT NOT NULL, 
    CONSTRAINT fk_Asistentes_Capacitacion FOREIGN KEY (Capacitacion_idcapacitacion) 
    REFERENCES Capacitacion (idcapacitacion)
    );

CREATE TABLE Accidente (
	idaccidente INT PRIMARY KEY NOT NULL,
    accifecha DATE NOT NULL,
    accihora DATE NOT NULL,
    accilugar VARCHAR(150) NOT NULL,
    acciorigen VARCHAR (100), 
	acciconsecuencias VARCHAR (100),
    Cliente_rutcliente INT NOT NULL,
    CONSTRAINT fk_Accidente_Cliente1 FOREIGN KEY (Cliente_rutcliente)
    REFERENCES Cliente (rutcliente)
    );    



