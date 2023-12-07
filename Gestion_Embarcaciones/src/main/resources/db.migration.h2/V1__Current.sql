

CREATE TABLE IF NOT EXISTS PROPIETARIOS (
                                            IdProp INT NOT NULL AUTO_INCREMENT,
                                            NomProp VARCHAR(20) NULL,
    ApsProp VARCHAR(30) NULL,
    Telefono VARCHAR(10) NULL,
    Correo VARCHAR(30) NULL,
    EstadoProp BOOLEAN NULL DEFAULT TRUE,
    PRIMARY KEY (IdProp)
    );

INSERT INTO PROPIETARIOS (NomProp, ApsProp, Telefono, Correo, EstadoProp)
VALUES ('Juan', 'Gomez', '1234567890', 'juan@gmail.com'
       , 1),
       ('Maria', 'Rodriguez', '9876543210', 'maria@gmail.com'
       , 1),
       ('Pedro', 'Martinez', '5555555555', 'pedro@gmail.com'
       , 1),
       ('Ana', 'Lopez', '1112223333', 'ana@gmail.com'
       , 1),
       ('Carlos', 'Perez', '9998887777', 'carlos@gmail.com'
       , 1),
       ('Laura', 'Gutierrez', '4443332222', 'laura@gmail.com'
       , 1),
       ('Javier', 'Fernandez', '7778889999', 'javier@gmail.com'
       , 1),
       ('Sofia', 'Diaz', '6667778888', 'sofia@gmail.com'
       , 1),
       ('Alejandro', 'Hernandez', '3334445555', 'alejandro@gmail.com'
       , 1),
       ('Carmen', 'Torres', '2225554444', 'carmen@gmail.com'
       , 1),
       ('Roberto', 'Sanchez', '8889991111', 'roberto@gmail.com'
       , 1),
       ('Luisa', 'Ramirez', '5554443333', 'luisa@gmail.com'
       , 1),
       ('Mario', 'Vargas', '7777777777', 'mario@gmail.com'
       , 1),
       ('Patricia', 'Castro', '6666666666', 'patricia@gmail.com'
       , 1),
       ('Raul', 'Gonzalez', '9999999999', 'raul@gmail.com'
       , 1),
       ('Isabel', 'Ortega', '1111111111', 'isabel@gmail.com'
       , 1),
       ('Hugo', 'Fuentes', '2222222222', 'hugo@gmail.com'
       , 1),
       ('Elena', 'Cruz', '3333333333', 'elena@gmail.com'
       , 1),
       ('Fernando', 'Mendoza', '4444444444', 'fernando@gmail.com'
       , 1),
       ('Monica', 'Luna', '5555555555', 'monica@gmail.com'
       , 1);

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS BARCOS (
                                      Matricula INT NOT NULL,
                                      NomBarco VARCHAR(30) NULL,
    CapitaniaPuerto VARCHAR(60) NULL,
    EstadoBarco VARCHAR(10) NULL,
    ArqueoBruto_Tons FLOAT NULL,
    ArqueoNeto_Tons FLOAT NULL,
    Eslora_Mts FLOAT NULL,
    Manga_Mts FLOAT NULL,
    Puntal_Mts FLOAT NULL,
    IdProp INT NULL,
    PRIMARY KEY (Matricula),
    FOREIGN KEY (IdProp) REFERENCES PROPIETARIOS (IdProp)
    );

