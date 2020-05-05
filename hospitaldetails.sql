-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2020 at 10:03 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospitaldetails`
--

CREATE TABLE IF NOT EXISTS `hospitaldetails` (
`HID` int(50) NOT NULL,
  `hCode` varchar(50) NOT NULL,
  `hName` varchar(50) NOT NULL,
  `cDoc` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  `phone` int(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `desc` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospitaldetails`
--
ALTER TABLE `hospitaldetails`
 ADD PRIMARY KEY (`HID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hospitaldetails`
--
ALTER TABLE `hospitaldetails`
MODIFY `HID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
