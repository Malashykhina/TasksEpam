-- MySQL Script generated by MySQL Workbench
-- 06/24/15 16:23:58
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema CoffeeDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `CoffeeDB` ;

-- -----------------------------------------------------
-- Schema CoffeeDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CoffeeDB` DEFAULT CHARACTER SET cp1251 COLLATE cp1251_ukrainian_ci ;
USE `CoffeeDB` ;

-- -----------------------------------------------------
-- Table `CoffeeDB`.`Coffee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoffeeDB`.`Coffee` ;

CREATE TABLE IF NOT EXISTS `CoffeeDB`.`Coffee` (
  `idCoffee` INT NOT NULL AUTO_INCREMENT,
  `coffeeType` VARCHAR(45) NULL,
  `pricePerServing` DOUBLE NULL,
  `servingsLeft` INT NULL,
  PRIMARY KEY (`idCoffee`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoffeeDB`.`Additives`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoffeeDB`.`Additives` ;

CREATE TABLE IF NOT EXISTS `CoffeeDB`.`Additives` (
  `idAdditive` INT NOT NULL AUTO_INCREMENT,
  `additiveType` VARCHAR(45) NULL,
  `pricePerServing` DOUBLE NULL,
  `servingsLeft` INT NULL,
  PRIMARY KEY (`idAdditive`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoffeeDB`.`Drink`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoffeeDB`.`Drink` ;

CREATE TABLE IF NOT EXISTS `CoffeeDB`.`Drink` (
  `idDrink` INT NOT NULL AUTO_INCREMENT,
  `numberOfDrinks` INT NULL,
  `Coffee_idCoffee` INT NOT NULL,
  PRIMARY KEY (`idDrink`, `Coffee_idCoffee`),
  INDEX `fk_Drink_Coffee1_idx` (`Coffee_idCoffee` ASC),
  CONSTRAINT `fk_Drink_Coffee1`
    FOREIGN KEY (`Coffee_idCoffee`)
    REFERENCES `CoffeeDB`.`Coffee` (`idCoffee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoffeeDB`.`Additives_Of_Specific_Drink`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoffeeDB`.`Additives_Of_Specific_Drink` ;

CREATE TABLE IF NOT EXISTS `CoffeeDB`.`Additives_Of_Specific_Drink` (
  `idAdditivesOfDrink` INT NOT NULL,
  `Additives_idAdditive` INT NOT NULL,
  `numberOfEditions` INT NULL,
  `Drink_idDrink` INT NOT NULL,
  PRIMARY KEY (`idAdditivesOfDrink`, `Additives_idAdditive`, `Drink_idDrink`),
  INDEX `fk_Additives_Of_Specific_Drink_Additives_idx` (`Additives_idAdditive` ASC),
  INDEX `fk_Additives_Of_Specific_Drink_Drink1_idx` (`Drink_idDrink` ASC),
  CONSTRAINT `fk_Additives_Of_Specific_Drink_Additives`
    FOREIGN KEY (`Additives_idAdditive`)
    REFERENCES `CoffeeDB`.`Additives` (`idAdditive`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Additives_Of_Specific_Drink_Drink1`
    FOREIGN KEY (`Drink_idDrink`)
    REFERENCES `CoffeeDB`.`Drink` (`idDrink`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoffeeDB`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoffeeDB`.`User` ;

CREATE TABLE IF NOT EXISTS `CoffeeDB`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoffeeDB`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoffeeDB`.`Order` ;

CREATE TABLE IF NOT EXISTS `CoffeeDB`.`Order` (
  `User_idUser` INT NOT NULL,
  `Drink_idDrink` INT NOT NULL,
  `Price` DOUBLE NULL,
  PRIMARY KEY (`User_idUser`, `Drink_idDrink`),
  INDEX `fk_Order_Drink1_idx` (`Drink_idDrink` ASC),
  CONSTRAINT `fk_Order_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `CoffeeDB`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Drink1`
    FOREIGN KEY (`Drink_idDrink`)
    REFERENCES `CoffeeDB`.`Drink` (`idDrink`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CoffeeDB`.`Card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CoffeeDB`.`Card` ;

CREATE TABLE IF NOT EXISTS `CoffeeDB`.`Card` (
  `cardNumber` VARCHAR(45) NULL,
  `User_idUser` INT NOT NULL,
  `money` DOUBLE NULL,
  PRIMARY KEY (`User_idUser`),
  INDEX `fk_Authorization_User1_idx` (`User_idUser` ASC),
  CONSTRAINT `fk_Authorization_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `CoffeeDB`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;






INSERT INTO `CoffeeDB`.`Coffee` ( `coffeeType`,`pricePerServing`,`servingsLeft`)
VALUES ("arabica",10,100);
commit;

INSERT INTO `CoffeeDB`.`Coffee` ( `coffeeType`,`pricePerServing`,`servingsLeft`)
VALUES ("java",8,100);
commit;

INSERT INTO `CoffeeDB`.`Coffee` ( `coffeeType`,`pricePerServing`,`servingsLeft`)
VALUES ("robusta",9,100);
commit;

INSERT INTO  `CoffeeDB`.`Additives` (
 `additiveType` ,  `pricePerServing` ,
  `servingsLeft`)
VALUES("Sugar",1,100);
commit;

INSERT INTO  `CoffeeDB`.`Additives` (
 `additiveType` ,  `pricePerServing` ,
  `servingsLeft`)
VALUES("Milk",2,100);
commit;

INSERT INTO  `CoffeeDB`.`Additives` (
 `additiveType` ,  `pricePerServing` ,
  `servingsLeft`)
VALUES("Cinnamon",1,100);
commit;

INSERT INTO  `CoffeeDB`.`User` (
`userName`, `password`)
VALUES("Admin","qazwsx");
commit;

INSERT INTO  `CoffeeDB`.`User` (
`userName`, `password`)
VALUES("Ann","123");
commit;

select * from  `CoffeeDB`.`User`;

select * from  `CoffeeDB`.`Coffee` ;

select * from  `CoffeeDB`.`Additives`;