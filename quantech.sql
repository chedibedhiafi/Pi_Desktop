-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 24, 2022 at 10:01 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.24

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
-- Table structure for table `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `sujet` varchar(255) NOT NULL,
  `contenu` text NOT NULL,
  `date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`id`, `titre`, `sujet`, `contenu`, `date`) VALUES
(3, 'new product', 'PC sales', 'We are selling brand new Asus Tuf', '2022-02-02'),
(5, 'new phones', 'Phone sales', 'We are now selling Iphone11', '2022-02-02');

-- --------------------------------------------------------

--
-- Table structure for table `catégorie`
--

CREATE TABLE `catégorie` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `catégorie`
--

INSERT INTO `catégorie` (`id`, `nom`) VALUES
(4, 'TV'),
(5, 'PC'),
(6, 'SMARTPHONES'),
(7, 'CONSOLES');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `Client_Id` int(11) NOT NULL,
  `Historique_Achat` varchar(11) NOT NULL,
  `Fk_Reserv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`Client_Id`, `Historique_Achat`, `Fk_Reserv`) VALUES
(1, 'fefe', 3);

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `date_envoie` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`id`, `date_creation`, `date_envoie`) VALUES
(2, '3921-03-22', '3921-06-23'),
(3, '3921-03-22', '3921-06-23'),
(4, '3921-03-22', '3921-06-23'),
(6, '3921-03-22', '3921-06-23'),
(7, '3921-03-22', '3921-06-23'),
(8, '3921-03-22', '3921-06-23'),
(9, '3921-03-22', '3921-06-23'),
(10, '3921-03-22', '3921-06-23'),
(11, '3921-03-22', '3921-06-23'),
(12, '3921-03-22', '3921-06-23');

-- --------------------------------------------------------

--
-- Table structure for table `commentaire`
--

CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `date` date NOT NULL,
  `id_blog` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commentaire`
--

INSERT INTO `commentaire` (`id`, `contenu`, `date`, `id_blog`) VALUES
(8, 'Finally, I was really patiently waiting for this product', '2012-12-12', 3),
(9, 'prix svp pas privé', '2012-12-12', 3),
(10, 'prix svp', '2012-12-12', 3),
(11, 'prix svp', '2012-12-12', 3);

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `role` varchar(255) NOT NULL,
  `id_pointdevente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`id`, `role`, `id_pointdevente`) VALUES
(14, 'admin', 3),
(37, 'admin', 3);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `Event_Id` int(11) NOT NULL,
  `Date_Event` date NOT NULL,
  `Titre` varchar(100) NOT NULL,
  `Prix` int(11) NOT NULL,
  `Image` varchar(150) NOT NULL,
  `Description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`Event_Id`, `Date_Event`, `Titre`, `Prix`, `Image`, `Description`) VALUES
(15, '2021-11-22', 'efe', 5, 'fe', 'fe'),
(16, '2021-11-22', 'efe', 5, 'fe', 'fe'),
(17, '2021-11-22', 'efe', 5, 'fe', 'fe'),
(18, '2021-11-22', 'efe', 5, 'fe', 'fe'),
(19, '2021-11-22', 'efe', 5, 'fe', 'fe');

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

-- --------------------------------------------------------

--
-- Table structure for table `livraison`
--

