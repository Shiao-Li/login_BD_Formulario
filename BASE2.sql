create database base2;
use base2;

CREATE TABLE `base2`.`usuario` (
  `Id` CHAR(12) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Celular` VARCHAR(45) NULL,
  `Correo` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`));
  
INSERT INTO `base2`.`usuario` (`Id`, `Nombre`, `Celular`, `Correo`) VALUES ('1720179645', 'Alexis Chasi', '09456781345', 'alexis.chasi@gmail.com');
INSERT INTO `base2`.`usuario` (`Id`, `Nombre`, `Celular`, `Correo`) VALUES ('1765466548', 'Elvis Guanoluisa', '09456754512', 'elvis.guanoluisa@gmail.com');
INSERT INTO `base2`.`usuario` (`Id`, `Nombre`, `Celular`, `Correo`) VALUES ('1765465484', 'Jared Valenzuela', '09465468436', 'jared.valen@epn.edu.ec');
INSERT INTO `base2`.`usuario` (`Id`, `Nombre`, `Celular`, `Correo`) VALUES ('1745697459', 'Joseph Yepez', '09453543655', 'josep.yepez@gmail.com');
INSERT INTO `base2`.`usuario` (`Id`, `Nombre`, `Celular`, `Correo`) VALUES ('1748453543', 'Alejandro Moreira', '0954135454', 'alejo@epn.edu.ec');


select * from usuario