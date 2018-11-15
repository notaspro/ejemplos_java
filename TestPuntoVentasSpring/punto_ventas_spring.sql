-- phpMyAdmin SQL Dump
-- version 4.0.6
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-09-2014 a las 21:41:41
-- Versión del servidor: 5.6.13-log
-- Versión de PHP: 5.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `PuntoVentasSpring`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_configuracionapp`
--

CREATE TABLE IF NOT EXISTS `app_configuracionapp` (
  `id_ConfiguracionApp` int(11) NOT NULL AUTO_INCREMENT,
  `tx_ConfiguracionNombre` varchar(50) DEFAULT NULL,
  `tx_ConfiguracionDescripcion` varchar(250) DEFAULT NULL,
  `configuracionValor` varchar(500) NOT NULL,
  `tx_TipoValor` varchar(5) DEFAULT NULL,
  `i_Activo` int(11) DEFAULT NULL,
  `dt_FechaRegistro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_ConfiguracionApp`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Volcado de datos para la tabla `app_configuracionapp`
--

INSERT INTO `app_configuracionapp` (`id_ConfiguracionApp`, `tx_ConfiguracionNombre`, `tx_ConfiguracionDescripcion`, `configuracionValor`, `tx_TipoValor`, `i_Activo`, `dt_FechaRegistro`) VALUES
(1, 'Maximo Intentos Login', 'Maximo numero de veces que un \nempleado puede intentar hacer login (sin lograrlo) en los ultimos 30 minutos.', '3', 'num', 1, '2013-10-22 13:35:03'),
(2, 'Caducidad Password', 'Tiempo que debe pasar para que la contraseña del empleado caduque y deje de ser valida.', '3', 'meses', 1, '2013-10-22 13:35:03'),
(3, 'Tiempo Notificar Password', 'Tiempo previo a la caducidad de la contraseña para empezar a notificar al empleado que debe cambiarla.', '15', 'dias', 1, '2013-10-22 13:35:03'),
(4, 'Maximo Sesiones Activas', 'Numero maximo de sesiones activas por empleado.', '3', 'num', 1, '2013-10-22 13:35:03'),
(5, 'Bloquear Usuarios Password Caducada', 'Al intentar hacer login ¿Se debe bloquear a los empleados con contraseña caducada?.', '1', 'bool', 1, '2013-10-22 13:35:03'),
(6, 'Id Super Usuario', 'Id del super usuario administrador. Sirve para tomar datos de ese usuario y enviar notificaciones de la aplicacion.', '1', 'num', 1, '2013-10-22 13:35:03'),
(7, 'Tiempo Bloqueo Intentos', 'Tiempo que debe ser bloqueado un empleado por exceder el maximo de intentos fallidos.', '30', 'min', 1, '2013-10-22 13:35:03'),
(8, 'Maxima Inactividad Sesion', 'Tiempo maximo que una sesion puede estar inactiva para que sea invalida.', '15', 'min', 1, '2013-10-22 13:35:03'),
(9, 'Nombre de la empresa', 'Nombre de la empresa o negocio, este dato aparecera en los tickets.', 'El Proveedor Ranchero', 'txt', 1, '2013-12-03 13:35:03'),
(10, 'Nombre del propietario', 'Nombre del propietario o negocio, este dato aparecera en los tickets.', 'Viridiana Macrina Malacon Galvan', 'txt', 1, '2013-12-03 13:35:03'),
(11, 'R.F.C. de la empresa', 'R.F.C. de la empresa o negocio, este dato aparecera en los tickets.', 'MAGVM11', 'txt', 1, '2013-12-03 13:35:03'),
(12, 'Direccion de la empresa', 'Direccion de la empresa o negocio, este dato aparecera en los tickets.', 'Domicilio Conocido, Campeche', 'txt', 1, '2013-12-03 13:35:03'),
(13, 'Telefono de la empresa', 'Telefono de la empresa o negocio, este dato aparecera en los tickets.', '1234567890', 'txt', 1, '2013-12-03 13:35:03'),
(14, 'C.P. de la empresa', 'Codigo Postal de la empresa o negocio, este dato aparecera en los tickets.', '45700', 'txt', 1, '2013-12-03 13:35:03'),
(15, 'Animacion Secciones', 'Tipo de animacion para mostrar el contenido de las secciones de la aplicacion.', 'default', 'txt', 1, '2013-12-13 06:00:00'),
(16, 'Velocidad Animacion Secciones', 'Velocidad para mostrar la Animacion de las secciones.', 'default', 'txt', 1, '2013-12-13 06:03:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_logssesiones`
--

