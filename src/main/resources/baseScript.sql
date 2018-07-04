/*drop database if exists `simpledb`;*/

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Table `simpledb`.`user`
-- -----------------------------------------------------

/*CREATE DATABASE IF NOT EXISTS `simpledb` DEFAULT CHARACTER SET utf8 ;
USE `simpledb` ;*/

use sql7245411;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user`(
  `idUser` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) DEFAULT NULL,
  `userName` VARCHAR(255) NOT NULL,
  `userPass` VARCHAR(255) NOT NULL,
  `idRole` BIGINT(20) DEFAULT NULL,
  `idImage` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `idRole` (`idRole` ASC),
  INDEX `idImage` (`idImage` ASC),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`idImage`) REFERENCES `image` (`idImage`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role` ;

CREATE TABLE IF NOT EXISTS `role`(
  `idRole` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idRole`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `image` ;

CREATE TABLE IF NOT EXISTS `image` (
  `idImage` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `imageUrl` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idImage`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- SELECT GROUP_CONCAT(CONCAT('KILL ',id,';') SEPARATOR ' ') FROM information_schema.processlist  where user='sql2246030' and Command = 'sleep';