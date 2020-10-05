-- MySQL Script generated by MySQL Workbench
-- qui 01 out 2020 20:51:38
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema rentvent
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rentvent` ;

-- -----------------------------------------------------
-- Schema rentvent
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rentvent` ;
USE `rentvent` ;

-- -----------------------------------------------------
-- Table `rentvent`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`cliente` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`pessoa_fisica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`pessoa_fisica` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`pessoa_fisica` (
  `cpf` VARCHAR(11) NOT NULL,
  `rg` VARCHAR(8) NOT NULL,
  `data_expedicao` DATE NOT NULL,
  `orgao_emissor` VARCHAR(255) NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`cliente_id`),
  CONSTRAINT `fk_pessoa_fisica_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `rentvent`.`cliente` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`pessoa_juridica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`pessoa_juridica` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`pessoa_juridica` (
  `cnpj` VARCHAR(255) NOT NULL,
  `inscricao_estadual` VARCHAR(45) NULL,
  `inscricao_municipal` VARCHAR(45) NULL,
  `isento` VARCHAR(45) NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`cliente_id`),
  CONSTRAINT `fk_pessoa_juridica_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `rentvent`.`cliente` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`contato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`contato` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`contato` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `telefone` VARCHAR(10) NOT NULL,
  `celular` VARCHAR(11) NULL,
  `email` VARCHAR(255) NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`, `cliente_id`),
  INDEX `fk_contato_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_contato_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `rentvent`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`dados_pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`dados_pagamento` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`dados_pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titular` VARCHAR(255) NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`, `cliente_id`),
  INDEX `fk_dados_pagamento_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_dados_pagamento_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `rentvent`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`conta_bancaria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`conta_bancaria` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`conta_bancaria` (
  `agencia` VARCHAR(255) NOT NULL,
  `banco` VARCHAR(255) NOT NULL,
  `conta` VARCHAR(255) NOT NULL,
  `dados_pagamento_id` INT NOT NULL,
  `dados_pagamento_cliente_id` INT NOT NULL,
  PRIMARY KEY (`dados_pagamento_id`, `dados_pagamento_cliente_id`),
  CONSTRAINT `fk_conta_bancaria_dados_pagamento1`
    FOREIGN KEY (`dados_pagamento_id` , `dados_pagamento_cliente_id`)
    REFERENCES `rentvent`.`dados_pagamento` (`id` , `cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`cartao_credito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`cartao_credito` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`cartao_credito` (
  `numero` VARCHAR(255) NOT NULL,
  `validade` DATE NOT NULL,
  `cod_seguranca` VARCHAR(3) NOT NULL,
  `dados_pagamento_id` INT NOT NULL,
  `dados_pagamento_cliente_id` INT NOT NULL,
  PRIMARY KEY (`dados_pagamento_id`, `dados_pagamento_cliente_id`),
  CONSTRAINT `fk_cartao_credito_dados_pagamento1`
    FOREIGN KEY (`dados_pagamento_id` , `dados_pagamento_cliente_id`)
    REFERENCES `rentvent`.`dados_pagamento` (`id` , `cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`funcao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`funcao` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`funcao` (
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`cliente_id`),
  CONSTRAINT `fk_funcao_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `rentvent`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`locador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`locador` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`locador` (
  `funcao_cliente_id` INT NOT NULL,
  PRIMARY KEY (`funcao_cliente_id`),
  CONSTRAINT `fk_locador_funcao1`
    FOREIGN KEY (`funcao_cliente_id`)
    REFERENCES `rentvent`.`funcao` (`cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`locatario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`locatario` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`locatario` (
  `funcao_cliente_id` INT NOT NULL,
  PRIMARY KEY (`funcao_cliente_id`),
  CONSTRAINT `fk_locatario_funcao1`
    FOREIGN KEY (`funcao_cliente_id`)
    REFERENCES `rentvent`.`funcao` (`cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`espaco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`espaco` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`espaco` (
  `id` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `capacidade` INT NOT NULL,
  `valor_hora` DOUBLE NOT NULL,
  `valor_dia` DOUBLE NOT NULL,
  `disponibilidade` VARCHAR(255) NOT NULL,
  `locador_funcao_cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`, `locador_funcao_cliente_id`),
  INDEX `fk_espaco_locador1_idx` (`locador_funcao_cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_espaco_locador1`
    FOREIGN KEY (`locador_funcao_cliente_id`)
    REFERENCES `rentvent`.`locador` (`funcao_cliente_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`endereco` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`endereco` (
  `cep` VARCHAR(8) NOT NULL,
  `logradouro` VARCHAR(255) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `complemento` VARCHAR(255) NULL,
  `cidade` VARCHAR(255) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `espaco_id` INT NOT NULL,
  PRIMARY KEY (`espaco_id`),
  CONSTRAINT `fk_endereco_espaco1`
    FOREIGN KEY (`espaco_id`)
    REFERENCES `rentvent`.`espaco` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`locacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`locacao` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`locacao` (
  `espaco_id` INT NOT NULL,
  `espaco_locador_funcao_cliente_id` INT NOT NULL,
  `locatario_funcao_cliente_id` INT NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  PRIMARY KEY (`espaco_id`, `espaco_locador_funcao_cliente_id`, `locatario_funcao_cliente_id`),
  INDEX `fk_espaco_has_locatario_locatario1_idx` (`locatario_funcao_cliente_id` ASC) VISIBLE,
  INDEX `fk_espaco_has_locatario_espaco1_idx` (`espaco_id` ASC, `espaco_locador_funcao_cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_espaco_has_locatario_espaco1`
    FOREIGN KEY (`espaco_id` , `espaco_locador_funcao_cliente_id`)
    REFERENCES `rentvent`.`espaco` (`id` , `locador_funcao_cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_espaco_has_locatario_locatario1`
    FOREIGN KEY (`locatario_funcao_cliente_id`)
    REFERENCES `rentvent`.`locatario` (`funcao_cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`locacao_hora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`locacao_hora` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`locacao_hora` (
  `data_hora_inicial` DATETIME NOT NULL,
  `data_hora_final` DATETIME NOT NULL,
  `qtd_horas` DATETIME NOT NULL,
  `locacao_espaco_id` INT NOT NULL,
  `locacao_espaco_locador_funcao_cliente_id` INT NOT NULL,
  `locacao_locatario_funcao_cliente_id` INT NOT NULL,
  PRIMARY KEY (`locacao_espaco_id`, `locacao_espaco_locador_funcao_cliente_id`, `locacao_locatario_funcao_cliente_id`),
  CONSTRAINT `fk_locacao_hora_locacao1`
    FOREIGN KEY (`locacao_espaco_id` , `locacao_espaco_locador_funcao_cliente_id` , `locacao_locatario_funcao_cliente_id`)
    REFERENCES `rentvent`.`locacao` (`espaco_id` , `espaco_locador_funcao_cliente_id` , `locatario_funcao_cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentvent`.`locacao_dia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentvent`.`locacao_dia` ;

CREATE TABLE IF NOT EXISTS `rentvent`.`locacao_dia` (
  `data_inicial` DATETIME NOT NULL,
  `data_final` DATETIME NOT NULL,
  `qtd_dias` DATETIME NOT NULL,
  `locacao_espaco_id` INT NOT NULL,
  `locacao_espaco_locador_funcao_cliente_id` INT NOT NULL,
  `locacao_locatario_funcao_cliente_id` INT NOT NULL,
  PRIMARY KEY (`locacao_espaco_id`, `locacao_espaco_locador_funcao_cliente_id`, `locacao_locatario_funcao_cliente_id`),
  CONSTRAINT `fk_locacao_dia_locacao1`
    FOREIGN KEY (`locacao_espaco_id` , `locacao_espaco_locador_funcao_cliente_id` , `locacao_locatario_funcao_cliente_id`)
    REFERENCES `rentvent`.`locacao` (`espaco_id` , `espaco_locador_funcao_cliente_id` , `locatario_funcao_cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
