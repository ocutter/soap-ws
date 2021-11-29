/* MySQL - Data Manipulation Language. */
/* Insertar registros iniciales para pruebas. */

DELETE FROM `school`.`parent`;

INSERT INTO  `school`.`parent` (ParentId, IdentificationCard, FullName, DateOfBirthStr) VALUES(1,'031-0025415-1','JUAN SMITH','NOVEMBER 20, 1989');
INSERT INTO  `school`.`parent` (ParentId, IdentificationCard, FullName, DateOfBirthStr) VALUES(2,'005-0665452-4','CARMEN SOSA','JANUARY 20, 1999');
INSERT INTO  `school`.`parent` (ParentId, IdentificationCard, FullName, DateOfBirthStr) VALUES(3,'025-0005245-5','TOMAS ALCANTARA','NOVEMBER 20, 1990');
INSERT INTO  `school`.`parent` (ParentId, IdentificationCard, FullName, DateOfBirthStr) VALUES(4,'025-0014522-5','JHON MILLER','MARCH 20, 1992');
INSERT INTO  `school`.`parent` (ParentId, IdentificationCard, FullName, DateOfBirthStr) VALUES(5,'030-0254554-3','TERESA SANTOS','MAY 20, 1989');
INSERT INTO  `school`.`parent` (ParentId, IdentificationCard, FullName, DateOfBirthStr) VALUES(6,'027-0000215-1','RAMON CABRERA','OCTOBER 20, 1995');


INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('JOSE SMITH','2010-11-20','MALE','ASSOCIATE','1'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('MARIA PEREZ','2011-1-15','FEMALE','ASSOCIATE','2'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('TOMAS PEREZ','2002-5-1','MALE','BACHELOR','2'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('RONNY PEREZ','2004-6-12','MALE','BACHELOR','2'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('RAFAELA ALCANTARA','2011-7-15','FEMALE','ASSOCIATE','3'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('JOSEPH MILLER','2008-5-31','MALE','ASSOCIATE','4'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('HANNA MILLER','2005-4-25','FEMALE','BACHELOR','4'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('TOMAS DE LA ROSA','2006-6-26','MALE','ASSOCIATE','5'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('JOSE CABRERA','2004-8-26','MALE','BACHELOR','6'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('ROLANDO CABRERA','2004-12-31','MALE','ASSOCIATE','6'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('SOFIA CABRERA','2003-10-1','FEMALE','BACHELOR','6'); 
INSERT INTO  `school`.`student` (FullName, DateOfBirth, Gender, AcademicDegree, ParentId) VALUES('ANA CABRERA','2006-10-20','FEMALE','ASSOCIATE','6'); 