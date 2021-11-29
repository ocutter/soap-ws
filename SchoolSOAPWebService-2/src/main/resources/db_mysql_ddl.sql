/* MySQL - Data Definition Language. */
/* Crear la base de datos, tablas necesarias y la relacion entre estas. */

CREATE DATABASE IF NOT EXISTS `school` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `school`;

DROP TABLE IF EXISTS `school`.`student`;

CREATE TABLE `school`.`student` ( `StudentId` INT NOT NULL AUTO_INCREMENT , `FullName` VARCHAR(200) NOT NULL , `DateOfBirth` DATE NOT NULL, `Gender` VARCHAR(20) NOT NULL , `AcademicDegree` VARCHAR(100) NOT NULL , `ParentId` INT NOT NULL , PRIMARY KEY (`StudentId`)) ENGINE = InnoDB;

DROP TABLE IF EXISTS `school`.`parent`;

CREATE TABLE `school`.`parent` ( `ParentId` INT NOT NULL AUTO_INCREMENT , `FullName` VARCHAR(200) NOT NULL , `IdentificationCard` VARCHAR(50) NOT NULL, `DateOfBirthStr` VARCHAR(100) NOT NULL , PRIMARY KEY (`ParentId`)) ENGINE = InnoDB;

ALTER TABLE `school`.`student` ADD CONSTRAINT `student-parent` FOREIGN KEY (`ParentId`) REFERENCES `parent`(`ParentId`) ON DELETE RESTRICT ON UPDATE RESTRICT;


CREATE VIEW IF NOT EXISTS view_student AS 
SELECT 
	T0.StudentId,
    T0.FullName,
    DATE_FORMAT(T0.DateOfBirth,  "%Y-%m-%d") AS DateOfBirth,
    CAST(TIMESTAMPDIFF(YEAR, T0.DateOfBirth, CURDATE()) AS SIGNED) AS Age,
    T0.Gender,
    T0.AcademicDegree,
    T1.ParentId,
    T1.FullName AS ParentFullName,
	T1.IdentificationCard AS ParentIdCard,
    T1.DateOfBirthStr AS ParentDOBText
FROM 
	`school`.`student` T0 
	INNER JOIN `school`.`parent` T1 ON T0.ParentId = T1.ParentId;
	