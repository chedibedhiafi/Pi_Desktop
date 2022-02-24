-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 24, 2022 at 07:55 AM
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
(3, 'tunis', 'walid', 'tunis', '2022-12-02'),
(4, 'name', 'proprietaire', 'adresse', '2022-04-04'),
(5, 'name', 'proprietaire', 'adresse', '2022-04-04'),
(6, 'Point G', 'Hassen', 'Soukra, Ariana', '2000-04-04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pointdevente`
--
ALTER TABLE `pointdevente`
  ADD PRIMARY KEY (`reference`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pointdevente`
--
ALTER TABLE `pointdevente`
  MODIFY `reference` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
