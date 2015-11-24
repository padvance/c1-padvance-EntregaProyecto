-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema preguntas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `preguntas` ;

-- -----------------------------------------------------
-- Schema preguntas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `preguntas` DEFAULT CHARACTER SET latin1 ;
USE `preguntas` ;

-- -----------------------------------------------------
-- Table `preguntas`.`materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `preguntas`.`materia` ;

CREATE TABLE IF NOT EXISTS `preguntas`.`materia` (
  `idmateria` INT NOT NULL AUTO_INCREMENT,
  `descri_materia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmateria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `preguntas`.`respuesta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `preguntas`.`respuesta` ;

CREATE TABLE IF NOT EXISTS `preguntas`.`respuesta` (
  `idrespuesta` INT NOT NULL AUTO_INCREMENT,
  `descri_respuesta` VARCHAR(45) NOT NULL,
  `veracidad_respuesta` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`idrespuesta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `preguntas`.`pregunta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `preguntas`.`pregunta` ;

CREATE TABLE IF NOT EXISTS `preguntas`.`pregunta` (
  `idpregunta` INT NOT NULL AUTO_INCREMENT,
  `descri_pregunta` VARCHAR(45) NULL,
  `tipo_pregunta` VARCHAR(45) NULL,
  `materia_idmateria` INT NOT NULL,
  `respuesta_idrespuesta` INT NOT NULL,
  `dificultad_pregunta` VARCHAR(45) NULL,
  `peso_pregunta` INT NULL,
  PRIMARY KEY (`idpregunta`),
  CONSTRAINT `fk_pregunta_materia`
    FOREIGN KEY (`materia_idmateria`)
    REFERENCES `preguntas`.`materia` (`idmateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pregunta_respuesta1`
    FOREIGN KEY (`respuesta_idrespuesta`)
    REFERENCES `preguntas`.`respuesta` (`idrespuesta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_pregunta_materia_idx` ON `preguntas`.`pregunta` (`materia_idmateria` ASC);

CREATE INDEX `fk_pregunta_respuesta1_idx` ON `preguntas`.`pregunta` (`respuesta_idrespuesta` ASC);


-- -----------------------------------------------------
-- Table `preguntas`.`pregunta_has_respuesta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `preguntas`.`pregunta_has_respuesta` ;

CREATE TABLE IF NOT EXISTS `preguntas`.`pregunta_has_respuesta` (
  `pregunta_idpregunta` INT NOT NULL,
  `respuesta_idrespuesta` INT NOT NULL,
  `id_pregrespueta` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_pregrespueta`),
  CONSTRAINT `fk_pregunta_has_respuesta_pregunta1`
    FOREIGN KEY (`pregunta_idpregunta`)
    REFERENCES `preguntas`.`pregunta` (`idpregunta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pregunta_has_respuesta_respuesta1`
    FOREIGN KEY (`respuesta_idrespuesta`)
    REFERENCES `preguntas`.`respuesta` (`idrespuesta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_pregunta_has_respuesta_respuesta1_idx` ON `preguntas`.`pregunta_has_respuesta` (`respuesta_idrespuesta` ASC);

CREATE INDEX `fk_pregunta_has_respuesta_pregunta1_idx` ON `preguntas`.`pregunta_has_respuesta` (`pregunta_idpregunta` ASC);


-- -----------------------------------------------------
-- Table `preguntas`.`examen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `preguntas`.`examen` ;

CREATE TABLE IF NOT EXISTS `preguntas`.`examen` (
  `idexamen` INT NOT NULL AUTO_INCREMENT,
  `descri_examen` VARCHAR(45) NULL,
  PRIMARY KEY (`idexamen`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `preguntas`.`examen_has_pregunta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `preguntas`.`examen_has_pregunta` ;

CREATE TABLE IF NOT EXISTS `preguntas`.`examen_has_pregunta` (
  `examen_idexamen` INT NOT NULL,
  `pregunta_idpregunta` INT NOT NULL,
  `id_exampreg` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_exampreg`),
  CONSTRAINT `fk_examen_has_pregunta_examen1`
    FOREIGN KEY (`examen_idexamen`)
    REFERENCES `preguntas`.`examen` (`idexamen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_examen_has_pregunta_pregunta1`
    FOREIGN KEY (`pregunta_idpregunta`)
    REFERENCES `preguntas`.`pregunta` (`idpregunta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_examen_has_pregunta_pregunta1_idx` ON `preguntas`.`examen_has_pregunta` (`pregunta_idpregunta` ASC);

CREATE INDEX `fk_examen_has_pregunta_examen1_idx` ON `preguntas`.`examen_has_pregunta` (`examen_idexamen` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