INSERT INTO BARCOS
VALUES (121212121, 'Cielo Salado', 'Capitanía del Pacífico, Sinaloa', 'Disponible', 52
       , 41.6, 21.5, 8.8, 5.7, 6),
       (121234567, 'Navegante del Amanecer', 'Capitanía de los Altos, Zacatecas', 'Reparación', 57.3
       , 45.8, 23.8, 9.5, 6.8, 16),
       (223344550, 'Brisa Marítima', 'Capitanía de los Llanos, Tamaulipas', 'Disponible', 49.5
       , 39.6, 20.5, 8.2, 5.5, 14),
       (223344556, 'Velero del Horizonte', 'Capitanía del Golfo, Veracruz', 'Disponible', 45
       , 36, 18, 7.5, 5, 3),
       (321098765, 'Travesía del Crepúsculo', 'Capitanía del Desierto, Coahuila', 'Disponible', 54.8
       , 43.8, 22.5, 9, 6.2, 15),
       (345678901, 'Marejada Serena', 'Capitanía de Costa, Guerrero', 'Disponible', 50.5
       , 40.2, 20.5, 8.2, 5.5, 1),
       (432109876, 'Islas Gemelas', 'Capitanía del Bajío, Guanajuato', 'Disponible', 49.8
       , 39.8, 20.8, 8.3, 5.6, 9),
       (543210987, 'Brisas Doradas', 'Capitanía de los Cactus, Sonora', 'Reparación', 46.2
       , 37, 19.2, 7.7, 5.2, 20),
       (579024680, 'Mariposa del Mar', 'Capitanía del Sur, Chiapas', 'Disponible', 58.5
       , 46.8, 24, 9.5, 6.5, 7),
       (654321087, 'Estrella del Mar', 'Capitanía de las Playas, Nayarit', 'Disponible', 51.5
       , 41.2, 21.2, 8.8, 6, 18),
       (654321098, 'Náutico Soñador', 'Capitanía del Norte, Sonora', 'Disponible', 48.7
       , 38.9, 20, 8, 5.2, 5),
       (678901234, 'Aurora Boreal', 'Capitanía del Istmo, Veracruz', 'Disponible', 56
       , 44.8, 23, 9, 6, 13),
       (681012141, 'Espíritu Marino', 'Capitanía del Altiplano, Aguascalientes', 'Disponible', 55
       , 44, 22.8, 9.2, 6.5, 19),
       (681357902, 'Ola Infinita', 'Capitanía de la Huasteca, San Luis Potosí', 'Disponible', 47.2
       , 37.8, 19.5, 7.8, 5.3, 8),
       (765432100, 'Aurora Maris', 'Capitanía de la Península, Baja California', 'Disponible', 53.3
       , 42.6, 22.2, 8.7, 5.9, 10),
       (765432109, 'Albatros Azul', 'Capitanía de Sierra, Chihuahua', 'Disponible', 60.3
       , 48.1, 25, 9, 6, 2),
       (765432123, 'Travesía Tranquila', 'Capitanía de la Selva, Quintana Roo', 'Disponible', 50
       , 40, 21, 8, 5.5, 12),
       (765432198, 'Viento del Norte', 'Capitanía de la Tierra Caliente, Michoacán', 'Disponible', 48
       , 38.4, 20, 8.5, 5.8, 17),
       (900011122, 'Mar Luminoso', 'Capitanía de Montaña, Oaxaca', 'Disponible', 55.2
       , 44, 22.8, 8.5, 5.8, 4),
       (919191919, 'Sol de Medianoche', 'Capitanía de los Valles, Jalisco', 'Disponible', 46.5
       , 37.2, 19, 7.5, 5, 11);


CREATE TABLE IF NOT EXISTS TRIPULANTES (
    CURP VARCHAR(18) NOT NULL,
    NomTripulante VARCHAR(20) NULL,
    ApsTripulante VARCHAR(30) NULL,
    Matricula INT NULL,
    PRIMARY KEY (CURP),
    FOREIGN KEY (Matricula) REFERENCES BARCOS (Matricula)
    );

