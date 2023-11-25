-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bfqi5lpcbyzizmap4utb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bfqi5lpcbyzizmap4utb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bfqi5lpcbyzizmap4utb` DEFAULT CHARACTER SET utf8 ;
USE `bfqi5lpcbyzizmap4utb` ;

-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`PROPIETARIOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`PROPIETARIOS` (
  `IdProp` INT NOT NULL AUTO_INCREMENT,
  `NomProp` VARCHAR(20) NULL DEFAULT NULL,
  `ApsProp` VARCHAR(30) NULL DEFAULT NULL,
  `Telefono` CHAR(10) NULL DEFAULT NULL,
  `Correo` VARCHAR(30) NULL DEFAULT NULL,
  `EstadoProp` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`IdProp`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`BARCOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`BARCOS` (
  `Matricula` INT NOT NULL,
  `NomBarco` VARCHAR(30) NULL DEFAULT NULL,
  `CapitaniaPuerto` VARCHAR(60) NULL DEFAULT NULL,
  `EstadoBarco` VARCHAR(10) NULL DEFAULT NULL,
  `ArqueoBruto_Tons` FLOAT NULL DEFAULT NULL,
  `ArqueoNeto_Tons` FLOAT NULL DEFAULT NULL,
  `Eslora_Mts` FLOAT NULL DEFAULT NULL,
  `Manga_Mts` FLOAT NULL DEFAULT NULL,
  `Puntal_Mts` FLOAT NULL DEFAULT NULL,
  `IdProp` INT NULL DEFAULT NULL,
  PRIMARY KEY (`Matricula`),
  INDEX `IdProp` (`IdProp` ASC) VISIBLE,
  CONSTRAINT `BARCOS_ibfk_1`
    FOREIGN KEY (`IdProp`)
    REFERENCES `bfqi5lpcbyzizmap4utb`.`PROPIETARIOS` (`IdProp`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`TRIPULANTES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`TRIPULANTES` (
  `CURP` CHAR(18) NOT NULL,
  `NomTripulante` VARCHAR(20) NULL DEFAULT NULL,
  `ApsTripulante` VARCHAR(30) NULL DEFAULT NULL,
  `Matricula` INT NULL DEFAULT NULL,
  PRIMARY KEY (`CURP`),
  INDEX `Matricula` (`Matricula` ASC) VISIBLE,
  CONSTRAINT `TRIPULANTES_ibfk_1`
    FOREIGN KEY (`Matricula`)
    REFERENCES `bfqi5lpcbyzizmap4utb`.`BARCOS` (`Matricula`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`CERT_COMPETENCIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`CERT_COMPETENCIA` (
  `Folio` VARCHAR(10) NOT NULL,
  `CURP` CHAR(18) NULL DEFAULT NULL,
  `FVigenciaCC` DATE NULL DEFAULT NULL,
  `Categoria` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`Folio`),
  INDEX `CURP` (`CURP` ASC) VISIBLE,
  CONSTRAINT `CERT_COMPETENCIA_ibfk_1`
    FOREIGN KEY (`CURP`)
    REFERENCES `bfqi5lpcbyzizmap4utb`.`TRIPULANTES` (`CURP`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`CERT_SEGURIDAD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`CERT_SEGURIDAD` (
  `NoCert` CHAR(13) NOT NULL,
  `Matricula` INT NULL DEFAULT NULL,
  `LugarExpedicion` VARCHAR(60) NULL DEFAULT NULL,
  `FExpedicion` DATE NULL DEFAULT NULL,
  `FVigenciaCS` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`NoCert`),
  INDEX `Matricula` (`Matricula` ASC) VISIBLE,
  CONSTRAINT `CERT_SEGURIDAD_ibfk_1`
    FOREIGN KEY (`Matricula`)
    REFERENCES `bfqi5lpcbyzizmap4utb`.`BARCOS` (`Matricula`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`EMBARCACIONES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`EMBARCACIONES` (
  `Matricula` INT NOT NULL,
  `FSalida` DATE NOT NULL,
  `FRegreso` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`Matricula`, `FSalida`),
  CONSTRAINT `EMBARCACIONES_ibfk_1`
    FOREIGN KEY (`Matricula`)
    REFERENCES `bfqi5lpcbyzizmap4utb`.`BARCOS` (`Matricula`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`EXTINTORES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`EXTINTORES` (
  `Matricula` INT NOT NULL,
  `FVigenciaEx` DATE NOT NULL,
  `Cantidad` INT NULL DEFAULT NULL,
  PRIMARY KEY (`Matricula`, `FVigenciaEx`),
  CONSTRAINT `EXTINTORES_ibfk_1`
    FOREIGN KEY (`Matricula`)
    REFERENCES `bfqi5lpcbyzizmap4utb`.`BARCOS` (`Matricula`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`MOTORES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`MOTORES` (
  `Matricula` INT NOT NULL,
  `NoMotor` INT NOT NULL,
  `Marca` VARCHAR(20) NULL DEFAULT NULL,
  `Potencia_KW` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`Matricula`, `NoMotor`),
  CONSTRAINT `MOTORES_ibfk_1`
    FOREIGN KEY (`Matricula`)
    REFERENCES `bfqi5lpcbyzizmap4utb`.`BARCOS` (`Matricula`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`PERMISO_PESCA_COM`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`PERMISO_PESCA_COM` (
  `NoPermiso` CHAR(12) NOT NULL,
  `Matricula` INT NULL DEFAULT NULL,
  `FVigenciaPPC` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`NoPermiso`),
  INDEX `Matricula` (`Matricula` ASC) VISIBLE,
  CONSTRAINT `PERMISO_PESCA_COM_ibfk_1`
    FOREIGN KEY (`Matricula`)
    REFERENCES `bfqi5lpcbyzizmap4utb`.`BARCOS` (`Matricula`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bfqi5lpcbyzizmap4utb`.`TipoPesca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfqi5lpcbyzizmap4utb`.`TipoPesca` (
  `NoPermiso` CHAR(12) NOT NULL,
  `NoEspecie` INT NOT NULL,
  `Especie` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`NoPermiso`, `NoEspecie`),
  CONSTRAINT `TipoPesca_ibfk_1`
    FOREIGN KEY (`NoPermiso`)
    REFERENCES `bfqi5lpcbyzizmap4utb`.`PERMISO_PESCA_COM` (`NoPermiso`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
