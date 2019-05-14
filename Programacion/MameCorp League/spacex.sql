-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 04-05-2019 a las 16:20:30
-- Versión del servidor: 5.6.13
-- Versión de PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `spacex`
--
CREATE DATABASE IF NOT EXISTS `spacex` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `spacex`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingeniero`
--

CREATE TABLE IF NOT EXISTS `ingeniero` (
  `dni` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `edad` int(3) NOT NULL,
  `id_puesto` int(10) NOT NULL,
  `jefe` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `id_puesto` (`id_puesto`),
  KEY `jefe` (`jefe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ingeniero`
--

INSERT INTO `ingeniero` (`dni`, `nombre`, `apellido`, `edad`, `id_puesto`, `jefe`) VALUES
('72842130H', 'Elon', 'Musk', 43, 3, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mision`
--

CREATE TABLE IF NOT EXISTS `mision` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--

CREATE TABLE IF NOT EXISTS `modulo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `fecha_fabricacion` date NOT NULL,
  `tipo` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo` (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo_ingeniero`
--

CREATE TABLE IF NOT EXISTS `modulo_ingeniero` (
  `id_modulo` int(10) NOT NULL,
  `dni` varchar(20) NOT NULL,
  PRIMARY KEY (`id_modulo`,`dni`),
  KEY `dni` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo_mision`
--

CREATE TABLE IF NOT EXISTS `modulo_mision` (
  `id_modulo` int(10) NOT NULL,
  `id_mision` int(10) NOT NULL,
  PRIMARY KEY (`id_modulo`,`id_mision`),
  KEY `id_mision` (`id_mision`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

CREATE TABLE IF NOT EXISTS `puesto` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `puesto`
--

INSERT INTO `puesto` (`id`, `nombre`) VALUES
(3, 'Ingeniero de motores'),
(4, 'Ingeniero de propulsión'),
(5, 'Ingeniero de estructura'),
(6, 'Ingeniero mecánico'),
(7, 'Ingeniero de aerondinámica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_modulo`
--

CREATE TABLE IF NOT EXISTS `tipo_modulo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ingeniero`
--
ALTER TABLE `ingeniero`
  ADD CONSTRAINT `ingeniero_ibfk_2` FOREIGN KEY (`jefe`) REFERENCES `ingeniero` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ingeniero_ibfk_3` FOREIGN KEY (`id_puesto`) REFERENCES `puesto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `modulo`
--
ALTER TABLE `modulo`
  ADD CONSTRAINT `modulo_ibfk_1` FOREIGN KEY (`tipo`) REFERENCES `tipo_modulo` (`id`);

--
-- Filtros para la tabla `modulo_ingeniero`
--
ALTER TABLE `modulo_ingeniero`
  ADD CONSTRAINT `modulo_ingeniero_ibfk_1` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id`),
  ADD CONSTRAINT `modulo_ingeniero_ibfk_2` FOREIGN KEY (`dni`) REFERENCES `ingeniero` (`dni`);

--
-- Filtros para la tabla `modulo_mision`
--
ALTER TABLE `modulo_mision`
  ADD CONSTRAINT `modulo_mision_ibfk_1` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id`),
  ADD CONSTRAINT `modulo_mision_ibfk_2` FOREIGN KEY (`id_mision`) REFERENCES `mision` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
