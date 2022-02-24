-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 24, 2022 at 07:56 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quantech`
--

-- --------------------------------------------------------

--
-- Table structure for table `historiquestock`
--

CREATE TABLE `historiquestock` (
  `reference` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `id_pointdevente` int(11) NOT NULL,
  `date` date NOT NULL,
  `quantite` int(11) NOT NULL,
  `reason` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Triggers `historiquestock`
--
DELIMITER $$
CREATE TRIGGER `deleteHistorique` AFTER DELETE ON `historiquestock` FOR EACH ROW UPDATE `stock`
SET `quantite`= (SELECT SUM(quantite) from historiquestock WHERE `id_produit` = OLD.id_produit AND `id_pointdevente` = OLD.id_pointdevente )
WHERE `id_produit` = OLD.id_produit AND `id_pointdevente` = OLD.id_pointdevente
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `insertHistorique` AFTER INSERT ON `historiquestock` FOR EACH ROW UPDATE `stock`
SET `quantite`= (SELECT SUM(quantite) from historiquestock WHERE `id_produit` = NEW.id_produit AND `id_pointdevente` = NEW.id_pointdevente )
WHERE `id_produit` = NEW.id_produit AND `id_pointdevente` = NEW.id_pointdevente
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `updateHistorique` AFTER UPDATE ON `historiquestock` FOR EACH ROW UPDATE `stock`
SET `quantite`= (SELECT SUM(quantite) from historiquestock WHERE `id_produit` = NEW.id_produit AND `id_pointdevente` = NEW.id_pointdevente )
WHERE `id_produit` = NEW.id_produit AND `id_pointdevente` = NEW.id_pointdevente
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `historiquestock`
--
ALTER TABLE `historiquestock`
  ADD PRIMARY KEY (`reference`),
  ADD KEY `id_produit` (`id_produit`,`id_pointdevente`),
  ADD KEY `fk_idPointDeVenteHistorique` (`id_pointdevente`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `historiquestock`
--
ALTER TABLE `historiquestock`
  MODIFY `reference` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `historiquestock`
--
ALTER TABLE `historiquestock`
  ADD CONSTRAINT `fk_idPointDeVenteHistorique` FOREIGN KEY (`id_pointdevente`) REFERENCES `stock` (`id_pointdevente`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idProduitHistorique` FOREIGN KEY (`id_produit`) REFERENCES `stock` (`id_produit`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
