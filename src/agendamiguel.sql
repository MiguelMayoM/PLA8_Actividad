-- Creamos la BD en la propiedad "jdbcUrl" del bean de la BD del archivo
-- spring-mvc-hibernate-pla8-servlet.xml
-- CREATE DATABASE `agendamiguel` IF NOT EXISTS;

USE `agendamiguel`;
CREATE TABLE `contactos` (`idcontacto` int(11) NOT NULL AUTO_INCREMENT,	`nombre` varchar(45) DEFAULT NULL, `email` varchar(45) DEFAULT NULL, `telefono` varchar(9) DEFAULT NULL,	PRIMARY KEY (`idcontacto`)) ENGINE=InnoDB; 
-- DEFAULT CHARSET=latin1;