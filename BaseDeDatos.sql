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

DELIMITER $$
ALTER TABLE `proyecto`.`usuario` MODIFY `sexo` INT(11) NULL$$
ALTER TABLE `proyecto`.`usuario` MODIFY `email` VARCHAR(100) NULL$$
ALTER TABLE `proyecto`.`usuario` MODIFY `fecha_nacimiento` DATETIME NULL$$
ALTER TABLE `proyecto`.`usuario` MODIFY `telefono` VARCHAR(20) NULL$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
INSERT INTO `proyecto`.`rol_usuario`(`id_rol`, `nombre_rol`, `descripcion`, `fecha_creacion`, `fecha_modificacion`) VALUES (1, "Administrador", "Tiene acceso a todas las funciones de la página.", NOW(), NOW())$$
INSERT INTO `proyecto`.`rol_usuario`(`id_rol`, `nombre_rol`, `descripcion`, `fecha_creacion`, `fecha_modificacion`) VALUES (2, "Cliente", "Puede comprar productos dentro de la página.", NOW(), NOW())$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
INSERT INTO `proyecto`.`pais`(`nombre_pais`) VALUES ("Guatemala")$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
INSERT INTO `proyecto`.`estado_usuario`(`id_estado`, `nombre_estado`) VALUES (1, "Activo")$$
INSERT INTO `proyecto`.`estado_usuario`(`id_estado`, `nombre_estado`) VALUES (2, "Inactivo")$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
INSERT INTO `proyecto`.`usuario`(`id_usuario`, `nombres`, `apellidos`, `sexo`, `email`, `fecha_nacimiento`, `fecha_creacion`, `id_rol`, `foto`, `id_pais`, `telefono`, `clave_acceso`, `estado`) VALUES (1, "Administrador", "Administrador", NULL, NULL, NULL, NOW(), 1, "404.jpg", 1, NULL, md5("admin"), 1)$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
INSERT INTO `proyecto`.`estado_proveedor`(`id_estado`, `nombre_estado`) VALUES (1, "Activo")$$
INSERT INTO `proyecto`.`estado_proveedor`(`id_estado`, `nombre_estado`) VALUES (2, "Inactivo")$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
INSERT INTO `proyecto`.`estado_producto`(`id_estado`, `nombre_estado`) VALUES (1, "Activo")$$
INSERT INTO `proyecto`.`estado_producto`(`id_estado`, `nombre_estado`) VALUES (2, "Inactivo")$$
INSERT INTO `proyecto`.`estado_producto`(`id_estado`, `nombre_estado`) VALUES (3, "Vencido")$$
INSERT INTO `proyecto`.`estado_producto`(`id_estado`, `nombre_estado`) VALUES (4, "Sin_stock")$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
INSERT INTO `proyecto`.`tipo_producto`(`id_tipo`, `nombre_tipo`) VALUES (1, "Producto_normal")$$
DELIMITER ;

/***********************************************************************************************************************/

DELIMITER $$
INSERT INTO `proyecto`.`tipo_factura`(`id_tipo`, `nombre_factura`) VALUES (1, "Factura_simplificada")$$
INSERT INTO `proyecto`.`tipo_factura`(`id_tipo`, `nombre_factura`) VALUES (2, "Factura_ordinaria")$$
DELIMITER ;

ALTER TABLE `usuario` DROP FOREIGN KEY usuario_ibfk_3;
DROP TABLE IF EXISTS `proyecto`.`estado_usuario`;

ALTER TABLE `producto` DROP COLUMN temporalidad_inicial;
ALTER TABLE `producto` DROP COLUMN temporalidad_final;
ALTER TABLE `producto` DROP COLUMN expiracion;
ALTER TABLE `producto` DROP COLUMN condiciones;
ALTER TABLE `producto` DROP COLUMN devolucion;

