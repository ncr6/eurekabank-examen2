-- ----------------------------------
-- Relación entre empleado y sucursal
-- ----------------------------------

ALTER TABLE `eurekabank`.`empleado` 
ADD COLUMN `sucucodigo` CHAR(3) NULL AFTER `emplclave`,
ADD INDEX `fk_empleado_sucursal_idx` (`sucucodigo` ASC) VISIBLE;
;
ALTER TABLE `eurekabank`.`empleado` 
ADD CONSTRAINT `fk_empleado_sucursal`
  FOREIGN KEY (`sucucodigo`)
  REFERENCES `eurekabank`.`sucursal` (`sucucodigo`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