INSERT INTO TRIPULANTES
VALUES ('ASDF789012ZXCVBN56', 'Elena', 'Vargas', 765432123),
       ('BVCX789012QWERTY35', 'Héctor', 'Ríos', 223344556),
       ('ERTY321098NMKLJH76', 'Camila', 'Pérez', 121212121),
       ('GFDS432109ZXCVBN56', 'Sergio', 'Morales', 900011122),
       ('GFDS765432ZXCVBN01', 'Luis', 'Sánchez', 765432198),
       ('GHJK876543PLKJUY90', 'Javier', 'Núñez', 919191919),
       ('HGFD678901PLKJUY32', 'Francisco', 'Silva', 765432100),
       ('HJLO678901PQWAXZ54', 'Laura', 'Medina', 678901234),
       ('HJLO987654PQWAXZ12', 'Susana', 'Cruz', 654321098),
       ('KLMN567890POIUYT41', 'Alejandro', 'González', 543210987),
       ('KPOU753209QWERZX41', 'Guillermo', 'Méndez', 345678901),
       ('LQRF426709ZABMKL83', 'Diana', 'González', 223344556),
       ('MNBV890123LKJHGF45', 'Daniela', 'Jiménez', 765432100),
       ('MNOP654321LKJHGT87', 'Ángel', 'Torres', 765432109),
       ('MNOP678901LKJHGT34', 'Laura', 'Fernández', 765432198),
       ('NBVC567890QWERTY41', 'Andrés', 'Ortiz', 678901234),
       ('OIJK912345HGFDSA68', 'Lorena', 'Soto', 579024680),
       ('PLMK789012UIOJNH43', 'Miguel', 'Herrera', 321098765),
       ('PLMK876543UIOJNH29', 'Adriana', 'Mendoza', 432109876),
       ('POIU234567LKJHGT89', 'Gabriela', 'Martínez', 654321087),
       ('POIU567890LKJHGT21', 'Valeria', 'Herrera', 919191919),
       ('POIU876543LKJHGT21', 'Emilio', 'Rodríguez', 579024680),
       ('POIU876543LKJHGT29', 'Isabel', 'Ramos', 223344550),
       ('QWAS789012ZXCVBN34', 'Jorge', 'Cárdenas', 681357902),
       ('QWED876543ZXCVBN90', 'Ricardo', 'Ramírez', 654321087),
       ('QWER876543ZXCVBN12', 'José', 'García', 121234567),
       ('RAGH308765PLKMJI21', 'Roberto', 'Ruiz', 654321098),
       ('UIJK432109HGFDSA56', 'Carolina', 'Díaz', 121234567),
       ('UIJK543210HGFDSA98', 'Antonio', 'Márquez', 121212121),
       ('UIJK567890HGFDSA23', 'Juan', 'Pérez', 681012141),
       ('UYTR567120NBVCXE43', 'Natalia', 'Guzmán', 681357902),
       ('VBNM543210LKJHGT65', 'Ana', 'López', 681012141),
       ('WXTD938214IXYVHN62', 'Victoria', 'Gómez', 345678901),
       ('YSLM864102DCNVBH59', 'Silvia', 'Flores', 765432109),
       ('YUIO987654HJLKMN32', 'Carlos', 'Flores', 223344550),
       ('ZXCN109238BVFDRQ74', 'Beatriz', 'Moreno', 900011122),
       ('ZXCV123456QWERTY79', 'Raúl', 'Vázquez', 432109876),
       ('ZXCV345678QWERTY21', 'Paula', 'Torres', 321098765),
       ('ZXCV345678QWERTY67', 'Martín', 'Castro', 765432123),
       ('ZXCV432109QWERTY78', 'María', 'Rodríguez', 543210987);


CREATE TABLE IF NOT EXISTS CERT_COMPETENCIA (
    Folio VARCHAR(10) NOT NULL,
    CURP VARCHAR(18) NULL,
    FVigenciaCC DATE NULL,
    Categoria VARCHAR(30) NULL,
    PRIMARY KEY (Folio),
    FOREIGN KEY (CURP) REFERENCES TRIPULANTES (CURP)
    );



