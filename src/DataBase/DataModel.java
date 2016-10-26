/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author elenice.carvalho
 */
public class DataModel {

    PreparedStatement pst;

    public void createDataBase() throws SQLException {
        Db conexao = new Db();

        pst = conexao.open().prepareStatement("CREATE DATABASE IF NOT EXISTS valter_teste DEFAULT CHARACTER SET utf8 \n"
                + "DEFAULT COLLATE utf8_general_ci");
        pst.execute();

        pst = conexao.open().prepareStatement("CREATE TABLE IF NOT EXISTS `valter_teste`.`Usuario`(\n"
                + " `usu_codigo` INT NOT NULL AUTO_INCREMENT,\n"
                + " `usu_nome` VARCHAR(255) NOT NULL,\n"
                + " `usu_login` VARCHAR(50) NOT NULL,\n"
                + " `usu_senha` VARCHAR(32) NOT NULL,\n"
                + " `usu_email` VARCHAR(255) NULL,\n"
                + " `usu_status` ENUM('0', '1') NOT NULL DEFAULT '1',\n"
                + " PRIMARY KEY (`usu_codigo`));");

        pst.execute();

    }

//-- ------------------------------------------------------
//-- Table `valter_banco`.`usuario`
//-- -----------------------------------------------------
//CREATE TABLE IF NOT EXISTS `valter_banco`.`usuario` (
//  `usu_codigo` INT NOT NULL AUTO_INCREMENT,
//  `usu_nome` VARCHAR(255) NOT NULL,
//  `usu_login` VARCHAR(50) NOT NULL,
//  `usu_senha` VARCHAR(32) NOT NULL,
//  `usu_email` VARCHAR(255) NULL,
//  `usu_status` ENUM('0', '1') NOT NULL DEFAULT '1',
//  PRIMARY KEY (`usu_codigo`))
//ENGINE = InnoDB;
//
//
//-- -----------------------------------------------------
//-- Table `valter_banco`.`modulo`
//-- -----------------------------------------------------
//CREATE TABLE IF NOT EXISTS `valter_banco`.`modulo` (
//  `mod_codigo` INT NOT NULL AUTO_INCREMENT,
//  `mod_nome` VARCHAR(255) NOT NULL,
//  `mod_classe` VARCHAR(255) NOT NULL,
//  `mod_status` ENUM('0', '1') NOT NULL,
//  PRIMARY KEY (`mod_codigo`))
//ENGINE = InnoDB;
//
//
//-- -----------------------------------------------------
//-- Table `valter_banco`.`permissao`
//-- -----------------------------------------------------
//CREATE TABLE IF NOT EXISTS `valter_banco`.`permissao` (
//  `per_codigo` INT NOT NULL AUTO_INCREMENT,
//  `per_usuario` INT NOT NULL,
//  `per_modulo` INT NOT NULL,
//  PRIMARY KEY (`per_codigo`),
//  INDEX `FK_per_usuario_idx` (`per_usuario` ASC),
//  INDEX `FK_per_modulo_idx` (`per_modulo` ASC),
//  CONSTRAINT `FK_per_usuario`
//    FOREIGN KEY (`per_usuario`)
//    REFERENCES `valter_banco`.`usuario` (`usu_codigo`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION,
//  CONSTRAINT `FK_per_modulo`
//    FOREIGN KEY (`per_modulo`)
//    REFERENCES `valter_banco`.`modulo` (`mod_codigo`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION)
//ENGINE = InnoDB;
//
//
//-- -----------------------------------------------------
//-- Table `valter_banco`.`tipo_conta`
//-- -----------------------------------------------------
//CREATE TABLE IF NOT EXISTS `valter_banco`.`tipo_conta` (
//  `tip_codigo` INT NOT NULL AUTO_INCREMENT,
//  `tipo_nome` VARCHAR(255) NOT NULL,
//  `tipo_status` ENUM('0', '1') NOT NULL DEFAULT '1',
//  PRIMARY KEY (`tip_codigo`))
//ENGINE = InnoDB;
//
//
//-- -----------------------------------------------------
//-- Table `valter_banco`.`cliente`
//-- -----------------------------------------------------
//CREATE TABLE IF NOT EXISTS `valter_banco`.`cliente` (
//  `cli_codigo` INT NOT NULL AUTO_INCREMENT,
//  `cli_nome` VARCHAR(255) NOT NULL,
//  `cli_cpf` CHAR(11) NOT NULL,
//  `cli_idade` INT NOT NULL,
//  `cli_email` VARCHAR(255) NULL,
//  `cli_status` ENUM('0', '1') NOT NULL DEFAULT '1',
//  PRIMARY KEY (`cli_codigo`))
//ENGINE = InnoDB;
//
//
//-- -----------------------------------------------------
//-- Table `valter_banco`.`conta`
//-- -----------------------------------------------------
//CREATE TABLE IF NOT EXISTS `valter_banco`.`conta` (
//  `con_codigo` INT NOT NULL AUTO_INCREMENT,
//  `con_numero` VARCHAR(10) NOT NULL,
//  `con_cliente` INT NOT NULL,
//  `con_saldo` DECIMAL(10,2) NOT NULL DEFAULT 0,
//  `con_limite` DECIMAL(10,2) NULL,
//  `con_data_abertura` DATETIME NOT NULL,
//  `con_data_encerramento` DATETIME NULL,
//  `con_tipo_conta` INT NOT NULL,
//  `con_status` ENUM('0', '1') NOT NULL DEFAULT '1',
//  PRIMARY KEY (`con_codigo`),
//  INDEX `FK_con_tipo_conta_idx` (`con_tipo_conta` ASC),
//  INDEX `FK_con_cliente_idx` (`con_cliente` ASC),
//  CONSTRAINT `FK_con_tipo_conta`
//    FOREIGN KEY (`con_tipo_conta`)
//    REFERENCES `valter_banco`.`tipo_conta` (`tip_codigo`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION,
//  CONSTRAINT `FK_con_cliente`
//    FOREIGN KEY (`con_cliente`)
//    REFERENCES `valter_banco`.`cliente` (`cli_codigo`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION)
//ENGINE = InnoDB;
//
//
//-- -----------------------------------------------------
//-- Table `valter_banco`.`historico_conta`
//-- -----------------------------------------------------
//CREATE TABLE IF NOT EXISTS `valter_banco`.`historico_conta` (
//  `his_codigo` INT NOT NULL AUTO_INCREMENT,
//  `his_conta` INT NOT NULL,
//  `his_saldo` DECIMAL(10,2) NOT NULL,
//  `his_data_operacao` DATETIME NOT NULL,
//  `his_operacao` VARCHAR(255) NOT NULL,
//  PRIMARY KEY (`his_codigo`),
//  INDEX `FK_his_conta_idx` (`his_conta` ASC),
//  CONSTRAINT `FK_his_conta`
//    FOREIGN KEY (`his_conta`)
//    REFERENCES `valter_banco`.`conta` (`con_codigo`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION)
//ENGINE = InnoDB;
}
