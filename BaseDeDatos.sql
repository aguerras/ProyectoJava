DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`rol_usuario`$$
CREATE TABLE `proyecto`.`rol_usuario` (
`id_rol` INT NOT NULL AUTO_INCREMENT,
`nombre_rol` VARCHAR(50) NOT NULL,
`descripcion` VARCHAR(250) NOT NULL,
`fecha_creacion` DATETIME NOT NULL,
`fecha_modificacion` DATETIME NULL,
PRIMARY KEY (`id_rol`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`pais`$$
CREATE TABLE `proyecto`.`pais` (
`id_pais` INT NOT NULL AUTO_INCREMENT,
`nombre_pais` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id_pais`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`estado_usuario`$$
CREATE TABLE `proyecto`.`estado_usuario` (
`id_estado` INT NOT NULL AUTO_INCREMENT,
`nombre_estado` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id_estado`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`usuario`$$
CREATE TABLE `proyecto`.`usuario` (
`id_usuario` INT NOT NULL AUTO_INCREMENT,
`nombres` VARCHAR(250) NOT NULL,
`apellidos` VARCHAR(250) NOT NULL,
`sexo` INT(11) NOT NULL,
`email` VARCHAR(100) NOT NULL,
`fecha_nacimiento` DATETIME NOT NULL,
`fecha_creacion` DATETIME NOT NULL,
`id_rol` INT(11) NOT NULL,
`foto` VARCHAR(100) NOT NULL,
`id_pais` INT(11) NOT NULL,
`telefono` VARCHAR(20) NOT NULL,
`clave_acceso` VARCHAR(250) NOT NULL,
`estado` INT(11) NOT NULL,
PRIMARY KEY (`id_usuario`),
FOREIGN KEY (`id_rol`) REFERENCES `proyecto`.`rol_usuario`(`id_rol`),
FOREIGN KEY (`id_pais`) REFERENCES `proyecto`.`pais`(`id_pais`),
FOREIGN KEY (`estado`) REFERENCES `proyecto`.`estado_usuario`(`id_estado`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`estado_proveedor`$$
CREATE TABLE `proyecto`.`estado_proveedor` (
`id_estado` INT NOT NULL AUTO_INCREMENT,
`nombre_estado` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id_estado`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`proveedor`$$
CREATE TABLE `proyecto`.`proveedor` (
`id_proveedor` INT(11) NOT NULL AUTO_INCREMENT,
`nombre` VARCHAR(250) NOT NULL,
`direccion` VARCHAR(250) NOT NULL,
`telefono` INT(11) NOT NULL,
`fax` VARCHAR(250) NULL,
`estado` INT(11) NOT NULL,
`fecha_creacion` DATETIME NULL,
`nombre_comercial` VARCHAR(250) NOT NULL,
`nit` VARCHAR(9) NOT NULL,
`documentacion_completa` INT(11) NULL,
`observaciones` VARCHAR(250) NULL,
PRIMARY KEY (`id_proveedor`),
FOREIGN KEY (`estado`) REFERENCES `proyecto`.`estado_proveedor`(`id_estado`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`estado_producto`$$
CREATE TABLE `proyecto`.`estado_producto` (
`id_estado` INT NOT NULL AUTO_INCREMENT,
`nombre_estado` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id_estado`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`tipo_producto`$$
CREATE TABLE `proyecto`.`tipo_producto` (
`id_tipo` INT NOT NULL AUTO_INCREMENT,
`nombre_tipo` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id_tipo`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`producto`$$
CREATE TABLE `proyecto`.`producto` (
`id_producto` INT(11) NOT NULL AUTO_INCREMENT,
`nombre_producto` VARCHAR(250) NOT NULL,
`descripcion` VARCHAR(250) NOT NULL,
`id_proveedor` INT(11) NOT NULL,
`tipo` INT(11) NOT NULL,
`temporalidad_inicial` DATETIME NULL,
`temporalidad_final` DATETIME NULL,
`expiracion` DATETIME NULL,
`precio` FLOAT(11) NOT NULL,
`descuento` FLOAT NULL,
`condiciones` VARCHAR(250) NULL,
`estado` INT(11) NOT NULL,
`devolucion` INT(11) NULL,
PRIMARY KEY (`id_producto`),
FOREIGN KEY (`id_proveedor`) REFERENCES `proyecto`.`proveedor`(`id_proveedor`),
FOREIGN KEY (`estado`) REFERENCES `proyecto`.`estado_producto`(`id_estado`),
FOREIGN KEY (`tipo`) REFERENCES `proyecto`.`tipo_producto`(`id_tipo`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`detalle_producto`$$
CREATE TABLE `proyecto`.`detalle_producto` (
`id_producto` INT(11) NOT NULL,
`cantidad` INT(11) NULL,
`ilimitado` INT(11) NULL,
`id_usuario_creacion` INT(11) NOT NULL,
`fecha_creacion` DATETIME NOT NULL,
FOREIGN KEY (`id_producto`) REFERENCES `proyecto`.`producto`(`id_producto`),
FOREIGN KEY (`id_usuario_creacion`) REFERENCES `proyecto`.`usuario`(`id_usuario`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`facturacion`$$
CREATE TABLE `proyecto`.`facturacion` (
`id_facturacion` INT NOT NULL AUTO_INCREMENT,
`id_usuario` INT NOT NULL,
`nombres` VARCHAR(64) NOT NULL,
`apellidos` VARCHAR(64) NOT NULL,
`nit` VARCHAR(9) NOT NULL,
`direccion` VARCHAR(250) NOT NULL,
`estado` INT NOT NULL,
PRIMARY KEY (`id_facturacion`),
FOREIGN KEY (`id_usuario`) REFERENCES `proyecto`.`usuario`(`id_usuario`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`tipo_factura`$$
CREATE TABLE `proyecto`.`tipo_factura` (
`id_tipo` INT NOT NULL AUTO_INCREMENT,
`nombre_factura` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id_tipo`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`factura`$$
CREATE TABLE `proyecto`.`factura` (
`id_factura` INT(11) NOT NULL AUTO_INCREMENT,
`precio_total` INT(11) NOT NULL,
`id_usuario` INT(11) NOT NULL,
`id_facturacion` INT(11) NULL,
`tipo` INT(11) NOT NULL,
`fecha_facturacion` DATETIME NULL,
PRIMARY KEY (`id_factura`),
FOREIGN KEY (`id_usuario`) REFERENCES `proyecto`.`usuario`(`id_usuario`),
FOREIGN KEY (`id_facturacion`) REFERENCES `proyecto`.`facturacion`(`id_facturacion`),
FOREIGN KEY (`tipo`) REFERENCES `proyecto`.`tipo_factura`(`id_tipo`)
) ENGINE = InnoDB$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`detalle_factura`$$
CREATE TABLE `proyecto`.`detalle_factura` (
`id_factura` INT(11) NOT NULL,
`id_producto` INT(11) NOT NULL,
`cantidad` INT(11) NOT NULL,
FOREIGN KEY (`id_factura`) REFERENCES `proyecto`.`factura`(`id_factura`),
FOREIGN KEY (`id_producto`) REFERENCES `proyecto`.`producto`(`id_producto`)
) ENGINE = InnoDB$$
DELIMITER ;

