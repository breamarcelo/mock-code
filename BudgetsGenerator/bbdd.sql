DROP DATABASE IF EXISTS budgets_generator;
CREATE DATABASE budgets_generator;
USE budgets_generator;

CREATE TABLE TPacks_futbol
(
    PK_ID INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Precio DECIMAL(10, 2) NOT NULL
);

CREATE TABLE TCentralitas
(
    PK_ID INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Precio DECIMAL(10, 2) NOT NULL
);

CREATE TABLE TDescuentos
(
    PK_ID INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Porciento INT(3) NOT NULL CHECK(Porciento<=100)
);

CREATE TABLE TLineas_adicionales
(
    PK_ID INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Tipo VARCHAR(10) NOT NULL,
    Num_lineas INT(4) NOT NULL DEFAULT 1,
    Llamadas VARCHAR(20),
    Gb VARCHAR(100),
    Fibra VARCHAR(100),
    Precio DECIMAL(10, 2) NOT NULL
);

CREATE TABLE TServicios_adicionales
(
    PK_ID INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Roaming VARCHAR(10) NOT NULL DEFAULT "45Gb",
    Internacional VARCHAR(100),
    Legalitas BOOLEAN DEFAULT FALSE,
    Cloud BOOLEAN DEFAULT FALSE,
    Ciber_proteccion BOOLEAN DEFAULT FALSE,
    Atencion_personalizada BOOLEAN DEFAULT FALSE,
    Centralita VARCHAR(100),
    Numero_beneficios INT(4) DEFAULT 0,
    Descuento_beneficios VARCHAR(100)
);

CREATE TABLE TTarifas
(
    PK_ID INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Tipo VARCHAR(10) NOT NULL DEFAULT "Captación",
    Lineas_moviles INT(4) NOT NULL DEFAULT 1,
    Llamadas_movil VARCHAR(20) NOT NULL DEFAULT "Ilimitadas",
    Gb_movil VARCHAR(20) NOT NULL DEFAULT "Ilimitados",
    Opcion_fibra1 VARCHAR(20) NOT NULL,
    Opcion_fibra2 VARCHAR(20) NOT NULL,
    Sobrecargo_fibra DECIMAL(10,2) NOT NULL,
    Precio DECIMAL(10,2) NOT NULL,
    FK_Servicios_ID INT(4) NOT NULL,
    Tv BOOLEAN DEFAULT FALSE,
    Servicio_streaming BOOLEAN DEFAULT FALSE,
    FOREIGN KEY(FK_Servicios_ID) REFERENCES TServicios_adicionales(PK_ID)
);