INSERT INTO CERT_COMPETENCIA
VALUES ('0005432-B', 'UIJK432109HGFDSA56', '2026-12-31', 'MAR. PESC.'),
       ('0008765-B', 'WXTD938214IXYVHN62', '2025-12-28', 'PAT. PESC. LIT.'),
       ('0009876-B', 'QWAS789012ZXCVBN34', '2026-03-08', 'PAT. PESC. LIT.'),
       ('0012345-B', 'RAGH308765PLKMJI21', '2027-08-15', '3ER. MOT. PESC.'),
       ('0019876-B', 'MNOP654321LKJHGT87', '2025-03-25', '2NDO. MOT. PESC.'),
       ('0023456-B', 'ZXCN109238BVFDRQ74', '2028-04-18', 'PAT. PESC. LIT.'),
       ('0026789-B', 'VBNM543210LKJHGT65', '2025-09-19', '2NDO. MOT. PESC.'),
       ('0032109-B', 'OIJK912345HGFDSA68', '2026-12-11', 'PATRON DE COSTA'),
       ('0043210-B', 'HJLO678901PQWAXZ54', '2028-05-11', 'MAR. PESC.'),
       ('0067123-B', 'ZXCV345678QWERTY21', '2027-06-25', '2NDO. MOT. PESC.'),
       ('0078901-B', 'ASDF789012ZXCVBN56', '2028-11-03', '2NDO. MOT. PESC.'),
       ('0087345-B', 'POIU234567LKJHGT89', '2026-02-14', 'PAT. PESC. LIT.'),
       ('0098765-B', 'MNBV890123LKJHGF45', '2025-08-15', '2NDO. MOT. PESC.'),
       ('124567', 'POIU567890LKJHGT21', '2025-02-20', 'PAT. PESC. LIT.'),
       ('215689', 'ZXCV123456QWERTY79', '2025-10-26', 'MAR. PESC.'),
       ('365402', 'QWED876543ZXCVBN90', '2025-12-02', '1ER. MOT. PESC.'),
       ('408932', 'ZXCV432109QWERTY78', '2023-10-27', 'PATRON DE COSTA'),
       ('478215', 'UYTR567120NBVCXE43', '2026-06-19', 'MAR. PESC.'),
       ('482036', 'MNOP678901LKJHGT34', '2026-08-07', '1ER. MOT. PESC.'),
       ('532497', 'YSLM864102DCNVBH59', '2025-06-06', '3ER. MOT. PESC.'),
       ('569812', 'UIJK543210HGFDSA98', '2027-02-22', '3ER. MOT. PESC.'),
       ('619204', 'POIU876543LKJHGT29', '2027-11-17', 'PAT. PESC. LIT.'),
       ('753198', 'HJLO987654PQWAXZ12', '2027-10-26', '2NDO. MOT. PESC.'),
       ('753982', 'PLMK789012UIOJNH43', '2027-03-14', '3ER. MOT. PESC.'),
       ('830126', 'ZXCV345678QWERTY67', '2028-08-22', '3ER. MOT. PESC.'),
       ('964801', 'BVCX789012QWERTY35', '2028-07-29', '1ER. MOT. PESC.'),
       ('SM00123456', 'HGFD678901PLKJUY32', '2025-05-04', '3ER. MOT. PESC.'),
       ('SM00129876', 'GFDS765432ZXCVBN01', '2023-05-26', '2NDO. MOT. PESC.'),
       ('SM00235678', 'YUIO987654HJLKMN32', '2027-09-06', '1ER. MOT. PESC.'),
       ('SM00324561', 'KLMN567890POIUYT41', '2025-01-15', 'MAR. PESC.'),
       ('SM00345678', 'KPOU753209QWERZX41', '2025-09-17', 'MAR. PESC.'),
       ('SM00432198', 'PLMK876543UIOJNH29', '2025-12-31', '1ER. MOT. PESC.'),
       ('SM00543210', 'GHJK876543PLKJUY90', '2028-12-16', 'PATRON DE COSTA'),
       ('SM00678901', 'POIU876543LKJHGT21', '2026-09-30', '2NDO. MOT. PESC.'),
       ('SM00781523', 'UIJK567890HGFDSA23', '2025-07-08', '3ER. MOT. PESC.'),
       ('SM00789012', 'GFDS432109ZXCVBN56', '2028-01-06', 'MAR. PESC.'),
       ('SM00876543', 'NBVC567890QWERTY41', '2028-02-29', '1ER. MOT. PESC.'),
       ('SM00890123', 'LQRF426709ZABMKL83', '2028-10-10', 'PATRON DE COSTA'),
       ('SM00901234', 'ERTY321098NMKLJH76', '2027-06-04', '1ER. MOT. PESC.'),
       ('SM00987412', 'QWER876543ZXCVBN12', '2026-10-18', 'PATRON DE COSTA');

CREATE TABLE IF NOT EXISTS CERT_SEGURIDAD (
    NoCert VARCHAR(13) NOT NULL,
    Matricula INT NULL,
    LugarExpedicion VARCHAR(60) NULL,
    FExpedicion DATE NULL,
    FVigenciaCS DATE NULL,
    PRIMARY KEY (NoCert),
    FOREIGN KEY (Matricula) REFERENCES BARCOS (Matricula)
    );

