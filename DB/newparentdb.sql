-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema newparentdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `newparentdb` ;

-- -----------------------------------------------------
-- Schema newparentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `newparentdb` DEFAULT CHARACTER SET utf8 ;
USE `newparentdb` ;

-- -----------------------------------------------------
-- Table `baby`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `baby` ;

CREATE TABLE IF NOT EXISTS `baby` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` VARCHAR(45) NULL,
  `last_feed` VARCHAR(200) NULL,
  `time_slept` VARCHAR(200) NULL,
  `number_of_naps` VARCHAR(200) NULL,
  `number_of_diaper_changes` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS newparent@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'newparent'@'localhost' IDENTIFIED BY 'newparent';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'newparent'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `baby`
-- -----------------------------------------------------
START TRANSACTION;
USE `newparentdb`;
INSERT INTO `baby` (`id`, `name`, `age`, `last_feed`, `time_slept`, `number_of_naps`, `number_of_diaper_changes`) VALUES (1, 'Kadence', '10', '12:00', '8 hrs', '1', '0');
INSERT INTO `baby` (`id`, `name`, `age`, `last_feed`, `time_slept`, `number_of_naps`, `number_of_diaper_changes`) VALUES (2, 'Max', '1', '13:45', '9.5 hrs', '2', '3');
INSERT INTO `baby` (`id`, `name`, `age`, `last_feed`, `time_slept`, `number_of_naps`, `number_of_diaper_changes`) VALUES (3, 'Joey', '2', '12:45', '9.25 hrs', '1', '2');
INSERT INTO `baby` (`id`, `name`, `age`, `last_feed`, `time_slept`, `number_of_naps`, `number_of_diaper_changes`) VALUES (4, 'Molly', '3', '10:12', '10 hrs', '0', '0');
INSERT INTO `baby` (`id`, `name`, `age`, `last_feed`, `time_slept`, `number_of_naps`, `number_of_diaper_changes`) VALUES (5, 'Madi', '1', '16:00', '9 hrs', '2', '4');

COMMIT;