CREATE TABLE IF NOT EXISTS `app_logssesiones` (
  `id_logsesion` int(11) NOT NULL AUTO_INCREMENT,
  `tx_username` varchar(50) DEFAULT NULL,
  `tx_password` varchar(50) DEFAULT NULL,
  `tx_ClaveSesion` varchar(50) DEFAULT NULL,
  `tx_StatusIntento` varchar(50) DEFAULT NULL,
  `tx_IP` varchar(20) DEFAULT '0.0.0.0',
  `i_IntentoFallido` int(11) DEFAULT NULL,
  `dt_FechaRegistro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_logsesion`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=197 ;

--
-- Volcado de datos para la tabla `app_logssesiones`
--

INSERT INTO `app_logssesiones` (`id_logsesion`, `tx_username`, `tx_password`, `tx_ClaveSesion`, `tx_StatusIntento`, `tx_IP`, `i_IntentoFallido`, `dt_FechaRegistro`) VALUES
(1, 'xavier', '', '392b31f86fddb95a9fa1792e2cd70007', '!Logueado!', '201.145.206.23', 0, '2013-11-11 07:25:15'),
(2, 'virik', '', 'c83eb3e288604fe9cb0d5938cf63c3e4', '!Logueado!', '201.145.206.23', 0, '2013-11-11 07:59:36'),
(3, 'xavier', '', '22e26f1b7863f0716e80b3ef26a1f2d6', '!Logueado!', '201.145.206.23', 0, '2013-11-11 09:10:53'),
(4, 'virik', '', '214b0e3d9609a0db5e94809ddc042f2f', '!Logueado!', '187.150.35.253', 0, '2013-11-11 09:59:30'),
(5, 'xavier', '', '4d54c50aade4309b5c4def460962bdbf', '!Logueado!', '201.145.206.23', 0, '2013-11-11 11:48:17'),
(6, 'virik', '', '346dd4185983cd27fc22bedcbda47e72', '!Logueado!', '187.150.35.253', 0, '2013-11-11 11:48:41'),
(7, 'xavier', '', '70d17d41d8db7d755218d642fc859041', '!Logueado!', '201.145.206.23', 0, '2013-11-11 12:13:13'),
(8, 'xavier', '', '38c46afe8d649c02bd3138f1bd11fe80', '!Logueado!', '201.145.206.23', 0, '2013-11-11 12:14:42'),
(9, 'maryy', '', '721952973305286e570cb61b79f0144c', '!Logueado!', '187.150.35.253', 0, '2013-11-11 12:16:07'),
(10, 'virik', '', '28cae7b3e7ebea6cfce52dfab3dc81e6', '!Logueado!', '187.150.35.253', 0, '2013-11-11 12:17:06'),
(11, 'xavier', '', 'd68be622995d1695d99479f06424d76b', '!Logueado!', '201.145.206.23', 0, '2013-11-11 12:38:28'),
(12, 'xavier', '', '61fd2cdc038a728fb8c0dbf9110967e2', '!Logueado!', '201.145.206.23', 0, '2013-11-11 12:58:18'),
(13, 'virik', '', 'b0c154ad127633d0ee1737e5d5c59eea', '!Logueado!', '201.145.206.23', 0, '2013-11-11 13:07:44'),
(14, 'virik', '', 'e397c089ba336ba171a26fa82b9011d1', '!Logueado!', '187.150.35.253', 0, '2013-11-11 14:58:31'),
(15, 'xavier', '', '7c64e9845320aac3a0305c46af55916a', '!Logueado!', '187.150.35.253', 0, '2013-11-11 15:37:07'),
(16, 'xavier', '', 'a4960bb6d4d80e602bbe95e17dc75f37', '!Logueado!', '201.145.206.23', 0, '2013-11-11 16:12:55'),
(17, 'virik', '', '510d5024bc8fa00e55535fe2bad60537', '!Logueado!', '187.150.35.253', 0, '2013-11-11 17:30:25'),
(18, 'fdslash', '', 'a45f24fc74bef79162646bdf2f2be80e', '!Logueado!', '187.150.35.253', 0, '2013-11-11 17:35:14'),
(19, 'virik', '', '02a49100216c7cf3ff16e2a42309955b', '!Logueado!', '187.150.35.253', 0, '2013-11-11 17:40:46'),
(20, 'virik', '', '13028ee3c0e726fa0b55e5bbe59f5c35', '!Logueado!', '187.150.35.253', 0, '2013-11-11 18:49:59'),
(21, 'virik', '', '334b3ae334518d89d86e90e925b5c1ee', '!Logueado!', '187.150.35.253', 0, '2013-11-11 20:12:26'),
(22, 'virik', '', '657aff48cf2d366b1b8c1f4758e6baf3', '!Logueado!', '187.150.35.253', 0, '2013-11-11 21:45:38'),
(23, 'virik', '', 'c14ed4f1e77decd49a75e0a11d932677', '!Logueado!', '201.145.206.23', 0, '2013-11-11 23:51:55'),
(24, 'xavier', '', '31d45af64ed37e662643e5ece229c3c0', '!Logueado!', '201.141.152.12', 0, '2013-11-11 23:53:37'),
(25, 'xavier', '', 'd7ed5e1ebdf16a5fc74681771da456dc', '!Logueado!', '201.145.206.23', 0, '2013-11-11 23:56:03'),
(26, 'virik', '', 'adcb2419af402aa905545b171cdf0d6b', '!Logueado!', '187.150.35.253', 0, '2013-11-12 06:39:02'),
(27, 'virik', '', '10a175b091beb5eb66c9d3cbae2f1285', '!Logueado!', '187.150.35.253', 0, '2013-11-12 11:56:33'),
(28, 'virik', '', '62927546cf5ccaae34dbd96d5425100d', '!Logueado!', '187.150.39.158', 0, '2013-11-12 14:33:14'),
(29, 'macrina', '', '526ebae178131557c9ca1257c07c042b', '!Logueado!', '187.150.39.158', 0, '2013-11-12 14:43:14'),
(30, 'virik', '', '9012637e819297cf58e056366a3ad25e', '!Logueado!', '187.150.39.158', 0, '2013-11-12 14:44:20'),
(31, 'virik', '', 'f0875501e24164246e2af05ff1fdc9f5', '!Logueado!', '187.150.35.253', 0, '2013-11-13 08:52:00'),
(32, 'virik', '', '145a4c1780d0b10f7d6d20ea4b85a6d4', '!Logueado!', '187.150.35.253', 0, '2013-11-13 10:13:18'),
(33, 'virik', '', '51598bf6f4eefafd37a9e01b119dded8', '!Logueado!', '187.150.35.253', 0, '2013-11-13 10:32:53'),
(34, 'xavier', '', '033096b351905a88a3df6382037dc623', '!Logueado!', '201.145.223.243', 0, '2013-11-13 13:14:41'),
(35, 'virik', '', 'b6601fac9e575384133f35011a195721', '!Logueado!', '201.145.223.243', 0, '2013-11-13 17:01:56'),
(36, 'xavier', '', 'e90d610ac16dee7bb3d4c0f110f2f478', '!Logueado!', '201.145.223.243', 0, '2013-11-14 08:37:06'),
(37, 'virik', '', 'b647bfa9f1005cc15d17538b0c8c817b', '!Logueado!', '187.150.135.31', 0, '2013-11-15 00:37:12'),
(38, 'virik', '', 'c4239b8a1e0eb73ec05db78ad016d269', '!Logueado!', '187.150.135.31', 0, '2013-11-15 00:55:47'),
(39, 'virik', '', '3014ab4bec4e0dcc86a98cb596e7c5c1', '!Logueado!', '187.150.135.31', 0, '2013-11-15 08:25:08'),
(40, 'virik', '', '2e02412a22278856e8c481f6f2d83afa', '!Logueado!', '187.150.135.31', 0, '2013-11-16 06:20:21'),
(41, 'virik', '', 'e46abbb03d34fdf5dcf30120649f3695', '!Logueado!', '187.150.135.31', 0, '2013-11-16 12:16:30'),
(42, 'gonzasilve', '123456', '27084f19c2d97bc60425691a22c69951', 'datos incorrectos.', '201.145.223.243', 1, '2013-11-16 12:24:33'),
(43, 'gonzasilve', '', 'aebc3cd74db486ac3a73e7fa02337221', '!Logueado!', '201.145.223.243', 0, '2013-11-16 12:24:48'),
(44, 'gonzasilve', '', '0c9d366d471ed37e775c0c66f6adda9f', '!Logueado!', '201.145.223.243', 0, '2013-11-16 15:48:12'),
(45, 'gonzasilve', '', '4f9022de566a24baad6d3fc4a59b273d', '!Logueado!', '201.145.223.243', 0, '2013-11-16 20:00:13'),
(46, 'gonzasilve', '', '915be5f513dd5053a209ad4e05f72e99', '!Logueado!', '201.145.223.243', 0, '2013-11-17 13:10:39'),
(47, 'gonzasilve', '', '3e46edb292687e56382232b3540ec769', '!Logueado!', '201.145.223.243', 0, '2013-11-17 16:40:28'),
(48, 'gonzasilve', '', 'df0b43f398cd1175dc0732b0521d0d87', '!Logueado!', '201.145.223.243', 0, '2013-11-17 20:16:01'),
(49, 'gonzasilve', '', '42806d8975c3217a277c04cd0f43692b', '!Logueado!', '201.145.223.243', 0, '2013-11-17 22:09:46'),
(50, 'gonzasilve', '', 'fe06698df6bec2334e9bbf85c44ffa3b', '!Logueado!', '201.145.223.243', 0, '2013-11-17 23:10:07'),
(51, 'gonzasilve', '', 'ffe1bbc4358eab9065da51e6c3812701', '!Logueado!', '201.145.223.243', 0, '2013-11-17 23:21:30'),
(52, 'gonzasilve', '', 'de2f9d4b730b4bf42a7c81c66f17c070', '!Logueado!', '201.145.223.243', 0, '2013-11-17 23:23:39'),
(53, 'gonzasilve', '', '5ee652831f9f130c31c930a9be1ddcf6', '!Logueado!', '201.145.223.243', 0, '2013-11-18 07:41:17'),
(54, 'gonzasilve', '', '19a5e3b4f5ac9496cd9b864c485500d6', '!Logueado!', '201.145.223.243', 0, '2013-11-18 08:44:59'),
(55, 'gonzasilve', '', 'b182e15340684e05fc9d9ae12294e1a7', '!Logueado!', '201.145.223.243', 0, '2013-11-18 11:05:07'),
(56, 'gonzasilve', '', '66c139c9cef0a0e4fc4fe77854b9c4a7', '!Logueado!', '201.145.222.134', 0, '2013-11-19 15:56:41'),
(57, 'gonzasilve', '', '34a061b49e168495781b9a837cc524a4', '!Logueado!', '201.145.198.235', 0, '2013-11-21 22:27:59'),
(58, 'gonzasilve', '', 'b736ee4f8c4658dfdb96e803d3852eee', '!Logueado!', '201.145.198.235', 0, '2013-11-22 10:50:25'),
(59, 'gonzasilve', '', '7f924aa5355a8bfd4d3c960bfe97018e', '!Logueado!', '201.145.198.235', 0, '2013-11-24 09:00:13'),
(60, 'gonzasilve', '', 'f53632abbd4c0a97e09908d5e12f8b13', '!Logueado!', '201.145.198.235', 0, '2013-11-24 13:30:03'),
(61, 'gonzasilve', '123456', '0ec4607e520eb6ab257d458ad5d03b85', 'datos incorrectos.', '201.145.198.235', 1, '2013-11-24 15:36:59'),
(62, 'gonzasilve', '', '6370e1a66b56f13f16a495782ffb28f2', '!Logueado!', '201.145.198.235', 0, '2013-11-24 15:37:04'),
(63, 'gonzasilve', '', 'aa56705f0d510a1255cad3f67999b2dd', '!Logueado!', '201.145.198.235', 0, '2013-11-24 18:43:07'),
(64, 'gonzasilve', '', '513c2a7d2a986f8175235bbab185ccb7', '!Logueado!', '201.145.198.235', 0, '2013-11-24 20:22:03'),
(66, 'gonzasilve', '', '53579a8710518cae1dabf92ab1a3aa67', '!Logueado!', '201.145.198.235', 0, '2013-11-25 06:24:23'),
(67, 'xavier', '', '6313b1d2954727a34db8b6b73c2f28f1', '!Logueado!', '201.145.198.235', 0, '2013-11-25 06:25:29'),
(68, 'xavier', '', '7f8bbb9a7ae2246fb7564203d8354fa1', '!Logueado!', '201.145.198.235', 0, '2013-11-25 08:03:28'),
(69, 'carlos', '', 'c301d628f48f456f3d5fa8cde828388e', '!Logueado!', '201.145.198.235', 0, '2013-11-25 08:17:41'),
(70, 'carlos', '', '7bc744687bf08c91cb18c191f9a047b6', '!Logueado!', '201.145.198.235', 0, '2013-11-25 08:19:54'),
(71, 'gonzasilve', '', 'b3000031c0612506d4235640414b7190', '!Logueado!', '201.145.198.235', 0, '2013-11-25 08:38:21'),
(72, 'gonzasilve', '', 'd1ec3e1bde90a118ace2e0f7b72be283', '!Logueado!', '201.145.198.235', 0, '2013-11-25 10:25:44'),
(73, 'gonzasilve', '', '6a27fd64c077bb020328aab4e1bd6649', '!Logueado!', '201.145.198.235', 0, '2013-11-25 17:23:08'),
(74, 'gonzasilve', '', '28942c0efa9fc535faed84d1edc1c5da', '!Logueado!', '201.145.188.108', 0, '2013-11-25 19:21:44'),
(75, 'gonzasilve', '', '040410f719a465c514a3e704ab9fa420', '!Logueado!', '201.145.188.108', 0, '2013-11-25 23:26:30'),
(76, 'gonzasilve', '', '1e57c75f3914628f862b64cd470cb59f', '!Logueado!', '201.145.188.108', 0, '2013-11-26 07:42:32'),
(77, 'gonzasilve', '', 'b336fa3129b48dd61bc7bd9d7f7d657e', '!Logueado!', '201.145.188.108', 0, '2013-11-27 00:48:00'),
(79, 'gonzasilve', '', 'e5a186c933a2800ceeccf3398c106532', '!Logueado!', '201.145.188.108', 0, '2013-11-27 08:09:43'),
(80, 'gonzasilve', '', '17e58c76feaa8ed6787d3e5cb7bde177', '!Logueado!', '201.145.188.108', 0, '2013-11-27 11:04:57'),
(81, 'gonzasilve', '', '92783f7db3f9568b8ca87021382728c4', '!Logueado!', '201.145.188.108', 0, '2013-11-27 14:07:51'),
(82, 'gonzasilve', '', '37017bfd2f0a7b68fb8b51168cd1ef28', '!Logueado!', '201.145.188.108', 0, '2013-11-27 16:36:06'),
(83, 'gonzasilve', '', 'bea888a397db62e29eae05193b23f1bb', '!Logueado!', '201.145.188.108', 0, '2013-11-27 16:41:23'),
(84, 'gonzasilve', '', 'db2d89e0e2707914c584931b79e9000b', '!Logueado!', '201.145.188.108', 0, '2013-11-27 19:39:51'),
(85, 'virik', '12345', '200b83c7cb4074b2965e04f7c2bd5b6a', 'datos incorrectos.', '187.150.63.53', 1, '2013-11-27 20:42:19'),
(86, 'xavier', '', 'fa97f125b26d67169c9ffdac13b6a97e', '!Logueado!', '187.150.63.53', 0, '2013-11-27 20:42:30'),
(87, 'gonzasilve', '', 'b374d219bd5c56dd4c84934e296f5668', '!Logueado!', '189.226.137.145', 0, '2013-11-27 22:20:26'),
(88, 'gonzasilve', '', '3f5012a749a2598b75299d2c1237ca93', '!Logueado!', '189.226.137.145', 0, '2013-11-28 08:17:56'),
(91, 'gonzasilve', '', '5d1bfa58f307e8b59b235f3efa692806', '!Logueado!', '189.226.137.145', 0, '2013-11-28 15:21:48'),
(94, 'gonzasilve', '', '30cf055818f5725168afe9fdb2d86641', '!Logueado!', '189.226.137.145', 0, '2013-11-28 15:31:11'),
(96, 'adanvh', '', '4fefdfea10333047afad36b4bf8696b9', '!Logueado!', '189.226.137.145', 0, '2013-11-28 15:34:19'),
(97, 'karyavsa', '', '71a94b086889cfe15b6d10b20e043e55', '!Logueado!', '189.226.137.145', 0, '2013-11-28 15:37:36'),
(98, 'virik', '12345', '1851179281717f1d36825795b9fde2a5', 'datos incorrectos.', '187.150.63.53', 1, '2013-11-28 15:41:37'),
(99, 'xavier', '', 'c84ecb48fa97172a64acf6bb9fe6e734', '!Logueado!', '187.150.63.53', 0, '2013-11-28 15:41:47'),
(100, 'gonzasilve', '', '7720287381ef5e72eb8de65126011b75', '!Logueado!', '189.226.137.145', 0, '2013-11-28 16:39:01'),
(101, 'adanvh', '', '4d2526d1cdaa64fff778ab81c1a2864d', '!Logueado!', '189.226.137.145', 0, '2013-11-28 17:36:05'),
(102, 'xavier', '', '1458fbb4acfd321335c942fd30d4f461', '!Logueado!', '189.226.137.145', 0, '2013-11-28 17:41:07'),
(103, 'gonzasilve', '', '1ffb099fc8c737c0afd3b723b5d4c512', '!Logueado!', '189.226.137.145', 0, '2013-11-28 17:50:07'),
(104, 'gonzasilve', '', '0fcca284d3b925f762b8e0adb1abd9d4', '!Logueado!', '189.226.137.145', 0, '2013-11-28 18:35:07'),
(105, 'gonzasilve', '', '6d0d39f9accd71d44ef85b79f92f759a', '!Logueado!', '189.226.137.145', 0, '2013-11-29 08:11:47'),
(106, 'xavier', 'sfasdf', '444178ee8e84e9d82f8c618135dde542', 'datos incorrectos.', '189.226.137.145', 1, '2013-11-29 08:49:59'),
(107, 'xavier', 'asdfswer', 'd41284943b8dfef234412666ce894ffc', 'datos incorrectos.', '189.226.137.145', 1, '2013-11-29 08:50:04'),
(108, 'xavier', 'sdfasd', '6581f416141899033661d057fd624435', 'datos incorrectos.', '189.226.137.145', 1, '2013-11-29 08:50:08'),
(109, 'xavier', 'sasfdf', '15b6bae2c53a22003af8440f998f25a4', 'Intentos Excedidos.', '189.226.137.145', 1, '2013-11-29 08:50:16'),
(110, 'gonzasilve', '', '326baae6da135c19d0cc740578abee9e', '!Logueado!', '189.226.137.145', 0, '2013-11-29 08:50:43'),
(111, 'gonzasilve', '', '571cc0f3070e5bfe7ea3fc019997d6a5', '!Logueado!', '189.226.137.145', 0, '2013-11-29 10:40:47'),
(112, 'gonzasilve', '', 'af53869344765341d5cff0dc3da6d08b', '!Logueado!', '189.226.137.145', 0, '2013-11-29 13:27:48'),
(113, 'xavier', '', 'cee37bf30854fcd17c1a38d6f1102214', '!Logueado!', '189.226.137.145', 0, '2013-11-29 13:37:36'),
(114, 'gonzasilve', '', '3fb5b84ea93673fc97ebbbba21a0c2d4', '!Logueado!', '189.226.137.145', 0, '2013-11-29 13:38:20'),
(115, 'gonzasilve', '', 'a6315a7886862cf347617c356b697baf', '!Logueado!', '189.226.137.145', 0, '2013-11-29 15:25:42'),
(116, 'gonzasilve', '', 'bc1253df4a44a2644fd96feab635d42b', '!Logueado!', '189.226.137.145', 0, '2013-11-29 16:09:28'),
(117, 'dsdsadsad', 'sdasd', 'db8f74d05149468995b74e2e12cbd3ff', 'datos incorrectos.', '189.226.137.145', 1, '2013-11-29 16:12:37'),
(118, 'gonzasilve', '', 'cfc84a5ec74818dd486980ac83dbf371', '!Logueado!', '189.226.137.145', 0, '2013-11-29 16:37:37'),
(119, 'gonzasilve', '', 'bef849314095993dcec3b81d499bf34a', '!Logueado!', '189.226.137.145', 0, '2013-11-29 19:47:01'),
(120, 'gonzasilve', '', '424f9a56568c661823fdb0d1f13c1c1c', '!Logueado!', '189.226.137.145', 0, '2013-11-29 19:47:25'),
(121, 'gonzasilve', '12345', 'a6f5ec5ed40162b8b75ae1c8deaeb2d5', 'datos incorrectos.', '189.226.137.145', 1, '2013-11-29 22:26:35'),
(122, 'gonzasilve', '12345', '3a12d13b75c180f027afcaec9d3cb11c', 'datos incorrectos.', '189.226.137.145', 1, '2013-11-29 22:26:42'),
(123, 'gonzasilve', '', '3fa175695047a9917ae093fc553da8d7', '!Logueado!', '189.226.137.145', 0, '2013-11-29 22:27:08'),
(124, 'gonzasilve', '', 'b0b66f905f32f719f4cbb59cabb1dcb8', '!Logueado!', '189.226.137.145', 0, '2013-11-29 22:28:06'),
(125, 'gonzasilve', '12345', '9b492634e81c73d338f2d741df1bf88d', 'datos incorrectos.', '189.226.137.145', 1, '2013-11-30 07:45:59'),
(126, 'gonzasilve', '12345', '4ba49c9ac5c35045264aae8325d970aa', 'datos incorrectos.', '189.226.137.145', 1, '2013-11-30 07:46:05'),
(127, 'xavier', '', '11277dcbabd5b182cef59559946ac053', '!Logueado!', '189.226.137.145', 0, '2013-11-30 07:46:15'),
(128, 'gonzasilve', '', 'd205256fcff52b39318b8a06f15fe7e6', '!Logueado!', '189.226.137.145', 0, '2013-11-30 07:50:40'),
(129, 'gonzasilve', '', 'bcb08ff6fd7cf975bb207a4673dcda5d', '!Logueado!', '189.226.137.145', 0, '2013-11-30 17:40:21'),
(130, 'gonzasilve', '', '130d4b6e68b81c6313e69fa3b52dde28', '!Logueado!', '189.226.137.145', 0, '2013-11-30 19:41:08'),
(131, 'gonzasilve', '', '1d896a02b14bdefbf7e38739b6506684', '!Logueado!', '189.226.137.145', 0, '2013-12-01 09:51:06'),
(132, 'gonzasilve', '', '56c4bb7484502a3eb26573236a4094a3', '!Logueado!', '189.226.137.145', 0, '2013-12-01 13:36:07'),
(133, 'gonzasilve', '', '50e3cc5ce8356c0a43b35f2354588f0d', '!Logueado!', '201.145.194.112', 0, '2013-12-01 23:53:04'),
(134, 'xavier', '', 'f3d5961f450d065910ca6f1a0d0bf863', '!Logueado!', '201.145.194.112', 0, '2013-12-02 00:36:41'),
(135, 'gonzasilve', '', '45b1b7b2582c8fa1b5637f72c09be030', '!Logueado!', '201.145.194.112', 0, '2013-12-02 00:36:58'),
(136, 'gonzasilve', '', 'b754e463f8249956fd2e910addeeea5e', '!Logueado!', '201.145.194.112', 0, '2013-12-02 00:37:21'),
(137, 'xavier', '', 'a788743cdc5a1d8b7998521d252ea46f', '!Logueado!', '201.145.194.112', 0, '2013-12-02 00:39:35'),
(138, 'gonzasilve', '', 'b4bcabe06407a1c68f034419cbbcf4b5', '!Logueado!', '201.145.194.112', 0, '2013-12-02 08:21:09'),
(139, 'gonzasilve', '', '2b8099ce23333a3821880e59b4370885', '!Logueado!', '201.145.194.112', 0, '2013-12-02 09:10:32'),
(140, 'gonzasilve', '', '803bbdd902b826a4591be1ad8c4f4f15', '!Logueado!', '201.145.194.112', 0, '2013-12-02 13:59:27'),
(141, 'virik', '12345', 'a5ff6b9d7db83785aeed6ad9654af221', 'datos incorrectos.', '187.150.90.102', 1, '2013-12-02 17:19:32'),
(142, 'virik', '12345', '3ca40100946d10eb40024c339933795e', 'datos incorrectos.', '187.150.90.102', 1, '2013-12-02 17:19:45'),
(143, 'xavier', '', '26a3aa077386e28795e85647cf5d9dfe', '!Logueado!', '187.150.90.102', 0, '2013-12-02 17:20:02'),
(144, 'xavier', '', '07fab1ff95c4b3cf97bf892bae2da9d5', '!Logueado!', '187.150.90.102', 0, '2013-12-02 17:38:42'),
(145, 'gonzasilve', '', 'afb68f387b04421bb650cdfd047d8cee', '!Logueado!', '201.145.189.9', 0, '2013-12-02 19:02:45'),
(146, 'gonzasilve', '', '8385606478c4ff858964455497c15c35', '!Logueado!', '127.0.0.1', 0, '2013-12-05 09:43:22'),
(147, 'gonzasilve', '', '146e97d5cd48e76ab2ed8f08626fbc30', '!Logueado!', '127.0.0.1', 0, '2013-12-05 09:52:43'),
(148, 'gonzasilve', '', 'f5e49cc164a41ca1641013c843a1cf31', '!Logueado!', '127.0.0.1', 0, '2013-12-05 10:08:31'),
(149, 'gonzasilve', '', '52cbfe63fd2b866286668b0a4f01ba53', '!Logueado!', '127.0.0.1', 0, '2013-12-06 18:11:48'),
(150, 'gonzasilve', '', '9a03bd2b88bbf55e1c526b7caf391272', '!Logueado!', '127.0.0.1', 0, '2013-12-07 09:08:37'),
(151, 'gonzasilve', '', '699e173bdfbdf6d527bba8cce4b98142', '!Logueado!', '127.0.0.1', 0, '2013-12-07 12:51:58'),
(152, 'gonzasilve', '', '69cbf7ceac1f63ef492d4f68a910e6c2', '!Logueado!', '127.0.0.1', 0, '2013-12-08 08:11:49'),
(153, 'gonzasilve', '', 'c7f06cd5198acc1195c0bdbbaa392d35', '!Logueado!', '127.0.0.1', 0, '2013-12-08 08:28:40'),
(154, 'gonzasilve', '', '87392b5c4b02a5e5b37799f869cddd07', '!Logueado!', '127.0.0.1', 0, '2013-12-09 08:33:18'),
(155, 'gonzasilve', '', '9f292c121caddd3b4d80ffe36e6e96e1', '!Logueado!', '127.0.0.1', 0, '2013-12-09 10:21:44'),
(156, 'gonzasilve', '', '4787bbb1c833c39e6a4d308068114b98', '!Logueado!', '127.0.0.1', 0, '2013-12-09 10:24:41'),
(157, 'gonzasilve', '', '16726723b5dafd1275067b6984e75c0f', '!Logueado!', '127.0.0.1', 0, '2013-12-09 10:24:51'),
(158, 'gonzasilve', '', '80208e9d6ddd58ee2f0ad27c69638c88', '!Logueado!', '127.0.0.1', 0, '2013-12-09 13:18:50'),
(159, 'gonzasilve', '', '1d4d97680cc6febef04a0d829fa27005', '!Logueado!', '127.0.0.1', 0, '2013-12-10 08:50:05'),
(160, 'xavier', '', '0d23f436b49654f36fbcab9758d63ae5', '!Logueado!', '127.0.0.1', 0, '2013-12-11 10:00:41'),
(161, 'gonzasilve', '', '9bb987b0c4d4f53ad7e1c91692cecfb4', '!Logueado!', '127.0.0.1', 0, '2013-12-11 10:00:57'),
(162, 'xavier', '', 'd7be6ac6eee0d540bd5f41f5053985dc', '!Logueado!', '127.0.0.1', 0, '2013-12-11 10:01:32'),
(163, 'gonzasilve', '', '85182a12952df73c0eda7c6e4355a919', '!Logueado!', '127.0.0.1', 0, '2013-12-11 17:13:49'),
(164, 'carlos', '', '5a936a8b42766a88fb910feec0162eb4', '!Logueado!', '127.0.0.1', 0, '2013-12-11 17:14:15'),
(165, 'gonzasilve', '', 'f5825e5cbf31fd5afeafdbd0e09ebc7a', '!Logueado!', '127.0.0.1', 0, '2013-12-12 08:33:45'),
(166, 'gonzasilve', '', '1e33955843126eebad5312f834ba37b9', '!Logueado!', '127.0.0.1', 0, '2013-12-12 22:12:11'),
(167, 'gonzasilve', '', '19da211f39880ab2a4e7e007b1e432df', '!Logueado!', '127.0.0.1', 0, '2013-12-13 02:46:51'),
(168, 'gonzasilve', '', 'dc85acc38b12a821659df0774bcf3b31', '!Logueado!', '127.0.0.1', 0, '2013-12-13 03:14:11'),
(169, 'maria', '', '69b8c5c4ec74416f8f9cd423bce6e772', '!Logueado!', '127.0.0.1', 0, '2013-12-13 04:39:34'),
(170, 'xavier', '', 'a88cb21e448967badc01544f2cd2a911', '!Logueado!', '127.0.0.1', 0, '2013-12-13 04:39:46'),
(171, 'gonzasilve', '', '33849e8d6c8846905779044a7ffed8f5', '!Logueado!', '127.0.0.1', 0, '2013-12-13 11:32:18'),
(172, 'gonzasilve', '', '010d67ef358d7abe1e88565216503efc', '!Logueado!', '127.0.0.1', 0, '2013-12-13 12:17:05'),
(173, 'gonzasilve', '', '91e4f7871133bac3be4c0d701ec47e2d', '!Logueado!', '127.0.0.1', 0, '2013-12-15 00:16:13'),
(174, 'gonzasilve', '', '099cd478c7610c45154b9b220057c0e1', '!Logueado!', '127.0.0.1', 0, '2013-12-17 22:25:52'),
(175, 'gonzasilve', '', '7bb051381b72a3f7fde4eae849b95844', '!Logueado!', '127.0.0.1', 0, '2014-02-08 14:23:22'),
(176, 'gonzasilve', '12345', '07adae2956af88b38c3a39564aff742e', 'Password caducada.', '127.0.0.1', 1, '2014-05-04 11:37:02'),
(177, 'gonzasilve', '12345', 'c416cf1e0f8b4927e941f011f1a7b666', 'Tiene 1 bloqueo permanente.', '127.0.0.1', 0, '2014-05-04 11:39:19'),
(178, 'gonzasilve', 'maxpayne', 'fafe2ff653d505096bdbfaeb5dfe12d3', 'datos incorrectos.', '127.0.0.1', 1, '2014-05-04 11:39:41'),
(179, 'gonzasilve', '', 'a5ee06a9d09bcdc69cf98958769a6644', '!Logueado!', '127.0.0.1', 0, '2014-05-04 11:39:47'),
(180, 'gonzasilve', '', 'aa801bb92c58a88054b2cf1f879e5fab', '!Logueado!', '127.0.0.1', 0, '2014-05-04 13:50:48'),
(181, 'gonzasilve', '', '732786569bd7ec2c1b7fd74b929770b8', '!Logueado!', '127.0.0.1', 0, '2014-05-04 13:55:22'),
(182, 'gonzasilve', '', '396ea37dd005263bed22b80c5a0e9730', '!Logueado!', '127.0.0.1', 0, '2014-06-04 12:13:22'),
(183, 'gonzasilve', '', '3084324dd294cd81b77e559dd31cabe6', '!Logueado!', '127.0.0.1', 0, '2014-06-20 00:32:30'),
(184, 'gonzasilve', '', '196b4f0514a998f28dbc7d048b01eae6', '!Logueado!', '127.0.0.1', 0, '2014-06-28 15:21:17'),
(185, 'gonzasilve', '', '081ad6219d86d484bdfb45bfffbb4153', '!Logueado!', '127.0.0.1', 0, '2014-07-27 15:02:01'),
(186, 'gonzasilve', '', 'e8ed78683da257c018a3e579af54d996', '!Logueado!', '127.0.0.1', 0, '2014-07-27 15:12:46'),
(187, 'gonzasilve', '', '9ff2e3e14566119ed845a9be46654ae2', '!Logueado!', '127.0.0.1', 0, '2014-07-27 15:48:04'),
(188, 'gonzasilve', '12345', '1740b029071952a989e843f4459fa30e', 'Password caducada.', '127.0.0.1', 1, '2014-09-06 21:37:27'),
(189, 'gonzasilve', '12345', '76a33abbe3b3735b12d6821681ab6f70', 'Tiene 1 bloqueo permanente.', '127.0.0.1', 0, '2014-09-06 21:40:20'),
(190, 'gonzasilve', '123456', 'c2fa6445900081b1e7a9a621f174fa84', 'Tiene 1 bloqueo permanente.', '127.0.0.1', 0, '2014-09-06 21:42:21'),
(191, 'gonzasilve', '12345', '73e06f9adc22dfb6bafb9271d5d93d30', 'Tiene 1 bloqueo permanente.', '127.0.0.1', 0, '2014-09-06 21:44:08'),
(192, 'xavier', '12345', '2364b2411a52072c3bd51afa287307cf', 'Password caducada.', '127.0.0.1', 1, '2014-09-06 21:44:19'),
(193, 'xavier', '12345', 'c58690e3d14ebe0c4b98345ce295f8e7', 'Tiene 1 bloqueo permanente.', '127.0.0.1', 0, '2014-09-06 21:44:33'),
(194, 'gonzasilve', '', '6419708dff7beb73e41eadb09deea52c', '!Logueado!', '127.0.0.1', 0, '2014-09-06 21:48:59'),
(195, 'gonzasilve', '', '10db9144ce29d30a17677dbc9417baaa', '!Logueado!', '127.0.0.1', 0, '2014-09-21 10:31:35'),
(196, 'gonzasilve', '', '5fb31fd380788fcfb5cf82a0d6872e61', '!Logueado!', '127.0.0.1', 0, '2014-09-21 14:20:36');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_permisosusuarios`
--

CREATE TABLE IF NOT EXISTS `app_permisosusuarios` (
  `id_PermisoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `id_Usuario` int(11) DEFAULT NULL,
  `id_Seccion` int(11) DEFAULT NULL,
  `i_permiso` int(11) DEFAULT NULL,
  `id_UsuarioAsignacion` int(11) DEFAULT NULL,
  `dt_FechaAsignacion` datetime DEFAULT NULL,
  PRIMARY KEY (`id_PermisoUsuario`),
  KEY `id_Usuario` (`id_Usuario`),
  KEY `id_Seccion` (`id_Seccion`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=336 ;

--
-- Volcado de datos para la tabla `app_permisosusuarios`
--

INSERT INTO `app_permisosusuarios` (`id_PermisoUsuario`, `id_Usuario`, `id_Seccion`, `i_permiso`, `id_UsuarioAsignacion`, `dt_FechaAsignacion`) VALUES
(102, 8, 0, 1, 1, '2013-11-29 21:40:29'),
(219, 11, 0, 1, 1, '2013-11-29 22:41:59'),
(220, 11, 15, 1, 1, '2013-11-29 22:41:59'),
(221, 11, 20, 1, 1, '2013-11-29 22:41:59'),
(222, 11, 41, 1, 1, '2013-11-29 22:41:59'),
(242, 1, 0, 1, 1, '2013-11-29 23:00:23'),
(243, 1, 15, 1, 1, '2013-11-29 23:00:23'),
(244, 1, 20, 1, 1, '2013-11-29 23:00:23'),
(245, 1, 21, 1, 1, '2013-11-29 23:00:23'),
(246, 1, 30, 1, 1, '2013-11-29 23:00:23'),
(247, 1, 77, 1, 1, '2013-11-29 23:00:23'),
(248, 12, 0, 1, 1, '2013-11-29 23:20:40'),
(249, 12, 15, 1, 1, '2013-11-29 23:20:40'),
(250, 12, 20, 1, 1, '2013-11-29 23:20:40'),
(251, 12, 30, 1, 1, '2013-11-29 23:20:40'),
(252, 10, 0, 1, 1, '2013-11-29 23:31:04'),
(253, 7, 0, 1, 1, '2013-11-30 08:14:47'),
(258, 13, 0, 1, 1, '2013-11-30 08:15:58'),
(259, 13, 15, 1, 1, '2013-11-30 08:15:58'),
(260, 13, 20, 1, 1, '2013-11-30 08:15:58'),
(261, 13, 30, 1, 1, '2013-11-30 08:15:58'),
(274, 14, 0, 1, 1, '2013-12-06 18:51:12'),
(276, 3, 0, 1, 1, '2013-12-11 10:01:21'),
(277, 3, 10, 1, 1, '2013-12-11 10:01:21'),
(278, 3, 15, 1, 1, '2013-12-11 10:01:21'),
(279, 3, 20, 1, 1, '2013-12-11 10:01:21'),
(280, 3, 21, 1, 1, '2013-12-11 10:01:21'),
(281, 3, 30, 1, 1, '2013-12-11 10:01:21'),
(282, 3, 41, 1, 1, '2013-12-11 10:01:21'),
(283, 3, 77, 1, 1, '2013-12-11 10:01:21'),
(325, 6, 0, 1, 3, '2013-12-11 17:13:40'),
(326, 6, 10, 1, 3, '2013-12-11 17:13:40'),
(327, 6, 15, 1, 3, '2013-12-11 17:13:40'),
(328, 6, 20, 1, 3, '2013-12-11 17:13:40'),
(329, 6, 21, 1, 3, '2013-12-11 17:13:40'),
(330, 6, 30, 1, 3, '2013-12-11 17:13:40'),
(331, 6, 41, 1, 3, '2013-12-11 17:13:40'),
(332, 6, 77, 1, 3, '2013-12-11 17:13:40'),
(335, 9, 0, 1, 1, '2014-07-27 15:42:46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_rolesusuario`
--

CREATE TABLE IF NOT EXISTS `app_rolesusuario` (
  `id_RolUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `tx_RolUsuario` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_RolUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Volcado de datos para la tabla `app_rolesusuario`
--

INSERT INTO `app_rolesusuario` (`id_RolUsuario`, `tx_RolUsuario`) VALUES
(1, 'Administrador'),
(2, 'Asistente'),
(25, 'Prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_secciones`
--

CREATE TABLE IF NOT EXISTS `app_secciones` (
  `id_seccion` int(11) NOT NULL AUTO_INCREMENT,
  `tx_NombreSeccion` varchar(100) DEFAULT NULL,
  `tx_UrlSeccion` varchar(500) DEFAULT NULL,
  `i_activa` int(11) DEFAULT NULL,
  `tx_NombreCapa` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_seccion`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1002 ;

--
-- Volcado de datos para la tabla `app_secciones`
--

INSERT INTO `app_secciones` (`id_seccion`, `tx_NombreSeccion`, `tx_UrlSeccion`, `i_activa`, `tx_NombreCapa`) VALUES
(10, 'Inventario', '/inventario/', 1, 'inventario'),
(15, 'Empleados', '/empleados/', 1, 'empleados'),
(20, 'Proveedores', '/proveedores/', 1, 'proveedores'),
(21, 'Ventas', '/ventas/', 1, 'ventas'),
(30, 'Punto de Ventas', '/puntoventas/', 1, 'puntoventas'),
(41, 'Categorias', '/categorias/', 1, 'categorias'),
(77, 'Configuración', '/config/', 1, 'config'),
(1000, 'Todas las secciones', NULL, 1, NULL),
(1001, 'Inicio', '/', 1, 'home');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_statususuario`
--

CREATE TABLE IF NOT EXISTS `app_statususuario` (
  `id_StatusUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `tx_StatusUsuario` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_StatusUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `app_statususuario`
--

INSERT INTO `app_statususuario` (`id_StatusUsuario`, `tx_StatusUsuario`) VALUES
(1, 'Activo'),
(2, 'Bloqueado'),
(3, 'Eliminado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_tiposbloqueo`
--

CREATE TABLE IF NOT EXISTS `app_tiposbloqueo` (
  `id_TipoBloqueo` int(11) NOT NULL AUTO_INCREMENT,
  `tx_TipoBloqueo` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_TipoBloqueo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `app_tiposbloqueo`
--

INSERT INTO `app_tiposbloqueo` (`id_TipoBloqueo`, `tx_TipoBloqueo`) VALUES
(1, 'Bloqueo Permanente'),
(2, 'Bloqueo Temporal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_usuarios`
--

CREATE TABLE IF NOT EXISTS `app_usuarios` (
  `id_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `tx_username` varchar(30) DEFAULT NULL,
  `tx_password` varchar(50) DEFAULT NULL,
  `tx_Nombre` varchar(50) DEFAULT NULL,
  `tx_ApellidoPaterno` varchar(50) DEFAULT NULL,
  `tx_ApellidoMaterno` varchar(50) DEFAULT NULL,
  `tx_Email` varchar(50) DEFAULT NULL,
  `id_RolUsuario` int(11) DEFAULT NULL,
  `id_StatusUsuario` int(11) DEFAULT NULL,
  `id_UsuarioAlta` int(11) DEFAULT NULL,
  `dt_FechaRegistro` datetime DEFAULT NULL,
  `dt_UltimaModificacionUsuario` datetime DEFAULT NULL,
  `dt_UltimaModificacionPw` datetime DEFAULT NULL,
  PRIMARY KEY (`id_Usuario`),
  KEY `id_RolUsuario` (`id_RolUsuario`),
  KEY `id_StatusUsuario` (`id_StatusUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- Volcado de datos para la tabla `app_usuarios`
--

INSERT INTO `app_usuarios` (`id_Usuario`, `tx_username`, `tx_password`, `tx_Nombre`, `tx_ApellidoPaterno`, `tx_ApellidoMaterno`, `tx_Email`, `id_RolUsuario`, `id_StatusUsuario`, `id_UsuarioAlta`, `dt_FechaRegistro`, `dt_UltimaModificacionUsuario`, `dt_UltimaModificacionPw`) VALUES
(1, 'gonzasilve', '827ccb0eea8a706c4c34a16891f84e7b', 'Xavier', 'Silverio', 'BlaKe', 'gonzasilve@gmail.com', 2, 1, 1, '2013-10-22 13:27:49', '2014-09-06 23:00:23', '2014-09-06 22:27:42'),
(3, 'xavier', '827ccb0eea8a706c4c34a16891f84e7b', 'Xavier', 'Hernandez', 'Valdez', 'xavier@gmail.com', 2, 1, 1, '2013-11-02 14:42:55', '2014-09-06 10:01:21', '2014-09-06 14:42:55'),
(6, 'carlos', '827ccb0eea8a706c4c34a16891f84e7b', 'Carlos', 'Avila', 'Hernandez', 'carlos@gmail.com', 2, 1, 3, '2013-11-04 19:27:10', '2013-12-06 19:02:00', '2013-11-04 19:27:10'),
(7, 'maryy', '827ccb0eea8a706c4c34a16891f84e7b', 'Maria', 'Diaz', 'Perez', 'mari@hotmail.com', 2, 1, 1, '2013-11-10 21:50:08', '2013-11-30 08:14:47', '2013-11-10 21:50:08'),
(8, 'fdslash', 'e10adc3949ba59abbe56e057f20f883e', 'Gabriel', 'Diaz', 'Silva', 'fdslash.08@gmail.com', 2, 1, 1, '2013-11-11 17:33:10', '2013-11-29 21:40:29', '2013-11-11 17:33:10'),
(9, 'addame', '100bb35d67e9dda922648adf1ed81786', 'Adda', 'Valentin', 'Pomposo', 'ada27@hotmail.com', 2, 1, 1, '2013-11-12 14:40:30', '2014-07-27 15:42:46', '2013-11-12 14:40:30'),
(10, 'macrina', 'd41d8cd98f00b204e9800998ecf8427e', 'Macrina', 'Malacon', 'Galvan', 'macri30@live.com.mx', 1, 1, 1, '2013-11-12 14:42:30', '2013-11-29 23:31:04', '2013-11-29 23:31:04'),
(11, 'adanvh', '219796c60bd15efda54b427707820794', 'Adan', 'Vazquez', 'Hernandez', 'adanvh@gmail.com', 1, 1, 1, '2013-11-28 15:15:44', '2013-11-29 22:41:59', '2013-11-28 15:15:44'),
(12, 'karyavsa', '72c54698879941a0544048bc008ac1ee', 'Karina', 'Avila', 'Sanalona', 'karyavsa@gmail.com', 2, 1, 11, '2013-11-28 15:37:19', '2013-11-29 23:20:40', '2013-11-28 15:37:19'),
(13, 'maria', '827ccb0eea8a706c4c34a16891f84e7b', 'Maria', 'Test', 'Test', 'maria@gmail.com', 2, 1, 1, '2013-11-29 17:23:19', '2013-11-30 08:15:58', '2013-11-29 17:23:19'),
(14, 'analuisa', '827ccb0eea8a706c4c34a16891f84e7b', 'Ana Luisa', 'Perez', 'Osorio', 'anaidiriv_14_90@hotmail.com', 2, 1, 3, '2013-12-02 17:31:38', '2013-12-06 18:51:12', '2013-12-02 17:31:38'),
(21, NULL, NULL, 'gael', 'perez', 'salinas', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(22, NULL, NULL, 'gonzalo', 'perez', 'silverio', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(29, NULL, NULL, 'Wendy', 'perez', 'salinas', NULL, 1, NULL, NULL, NULL, '2014-09-21 01:00:43', '2014-09-21 01:00:43'),
(30, NULL, NULL, 'Marisol', 'Salinas', 'Apolinar', NULL, 1, NULL, NULL, NULL, '2014-09-21 01:00:43', '2014-09-21 01:00:43'),
(31, NULL, NULL, 'Wendy', 'perez', 'salinas', NULL, 1, NULL, NULL, NULL, '2014-09-21 08:32:50', '2014-09-21 08:32:50'),
(32, NULL, NULL, 'Marisol', 'Salinas', 'Apolinar', NULL, 1, NULL, NULL, NULL, '2014-09-21 08:32:50', '2014-09-21 08:32:50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_animacionesjquery`
--

CREATE TABLE IF NOT EXISTS `cat_animacionesjquery` (
  `id_AnimacionJQuery` int(11) NOT NULL,
  `tx_NombreAnimacionJQuery` varchar(30) NOT NULL,
  `tx_NombreAnimacionJQueryDescripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_AnimacionJQuery`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cat_animacionesjquery`
--

INSERT INTO `cat_animacionesjquery` (`id_AnimacionJQuery`, `tx_NombreAnimacionJQuery`, `tx_NombreAnimacionJQueryDescripcion`) VALUES
(1, 'toggle', 'Simplemente Mostrar (sin animacion)'),
(2, 'fadeToggle', 'Aparecer gradualmente'),
(3, 'slideToggle', 'Aparecer deslizando hacia abajo'),
(4, 'default', 'Default');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_cantidadpagos`
--

CREATE TABLE IF NOT EXISTS `cat_cantidadpagos` (
  `id_CantidadPago` int(11) NOT NULL AUTO_INCREMENT,
  `cantidadPago` int(11) NOT NULL,
  `tx_CantidadPago` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_CantidadPago`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `cat_cantidadpagos`
--

INSERT INTO `cat_cantidadpagos` (`id_CantidadPago`, `cantidadPago`, `tx_CantidadPago`) VALUES
(1, 2, 'Dos'),
(2, 3, 'Tres'),
(3, 4, 'Cuatro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_formaspago`
--

CREATE TABLE IF NOT EXISTS `cat_formaspago` (
  `id_FormaPago` int(11) NOT NULL AUTO_INCREMENT,
  `tx_FormaPago` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_FormaPago`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `cat_formaspago`
--

INSERT INTO `cat_formaspago` (`id_FormaPago`, `tx_FormaPago`) VALUES
(1, 'Efectivo'),
(2, 'Cheque'),
(3, 'Transferencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_respuestabinaria`
--

CREATE TABLE IF NOT EXISTS `cat_respuestabinaria` (
  `id_RespuestaBinaria` int(11) NOT NULL,
  `tx_RespuestaBinaria` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_RespuestaBinaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cat_respuestabinaria`
--

INSERT INTO `cat_respuestabinaria` (`id_RespuestaBinaria`, `tx_RespuestaBinaria`) VALUES
(0, 'No'),
(1, 'Si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_statuscompraproveedor`
--

CREATE TABLE IF NOT EXISTS `cat_statuscompraproveedor` (
  `id_statuscompraproveedor` int(11) NOT NULL AUTO_INCREMENT,
  `tx_StatusCompraProveedor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_statuscompraproveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `cat_statuscompraproveedor`
--

INSERT INTO `cat_statuscompraproveedor` (`id_statuscompraproveedor`, `tx_StatusCompraProveedor`) VALUES
(1, 'Pagada'),
(2, 'En proceso de pago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_tiposvalor`
--

CREATE TABLE IF NOT EXISTS `cat_tiposvalor` (
  `id_TipoValor` int(11) NOT NULL AUTO_INCREMENT,
  `tx_TipoValor` varchar(10) DEFAULT NULL,
  `tx_DescripcionValor` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_TipoValor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `cat_tiposvalor`
--

INSERT INTO `cat_tiposvalor` (`id_TipoValor`, `tx_TipoValor`, `tx_DescripcionValor`) VALUES
(1, 'num', 'Numeros enteros'),
(2, 'meses', 'Numero que representa una cantidad de meses (meses enteros)'),
(3, 'dias', 'Numero que representa una cantidad de dias (dias enteros)'),
(4, 'bool', 'Valor booleano (falso/verdadero)'),
(5, 'min', 'Minutos'),
(6, 'hrs', 'Horas'),
(7, 'segs', 'Segundos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_tiposventaproductos`
--

CREATE TABLE IF NOT EXISTS `cat_tiposventaproductos` (
  `id_TipoVentaProducto` int(11) NOT NULL AUTO_INCREMENT,
  `tx_TipoVentaProducto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_TipoVentaProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `cat_tiposventaproductos`
--

INSERT INTO `cat_tiposventaproductos` (`id_TipoVentaProducto`, `tx_TipoVentaProducto`) VALUES
(1, 'Kg.'),
(2, 'Caja'),
(4, 'Pieza'),
(5, 'metro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cat_velocidadesanimacionjquery`
--

CREATE TABLE IF NOT EXISTS `cat_velocidadesanimacionjquery` (
  `id_VelocidadAnimacionJQuery` int(11) NOT NULL,
  `tx_NombreVelocidadJQuery` varchar(30) NOT NULL,
  `tx_NombreVelocidadJQueryDescripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_VelocidadAnimacionJQuery`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cat_velocidadesanimacionjquery`
--

INSERT INTO `cat_velocidadesanimacionjquery` (`id_VelocidadAnimacionJQuery`, `tx_NombreVelocidadJQuery`, `tx_NombreVelocidadJQueryDescripcion`) VALUES
(1, 'slow', 'Lento'),
(2, 'normal', 'Normal'),
(3, 'fast', 'Rapido'),
(4, 'default', 'Default');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_categorias`
--

CREATE TABLE IF NOT EXISTS `tbl_categorias` (
  `id_Categoria` int(11) NOT NULL AUTO_INCREMENT,
  `tx_Nombre` varchar(30) NOT NULL,
  `porcentajeGanancia` double NOT NULL,
  `tx_CarpetaCategoria` varchar(250) NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_Categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `tbl_categorias`
--

INSERT INTO `tbl_categorias` (`id_Categoria`, `tx_Nombre`, `porcentajeGanancia`, `tx_CarpetaCategoria`, `dt_FechaRegistro`) VALUES
(1, 'Carnes Frias', 4, 'carnesfrias', '2013-11-07 18:17:48'),
(2, 'Frituras', 10, 'frituras', '2013-11-07 18:45:58'),
(5, 'Jabones', 14, 'jabones', '2013-11-05 06:37:31'),
(6, 'Alimentos mascotass', 20, 'alimentosmascotas', '2013-11-08 20:20:42'),
(7, 'antibioticos', 40, 'antibioticos', '2013-11-12 14:47:15'),
(8, 'Refrescos Y Bebidas', 30, 'bebidas', '2013-11-22 10:58:44'),
(9, 'Desodorantes', 30, 'desodorantes', '2013-12-12 14:15:45');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_clientes`
--

CREATE TABLE IF NOT EXISTS `tbl_clientes` (
  `id_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `tx_Nombre` varchar(250) NOT NULL,
  `totalCompras` int(11) NOT NULL,
  `id_UsuarioAlta` int(11) NOT NULL,
  `tx_ClaveUltimaCompra` varchar(50) NOT NULL,
  `dt_UltimaCompra` datetime NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_Cliente`),
  KEY `fk_tbl_clientes_usuarios` (`id_UsuarioAlta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `tbl_clientes`
--

INSERT INTO `tbl_clientes` (`id_Cliente`, `tx_Nombre`, `totalCompras`, `id_UsuarioAlta`, `tx_ClaveUltimaCompra`, `dt_UltimaCompra`, `dt_FechaRegistro`) VALUES
(1, 'Fabian Aranda', 1, 1, '183eaa6784b54236ce260cf4b402fa7e', '2013-12-10 10:25:30', '2013-12-10 10:25:30'),
(2, 'Elizabeth Garces', 1, 1, 'f5bf945f7f99d2d3bdffecff355fbd66', '2013-12-10 10:27:49', '2013-12-10 10:27:49'),
(3, 'Yareli Gomez', 1, 1, 'cdccf789b42038f836d7fc32534baa0c', '2013-12-10 11:42:36', '2013-12-10 11:42:36'),
(4, 'Marian Dominguez', 1, 1, 'd7029a7905b55d7fa2967324a5c670ae', '2013-12-11 06:53:17', '2013-12-11 06:53:17');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_comprasproveedor`
--

CREATE TABLE IF NOT EXISTS `tbl_comprasproveedor` (
  `id_CompraProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `id_Factura` int(11) NOT NULL,
  `id_Proveedor` int(11) NOT NULL,
  `id_Usuario` int(11) NOT NULL,
  `importeTotal` double NOT NULL,
  `descuento` int(11) NOT NULL,
  `id_FormaPago` int(11) NOT NULL,
  `id_StatusCompra` int(11) NOT NULL,
  `tx_ClaveCompra` varchar(50) NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_CompraProveedor`),
  KEY `fk_tbl_comprasproveedor_proveedores` (`id_Proveedor`),
  KEY `fk_tbl_comprasproveedor_usuarios` (`id_Usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `tbl_comprasproveedor`
--

INSERT INTO `tbl_comprasproveedor` (`id_CompraProveedor`, `id_Factura`, `id_Proveedor`, `id_Usuario`, `importeTotal`, `descuento`, `id_FormaPago`, `id_StatusCompra`, `tx_ClaveCompra`, `dt_FechaRegistro`) VALUES
(1, 1, 4, 1, 535.5, 0, 2, 1, 'a4532d5c28756b806a60c47f8f588ed1', '2013-11-24 21:09:03'),
(2, 4, 4, 3, 816, 0, 3, 1, 'ddcbf7fb0374ed1be147319fb59773e7', '2013-11-25 06:27:39'),
(3, 1, 4, 1, 2588, 0, 2, 1, 'dbd2e76ac12f0c7844b0f36fb8ec447d', '2013-11-25 06:37:54'),
(4, 6, 7, 1, 626, 0, 1, 1, 'b33f6166c3d7160512f5ea8794876251', '2013-11-25 06:39:34'),
(5, 7, 4, 1, 870.5, 0, 1, 1, '838322a60209ce2522cdaf06ddbbbc4d', '2013-11-25 06:45:44'),
(6, 8, 4, 1, 631, 0, 1, 2, '70a81d64762e041ed0087bf247ddc30f', '2013-11-25 06:50:44'),
(7, 9, 4, 1, 470, 0, 2, 1, '5e16cd2d47a41c8b5dd0cdb9487ed7c1', '2013-11-25 06:52:23'),
(8, 10, 4, 1, 650, 0, 1, 2, 'a7f8d7499fe5598168d6c678258ce8f3', '2013-11-25 07:26:46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_facturasproveedor`
--

CREATE TABLE IF NOT EXISTS `tbl_facturasproveedor` (
  `id_FacturaProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `id_Usuario` int(11) NOT NULL,
  `tx_ClaveCompra` varchar(50) NOT NULL,
  `i_temporal` int(11) DEFAULT NULL,
  `i_disponible` int(11) DEFAULT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_FacturaProveedor`),
  KEY `fk_tbl_facturasproveedor_usuarios` (`id_Usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tbl_facturasproveedor`
--

INSERT INTO `tbl_facturasproveedor` (`id_FacturaProveedor`, `id_Usuario`, `tx_ClaveCompra`, `i_temporal`, `i_disponible`, `dt_FechaRegistro`) VALUES
(1, 1, '84fd66f1b46abfbeea5bce99eeef2fed', 1, 0, '2013-11-25 08:00:58'),
(2, 3, '16b479002030ebd57a3fa0aed0ccc31a', 1, 0, '2013-11-25 08:14:34'),
(3, 6, '2bb2e12cf47c0b850ba33fef648c502a', 1, 0, '2013-11-25 08:19:57');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_facturasventas`
--

CREATE TABLE IF NOT EXISTS `tbl_facturasventas` (
  `id_FacturaVenta` int(11) NOT NULL AUTO_INCREMENT,
  `id_Usuario` int(11) NOT NULL,
  `tx_ClaveVenta` varchar(50) NOT NULL,
  `i_temporal` int(11) DEFAULT NULL,
  `i_disponible` int(11) DEFAULT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_FacturaVenta`),
  KEY `fk_tbl_facturasventas_usuarios` (`id_Usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `tbl_facturasventas`
--

INSERT INTO `tbl_facturasventas` (`id_FacturaVenta`, `id_Usuario`, `tx_ClaveVenta`, `i_temporal`, `i_disponible`, `dt_FechaRegistro`) VALUES
(1, 1, '183eaa6784b54236ce260cf4b402fa7e', 0, 0, '2013-12-09 14:29:30'),
(2, 1, 'f5bf945f7f99d2d3bdffecff355fbd66', 0, 0, '2013-12-10 10:26:36'),
(3, 1, 'ebef15b25583e2a4701e0690ce98a56b', 0, 0, '2013-12-10 10:29:45'),
(4, 1, 'cdccf789b42038f836d7fc32534baa0c', 0, 0, '2013-12-10 10:31:37'),
(5, 1, 'd7029a7905b55d7fa2967324a5c670ae', 0, 0, '2013-12-10 11:43:30'),
(6, 1, '9f889eb8d2a5ca8c7b9e1ddaff159a51', 0, 0, '2013-12-11 06:54:16'),
(7, 1, '05667090e1d8513bb973da1c17a575bb', 0, 0, '2013-12-11 06:55:28'),
(8, 1, '886d0acdd31c90de176ed919c89f00ba', 0, 0, '2013-12-11 06:58:25'),
(9, 3, '372d2a97ca01caaff75859896ab5b8c1', 0, 0, '2013-12-11 10:01:35'),
(10, 3, 'ff3176ea8010caf11bd52d1371aff8fc', 0, 0, '2013-12-11 10:01:57'),
(11, 3, '0aa634f0587ff7223f7c91fcca803ab6', 0, 0, '2013-12-11 10:03:11'),
(12, 3, 'bb175173e4719c111e73d59f10d2e954', 1, 0, '2013-12-11 14:53:19'),
(13, 6, '065cee52444bba756fd6831fc598c832', 0, 0, '2013-12-11 17:14:21'),
(14, 6, '4f25c2db23c4f4f4738f2ed0f3c7f324', 1, 0, '2013-12-11 17:15:17'),
(15, 1, '2d5e250c2cd4a8cd1e728906bcdc542c', 1, 0, '2014-06-28 15:32:03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_pagospendientes`
--

CREATE TABLE IF NOT EXISTS `tbl_pagospendientes` (
  `id_PagoPendiente` int(11) NOT NULL AUTO_INCREMENT,
  `id_Proveedor` int(11) NOT NULL,
  `id_UsuarioCompro` int(11) NOT NULL,
  `numeroDePago` int(11) NOT NULL,
  `cantidadAPagar` double NOT NULL,
  `i_avisar` int(11) DEFAULT NULL,
  `dt_FechaAviso` datetime DEFAULT NULL,
  `tx_ClaveCompra` varchar(50) NOT NULL,
  `i_pagado` int(11) NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_PagoPendiente`),
  KEY `fk_pagospendientes_proveedores` (`id_Proveedor`),
  KEY `fk_pagospendientes_usuarios` (`id_UsuarioCompro`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `tbl_pagospendientes`
--

INSERT INTO `tbl_pagospendientes` (`id_PagoPendiente`, `id_Proveedor`, `id_UsuarioCompro`, `numeroDePago`, `cantidadAPagar`, `i_avisar`, `dt_FechaAviso`, `tx_ClaveCompra`, `i_pagado`, `dt_FechaRegistro`) VALUES
(11, 4, 1, 1, 341234, NULL, NULL, 'c98edbeaa9a4364a8e15256145cfdce4', 0, '2013-11-24 11:33:42'),
(12, 4, 1, 2, 100, NULL, NULL, 'c98edbeaa9a4364a8e15256145cfdce4', 0, '2013-11-24 11:33:42'),
(13, 4, 1, 3, 4234, 1, '2013-11-28 00:00:00', 'c98edbeaa9a4364a8e15256145cfdce4', 0, '2013-11-24 11:33:42'),
(14, 4, 1, 1, 100, 1, '2013-11-29 00:00:00', '838322a60209ce2522cdaf06ddbbbc4d', 0, '2013-11-25 06:45:32'),
(15, 4, 1, 2, 636, NULL, NULL, '838322a60209ce2522cdaf06ddbbbc4d', 0, '2013-11-25 06:45:32'),
(16, 4, 1, 3, 352, 1, '2013-11-29 00:00:00', '838322a60209ce2522cdaf06ddbbbc4d', 0, '2013-11-25 06:45:32'),
(17, 4, 1, 1, 456, NULL, NULL, '70a81d64762e041ed0087bf247ddc30f', 0, '2013-11-25 06:50:34'),
(18, 4, 1, 2, 234, 1, '2013-11-29 00:00:00', '70a81d64762e041ed0087bf247ddc30f', 0, '2013-11-25 06:50:34'),
(19, 4, 1, 1, 325, 1, '2013-11-27 00:00:00', 'a7f8d7499fe5598168d6c678258ce8f3', 0, '2013-11-25 07:26:33'),
(20, 4, 1, 2, 325, 1, '2013-11-30 00:00:00', 'a7f8d7499fe5598168d6c678258ce8f3', 0, '2013-11-25 07:26:33');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_productos`
--

CREATE TABLE IF NOT EXISTS `tbl_productos` (
  `id_Producto` int(11) NOT NULL AUTO_INCREMENT,
  `tx_CodigoBarras` varchar(20) NOT NULL,
  `tx_nombre` varchar(50) NOT NULL,
  `id_TipoVentaProducto` int(11) NOT NULL,
  `tx_descripcion` varchar(500) NOT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL,
  `dt_FechaCaducidad` datetime NOT NULL,
  `tx_Imagen` varchar(50) NOT NULL,
  `id_Proveedor` int(11) NOT NULL,
  `id_Categoria` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_Producto`),
  KEY `fk_productos_proveedores` (`id_Proveedor`),
  KEY `fk_productos_categoria` (`id_Categoria`),
  KEY `fk_productos_tiposventaproductos` (`id_TipoVentaProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `tbl_productos`
--

INSERT INTO `tbl_productos` (`id_Producto`, `tx_CodigoBarras`, `tx_nombre`, `id_TipoVentaProducto`, `tx_descripcion`, `precioCompra`, `precioVenta`, `dt_FechaCaducidad`, `tx_Imagen`, `id_Proveedor`, `id_Categoria`, `cantidad`, `dt_FechaRegistro`) VALUES
(1, '25454354', 'Papas', 4, 'Papas Sabritas 150 gr', 8, 8.8, '0000-00-00 00:00:00', 'sabritas-bolsa-sabritas.png', 2, 2, 30, '2013-11-10 18:48:34'),
(2, '4574767377', 'Zest Yerbabuena', 4, 'Jabon higienico Marca Zest 350 gr', 7, 7.98, '0000-00-00 00:00:00', 'CV_Gonzasilve.pdf', 2, 5, 35, '2013-11-10 18:50:45'),
(3, '28302711', 'iverfler', 4, '500 ml', 320, 326.4, '0000-00-00 00:00:00', '', 3, 1, 18, '2013-11-12 14:37:40'),
(4, '6562457894', 'Manzanita Sol', 4, 'Nació en 1995 a fin de complacer el gusto de los mexicanos por el sabor manzana. Su peculiar aroma la ha convertido, a partir de su lanzamiento, en la bebida gasificada sabor manzana número uno en el país.', 7, 9.1, '2013-12-28 00:00:00', 'feis_hechizo.jpg', 4, 8, 34, '2013-11-22 10:58:12'),
(5, '2788743543', 'Fanta', 4, 'Divertido refresco con irresistible sabor naranja, que es fuente de energía e hidratación. Fue la primera marca de sabor en México, introducida por Coca-Cola hace más de 50 años.', 6, 7.8, '2013-12-28 00:00:00', 'fanta.png', 4, 8, 58, '2013-11-22 11:23:00'),
(6, '3456734373', ' Sidral Mundet Light', 4, 'El mismo suave y delicioso sabor de la manzana, bajo en sodio, sin azúcar y sin calorías.', 7, 9.1, '2013-12-21 00:00:00', 'sidral_light.png', 4, 8, 46, '2013-11-22 11:24:08'),
(7, '4645432454', 'Ameyal', 4, 'Es una marca que se lanzó en 2001 en Toluca y Cuernavaca. Cuenta con siete deliciosos sabores.', 6.5, 8.45, '2013-11-30 00:00:00', '10 mandamientos.jpg', 4, 8, 119, '2013-11-22 11:25:26'),
(8, '3534536776', 'Rufles', 4, 'Papas con Sabor a queso.', 8, 8.8, '0000-00-00 00:00:00', 'sabritas-bolsa-ruffles.png', 2, 2, 32, '2013-11-22 11:27:53'),
(9, '46548804467', 'Doritos', 4, 'Toritlla dorada con especias y sabor a pizza', 8, 8.8, '2013-11-30 00:00:00', 'sabritas-bolsa-doritos.png', 2, 2, 48, '2013-11-22 11:33:38'),
(10, '87777363563', 'Crujitos', 4, 'Tiritas de maiz enchilados', 8, 8.8, '0000-00-00 00:00:00', 'sabritas-bolsa-crujitos.png', 2, 2, 97, '2013-11-22 11:34:41'),
(11, '236542334', 'Frutsi', 4, 'Bebida de diferentes sabores', 5, 6.5, '2013-11-28 00:00:00', 'feis_hechizo.jpg', 2, 8, 9, '2013-11-24 14:06:14'),
(12, '7434574457', 'Canelitas', 4, 'Galletas sabor canela, irresistibles', 4.5, 4.95, '2013-11-30 00:00:00', 'feis_hechizo.jpg', 2, 2, 11, '2013-11-26 10:36:35'),
(13, '35454235793', 'Jabon Zote', 4, 'Jabon para ropa', 8, 9.12, '2013-12-28 00:00:00', 'hola_timido.png', 10, 5, 42, '2013-12-08 09:01:49');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_productoscompraproveedor`
--

CREATE TABLE IF NOT EXISTS `tbl_productoscompraproveedor` (
  `id_ProductoCompraProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `id_Proveedor` int(11) NOT NULL,
  `id_Usuario` int(11) NOT NULL,
  `tx_CodigoBarras` varchar(20) NOT NULL,
  `tx_Nombre` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `dt_Caducidad` datetime NOT NULL,
  `precioUnitario` double NOT NULL,
  `importe` double NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  `tx_ClaveCompra` varchar(50) NOT NULL,
  PRIMARY KEY (`id_ProductoCompraProveedor`),
  KEY `fk_tbl_productoscompraproveedor_proveedores` (`id_Proveedor`),
  KEY `fk_tbl_productoscompraproveedor_usuarios` (`id_Usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

--
-- Volcado de datos para la tabla `tbl_productoscompraproveedor`
--

INSERT INTO `tbl_productoscompraproveedor` (`id_ProductoCompraProveedor`, `id_Proveedor`, `id_Usuario`, `tx_CodigoBarras`, `tx_Nombre`, `cantidad`, `dt_Caducidad`, `precioUnitario`, `importe`, `dt_FechaRegistro`, `tx_ClaveCompra`) VALUES
(1, 4, 1, '28302711', 'iverfler', 45, '2013-11-28 00:00:00', 53.2, 2394, '2013-11-17 20:33:12', 'c98edbeaa9a4364a8e15256145cfdce4'),
(2, 4, 1, '25454354', 'Papas', 45, '2013-11-29 00:00:00', 53.2, 2394, '2013-11-17 20:58:02', 'c98edbeaa9a4364a8e15256145cfdce4'),
(3, 4, 1, '4574767377', 'Zest Yerbabuena', 77, '2013-12-25 00:00:00', 2.3, 177.1, '2013-11-17 20:59:19', 'c98edbeaa9a4364a8e15256145cfdce4'),
(4, 4, 1, '4645432454', 'Ameyal', 56, '2013-11-26 00:00:00', 56.2, 3147.2, '2013-11-24 13:34:25', 'c98edbeaa9a4364a8e15256145cfdce4'),
(8, 4, 1, '28302711', 'iverfler', 56, '2013-11-27 00:00:00', 34.5, 1932, '2013-11-24 09:03:38', '9d832eebb51b81e5163a13f3d763466b'),
(9, 4, 1, '4645432454', 'Ameyal', 56, '2013-11-25 00:00:00', 6.5, 364, '2013-11-24 20:39:31', '9d832eebb51b81e5163a13f3d763466b'),
(11, 2, 1, '87777363563', 'Crujitos', 40, '2013-11-30 00:00:00', 6.5, 260, '2013-11-24 20:57:37', '9d5d6f600c87ddc4df6bea416c239d79'),
(12, 2, 1, '46548804467', 'Doritos', 50, '2013-11-29 00:00:00', 8.5, 425, '2013-11-24 20:58:06', '9d5d6f600c87ddc4df6bea416c239d79'),
(13, 2, 1, '3534536776', 'Rufles', 20, '2013-11-27 00:00:00', 7.5, 150, '2013-11-24 20:58:32', '9d5d6f600c87ddc4df6bea416c239d79'),
(14, 4, 1, '2788743543', 'Fanta', 40, '2013-11-29 00:00:00', 7.5, 300, '2013-11-24 21:03:08', '55afaf506afb328184daa96b1b43642c'),
(15, 4, 1, '3456734373', ' Sidral Mundet Light', 34, '2013-11-28 00:00:00', 8.5, 289, '2013-11-24 21:03:27', '55afaf506afb328184daa96b1b43642c'),
(17, 4, 1, '2788743543', 'Fanta', 37, '2013-11-28 00:00:00', 8.5, 314.5, '2013-11-24 21:08:36', 'a4532d5c28756b806a60c47f8f588ed1'),
(18, 4, 1, '6562457894', 'Manzanita Sol', 34, '2013-11-28 00:00:00', 6.5, 221, '2013-11-24 21:08:54', 'a4532d5c28756b806a60c47f8f588ed1'),
(20, 4, 3, '6562457894', 'Manzanita Sol', 45, '2013-11-27 00:00:00', 5.8, 261, '2013-11-25 06:27:03', 'ddcbf7fb0374ed1be147319fb59773e7'),
(21, 4, 3, '2788743543', 'Fanta', 74, '2013-11-30 00:00:00', 7.5, 555, '2013-11-25 06:27:30', 'ddcbf7fb0374ed1be147319fb59773e7'),
(23, 4, 1, '4645432454', 'Ameyal', 40, '2013-11-30 00:00:00', 56.2, 2248, '2013-11-25 06:34:58', 'dbd2e76ac12f0c7844b0f36fb8ec447d'),
(24, 4, 1, '3456734373', ' Sidral Mundet Light', 40, '2013-12-20 00:00:00', 8.5, 340, '2013-11-25 06:35:32', 'dbd2e76ac12f0c7844b0f36fb8ec447d'),
(26, 7, 1, '4645432454', 'Ameyal', 34, '2013-11-29 00:00:00', 6.5, 221, '2013-11-25 06:38:49', 'b33f6166c3d7160512f5ea8794876251'),
(27, 7, 1, '236542334', 'Frutsi', 34, '2013-11-28 00:00:00', 7.5, 255, '2013-11-25 06:39:02', 'b33f6166c3d7160512f5ea8794876251'),
(28, 7, 1, '3534536776', 'Rufles', 20, '2013-11-30 00:00:00', 7.5, 150, '2013-11-25 06:39:20', 'b33f6166c3d7160512f5ea8794876251'),
(29, 4, 1, '2788743543', 'Fanta', 53, '2013-11-30 00:00:00', 8.5, 450.5, '2013-11-25 06:44:49', '838322a60209ce2522cdaf06ddbbbc4d'),
(30, 4, 1, '6562457894', 'Manzanita Sol', 56, '2013-11-29 00:00:00', 7.5, 420, '2013-11-25 06:45:03', '838322a60209ce2522cdaf06ddbbbc4d'),
(32, 4, 1, '3456734373', ' Sidral Mundet Light', 34, '2013-11-28 00:00:00', 9.5, 323, '2013-11-25 06:49:51', '70a81d64762e041ed0087bf247ddc30f'),
(33, 4, 1, '6562457894', 'Manzanita Sol', 56, '2013-11-28 00:00:00', 5.5, 308, '2013-11-25 06:50:12', '70a81d64762e041ed0087bf247ddc30f'),
(35, 4, 1, '4645432454', 'Ameyal', 20, '2013-11-28 00:00:00', 6.5, 130, '2013-11-25 06:52:00', '5e16cd2d47a41c8b5dd0cdb9487ed7c1'),
(36, 4, 1, '2788743543', 'Fanta', 40, '2013-11-29 00:00:00', 8.5, 340, '2013-11-25 06:52:13', '5e16cd2d47a41c8b5dd0cdb9487ed7c1'),
(38, 4, 1, '4645432454', 'Ameyal', 100, '2013-11-30 00:00:00', 6.5, 650, '2013-11-25 07:24:38', 'a7f8d7499fe5598168d6c678258ce8f3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_productosventa`
--

CREATE TABLE IF NOT EXISTS `tbl_productosventa` (
  `id_ProductoVenta` int(11) NOT NULL,
  `tx_NombreCliente` varchar(100) DEFAULT NULL,
  `id_Cliente` int(11) DEFAULT NULL,
  `id_Usuario` int(11) NOT NULL,
  `tx_CodigoBarras` varchar(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `importe` double NOT NULL,
  `tx_ClaveVenta` varchar(50) NOT NULL,
  `i_cancelado` int(11) DEFAULT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_ProductoVenta`),
  KEY `fk_tbl_productosventa_usuarios` (`id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tbl_productosventa`
--

INSERT INTO `tbl_productosventa` (`id_ProductoVenta`, `tx_NombreCliente`, `id_Cliente`, `id_Usuario`, `tx_CodigoBarras`, `cantidad`, `importe`, `tx_ClaveVenta`, `i_cancelado`, `dt_FechaRegistro`) VALUES
(1, NULL, 1, 1, '4645432454', 1, 8.45, '183eaa6784b54236ce260cf4b402fa7e', 0, '2013-12-10 10:25:03'),
(2, NULL, 1, 1, '2788743543', 2, 15.6, '183eaa6784b54236ce260cf4b402fa7e', 0, '2013-12-10 10:25:11'),
(3, NULL, 1, 1, '7434574457', 1, 4.95, '183eaa6784b54236ce260cf4b402fa7e', 0, '2013-12-10 10:25:22'),
(4, NULL, 2, 1, '3456734373', 1, 9.1, 'f5bf945f7f99d2d3bdffecff355fbd66', 0, '2013-12-10 10:26:57'),
(5, NULL, 2, 1, '4645432454', 1, 8.45, 'f5bf945f7f99d2d3bdffecff355fbd66', 0, '2013-12-10 10:27:03'),
(6, NULL, 2, 1, '35454235793', 1, 9.12, 'f5bf945f7f99d2d3bdffecff355fbd66', 0, '2013-12-10 10:27:20'),
(7, NULL, 2, 1, '2788743543', 2, 15.6, 'ebef15b25583e2a4701e0690ce98a56b', 0, '2013-12-10 10:31:26'),
(8, NULL, 3, 1, '2788743543', 1, 7.8, 'cdccf789b42038f836d7fc32534baa0c', 0, '2013-12-10 11:41:47'),
(9, NULL, 3, 1, '7434574457', 1, 4.95, 'cdccf789b42038f836d7fc32534baa0c', 0, '2013-12-10 11:41:53'),
(10, NULL, 3, 1, '6562457894', 1, 9.1, 'cdccf789b42038f836d7fc32534baa0c', 0, '2013-12-10 11:42:07'),
(11, NULL, 3, 1, '28302711', 1, 326.4, 'cdccf789b42038f836d7fc32534baa0c', 0, '2013-12-10 11:42:15'),
(12, NULL, 3, 1, '3534536776', 1, 8.8, 'cdccf789b42038f836d7fc32534baa0c', 0, '2013-12-10 11:42:23'),
(13, NULL, 4, 1, '3456734373', 1, 9.1, 'd7029a7905b55d7fa2967324a5c670ae', 0, '2013-12-11 06:53:10'),
(14, NULL, 2, 1, '46548804467', 1, 8.8, '9f889eb8d2a5ca8c7b9e1ddaff159a51', 0, '2013-12-11 06:55:20'),
(15, NULL, 4, 1, '236542334', 2, 13, '05667090e1d8513bb973da1c17a575bb', 0, '2013-12-11 06:57:24'),
(16, NULL, 4, 1, '7434574457', 1, 4.95, '05667090e1d8513bb973da1c17a575bb', 0, '2013-12-11 06:58:16'),
(17, NULL, 2, 3, '3456734373', 1, 9.1, '372d2a97ca01caaff75859896ab5b8c1', 0, '2013-12-11 10:01:47'),
(18, NULL, 2, 3, '4645432454', 1, 8.45, 'ff3176ea8010caf11bd52d1371aff8fc', 0, '2013-12-11 10:02:47'),
(19, NULL, 2, 3, '7434574457', 1, 4.95, 'ff3176ea8010caf11bd52d1371aff8fc', 0, '2013-12-11 10:02:56'),
(20, NULL, 2, 3, '6562457894', 1, 9.1, 'ff3176ea8010caf11bd52d1371aff8fc', 0, '2013-12-11 10:03:03'),
(21, NULL, 3, 3, '7434574457', 1, 4.95, '0aa634f0587ff7223f7c91fcca803ab6', 0, '2013-12-11 14:53:11'),
(22, NULL, 4, 6, '4645432454', 1, 8.45, '065cee52444bba756fd6831fc598c832', 0, '2013-12-11 17:14:29'),
(23, NULL, 4, 6, '6562457894', 1, 9.1, '065cee52444bba756fd6831fc598c832', 0, '2013-12-11 17:14:37'),
(24, NULL, 4, 6, '2788743543', 1, 7.8, '065cee52444bba756fd6831fc598c832', 0, '2013-12-11 17:14:50'),
(25, NULL, 4, 6, '3534536776', 1, 8.8, '065cee52444bba756fd6831fc598c832', 0, '2013-12-11 17:15:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_proveedores`
--

CREATE TABLE IF NOT EXISTS `tbl_proveedores` (
  `id_Proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `tx_RFC` varchar(20) NOT NULL,
  `tx_Nombre` varchar(50) NOT NULL,
  `tx_Telefono` varchar(50) NOT NULL,
  `tx_Contacto` varchar(50) NOT NULL,
  `tx_Direccion` varchar(500) NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_Proveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `tbl_proveedores`
--

INSERT INTO `tbl_proveedores` (`id_Proveedor`, `tx_RFC`, `tx_Nombre`, `tx_Telefono`, `tx_Contacto`, `tx_Direccion`, `dt_FechaRegistro`) VALUES
(2, 'awq312c', 'Sabritas', '2144354', 'javier alarcon', 'safsdf,sdf2f', '2013-11-07 17:45:45'),
(3, 'FDF232', 'San Rafael', '1342545', 'Laura Avila', 'Benito Juarez #34', '2013-11-07 19:51:47'),
(4, '2321412sf', 'Coca-Cola', '672346678', 'Angeles Mateos', 'privada #13, colonia barona', '2013-11-07 21:07:48'),
(6, 'Jab6323', 'el bronce de veracruz', '1455765665', 'Alex Roa', 'Benito Juarez #8, Del Cuahutemoc, Morelos', '2013-11-10 18:50:00'),
(7, '34526sd', 'pepsi', '9821182374', 'juan ', 'calle34x45', '2013-11-10 21:40:49'),
(8, 'lamc570930ms5', 'loefler', '9992130212', 'mauro martinez', 'av. hector perez', '2013-11-12 14:45:53'),
(10, 'bar657454', 'Bayer', '654673688', 'Gabriel Alarcon', 'Montes Urales, Col anzures, D.F.', '2013-11-30 16:45:25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_ventascanceladas`
--

CREATE TABLE IF NOT EXISTS `tbl_ventascanceladas` (
  `id_ProductoVenta` int(11) NOT NULL,
  `tx_NombreCliente` varchar(100) NOT NULL,
  `id_Usuario` int(11) NOT NULL,
  `tx_CodigoBarras` varchar(20) NOT NULL,
  `tx_Nombre` varchar(50) NOT NULL,
  `tx_descripcion` varchar(500) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioUnitario` double NOT NULL,
  `importe` double NOT NULL,
  `id_TipoVentaProducto` int(11) NOT NULL,
  `tx_ClaveVenta` varchar(50) NOT NULL,
  `i_cancelado` int(11) DEFAULT NULL,
  `id_UsuarioCancelo` int(11) NOT NULL,
  `dt_FechaCancelacion` datetime NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_ProductoVenta`),
  KEY `fk_tbl_ventascanceladas_usuarios` (`id_Usuario`),
  KEY `fk_tbl_ventascanceladas_tiposventaproductos` (`id_TipoVentaProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tbl_ventascanceladas`
--

INSERT INTO `tbl_ventascanceladas` (`id_ProductoVenta`, `tx_NombreCliente`, `id_Usuario`, `tx_CodigoBarras`, `tx_Nombre`, `tx_descripcion`, `cantidad`, `precioUnitario`, `importe`, `id_TipoVentaProducto`, `tx_ClaveVenta`, `i_cancelado`, `id_UsuarioCancelo`, `dt_FechaCancelacion`, `dt_FechaRegistro`) VALUES
(2, 'Gonzalo Silverio', 1, '3456734373', ' Sidral Mundet Light', 'El mismo suave y delicioso sabor de la manzana, bajo en sodio, sin azÃºcar y sin calorÃ­as.', 1, 9.1, 9.1, 4, 'ff335bf138f7ce06bc2f0f4ee6f71b35', 1, 1, '2013-11-27 14:33:55', '2013-11-27 12:07:07'),
(16, 'Gonzalo Silverio', 1, '3456734373', ' Sidral Mundet Light', 'El mismo suave y delicioso sabor de la manzana, bajo en sodio, sin azÃºcar y sin calorÃ­as.', 3, 9.1, 27.3, 4, '7a5c7b13a7193b48072abea075c9cf5e', 1, 1, '2013-11-28 09:20:12', '2013-11-27 15:04:01'),
(17, 'Marcos Garcia', 1, '87777363563', 'Crujitos', 'Tiritas de maiz enchilados', 1, 8.8, 8.8, 4, '13e85eaef1c1e5914af4363df2620d5f', 1, 1, '2013-11-28 09:18:13', '2013-11-28 08:56:39'),
(18, 'Marcos Garcia', 1, '2788743543', 'Fanta', 'Divertido refresco con irresistible sabor naranja, que es fuente de energÃ­a e hidratacÃ³n. Fue la primera marca de sabor en MÃ©xico, introducida por Coca-Cola hace mÃ¡s de 50 aÃ±os.', 3, 7.8, 23.4, 4, '13e85eaef1c1e5914af4363df2620d5f', 1, 1, '2013-11-28 09:18:13', '2013-11-28 08:56:49'),
(19, 'Marcos Garcia', 1, '3456734373', ' Sidral Mundet Light', 'El mismo suave y delicioso sabor de la manzana, bajo en sodio, sin azÃºcar y sin calorÃ­as.', 2, 9.1, 18.2, 4, '13e85eaef1c1e5914af4363df2620d5f', 1, 1, '2013-11-28 09:18:13', '2013-11-28 08:56:58'),
(20, 'Marcos Garcia', 1, '6562457894', 'Manzanita Sol', 'NaciÃ³ en 1995 a fin de complacer el gusto de los mexicanos por el sabor manzana. Su peculiar aroma la ha convertido, a partir de su lanzamiento, en la bebida gasificada sabor manzana nÃºmero uno en el paÃ­s.', 5, 9.1, 45.5, 4, '13e85eaef1c1e5914af4363df2620d5f', 1, 1, '2013-11-28 09:18:13', '2013-11-28 08:57:34'),
(21, 'Nancy Ortiz', 1, '4574767377', 'Zest Yerbabuena', 'Jabon higienico Marca Zest 350 gr', 4, 7.98, 31.92, 4, 'e41c7c172e1c19d91c55df5d7aef1d00', 1, 1, '2013-11-28 09:19:37', '2013-11-28 09:00:17'),
(30, 'ariel vomez', 3, '4645432454', 'Ameyal', 'Es una marca que se lanzÃ³ en 2001 en Toluca y Cuernavaca. Cuenta con siete deliciosos sabores.', 2, 8.45, 16.9, 4, '3866ebe134327dfad88f17448d83a136', 1, 3, '2013-12-02 17:28:03', '2013-12-02 17:27:15'),
(31, 'ariel vomez', 3, '87777363563', 'Crujitos', 'Tiritas de maiz enchilados', 2, 8.8, 17.6, 4, '3866ebe134327dfad88f17448d83a136', 1, 3, '2013-12-02 17:28:03', '2013-12-02 17:27:49');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_ventasclientes`
--

CREATE TABLE IF NOT EXISTS `tbl_ventasclientes` (
  `id_VentaCliente` int(11) NOT NULL AUTO_INCREMENT,
  `id_Cliente` int(11) DEFAULT NULL,
  `id_Factura` int(11) NOT NULL,
  `id_Usuario` int(11) NOT NULL,
  `totalVenta` double NOT NULL,
  `importe` double NOT NULL,
  `tx_ClaveVenta` varchar(50) NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_VentaCliente`),
  KEY `fk_tbl_tbl_ventasclientes_usuarios` (`id_Usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `tbl_ventasclientes`
--

INSERT INTO `tbl_ventasclientes` (`id_VentaCliente`, `id_Cliente`, `id_Factura`, `id_Usuario`, `totalVenta`, `importe`, `tx_ClaveVenta`, `dt_FechaRegistro`) VALUES
(1, 1, 1, 1, 28.999999999999996, 30, '183eaa6784b54236ce260cf4b402fa7e', '2013-12-08 10:25:30'),
(2, 2, 2, 1, 26.669999999999995, 30, 'f5bf945f7f99d2d3bdffecff355fbd66', '2013-12-10 10:27:49'),
(3, 2, 3, 1, 15.6, 50, 'ebef15b25583e2a4701e0690ce98a56b', '2013-12-10 10:31:36'),
(4, 3, 4, 1, 357.05, 400, 'cdccf789b42038f836d7fc32534baa0c', '2013-12-10 11:42:37'),
(5, 4, 5, 1, 9.1, 10, 'd7029a7905b55d7fa2967324a5c670ae', '2013-12-11 06:53:18'),
(6, 2, 6, 1, 8.8, 10, '9f889eb8d2a5ca8c7b9e1ddaff159a51', '2013-12-11 06:55:27'),
(7, 4, 7, 1, 17.95, 20, '05667090e1d8513bb973da1c17a575bb', '2013-12-11 06:58:24'),
(8, 2, 9, 3, 9.1, 10, '372d2a97ca01caaff75859896ab5b8c1', '2013-12-11 10:01:55'),
(9, 2, 10, 3, 22.5, 30, 'ff3176ea8010caf11bd52d1371aff8fc', '2013-12-11 10:03:10'),
(10, 3, 11, 3, 4.95, 5, '0aa634f0587ff7223f7c91fcca803ab6', '2013-12-11 14:53:18'),
(11, 4, 13, 6, 34.15, 35, '065cee52444bba756fd6831fc598c832', '2013-12-11 17:15:13'),
(12, 2, 8, 1, 88, 100, '886d0acdd31c90de176ed919c89f00ba', '2014-06-28 15:32:02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tmp_productoscompra`
--

CREATE TABLE IF NOT EXISTS `tmp_productoscompra` (
  `id_ProductoCompra` int(11) NOT NULL AUTO_INCREMENT,
  `id_Proveedor` int(11) NOT NULL,
  `id_Usuario` int(11) NOT NULL,
  `tx_CodigoBarras` varchar(20) NOT NULL,
  `tx_Nombre` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `dt_Caducidad` datetime NOT NULL,
  `precioUnitario` double NOT NULL,
  `importe` double NOT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  `tx_ClaveCompra` varchar(50) NOT NULL,
  PRIMARY KEY (`id_ProductoCompra`),
  KEY `fk_productoscompra_proveedores` (`id_Proveedor`),
  KEY `fk_productoscompra_usuarios` (`id_Usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `tmp_productoscompra`
--

INSERT INTO `tmp_productoscompra` (`id_ProductoCompra`, `id_Proveedor`, `id_Usuario`, `tx_CodigoBarras`, `tx_Nombre`, `cantidad`, `dt_Caducidad`, `precioUnitario`, `importe`, `dt_FechaRegistro`, `tx_ClaveCompra`) VALUES
(1, 4, 1, '3456734373', ' Sidral Mundet Light', 40, '2013-12-28 00:00:00', 6, 240, '2013-12-12 13:49:42', '660cdf62e049d75616dbc6dc59c2ece0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tmp_productosventa`
--

CREATE TABLE IF NOT EXISTS `tmp_productosventa` (
  `id_ProductoVenta` int(11) NOT NULL AUTO_INCREMENT,
  `tx_NombreCliente` varchar(100) NOT NULL,
  `id_Usuario` int(11) NOT NULL,
  `tx_CodigoBarras` varchar(20) NOT NULL,
  `tx_Nombre` varchar(50) NOT NULL,
  `tx_descripcion` varchar(500) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioUnitario` double NOT NULL,
  `importe` double NOT NULL,
  `id_TipoVentaProducto` int(11) NOT NULL,
  `tx_ClaveVenta` varchar(50) NOT NULL,
  `i_cancelado` int(11) DEFAULT NULL,
  `dt_FechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`id_ProductoVenta`),
  KEY `fk_tmp_productosventa_usuarios` (`id_Usuario`),
  KEY `fk_tmp_productosventa_tiposventaproductos` (`id_TipoVentaProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `tmp_productosventa`
--

INSERT INTO `tmp_productosventa` (`id_ProductoVenta`, `tx_NombreCliente`, `id_Usuario`, `tx_CodigoBarras`, `tx_Nombre`, `tx_descripcion`, `cantidad`, `precioUnitario`, `importe`, `id_TipoVentaProducto`, `tx_ClaveVenta`, `i_cancelado`, `dt_FechaRegistro`) VALUES
(3, 'Yareli Gomez', 1, '87777363563', 'Crujitos', 'Tiritas de maiz enchilados', 6, 8.8, 52.8, 4, '2d5e250c2cd4a8cd1e728906bcdc542c', 0, '2014-06-28 15:32:48'),
(4, 'Yareli Gomez', 1, '236542334', 'Frutsi', 'Bebida de diferentes sabores', 3, 6.5, 19.5, 4, '2d5e250c2cd4a8cd1e728906bcdc542c', 0, '2014-06-28 15:33:13'),
(5, 'Yareli Gomez', 1, '7777777777777777', 'Canción', 'cerciórese de que esto esta bien', 2, 380.93, 761.86, 4, '2d5e250c2cd4a8cd1e728906bcdc542c', 0, '2014-06-28 15:33:27'),
(6, 'Marian Dominguez', 1, '6562457894', 'Manzanita Sol', 'Nació en 1995 a fin de complacer el gusto de los mexicanos por el sabor manzana. Su peculiar aroma la ha convertido, a partir de su lanzamiento, en la bebida gasificada sabor manzana número uno en el país.', 1, 9.1, 9.1, 4, '9871352891627758468b894e998c3b27', 0, '2014-09-09 21:50:44');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tmp_sesionesactivas`
--

CREATE TABLE IF NOT EXISTS `tmp_sesionesactivas` (
  `id_sesion` int(11) NOT NULL AUTO_INCREMENT,
  `id_Usuario` int(11) DEFAULT NULL,
  `tx_ClaveSesion` varchar(50) DEFAULT NULL,
  `dt_FechaRegistro` datetime DEFAULT NULL,
  `dt_UltimaActividad` datetime DEFAULT NULL,
  PRIMARY KEY (`id_sesion`),
  KEY `id_Usuario` (`id_Usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tmp_usuariosbloqueados`
--

CREATE TABLE IF NOT EXISTS `tmp_usuariosbloqueados` (
  `id_UsuarioBloqueado` int(11) NOT NULL AUTO_INCREMENT,
  `id_Usuario` int(11) DEFAULT NULL,
  `tx_username` varchar(50) DEFAULT NULL,
  `id_TipoBloqueo` int(11) DEFAULT NULL,
  `tiempo` int(11) DEFAULT NULL,
  `tx_TipoTiempo` varchar(5) DEFAULT NULL,
  `dt_FechaRegistro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_UsuarioBloqueado`),
  KEY `id_TipoBloqueo` (`id_TipoBloqueo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tmp_usuariosbloqueados`
--

INSERT INTO `tmp_usuariosbloqueados` (`id_UsuarioBloqueado`, `id_Usuario`, `tx_username`, `id_TipoBloqueo`, `tiempo`, `tx_TipoTiempo`, `dt_FechaRegistro`) VALUES
(2, 3, 'xavier', 1, NULL, NULL, '2014-09-06 21:44:19');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `app_usuarios`
--
ALTER TABLE `app_usuarios`
  ADD CONSTRAINT `app_usuarios_ibfk_1` FOREIGN KEY (`id_RolUsuario`) REFERENCES `app_rolesusuario` (`id_RolUsuario`);

--
-- Filtros para la tabla `tbl_clientes`
--
ALTER TABLE `tbl_clientes`
  ADD CONSTRAINT `fk_tbl_clientes_usuarios` FOREIGN KEY (`id_UsuarioAlta`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tbl_comprasproveedor`
--
ALTER TABLE `tbl_comprasproveedor`
  ADD CONSTRAINT `fk_tbl_comprasproveedor_proveedores` FOREIGN KEY (`id_Proveedor`) REFERENCES `tbl_proveedores` (`id_Proveedor`),
  ADD CONSTRAINT `fk_tbl_comprasproveedor_usuarios` FOREIGN KEY (`id_Usuario`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tbl_facturasproveedor`
--
ALTER TABLE `tbl_facturasproveedor`
  ADD CONSTRAINT `fk_tbl_facturasproveedor_usuarios` FOREIGN KEY (`id_Usuario`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tbl_facturasventas`
--
ALTER TABLE `tbl_facturasventas`
  ADD CONSTRAINT `fk_tbl_facturasventas_usuarios` FOREIGN KEY (`id_Usuario`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tbl_pagospendientes`
--
ALTER TABLE `tbl_pagospendientes`
  ADD CONSTRAINT `fk_pagospendientes_proveedores` FOREIGN KEY (`id_Proveedor`) REFERENCES `tbl_proveedores` (`id_Proveedor`),
  ADD CONSTRAINT `fk_pagospendientes_usuarios` FOREIGN KEY (`id_UsuarioCompro`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tbl_productos`
--
ALTER TABLE `tbl_productos`
  ADD CONSTRAINT `fk_productos_categoria` FOREIGN KEY (`id_Categoria`) REFERENCES `tbl_categorias` (`id_Categoria`),
  ADD CONSTRAINT `fk_productos_proveedores` FOREIGN KEY (`id_Proveedor`) REFERENCES `tbl_proveedores` (`id_Proveedor`),
  ADD CONSTRAINT `fk_productos_tiposventaproductos` FOREIGN KEY (`id_TipoVentaProducto`) REFERENCES `cat_tiposventaproductos` (`id_TipoVentaProducto`);

--
-- Filtros para la tabla `tbl_productoscompraproveedor`
--
ALTER TABLE `tbl_productoscompraproveedor`
  ADD CONSTRAINT `fk_tbl_productoscompraproveedor_proveedores` FOREIGN KEY (`id_Proveedor`) REFERENCES `tbl_proveedores` (`id_Proveedor`),
  ADD CONSTRAINT `fk_tbl_productoscompraproveedor_usuarios` FOREIGN KEY (`id_Usuario`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tbl_productosventa`
--
ALTER TABLE `tbl_productosventa`
  ADD CONSTRAINT `fk_tbl_productosventa_usuarios` FOREIGN KEY (`id_Usuario`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tbl_ventascanceladas`
--
ALTER TABLE `tbl_ventascanceladas`
  ADD CONSTRAINT `fk_tbl_ventascanceladas_tiposventaproductos` FOREIGN KEY (`id_TipoVentaProducto`) REFERENCES `cat_tiposventaproductos` (`id_TipoVentaProducto`),
  ADD CONSTRAINT `fk_tbl_ventascanceladas_usuarios` FOREIGN KEY (`id_Usuario`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tbl_ventasclientes`
--
ALTER TABLE `tbl_ventasclientes`
  ADD CONSTRAINT `fk_tbl_tbl_ventasclientes_usuarios` FOREIGN KEY (`id_Usuario`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tmp_productoscompra`
--
ALTER TABLE `tmp_productoscompra`
  ADD CONSTRAINT `fk_productoscompra_proveedores` FOREIGN KEY (`id_Proveedor`) REFERENCES `tbl_proveedores` (`id_Proveedor`),
  ADD CONSTRAINT `fk_productoscompra_usuarios` FOREIGN KEY (`id_Usuario`) REFERENCES `app_usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `tmp_productosventa`
--
ALTER TABLE `tmp_productosventa`
  ADD CONSTRAINT `fk_tmp_productosventa_tiposventaproductos` FOREIGN KEY (`id_TipoVentaProducto`) REFERENCES `cat_tiposventaproductos` (`id_TipoVentaProducto`),
  ADD CONSTRAINT `fk_tmp_productosventa_usuarios` FOREIGN KEY (`id_Usuario`) REFERENCES `app_usuarios` (`id_Usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