INSERT INTO CERT_SEGURIDAD
VALUES ('DICM-059-0268', 900011122, 'PROGRESO, YUCATÁN', '2023-04-15', '2024-04-15'),
       ('DICM-059-1234', 543210987, 'IRAPUATO, GUANAJUATO', '2022-10-04', '2023-10-04'),
       ('DICM-059-1357', 223344550, 'PROGRESO, YUCATÁN', '2022-12-05', '2023-12-05'),
       ('DICM-059-1874', 765432109, 'ACAPULCO, GUERRERO', '2023-02-05', '2024-02-05'),
       ('DICM-059-2109', 765432100, 'VALLADOLID, YUCATÁN', '2023-10-14', '2024-10-14'),
       ('DICM-059-2468', 321098765, 'MERIDA, YUCATÁN', '2022-12-10', '2023-12-10'),
       ('DICM-059-3146', 579024680, 'PROGRESO, YUCATÁN', '2023-07-30', '2024-07-30'),
       ('DICM-059-3579', 765432123, 'ACAPULCO, GUERRERO', '2023-11-24', '2024-12-24'),
       ('DICM-059-4321', 765432198, 'ACAPULCO, GUERRERO', '2022-12-20', '2023-12-20'),
       ('DICM-059-4680', 681357902, 'ACAPULCO, GUERRERO', '2023-08-04', '2024-08-04'),
       ('DICM-059-5032', 345678901, 'PROGRESO, YUCATÁN', '2023-01-01', '2024-01-01'),
       ('DICM-059-5678', 681012141, 'TIJUANA, BAJA CALIFORNIA', '2022-08-30', '2023-08-30'),
       ('DICM-059-5791', 654321098, 'IRAPUATO, GUANAJUATO', '2023-05-20', '2024-05-20'),
       ('DICM-059-6942', 223344556, 'VALLADOLID, YUCATÁN', '2023-03-10', '2024-03-10'),
       ('DICM-059-7531', 432109876, 'TICUL, YUCATÁN', '2023-09-09', '2024-09-09'),
       ('DICM-059-8023', 121212121, 'VALLADOLID, YUCATÁN', '2023-06-25', '2024-06-25'),
       ('DICM-059-8642', 919191919, 'TIJUANA, BAJA CALIFORNIA', '2023-11-19', '2024-11-19'),
       ('DICM-059-8765', 121234567, 'TICUL, YUCATÁN', '2022-05-15', '2023-05-15'),
       ('DICM-059-9513', 678901234, 'IZAMAL, YUCATÁN', '2022-12-29', '2023-12-29'),
       ('DICM-059-9876', 654321087, 'MERIDA, YUCATÁN', '2022-12-25', '2023-12-25');


CREATE TABLE IF NOT EXISTS EMBARCACIONES (
                                             Matricula INT NOT NULL,
                                             FSalida DATE NOT NULL,
                                             FRegreso DATE NULL,
                                             PRIMARY KEY (Matricula, FSalida),
    FOREIGN KEY (Matricula) REFERENCES BARCOS (Matricula)
    );




CREATE TABLE IF NOT EXISTS EXTINTORES (
                                          Matricula INT NOT NULL,
                                          FVigenciaEx DATE NOT NULL,
                                          Cantidad INT NULL,
                                          PRIMARY KEY (Matricula, FVigenciaEx),
    FOREIGN KEY (Matricula) REFERENCES BARCOS (Matricula)
    );

INSERT INTO EXTINTORES
VALUES (121212121, '2024-01-01', 2),
       (121234567, '2025-12-01', 4),
       (223344550, '2026-04-01', 2),
       (223344556, '2025-03-01', 4),
       (321098765, '2026-05-01', 3),
       (345678901, '2025-01-01', 2),
       (432109876, '2025-04-01', 2),
       (543210987, '2024-04-01', 3),
       (579024680, '2024-02-01', 3),
       (654321087, '2023-02-01', 1),
       (654321098, '2024-05-01', 4),
       (678901234, '2025-03-01', 2),
       (681012141, '2024-03-01', 2),
       (681357902, '2026-03-01', 1),
       (765432100, '2026-05-01', 3),
       (765432109, '2026-02-01', 3),
       (765432123, '2024-02-01', 3),
       (765432198, '2023-01-01', 4),
       (900011122, '2025-04-01', 2),
       (919191919, '2026-01-01', 4);


CREATE TABLE IF NOT EXISTS MOTORES (
                                       Matricula INT NOT NULL,
                                       NoMotor INT NOT NULL,
                                       Marca VARCHAR(20) NULL,
    Potencia_KW FLOAT NULL,
    PRIMARY KEY (Matricula, NoMotor),
    FOREIGN KEY (Matricula) REFERENCES BARCOS (Matricula)
    );

