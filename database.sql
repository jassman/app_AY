-- phpMyAdmin SQL Dump
-- version 3.5.8
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Nov 10, 2014 at 04:10 AM
-- Server version: 5.5.30
-- PHP Version: 5.4.14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `exam_serv_nov_2014`
--

-- --------------------------------------------------------

--
-- Table structure for table `apellido`
--

CREATE TABLE IF NOT EXISTS `apellido` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador',
  `apellido` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Apellido',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

--
-- Dumping data for table `apellido`
--

INSERT INTO `apellido` (`id`, `apellido`) VALUES
(1, 'Butifarra'),
(2, 'Crispin'),
(3, 'Arcadas'),
(4, 'Pichón'),
(5, 'Bugarro'),
(6, 'Gasolina'),
(7, 'Linterna'),
(8, 'Salvaje'),
(9, 'Mamandurria');

-- --------------------------------------------------------

--
-- Table structure for table `autor`
--

CREATE TABLE IF NOT EXISTS `autor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador',
  `Nombre` varchar(255) COLLATE utf32_unicode_ci DEFAULT NULL COMMENT 'Nombre',
  `Apellido` varchar(255) COLLATE utf32_unicode_ci DEFAULT NULL COMMENT 'Apellido',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci COMMENT='Autor' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `disco`
--

CREATE TABLE IF NOT EXISTS `disco` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador',
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Nombre',
  `id_genero` int(11) DEFAULT NULL COMMENT 'Género',
  `id_autor` int(11) DEFAULT NULL COMMENT 'Autor',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `genero`
--

CREATE TABLE IF NOT EXISTS `genero` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador',
  `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Descripción',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Género musical' AUTO_INCREMENT=10 ;

--
-- Dumping data for table `genero`
--

INSERT INTO `genero` (`id`, `descripcion`) VALUES
(1, 'Chill'),
(2, 'Heavy Metal'),
(3, 'Punk Rock'),
(4, 'Rock'),
(5, 'Clásica'),
(6, 'Jazz'),
(7, 'Country'),
(8, 'Folk'),
(9, 'Pop');

-- --------------------------------------------------------

--
-- Table structure for table `nombre`
--

CREATE TABLE IF NOT EXISTS `nombre` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador',
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Nombre',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Nombre' AUTO_INCREMENT=10 ;

--
-- Dumping data for table `nombre`
--

INSERT INTO `nombre` (`id`, `nombre`) VALUES
(1, 'Agamenón'),
(2, 'Salustiano'),
(3, 'Steve'),
(4, 'Honorata'),
(5, 'Saturnina'),
(6, 'Gertrudis'),
(7, 'Apolonia'),
(8, 'Honorato'),
(9, 'John');

-- --------------------------------------------------------

--
-- Table structure for table `titulo`
--

CREATE TABLE IF NOT EXISTS `titulo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador',
  `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Descripción',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Título' AUTO_INCREMENT=10 ;

--
-- Dumping data for table `titulo`
--

INSERT INTO `titulo` (`id`, `descripcion`) VALUES
(1, 'Grandes éxitos'),
(2, 'Lo mejor de mi vida'),
(3, 'Recopilatorio'),
(4, 'Super bombazos'),
(5, 'Mis números uno'),
(6, 'El megadisco'),
(7, 'Lo más de lo más'),
(8, 'Exitazos'),
(9, 'Hipermegaventas');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
