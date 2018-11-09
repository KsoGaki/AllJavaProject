CREATE DATABASE IF NOT EXISTS `bestioles_test`;
USE `bestioles_test`;

CREATE TABLE IF NOT EXISTS `specie` (
  `id_Specie` int(11) NOT NULL AUTO_INCREMENT,
  `commonName` varchar(50) NOT NULL DEFAULT '0',
  `latinName` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_Specie`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `specie` (`id_Specie`, `commonName`, `latinName`) VALUES
	(1, 'Rabbit', 'Lepus'),
	(2, 'Dog', 'Canis'),
	(3, 'Cat', 'Felis');

CREATE TABLE IF NOT EXISTS `animal` (
  `id_Animal` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `coatColor` varchar(50) NOT NULL,
  `id_Specie` int(11) NOT NULL,
  PRIMARY KEY (`id_Animal`),
  KEY `FK_animal_specie` (`id_Specie`),
  CONSTRAINT `FK_animal_specie` FOREIGN KEY (`id_Specie`) REFERENCES `specie` (`id_Specie`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `animal` (`id_Animal`, `name`, `sex`, `coatColor`, `id_Specie`) VALUES
	(1, 'Said', 1, 'Brown', 2),
	(2, 'SaiDiable', 1, 'Red', 3),
	(3, 'SaiDoux', 0, 'Yellow', 1),
	(4, 'SaiDur', 0, 'Black', 2),
	(5, 'SaiDange', 1, 'White', 1),
	(6, 'SaiDonnee', 0, 'Green', 3);
	
CREATE TABLE IF NOT EXISTS `person` (
  `id_Person` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL DEFAULT '0',
  `lastName` varchar(50) NOT NULL DEFAULT '0',
  `age` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_Person`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `person` (`id_Person`, `firstName`, `lastName`, `age`) VALUES
	(1, 'Said', 'Oubram', 23),
	(2, 'Nathan', 'Lepers', 22),
	(3, 'Jonathan', 'Dupuis', 26),
	(4, 'Malik', 'Khelfa', 25),
	(5, 'Wissam', 'Salameh', 35);
	
CREATE TABLE IF NOT EXISTS `animal__person` (
  `id_Animal` int(11) NOT NULL,
  `id_Person` int(11) NOT NULL,
  PRIMARY KEY (`id_Animal`,`id_Person`),
  KEY `FK_Animal__Person_person` (`id_Person`),
  CONSTRAINT `FK_Animal__Person_animal` FOREIGN KEY (`id_Animal`) REFERENCES `animal` (`id_Animal`),
  CONSTRAINT `FK_Animal__Person_person` FOREIGN KEY (`id_Person`) REFERENCES `person` (`id_Person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `animal__person` (`id_Animal`, `id_Person`) VALUES
	(1, 1),
	(5, 2),
	(3, 3),
	(1, 4),
	(2, 4),
	(4, 4),
	(4, 5),
	(5, 5),
	(6, 5);