INSERT INTO MOTORES
VALUES (121212121, 1, 'Torqeedo', 185),
       (121234567, 1, 'Torqeedo', 185),
       (121234567, 2, 'Torqeedo', 190.2),
       (223344550, 1, 'Vetus', 170.7),
       (223344556, 1, 'Evinrude', 160.9),
       (321098765, 1, 'Yanmar', 160.9),
       (345678901, 1, 'Mercury', 150.5),
       (345678901, 2, 'Mercury', 200),
       (432109876, 1, 'MAN', 175.1),
       (432109876, 2, 'MAN', 255.9),
       (543210987, 1, 'Yamaha', 210.6),
       (579024680, 1, 'Mercury', 230.5),
       (654321087, 1, 'Vetus', 175.1),
       (654321098, 1, 'Lehr', 195.4),
       (678901234, 1, 'Tohatsu', 225.3),
       (681012141, 1, 'Westerbeke', 195.4),
       (681357902, 1, 'MAN', 200),
       (765432100, 1, 'Westerbeke', 210.6),
       (765432109, 1, 'Yamaha', 180.3),
       (765432109, 2, 'Yamaha', 220.7),
       (765432123, 1, 'MTU', 210.6),
       (765432198, 1, 'Evinrude', 205.8),
       (765432198, 2, 'Evinrude', 170.7),
       (900011122, 1, 'Tohatsu', 205.8),
       (900011122, 2, 'Tohatsu', 175.1),
       (919191919, 1, 'Lehr', 225.3),
       (919191919, 2, 'Lehr', 190.2);


CREATE TABLE IF NOT EXISTS PERMISO_PESCA_COM (
    NoPermiso VARCHAR(12) NOT NULL,
    Matricula INT NULL,
    FVigenciaPPC DATE NULL,
    PRIMARY KEY (NoPermiso),
    FOREIGN KEY (Matricula) REFERENCES BARCOS (Matricula)
    );

INSERT INTO PERMISO_PESCA_COM
VALUES ('106254793828', 121212121, '2024-06-28'),
       ('149235870632', 678901234, '2026-10-28'),
       ('239461507815', 121234567, '2024-12-03'),
       ('281904637590', 432109876, '2027-08-07'),
       ('365812094782', 321098765, '2028-08-29'),
       ('392874561890', 223344556, '2026-01-18'),
       ('430978612564', 579024680, '2025-08-22'),
       ('457801362189', 543210987, '2028-05-16'),
       ('503216978421', 765432100, '2028-12-12'),
       ('568931247605', 765432109, '2025-05-09'),
       ('572036198404', 765432198, '2023-10-17'),
       ('615209487332', 900011122, '2027-04-25'),
       ('618349205473', 681012141, '2027-01-10'),
       ('687540213921', 223344550, '2027-11-20'),
       ('724859631207', 345678901, '2024-03-15'),
       ('759183240156', 681357902, '2026-07-15'),
       ('825617439008', 765432123, '2025-11-04'),
       ('847502136974', 654321098, '2028-02-02'),
       ('894761320576', 654321087, '2023-11-02'),
       ('974306182345', 919191919, '2024-09-12');







CREATE TABLE IF NOT EXISTS TipoPesca (
    NoPermiso VARCHAR(12) NOT NULL,
    NoEspecie INT NOT NULL,
    Especie VARCHAR(30) NULL,
    PRIMARY KEY (NoPermiso, NoEspecie),
    FOREIGN KEY (NoPermiso) REFERENCES PERMISO_PESCA_COM (NoPermiso)
    );

INSERT INTO TipoPesca
VALUES ('106254793828', 1, 'Lubina'),
       ('106254793828', 2, 'Pez Espada'),
       ('149235870632', 1, 'Trucha'),
       ('149235870632', 2, 'Ostra'),
       ('239461507815', 1, 'Langosta'),
       ('281904637590', 1, 'Trucha'),
       ('365812094782', 1, 'Camarón'),
       ('365812094782', 2, 'Almeja'),
       ('392874561890', 1, 'Atún'),
       ('430978612564', 1, 'Merluza'),
       ('457801362189', 1, 'Pulpo'),
       ('503216978421', 1, 'Calamar'),
       ('503216978421', 2, 'Lubina'),
       ('568931247605', 1, 'Bacalao'),
       ('568931247605', 2, 'Pez Espada'),
       ('572036198404', 1, 'Langostino'),
       ('615209487332', 1, 'Dorado'),
       ('618349205473', 1, 'Mejillón'),
       ('687540213921', 1, 'Calamar'),
       ('687540213921', 2, 'Pulpo'),
       ('724859631207', 1, 'Atún'),
       ('724859631207', 2, 'Salmón'),
       ('759183240156', 1, 'Dorado'),
       ('825617439008', 1, 'Merluza'),
       ('825617439008', 2, 'Langosta'),
       ('847502136974', 1, 'Bacalao'),
       ('847502136974', 2, 'Salmón'),
       ('894761320576', 1, 'Ostra'),
       ('974306182345', 1, 'Camarón');
