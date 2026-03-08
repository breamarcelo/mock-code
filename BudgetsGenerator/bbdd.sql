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

INSERT INTO TPacks_futbol(Nombre, Precio) VALUES("Orange TV con más de 90 canales y todo el fútbol", 31.00);
INSERT INTO TPacks_futbol(Nombre, Precio) VALUES("Orange TV con más de 90 canales, deportes y todo el fútbol", 31.00);
INSERT INTO TCentralitas(Nombre, Precio) VALUES("Básica", 5.00);
INSERT INTO TCentralitas(Nombre, Precio) VALUES("Avanzada", 17.00);
INSERT INTO TDescuentos(Porciento) VALUES(10);
INSERT INTO TDescuentos(Porciento) VALUES(20);
INSERT INTO TDescuentos(Porciento) VALUES(30);
INSERT INTO TDescuentos(Porciento) VALUES(40);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea Smartphone Negocio Sin Límites", "Móvil", 1, "Ilimitadas", "Acceso al bono de GB compartido con la línea principal", NULL, 11.00);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea Smartphone Negocio 250 min", "Móvil", 1, "250 min", "Acceso al bono de GB compartido con la línea principal", NULL, 12.00);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea adicional Smartphone Negocio 2Gb", "Móvil", 1, "Ilimitadas", "2Gb", NULL, 8.00);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea Negocio Datos", "Datos", 1, "Ilimitadas", "Acceso al bono de GB compartido con la línea principal", NULL, 8.00);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea Negocio Datos", "Datos", 1, NULL, "Acceso al bono de GB compartido con la línea principal", NULL, 8.00);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea adicional Multisede con velocidad de 10Gb", "Fijo", 2, "Ilimitadas", NULL, "10Gb", 35.76);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea adicional Multisede con velocidad de 1Gb", "Fijo", 2, "Ilimitadas", NULL, "ADSL/1Gb", 27.50);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea Multisede Negocio con velocidad de 600Mb directa e indirecta 2P y 3P", "Fijo", 1, "Ilimitadas", NULL, "600Mb", 13.00);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea adicional Love Negocio Datos", "Datos", 1, NULL, "3Gb", NULL, 8.30);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea adicional Smartphone Empresa Smart", "Móvil", 1, "Ilimitadas", "30Gb", NULL, 3.31);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea móvil Negocio Base Sin Límites", "Móvil", 1, "Ilimitadas", "Ilimitados", NULL, 11.00);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea móvil Negocio Base Plus Sin Límites", "Móvil", 1, "Ilimitadas", "Ilimitados", NULL, 15.00);
INSERT INTO TLineas_adicionales(Nombre, Tipo, Num_lineas, Llamadas, Gb, Fibra, Precio) VALUES("Línea móvil Negocio 250 min", "Móvil", 1, "250 min", NULL, NULL, 12.00);
INSERT INTO TServicios_adicionales(Roaming, Internacional, Legalitas, Cloud, Ciber_proteccion, Atencion_personalizada, Centralita, Numero_beneficios, Descuento_beneficios) VALUES("45Gb", NULL, FALSE, FALSE, FALSE, FALSE, NULL, NULL, NULL);
INSERT INTO TServicios_adicionales(Roaming, Internacional, Legalitas, Cloud, Ciber_proteccion, Atencion_personalizada, Centralita, Numero_beneficios, Descuento_beneficios) VALUES("45Gb", NULL, FALSE, FALSE, FALSE, FALSE, NULL, NULL, NULL);
INSERT INTO TServicios_adicionales(Roaming, Internacional, Legalitas, Cloud, Ciber_proteccion, Atencion_personalizada, Centralita, Numero_beneficios, Descuento_beneficios) VALUES("60Gb", "200 min a fijos y móviles", TRUE, TRUE, FALSE, FALSE, NULL, 1, NULL);
INSERT INTO TServicios_adicionales(Roaming, Internacional, Legalitas, Cloud, Ciber_proteccion, Atencion_personalizada, Centralita, Numero_beneficios, Descuento_beneficios) VALUES("60Gb", "200 min a fijos y móviles", TRUE, TRUE, TRUE, FALSE, NULL, 2, NULL);
INSERT INTO TServicios_adicionales(Roaming, Internacional, Legalitas, Cloud, Ciber_proteccion, Atencion_personalizada, Centralita, Numero_beneficios, Descuento_beneficios) VALUES("60Gb", "200 min a fijos y móviles y 1.000 min de fijo a fijo", TRUE, TRUE, TRUE, FALSE, NULL, 3, NULL);
INSERT INTO TServicios_adicionales(Roaming, Internacional, Legalitas, Cloud, Ciber_proteccion, Atencion_personalizada, Centralita, Numero_beneficios, Descuento_beneficios) VALUES("60Gb", "200 min a fijos y móviles", TRUE, TRUE, TRUE, TRUE, "1 puesto fijo avanzado, IVR y DDIs adicionales", 3, "50% o 100% de descuento");
INSERT INTO TServicios_adicionales(Roaming, Internacional, Legalitas, Cloud, Ciber_proteccion, Atencion_personalizada, Centralita, Numero_beneficios, Descuento_beneficios) VALUES("60Gb", "200 min a fijos y móviles", TRUE, TRUE, TRUE, TRUE, "2 puestos fijos avanzados, IVR y DDIs adicionales", 3, "50% o 100% de descuento");
INSERT INTO TServicios_adicionales(Roaming, Internacional, Legalitas, Cloud, Ciber_proteccion, Atencion_personalizada, Centralita, Numero_beneficios, Descuento_beneficios) VALUES("20Gb", NULL, FALSE, FALSE, FALSE, FALSE, NULL, NULL, NULL);
INSERT INTO TTarifas(Nombre, Tipo, Lineas_moviles, Llamadas_movil, Gb_movil, Opcion_fibra1, Opcion_fibra2, Sobrecargo_fibra, Precio, FK_Servicios_ID, Tv, Servicio_streaming) VALUES("Negocio Base", "Captación", 1, "ilimitadas", "100Gb", "600Mb", "10Gb", 8.26, 42.00, 1, FALSE, FALSE);
INSERT INTO TTarifas(Nombre, Tipo, Lineas_moviles, Llamadas_movil, Gb_movil, Opcion_fibra1, Opcion_fibra2, Sobrecargo_fibra, Precio, FK_Servicios_ID, Tv, Servicio_streaming) VALUES("Negocio Base Plus", "Captación", 1, "ilimitadas", "Ilimitados", "1Gb", "10Gb", 8.26, 52.00, 2, TRUE, FALSE);
INSERT INTO TTarifas(Nombre, Tipo, Lineas_moviles, Llamadas_movil, Gb_movil, Opcion_fibra1, Opcion_fibra2, Sobrecargo_fibra, Precio, FK_Servicios_ID, Tv, Servicio_streaming) VALUES("Negocio Extra 1 línea", "Captación", 1, "ilimitadas", "Ilimitados", "1Gb", "10Gb", 8.26, 63.00, 3, TRUE, TRUE);
INSERT INTO TTarifas(Nombre, Tipo, Lineas_moviles, Llamadas_movil, Gb_movil, Opcion_fibra1, Opcion_fibra2, Sobrecargo_fibra, Precio, FK_Servicios_ID, Tv, Servicio_streaming) VALUES("Negocio Extra 3 línea", "Captación", 3, "ilimitadas", "Ilimitados", "1Gb", "10Gb", 8.26, 91.00, 4, TRUE, TRUE);
INSERT INTO TTarifas(Nombre, Tipo, Lineas_moviles, Llamadas_movil, Gb_movil, Opcion_fibra1, Opcion_fibra2, Sobrecargo_fibra, Precio, FK_Servicios_ID, Tv, Servicio_streaming) VALUES("Negocio Extra 5 línea", "Captación", 5, "ilimitadas", "Ilimitados", "1Gb", "10Gb", 8.26, 122.00, 5, TRUE, TRUE);
INSERT INTO TTarifas(Nombre, Tipo, Lineas_moviles, Llamadas_movil, Gb_movil, Opcion_fibra1, Opcion_fibra2, Sobrecargo_fibra, Precio, FK_Servicios_ID, Tv, Servicio_streaming) VALUES("Negocio Extra 10 línea", "Captación", 10, "ilimitadas", "Ilimitados", "2Gb", "10Gb", 8.26, 238.00, 6, FALSE, FALSE);
INSERT INTO TTarifas(Nombre, Tipo, Lineas_moviles, Llamadas_movil, Gb_movil, Opcion_fibra1, Opcion_fibra2, Sobrecargo_fibra, Precio, FK_Servicios_ID, Tv, Servicio_streaming) VALUES("Negocio Extra 20 línea", "Captación", 20, "ilimitadas", "Ilimitados", "2Gb", "10Gb", 8.26, 378.00, 7, FALSE, FALSE);
INSERT INTO TTarifas(Nombre, Tipo, Lineas_moviles, Llamadas_movil, Gb_movil, Opcion_fibra1, Opcion_fibra2, Sobrecargo_fibra, Precio, FK_Servicios_ID, Tv, Servicio_streaming) VALUES("Love Empresa Smart", "Cartera", 1, "ilimitadas", "Ilimitados", "ADSL/Fibra1Gb", "Fibra ONO 100Mb", 2.40, 31.00, 8, FALSE, FALSE);