CREATE TABLE `livraison` (
  `id` int(11) NOT NULL,
  `frais_livraison` float NOT NULL,
  `etat_livraison` int(11) NOT NULL,
  `num_livreur` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `livraison`
--

INSERT INTO `livraison` (`id`, `frais_livraison`, `etat_livraison`, `num_livreur`, `id_commande`) VALUES
(2, 45, 2, 24555888, 8),
(9, 500, 0, 25456230, 9),
(12, 35, 10, 94110535, 10);

-- --------------------------------------------------------

--
-- Table structure for table `pointdevente`
--

CREATE TABLE `pointdevente` (
  `reference` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `proprietaire` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `date_ouverture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pointdevente`
--

INSERT INTO `pointdevente` (`reference`, `name`, `proprietaire`, `adresse`, `date_ouverture`) VALUES
(3, 'tunis', 'walid', 'tunis', '2022-12-02');

-- --------------------------------------------------------

--
-- Table structure for table `produits`
--

CREATE TABLE `produits` (
  `id` int(11) NOT NULL,
  `id_catégorie` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prix` int(11) NOT NULL,
  `image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produits`
--

INSERT INTO `produits` (`id`, `id_catégorie`, `nom`, `prix`, `image`) VALUES
(4, 5, 'pc', 1400, 'pc'),
(6, 7, 'PS4', 650, 'PS4');

-- --------------------------------------------------------

--
-- Table structure for table `produit_commande`
--

CREATE TABLE `produit_commande` (
  `id` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rate`
--

CREATE TABLE `rate` (
  `Rate_Id` int(11) NOT NULL,
  `Event_Id` int(11) NOT NULL,
  `Client_Id` int(11) NOT NULL,
  `Sum` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rate`
--

INSERT INTO `rate` (`Rate_Id`, `Event_Id`, `Client_Id`, `Sum`) VALUES
(11, 17, 1, 30),
(12, 15, 1, 44);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `Reserv_Id` int(11) NOT NULL,
  `Nb_Places` int(11) NOT NULL,
  `Date_Achat` date NOT NULL,
  `Total` int(11) NOT NULL,
  `FK_Event` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`Reserv_Id`, `Nb_Places`, `Date_Achat`, `Total`, `FK_Event`) VALUES
(5, 10, '2021-11-22', 20, 17);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `id_produit` int(11) NOT NULL,
  `id_pointdevente` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `date_naissance` date NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tentative` int(11) NOT NULL,
  `unlock_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `mdp`, `date_naissance`, `nom`, `prenom`, `email`, `tentative`, `unlock_date`) VALUES
(14, 'cycyy', '#:>/^+rkb', '2022-12-02', 'essid', 'cyrine', 'cyrine@gmail.com', 0, '2000-01-01'),
(37, 'aziz', '${=-+>', '2020-07-04', 'lasfer', 'aziz', 'aziz@gmail.com', 0, '2000-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `vote`
--

CREATE TABLE `vote` (
  `id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `id_source` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vote`
--

INSERT INTO `vote` (`id`, `type`, `id_source`) VALUES
(22, 1, 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `catégorie`
--
ALTER TABLE `catégorie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`Client_Id`),
  ADD KEY `Fk_Reserv` (`Fk_Reserv`);

--
-- Indexes for table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_blog_cfk` (`id_blog`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_pointdevente` (`id_pointdevente`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`Event_Id`);

--
-- Indexes for table `historiquestock`
--
ALTER TABLE `historiquestock`
  ADD PRIMARY KEY (`reference`),
  ADD KEY `id_produit` (`id_produit`,`id_pointdevente`),
  ADD KEY `fk_idPointDeVenteHistorique` (`id_pointdevente`);

--
-- Indexes for table `livraison`
--
ALTER TABLE `livraison`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gdjfdj` (`id_commande`);

--
-- Indexes for table `pointdevente`
--
ALTER TABLE `pointdevente`
  ADD PRIMARY KEY (`reference`);

--
-- Indexes for table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_catégorie` (`id_catégorie`);

--
-- Indexes for table `produit_commande`
--
ALTER TABLE `produit_commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ds` (`id_commande`),
  ADD KEY `fdhyret` (`id_produit`);

--
-- Indexes for table `rate`
--
ALTER TABLE `rate`
  ADD PRIMARY KEY (`Rate_Id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`Reserv_Id`),
  ADD KEY `Fk_Event` (`FK_Event`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id_produit`,`id_pointdevente`),
  ADD KEY `id_produit` (`id_produit`),
  ADD KEY `id_pointdevente` (`id_pointdevente`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vote`
--
ALTER TABLE `vote`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_source_cfk` (`id_source`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `catégorie`
--
ALTER TABLE `catégorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `Client_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `Event_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `historiquestock`
--
ALTER TABLE `historiquestock`
  MODIFY `reference` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `livraison`
--
ALTER TABLE `livraison`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `pointdevente`
--
ALTER TABLE `pointdevente`
  MODIFY `reference` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `produits`
--
ALTER TABLE `produits`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `produit_commande`
--
ALTER TABLE `produit_commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `rate`
--
ALTER TABLE `rate`
  MODIFY `Rate_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `Reserv_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `vote`
--
ALTER TABLE `vote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `id_blog_cfk` FOREIGN KEY (`id_blog`) REFERENCES `blog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `fk_pointdevente` FOREIGN KEY (`id_pointdevente`) REFERENCES `pointdevente` (`reference`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `historiquestock`
--
ALTER TABLE `historiquestock`
  ADD CONSTRAINT `fk_idPointDeVenteHistorique` FOREIGN KEY (`id_pointdevente`) REFERENCES `stock` (`id_pointdevente`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idProduitHistorique` FOREIGN KEY (`id_produit`) REFERENCES `stock` (`id_produit`) ON UPDATE CASCADE;

--
-- Constraints for table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `gdjfdj` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id`);

--
-- Constraints for table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `fk_catégorie` FOREIGN KEY (`id_catégorie`) REFERENCES `catégorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `produit_commande`
--
ALTER TABLE `produit_commande`
  ADD CONSTRAINT `fk_commande` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_produit` FOREIGN KEY (`id_produit`) REFERENCES `produits` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `Fk_Event` FOREIGN KEY (`FK_Event`) REFERENCES `event` (`Event_Id`);

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `fk_idPointDeVente` FOREIGN KEY (`id_pointdevente`) REFERENCES `pointdevente` (`reference`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idProduit` FOREIGN KEY (`id_produit`) REFERENCES `produits` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `vote`
--
ALTER TABLE `vote`
  ADD CONSTRAINT `id_source_cfk` FOREIGN KEY (`id_source`) REFERENCES `commentaire` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
