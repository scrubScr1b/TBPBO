-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2023 at 05:25 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbvote`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

CREATE TABLE `candidate` (
  `codeCandidate` int(11) NOT NULL,
  `candidateId` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `createdAt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`codeCandidate`, `candidateId`, `status`, `createdAt`) VALUES
(1, 'deidara', 'active', '2023-05-15'),
(2, 'hidan', 'active', '2023-05-15'),
(3, 'itachi', 'active', '2023-05-15'),
(4, 'kakuzu', 'active', '2023-05-15'),
(5, 'kisame', 'active', '2023-05-15'),
(6, 'konan', 'active', '2023-05-15'),
(7, 'orochimaru', 'active', '2023-05-15'),
(8, 'pain', 'active', '2023-05-15'),
(9, 'sasori', 'active', '2023-05-15'),
(10, 'tobi', 'active', '2023-05-15'),
(11, 'zetsu', 'active', '2023-05-15');

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `codeEvent` int(11) NOT NULL,
  `eventId` varchar(20) NOT NULL,
  `eventDateStart` date NOT NULL,
  `eventDateEnd` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `createdAt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`codeEvent`, `eventId`, `eventDateStart`, `eventDateEnd`, `status`, `createdAt`) VALUES
(1, 'Iwagakure', '2023-01-01', '2023-06-30', 'active', '2023-01-01'),
(2, 'Kirigakure', '2023-06-01', '2023-06-30', 'active', '2023-05-31'),
(3, 'Konohagakure', '2023-05-01', '2023-05-31', 'active', '2023-05-01'),
(4, 'Sunagakure', '2023-01-01', '2023-06-30', 'active', '2022-12-31');

-- --------------------------------------------------------

--
-- Table structure for table `eventcandidate`
--

CREATE TABLE `eventcandidate` (
  `codeEventCandidate` int(11) NOT NULL,
  `eventCandidateId` varchar(20) NOT NULL,
  `codeEvent` int(11) NOT NULL,
  `codeCandidate` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `eventcandidate`
--

INSERT INTO `eventcandidate` (`codeEventCandidate`, `eventCandidateId`, `codeEvent`, `codeCandidate`, `status`) VALUES
(1, 'Ketua', 1, 1, 'active'),
(2, 'Wakil', 1, 4, 'active'),
(3, 'Sekretaris', 1, 4, 'active'),
(4, 'Bendahara', 1, 9, 'active'),
(5, 'Ketua', 2, 2, 'active'),
(6, 'Wakil', 2, 7, 'active'),
(7, 'Sekretaris', 2, 8, 'active'),
(8, 'Bendahara', 2, 9, 'active'),
(9, 'Ketua', 3, 11, 'active'),
(10, 'Wakil', 3, 9, 'active'),
(11, 'Sekretaris', 3, 4, 'active'),
(12, 'Sekretaris', 3, 3, 'active'),
(13, 'Bendahara', 3, 11, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `codeUser` int(11) NOT NULL,
  `userId` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `createdAt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`codeUser`, `userId`, `pass`, `role`, `status`, `createdAt`) VALUES
(1, 'akbar', '1234', 'user', 'active', '2023-05-15'),
(2, 'farhan', '123456', 'user', 'active', '2023-05-15'),
(3, 'rafly', '123', 'admin', 'active', '2018-05-15'),
(4, 'silvia', '12345', 'user', 'active', '2023-05-15');

-- --------------------------------------------------------

--
-- Table structure for table `vote`
--

CREATE TABLE `vote` (
  `codeVote` int(11) NOT NULL,
  `codeEventCandidate` int(11) NOT NULL,
  `codeUser` int(11) NOT NULL,
  `dateVote` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vote`
--

INSERT INTO `vote` (`codeVote`, `codeEventCandidate`, `codeUser`, `dateVote`) VALUES
(1, 1, 1, '2023-05-16'),
(2, 2, 1, '2023-05-16'),
(3, 3, 1, '2023-05-16'),
(4, 4, 1, '2023-05-16'),
(5, 5, 2, '2023-05-16'),
(6, 6, 2, '2023-05-16'),
(7, 7, 2, '2023-05-16'),
(8, 8, 2, '2023-05-16'),
(9, 9, 4, '2023-05-16'),
(10, 10, 4, '2023-05-16'),
(11, 11, 4, '2023-05-16'),
(12, 12, 2, '2023-05-16'),
(13, 13, 4, '2023-05-16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `candidate`
--
ALTER TABLE `candidate`
  ADD PRIMARY KEY (`codeCandidate`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`codeEvent`);

--
-- Indexes for table `eventcandidate`
--
ALTER TABLE `eventcandidate`
  ADD PRIMARY KEY (`codeEventCandidate`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`codeUser`);

--
-- Indexes for table `vote`
--
ALTER TABLE `vote`
  ADD PRIMARY KEY (`codeVote`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `candidate`
--
ALTER TABLE `candidate`
  MODIFY `codeCandidate` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `codeEvent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `eventcandidate`
--
ALTER TABLE `eventcandidate`
  MODIFY `codeEventCandidate` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `codeUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `vote`
--
ALTER TABLE `vote`
  MODIFY `codeVote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `eventcandidate`
--
ALTER TABLE `eventcandidate`
  ADD CONSTRAINT `eventcandidate_ibfk_1` FOREIGN KEY (`codeEvent`) REFERENCES `event` (`codeEvent`),
  ADD CONSTRAINT `eventcandidate_ibfk_2` FOREIGN KEY (`codeCandidate`) REFERENCES `candidate` (`codeCandidate`);

--
-- Constraints for table `vote`
--
ALTER TABLE `vote`
  ADD CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`codeUser`) REFERENCES `user` (`codeUser`),
  ADD CONSTRAINT `vote_ibfk_2` FOREIGN KEY (`codeEventCandidate`) REFERENCES `eventcandidate` (`codeEventCandidate`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
