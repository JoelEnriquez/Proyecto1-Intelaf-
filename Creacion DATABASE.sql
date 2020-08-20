CREATE DATABASE INTELAF;
	USE INTELAF;


CREATE TABLE IF NOT EXISTS Tienda(
	codigo VARCHAR(10) NOT NULL,
	nombre VARCHAR(35) NOT NULL,
	direccion VARCHAR(30) NOT NULL,
	telefono_1 VARCHAR(15) NOT NULL,
	telefono_2 VARCHAR(15),
	horario VARCHAR(15),
	correo_electronico VARCHAR(50),

	PRIMARY KEY(codigo)
);


CREATE TABLE IF NOT EXISTS Cliente(
	NIT VARCHAR(13) NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	apellido VARCHAR(30),
	telefono VARCHAR(15) NOT NULL,
	DPI INT(13),
	credito FLOAT(12),
	efectivo FLOAT(12),
	direccion VARCHAR(30),
	correo_electronico VARCHAR(50),
	
	PRIMARY KEY(NIT)
);


CREATE TABLE IF NOT EXISTS Empleado(	
	codigo VARCHAR(10) NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	apellido VARCHAR(30),
	telefono VARCHAR(15) NOT NULL,
	DPI INT(13) NOT NULL,
	direccion VARCHAR(30) NOT NULL,
	correo_electronico VARCHAR(50) NOT NULL,
	NIT VARCHAR(13),
	codigo_tienda VARCHAR(10) NOT NULL,

	PRIMARY KEY(codigo),
	FOREIGN KEY(codigo_tienda) REFERENCES Tienda(codigo) 
);


CREATE TABLE IF NOT EXISTS Producto(
	codigo VARCHAR(10) NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	precio FLOAT(10) NOT NULL,
	fabricante VARCHAR(30) NOT NULL,
	cantidad INT (5) NOT NULL,
	descripción VARCHAR(60),
	garantia INT (2),
	codigo_tienda VARCHAR(10) NOT NULL,

	PRIMARY KEY(codigo),
	FOREIGN KEY(codigo_tienda) REFERENCES Tienda(codigo) 
);


CREATE TABLE IF NOT EXISTS Tiempo(
	id INT(3) NOT NULL, 
	codigo_tienda_1 VARCHAR(10) NOT NULL,
	codigo_tienda_2 VARCHAR(10) NOT NULL,
	tiempo_tiendas INT(2) NOT NULL,

	PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS Venta(
	codigo VARCHAR(10) NOT NULL,
	fecha DATE NOT NULL,
	anticipo FLOAT(8),
	codigo_producto VARCHAR(10) NOT NULL,
	cantidad INT(5) NOT NULL,
	total FLOAT(10) NOT NULL,
	codigo_tienda VARCHAR(10) NOT NULL,
	NIT_cliente VARCHAR(13) NOT NULL,

	PRIMARY KEY(codigo),
	INDEX(codigo_producto),
	FOREIGN KEY(codigo_producto) REFERENCES Producto(codigo),	
	INDEX(codigo_tienda),
	FOREIGN KEY(codigo_tienda) REFERENCES Tienda(codigo),
	INDEX(NIT_cliente),
	FOREIGN KEY(NIT_cliente) REFERENCES Cliente(NIT)
);


CREATE TABLE IF NOT EXISTS Pedido(
	codigo VARCHAR(10) NOT NULL,
	fecha DATE NOT NULL,
	codigo_producto VARCHAR(10) NOT NULL,
	cantidad INT(5) NOT NULL,
	anticipo FLOAT(8) NOT NULL,
	total FLOAT(10) NOT NULL,
	pedido_entregado BOOLEAN NOT NULL,	
	codigo_tienda_1 VARCHAR(10) NOT NULL,
	codigo_tienda_2 VARCHAR(10) NOT NULL,
	id_tiempo INT(3) NOT NULL,
	NIT_cliente VARCHAR(13) NOT NULL,

	PRIMARY KEY(codigo),

	INDEX(codigo_producto),
	FOREIGN KEY(codigo_producto) REFERENCES Producto(codigo),
	INDEX(codigo_tienda_1),
    FOREIGN KEY(codigo_tienda_1) REFERENCES Tienda(codigo),
    INDEX(codigo_tienda_2),
    FOREIGN KEY(codigo_tienda_2) REFERENCES Tienda(codigo),
    INDEX(id_tiempo),
    FOREIGN KEY(id_tiempo) REFERENCES Tiempo(id),
    INDEX(NIT_cliente),
    FOREIGN KEY(NIT_cliente) REFERENCES Cliente(NIT)
);
