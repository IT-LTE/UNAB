CREATE DATABASE IF NOT EXISTS Asesorias CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE Asesorias;

CREATE TABLE usuario (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
usurut VARCHAR(12) NOT NULL UNIQUE,
usunombres VARCHAR(80) NOT NULL,
usuapellidos VARCHAR(80) NOT NULL);

CREATE TABLE cliente (
rutcliente VARCHAR(12) PRIMARY KEY NOT NULL UNIQUE,
clinombres VARCHAR(30) NOT NULL,
cliapellidos VARCHAR(50) NOT NULL,
clitelefono VARCHAR(20) NOT NULL,
cliafp VARCHAR(30),
clisistemasalud ENUM('Fonasa','Isapre'),
clidireccion VARCHAR(100),
clicomuna VARCHAR(50),
cliedad INT,
usuario_id INT NOT NULL UNIQUE,
FOREIGN KEY (usuario_id) REFERENCES usuario(id));

CREATE TABLE administrativo (
rutadministrativo VARCHAR(12) PRIMARY KEY NOT NULL UNIQUE,
adminombres VARCHAR(30) NOT NULL,
admiapellidos VARCHAR(50) NOT NULL,
admiemail VARCHAR(100),
admiarea VARCHAR(50),
usuario_id INT NOT NULL UNIQUE,
FOREIGN KEY (usuario_id) REFERENCES usuario(id));

CREATE TABLE profesional (
rutprofesional VARCHAR(12) PRIMARY KEY NOT NULL UNIQUE,
profnombres VARCHAR(30) NOT NULL,
profapellidos VARCHAR(50) NOT NULL,
proftelefono VARCHAR(20),
proftitulo VARCHAR(100),
profproyecto VARCHAR(100),
usuario_id INT NOT NULL UNIQUE,
FOREIGN KEY (usuario_id) REFERENCES usuario(id));

INSERT INTO usuario (usurut, usunombres, usuapellidos)
VALUES
('11111111-1','Aquiles','Bailo'),
('22222222-2','Elsa','Pato'),
('33333333-3','Juan','Alcachofa'),
('44444444-4','Barren','Henituse'),
('55555555-5','Leylin','Farlier'),
('66666666-6','Barnie','Eldinosaurio'),
('77777777-7','Ester','Egalo'),
('88888888-8','Teodora','Villavicencio'),
('99999999-9','Martin','Rojas');

INSERT INTO administrativo (rutadministrativo, adminombres, admiapellidos, admiemail, admiarea, usuario_id)
VALUES 
('11111111-1','Aquiles','Bailo','aquiles@gmail.com', 'Recursos Humanos', 1),
('44444444-4','Barren','Henituse','barren@gmail.com', 'Logistica',  4),
('55555555-5','Leylin','Farlier','leylin@gamil.com', 'Financiera', 5);

INSERT INTO profesional (rutprofesional, profnombres, profapellidos, proftelefono, proftitulo, usuario_id)
VALUES 
('22222222-2','Elsa','Pato','+56922222222','Prevención de riesgos', 2),
('66666666-6','Barnie','Eldinosaurio','+56966666666', 'Arquitecto', 6),
('77777777-7','Ester','Egalo','+56977777777', 'Ingeniera civil', 7);

INSERT INTO cliente (rutcliente, clinombres, cliapellidos, clitelefono, cliafp, clisistemasalud, clidireccion, clicomuna, cliedad,usuario_id)
VALUES 
('33333333-3','Juan','Alcachofa','+56933333333', 'Modelo', 'Fonasa', 'Monte 123', 'Valparaiso', 46, 3),
('88888888-8','Teodora','Villavicencio','+56988888888', 'Uno', 'Isapre', 'Catrina 123', 'Huechuraba', 32, 8),
('99999999-9','Martin','Rojas','+56999999999', 'Modelo', 'Isapre', 'Bandera 123', 'Valparaiso', 29, 9);