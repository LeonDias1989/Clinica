SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `consultas`
-- ----------------------------
DROP TABLE IF EXISTS `consultas`;
CREATE TABLE `consultas` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `paciente` int(10) NOT NULL,
  `detalhes` text,
  `data_inicio` timestamp NOT NULL,
  `data_fim` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_consultas_pacientes_idx` (`paciente`),
  CONSTRAINT `fk_consultas_pacientes` FOREIGN KEY (`paciente`) REFERENCES `pacientes` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `consultas_medicamentos`
-- ----------------------------
DROP TABLE IF EXISTS `consultas_medicamentos`;
CREATE TABLE `consultas_medicamentos` (
  `consulta` int(15) NOT NULL,
  `medicamento` int(10) NOT NULL,
  PRIMARY KEY (`consulta`,`medicamento`),
  KEY `fk_consultas_has_medicamentos_medicamentos1_idx` (`medicamento`),
  KEY `fk_consultas_has_medicamentos_consultas1_idx` (`consulta`),
  CONSTRAINT `fk_consultas_has_medicamentos_consultas1` FOREIGN KEY (`consulta`) REFERENCES `consultas` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_consultas_has_medicamentos_medicamentos1` FOREIGN KEY (`medicamento`) REFERENCES `medicamentos` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `medicamentos`
-- ----------------------------
DROP TABLE IF EXISTS `medicamentos`;
CREATE TABLE `medicamentos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `pacientes`
-- ----------------------------
DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE `pacientes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `cpf` char(11) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for `view_agenda`
-- ----------------------------
DROP VIEW IF EXISTS `view_agenda`;
CREATE VIEW `view_agenda` AS select `pacientes`.`nome` AS `paciente`,`consultas`.`detalhes` AS `detalhes`,`consultas`.`data_inicio` AS `data_inicio` from (`consultas` join `pacientes` on((`consultas`.`paciente` = `pacientes`.`id`))) where ((`consultas`.`data_inicio` > now()) and isnull(`consultas`.`data_fim`)) order by `consultas`.`data_inicio` desc ;

-- ----------------------------
-- View structure for `view_historico`
-- ----------------------------
DROP VIEW IF EXISTS `view_historico`;
CREATE VIEW `view_historico` AS select `pacientes`.`nome` AS `paciente`,`consultas`.`detalhes` AS `detalhes`,`consultas`.`data_inicio` AS `data_inicio`,`consultas`.`data_fim` AS `data_fim` from (`consultas` join `pacientes` on((`consultas`.`paciente` = `pacientes`.`id`))) where (`consultas`.`data_inicio` < now()) order by `consultas`.`data_inicio` desc ;
