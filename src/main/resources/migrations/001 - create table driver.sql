--liquibase formatted sql

--changeset baidyanathprasad:1 dbms=mysql
CREATE TABLE IF NOT EXISTS `Drivers_Basic Info` (
  `id` CHAR(36) NOT NULL,
  `name` VARCHAR (50) NOT NULL,
  `email` VARCHAR (50) NOT NULL,
  `phone` INT NOT NULL, 
  `ext` VARCHAR(5) NOT NULL,
  `created_on` DATETIME DEFAULT NOW(),
  `updated_on` DATETIME DEFAULT NOW() ON UPDATE NOW(),
  `licence_id` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `fk.Drivers_Basic Info.email` (`email` ASC),
  UNIQUE INDEX `fk.Drivers_Basic Info.phone` (`phone`, `ext` ASC)
) ENGINE = InnoDB;

--rollback DROP TABLE `Drivers_Basic Info`;