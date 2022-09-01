-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 09, 2022 at 06:48 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `diagnosis`
--

CREATE TABLE `diagnosis` (
  `number` int(5) NOT NULL,
  `complaint` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `admissionD` varchar(100) NOT NULL,
  `admissionT` varchar(100) NOT NULL,
  `doctorR` varchar(100) NOT NULL,
  `medication` varchar(100) NOT NULL,
  `dischargeD` varchar(100) NOT NULL,
  `dischargeT` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE `parent` (
  `number` int(6) NOT NULL,
  `fatherFirstName` varchar(100) NOT NULL,
  `fatherLastName` varchar(100) NOT NULL,
  `fatherContact` int(100) NOT NULL,
  `fatherAddress` varchar(100) NOT NULL,
  `motherFirstName` varchar(100) NOT NULL,
  `motherLastName` varchar(100) NOT NULL,
  `motherContact` int(20) NOT NULL,
  `motherAddress` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient_contact`
--

CREATE TABLE `patient_contact` (
  `number` int(5) NOT NULL,
  `patientPhone` int(20) NOT NULL,
  `patientPhone2` int(20) NOT NULL,
  `patientEmail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient_details`
--

CREATE TABLE `patient_details` (
  `number` int(5) NOT NULL,
  `patientID` varchar(100) NOT NULL,
  `patientFirstName` varchar(100) NOT NULL,
  `patientLastName` varchar(100) NOT NULL,
  `patientAge` varchar(100) NOT NULL,
  `patientGender` varchar(100) NOT NULL,
  `patientAddress` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `number` int(5) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `id` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`number`, `firstname`, `lastname`, `id`, `password`) VALUES
(1, 'doc', 'nurse', 'doc-1', '123456789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diagnosis`
--
ALTER TABLE `diagnosis`
  ADD PRIMARY KEY (`number`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`number`);

--
-- Indexes for table `patient_contact`
--
ALTER TABLE `patient_contact`
  ADD PRIMARY KEY (`number`);

--
-- Indexes for table `patient_details`
--
ALTER TABLE `patient_details`
  ADD PRIMARY KEY (`number`),
  ADD UNIQUE KEY `patientID` (`patientID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diagnosis`
--
ALTER TABLE `diagnosis`
  MODIFY `number` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `parent`
--
ALTER TABLE `parent`
  MODIFY `number` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `patient_contact`
--
ALTER TABLE `patient_contact`
  MODIFY `number` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `patient_details`
--
ALTER TABLE `patient_details`
  MODIFY `number` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `number` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
