App de Registro de Películas
Posee las funciones de agregar películas y categorías, buscar por texto o agrupar por
categorías,modificar, eliminar y listar.
Está configurada para funcionar con OracleDB, utiliza dos tablas: Categoría y Película

Script Tablas


Categoría

CREATE TABLE "CATEGORIA" 
   (	"ID" NUMBER(11,0) NOT NULL ENABLE, 
	"DESCRIPCION" VARCHAR2(50 CHAR) NOT NULL ENABLE, 
	 CONSTRAINT "PK_CATEGORIA" PRIMARY KEY ("ID"));
     
     
Película

CREATE TABLE "PELICULA" 
   (	"CODIGO" NUMBER(11,0) NOT NULL ENABLE, 
	"PRECIO" NUMBER(11,0) NOT NULL ENABLE, 
	"ID" NUMBER(11,0) NOT NULL ENABLE, 
	"FORMATO4K" VARCHAR2(1 CHAR) NOT NULL ENABLE, 
	"NOMBRE" VARCHAR2(50 CHAR) NOT NULL ENABLE, 
	 CONSTRAINT "PK_CODIGO" PRIMARY KEY ("CODIGO"));
     
     ALTER TABLE PELICULA
     ADD CONSTRAINT "FK_PELICULA_CATEGORIA" FOREIGN KEY ("ID")
	  REFERENCES "CATEGORIA" ("ID");