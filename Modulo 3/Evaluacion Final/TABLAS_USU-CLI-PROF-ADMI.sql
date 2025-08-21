CREATE DATABASE IF NOT EXISTS Asesorias CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE Asesorias;

CREATE TABLE usuario (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
rut VARCHAR(12) NOT NULL UNIQUE,
nombre VARCHAR(80) NOT NULL,
apellido VARCHAR(80) NOT NULL);

CREATE TABLE cliente (
#rut VARCHAR(12) PRIMARY KEY NOT NULL UNIQUE,
#nombre VARCHAR(30) NOT NULL,
#apellido VARCHAR(50) NOT NULL,
telefono VARCHAR(20) NOT NULL,
afp VARCHAR(30),
sistemasalud ENUM('Fonasa','Isapre'),
direccion VARCHAR(100),
comuna VARCHAR(50),
edad INT,
usuario_id INT NOT NULL UNIQUE,
FOREIGN KEY (usuario_id) REFERENCES usuario(id));

CREATE TABLE administrativo (
#rut VARCHAR(12) PRIMARY KEY NOT NULL UNIQUE,
#nombre VARCHAR(30) NOT NULL,
#apellido VARCHAR(50) NOT NULL,
email VARCHAR(100),
area VARCHAR(50),
usuario_id INT NOT NULL UNIQUE,
FOREIGN KEY (usuario_id) REFERENCES usuario(id));

CREATE TABLE profesional (
#rut VARCHAR(12) PRIMARY KEY NOT NULL UNIQUE,
#nombre VARCHAR(30) NOT NULL,
#apellido VARCHAR(50) NOT NULL,
telefono VARCHAR(20),
titulo VARCHAR(100),
proyecto VARCHAR(100),
usuario_id INT NOT NULL UNIQUE,
FOREIGN KEY (usuario_id) REFERENCES usuario(id));

INSERT INTO usuario (run, nombre, apellido)
VALUES
('12345678-9','Juan','Alcachofa'),
('11111111-1','Aquiles','Bailo'),
('22222222-2','Elsa','Pato');

