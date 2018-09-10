-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.22-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5293
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for minions
CREATE DATABASE IF NOT EXISTS `minions` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `minions`;

-- Dumping structure for table minions.minions
CREATE TABLE IF NOT EXISTS `minions` (
  `id` int(11) NOT NULL,
  `town_id` int(11) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_minions_towns` (`town_id`),
  CONSTRAINT `FK_minions_towns` FOREIGN KEY (`town_id`) REFERENCES `towns` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table minions.minions: ~2 rows (approximately)
/*!40000 ALTER TABLE `minions` DISABLE KEYS */;
INSERT INTO `minions` (`id`, `town_id`, `name`, `age`) VALUES
	(1, NULL, 'Kevin', 17),
	(2, NULL, 'Steward', 12);
/*!40000 ALTER TABLE `minions` ENABLE KEYS */;

-- Dumping structure for table minions.towns
CREATE TABLE IF NOT EXISTS `towns` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table minions.towns: ~0 rows (approximately)
/*!40000 ALTER TABLE `towns` DISABLE KEYS */;
/*!40000 ALTER TABLE `towns` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
