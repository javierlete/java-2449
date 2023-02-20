BEGIN TRANSACTION;
DROP TABLE IF EXISTS "clientes";
CREATE TABLE IF NOT EXISTS "clientes" (
	"id"	INTEGER NOT NULL,
	"nombre"	VARCHAR(50) NOT NULL,
	"nif"	CHAR(9) NOT NULL,
	"telefono"	CHAR(9),
	"email"	VARCHAR(50),
	"fecha_nacimiento"	DATE,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "clientes" ("id","nombre","nif","telefono","email","fecha_nacimiento") VALUES (1,'Javier','12345678Z','654321321','javier@email.net','2000-01-02'),
 (2,'Pepe','87654321Z',NULL,NULL,NULL);
COMMIT;