ALTER TABLE `proyecto`.`rol_usuario` MODIFY COLUMN `fecha_creacion` VARCHAR(20) NULL;
ALTER TABLE `proyecto`.`rol_usuario` MODIFY COLUMN `fecha_modificacion` VARCHAR(20) NULL;
ALTER TABLE `proyecto`.`usuario` MODIFY COLUMN `fecha_nacimiento` VARCHAR(20) NULL;
ALTER TABLE `proyecto`.`usuario` MODIFY COLUMN `fecha_creacion` VARCHAR(20) NULL;
ALTER TABLE `proyecto`.`proveedor` MODIFY COLUMN `fecha_creacion` VARCHAR(20) NULL;
ALTER TABLE `proyecto`.`detalle_producto` MODIFY COLUMN `fecha_creacion` VARCHAR(20) NULL;
ALTER TABLE `proyecto`.`factura` MODIFY COLUMN `fecha_facturacion` VARCHAR(20) NULL;
ALTER TABLE `proyecto`.`producto` ADD `path_img` VARCHAR(250) NULL AFTER `descuento`;
ALTER TABLE `proyecto`.`producto` CHANGE COLUMN `tipo` `id_tipo` int(11) NOT NULL;

ALTER TABLE `proyecto`.`producto` ADD `id_usuario` INT(11) NOT NULL AFTER `path_img`;
ALTER TABLE `proyecto`.`producto` ADD `cantidad` INT(11) NOT NULL AFTER `id_usuario`;
UPDATE `proyecto`.`producto` SET id_usuario = 1;
ALTER TABLE `proyecto`.`producto` ADD FOREIGN KEY (`id_usuario`) REFERENCES `proyecto`.`usuario`(`id_usuario`);

ALTER TABLE `usuario` DROP FOREIGN KEY usuario_ibfk_3;
DROP TABLE IF EXISTS `proyecto`.`estado_usuario`;
DROP TABLE IF EXISTS `proyecto`.`detalle_producto`;

RENAME TABLE `proyecto`.`rol_usuario` TO `proyecto`.`rol`;

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`pedido`$$
CREATE TABLE `proyecto`.`pedido` (
`id_pedido` INT NOT NULL AUTO_INCREMENT,
`id_usuario` INT NOT NULL,
`id_producto` INT NOT NULL,
`cantidad` INT NOT NULL,
`precio_total` FLOAT NOT NULL,
PRIMARY KEY (`id_pedido`),
FOREIGN KEY (`id_usuario`) REFERENCES `proyecto`.`usuario`(`id_usuario`),
FOREIGN KEY (`id_producto`) REFERENCES `proyecto`.`producto`(`id_producto`)
) ENGINE = InnoDB$$
DELIMITER ;

ALTER TABLE `proyecto`.`rol` DROP COLUMN `fecha_creacion`;
ALTER TABLE `proyecto`.`rol` DROP COLUMN `fecha_modificacion`;
ALTER TABLE `proyecto`.`pedido` DROP FOREIGN KEY pedido_ibfk_2;
ALTER TABLE `proyecto`.`pedido` DROP COLUMN `id_producto`;
ALTER TABLE `proyecto`.`pedido` DROP COLUMN `cantidad`;

DELIMITER $$
DROP TABLE IF EXISTS `proyecto`.`detalle_pedido`$$
CREATE TABLE `proyecto`.`detalle_pedido` (
`id_pedido` INT NOT NULL AUTO_INCREMENT,
`id_producto` INT NOT NULL,
`cantidad` INT NOT NULL,
FOREIGN KEY (`id_pedido`) REFERENCES `proyecto`.`pedido`(`id_pedido`),
FOREIGN KEY (`id_producto`) REFERENCES `proyecto`.`producto`(`id_producto`)
) ENGINE = InnoDB$$
DELIMITER ;

ALTER TABLE `proyecto`.`factura` CHANGE COLUMN `tipo` `id_tipo` INT(11) NOT NULL;


ALTER TABLE `proyecto`.`factura` DROP FOREIGN KEY `factura_ibfk_2`;
ALTER TABLE `proyecto`.`factura` DROP COLUMN `id_facturacion`;
DROP TABLE `proyecto`.`facturacion`;

ALTER TABLE `proyecto`.`proveedor` DROP FOREIGN KEY `proveedor_ibfk_1`;
ALTER TABLE `proyecto`.`producto` DROP FOREIGN KEY `producto_ibfk_2`;
ALTER TABLE `proyecto`.`tipo_producto` ADD `estado` INT(11) NOT NULL AFTER `nombre_tipo`;
ALTER TABLE `proyecto`.`proveedor` DROP KEY `estado`;
ALTER TABLE `proyecto`.`producto` DROP KEY `estado`;