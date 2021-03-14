-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2021 at 02:01 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `karaoke_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `permissions` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `signed_in_at` datetime DEFAULT NULL,
  `signed_out_at` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `active`, `created_at`, `updated_at`, `name`, `password`, `permissions`, `roles`, `signed_in_at`, `signed_out_at`, `username`) VALUES
(1, b'1', '2021-03-14 12:59:56', '2021-03-14 12:59:56', 'ADMIN', '$2a$10$jIAMNrggaPRbdHljuK2lz.Apfvf.gGrGrelz5ZjOlJqaN9FHTnLbe', 'INSERT, READ, UPDATE,DELETE', 'ADMIN', NULL, NULL, 'admin'),
(2, b'1', '2021-03-14 12:59:56', '2021-03-14 12:59:56', 'STAFF', '$2a$10$jIAMNrggaPRbdHljuK2lz.Apfvf.gGrGrelz5ZjOlJqaN9FHTnLbe', 'INSERT, READ', 'ADMIN', NULL, NULL, 'staff'),
(3, b'1', '2021-03-14 12:59:56', '2021-03-14 12:59:56', 'ACCOUNTING', '$2a$10$jIAMNrggaPRbdHljuK2lz.Apfvf.gGrGrelz5ZjOlJqaN9FHTnLbe', 'READ, STATISTIC', 'ACCOUNTING', NULL, NULL, 'account');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `tax_rate` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `check_in` datetime DEFAULT NULL,
  `check_out` datetime DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `bill_id` bigint(20) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `book_room`
--

CREATE TABLE `book_room` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `detail_product`
--

CREATE TABLE `detail_product` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `quanlity` int(11) DEFAULT NULL,
  `detail_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `exp_at` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `package_product`
--

CREATE TABLE `package_product` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `exp_at` datetime DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `packagez_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `quanlity` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `check_in` datetime DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `staff_open_room` tinyblob DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `active`, `created_at`, `updated_at`, `capacity`, `check_in`, `customer_phone`, `floor`, `name`, `staff_open_room`, `status`, `type`) VALUES
(1, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 1, 'F000', NULL, 'EMPTY', 'NORMAL'),
(2, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 1, 'F001', NULL, 'EMPTY', 'NORMAL'),
(3, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 1, 'F002', NULL, 'EMPTY', 'NORMAL'),
(4, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 1, 'F003', NULL, 'EMPTY', 'NORMAL'),
(5, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 15, NULL, 'EMPTY', 1, 'F004', NULL, 'EMPTY', 'NORMAL'),
(6, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 1, 'F005', NULL, 'EMPTY', 'NORMAL'),
(7, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 15, NULL, 'EMPTY', 1, 'F006', NULL, 'EMPTY', 'VIP'),
(8, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 15, NULL, 'EMPTY', 1, 'F007', NULL, 'EMPTY', 'VIP'),
(9, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 1, 'F008', NULL, 'EMPTY', 'VIP'),
(10, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 1, 'F009', NULL, 'EMPTY', 'VIP'),
(11, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 2, 'F010', NULL, 'EMPTY', 'NORMAL'),
(12, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 2, 'F011', NULL, 'EMPTY', 'NORMAL'),
(13, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 2, 'F012', NULL, 'EMPTY', 'NORMAL'),
(14, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 2, 'F013', NULL, 'EMPTY', 'NORMAL'),
(15, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 15, NULL, 'EMPTY', 2, 'F014', NULL, 'EMPTY', 'NORMAL'),
(16, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 2, 'F015', NULL, 'EMPTY', 'NORMAL'),
(17, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 15, NULL, 'EMPTY', 2, 'F016', NULL, 'EMPTY', 'VIP'),
(18, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 15, NULL, 'EMPTY', 2, 'F017', NULL, 'EMPTY', 'VIP'),
(19, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 2, 'F018', NULL, 'EMPTY', 'VIP'),
(20, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 2, 'F019', NULL, 'EMPTY', 'VIP'),
(21, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 3, 'F020', NULL, 'EMPTY', 'NORMAL'),
(22, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 3, 'F021', NULL, 'EMPTY', 'NORMAL'),
(23, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 10, NULL, 'EMPTY', 3, 'F022', NULL, 'EMPTY', 'NORMAL'),
(24, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 15, NULL, 'EMPTY', 3, 'F023', NULL, 'EMPTY', 'NORMAL'),
(25, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 3, 'F024', NULL, 'EMPTY', 'NORMAL'),
(26, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 3, 'F025', NULL, 'EMPTY', 'NORMAL'),
(27, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 15, NULL, 'EMPTY', 3, 'F026', NULL, 'EMPTY', 'VIP'),
(28, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 15, NULL, 'EMPTY', 3, 'F027', NULL, 'EMPTY', 'VIP'),
(29, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 3, 'F028', NULL, 'EMPTY', 'VIP'),
(30, b'1', '2021-03-14 13:00:07', '2021-03-14 13:00:07', 20, NULL, 'EMPTY', 3, 'F029', NULL, 'EMPTY', 'VIP');

-- --------------------------------------------------------

--
-- Table structure for table `room_price`
--

CREATE TABLE `room_price` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `check_in` int(11) DEFAULT NULL,
  `check_out` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `type_day` varchar(255) DEFAULT NULL,
  `type_room` varchar(255) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room_price`
--

INSERT INTO `room_price` (`id`, `active`, `created_at`, `updated_at`, `capacity`, `check_in`, `check_out`, `price`, `type_day`, `type_room`, `room_id`) VALUES
(1, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 10, 0, 6, 100000, 'DAILY', 'NORMAL', NULL),
(2, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 10, 6, 18, 70000, 'DAILY', 'NORMAL', NULL),
(3, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 10, 18, 24, 80000, 'DAILY', 'NORMAL', NULL),
(4, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 0, 6, 130000, 'DAILY', 'NORMAL', NULL),
(5, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 6, 18, 80000, 'DAILY', 'NORMAL', NULL),
(6, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 18, 24, 90000, 'DAILY', 'NORMAL', NULL),
(7, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 0, 6, 150000, 'DAILY', 'NORMAL', NULL),
(8, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 6, 18, 90000, 'DAILY', 'NORMAL', NULL),
(9, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 18, 24, 100000, 'DAILY', 'NORMAL', NULL),
(10, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 10, 0, 6, 200000, 'WEEKEND', 'NORMAL', NULL),
(11, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 10, 6, 18, 110000, 'WEEKEND', 'NORMAL', NULL),
(12, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 10, 18, 24, 130000, 'WEEKEND', 'NORMAL', NULL),
(13, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 0, 6, 230000, 'WEEKEND', 'NORMAL', NULL),
(14, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 6, 18, 120000, 'WEEKEND', 'NORMAL', NULL),
(15, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 18, 24, 130000, 'WEEKEND', 'NORMAL', NULL),
(16, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 0, 6, 250000, 'WEEKEND', 'NORMAL', NULL),
(17, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 6, 18, 130000, 'WEEKEND', 'NORMAL', NULL),
(18, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 18, 24, 140000, 'WEEKEND', 'NORMAL', NULL),
(19, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 10, 0, 6, 220000, 'HOLIDAY', 'NORMAL', NULL),
(20, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 10, 6, 18, 130000, 'HOLIDAY', 'NORMAL', NULL),
(21, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 10, 18, 24, 170000, 'HOLIDAY', 'NORMAL', NULL),
(22, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 0, 6, 260000, 'HOLIDAY', 'NORMAL', NULL),
(23, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 6, 18, 150000, 'HOLIDAY', 'NORMAL', NULL),
(24, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 18, 24, 180000, 'HOLIDAY', 'NORMAL', NULL),
(25, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 0, 6, 280000, 'HOLIDAY', 'NORMAL', NULL),
(26, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 6, 18, 180000, 'HOLIDAY', 'NORMAL', NULL),
(27, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 18, 24, 200000, 'HOLIDAY', 'NORMAL', NULL),
(28, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 0, 6, 350000, 'DAILY', 'VIP', NULL),
(29, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 6, 18, 150000, 'DAILY', 'VIP', NULL),
(30, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 18, 24, 160000, 'DAILY', 'VIP', NULL),
(31, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 0, 6, 380000, 'DAILY', 'VIP', NULL),
(32, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 6, 18, 200000, 'DAILY', 'VIP', NULL),
(33, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 18, 24, 230000, 'DAILY', 'VIP', NULL),
(34, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 0, 6, 400000, 'WEEKEND', 'VIP', NULL),
(35, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 6, 18, 250000, 'WEEKEND', 'VIP', NULL),
(36, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 18, 24, 300000, 'WEEKEND', 'VIP', NULL),
(37, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 0, 6, 420000, 'WEEKEND', 'VIP', NULL),
(38, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 6, 18, 270000, 'WEEKEND', 'VIP', NULL),
(39, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 18, 24, 320000, 'WEEKEND', 'VIP', NULL),
(40, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 0, 6, 430000, 'HOLIDAY', 'VIP', NULL),
(41, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 6, 18, 280000, 'HOLIDAY', 'VIP', NULL),
(42, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 15, 18, 24, 340000, 'HOLIDAY', 'VIP', NULL),
(43, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 0, 6, 450000, 'HOLIDAY', 'VIP', NULL),
(44, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 6, 18, 300000, 'HOLIDAY', 'VIP', NULL),
(45, b'1', '2021-03-14 13:00:02', '2021-03-14 13:00:02', 20, 18, 24, 350000, 'HOLIDAY', 'VIP', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `active`, `created_at`, `updated_at`, `address`, `name`, `phone`) VALUES
(1, b'1', '2021-03-14 13:00:00', '2021-03-14 13:00:00', 'Atlanta, Georgia, United States', 'Coca cola', '01213551223'),
(2, b'1', '2021-03-14 13:00:00', '2021-03-14 13:00:00', 'Purchase, Harrison, New York, United States', 'Pepsi', '01213551223'),
(3, b'1', '2021-03-14 13:00:00', '2021-03-14 13:00:00', '1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè', 'Mirinda', '01213551223'),
(4, b'1', '2021-03-14 13:00:00', '2021-03-14 13:00:00', '219 Đại lộ Bình Dương, Vĩnh Phú, Thuận An, Bình Dương', 'Tân Hiệp Phát', '01213551223'),
(5, b'1', '2021-03-14 13:00:00', '2021-03-14 13:00:00', '91 Pasteur, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh', 'Công Ty Tnhh Dv Thực Phẩm & Giải Khát Việt Nam', '01213551223'),
(6, b'1', '2021-03-14 13:00:00', '2021-03-14 13:00:00', 'Way 1A, Tường Khánh Block, Ward Khánh Hậu, Tân An City, Long An Province', 'Lavie', '01213551223');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgpfluataee5ad31ijyu9jfvms` (`account_id`);

--
-- Indexes for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeolgwyayei3o80bb7rj7t207q` (`bill_id`),
  ADD KEY `FKk62ecbvksghtflfqdjhf6tl2p` (`room_id`);

--
-- Indexes for table `book_room`
--
ALTER TABLE `book_room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcdmvcv77lp7to456ssbwj1cv9` (`account_id`),
  ADD KEY `FKi31ft97goy37a70h091ybs1dd` (`room_id`);

--
-- Indexes for table `detail_product`
--
ALTER TABLE `detail_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg7kvels0ej7g5sydcaoy6e1c4` (`detail_id`),
  ADD KEY `FK4r3clcdjdmduam3kt8qh2dqnt` (`product_id`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `package_product`
--
ALTER TABLE `package_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoo06chqiiltblcvjcfbymwnip` (`packagez_id`),
  ADD KEY `FKghcigsdhgual4u6ttqlfgre3i` (`product_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `room_price`
--
ALTER TABLE `room_price`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfj3ode2586k91fceuwrtfxhqp` (`room_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bill_detail`
--
ALTER TABLE `bill_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `book_room`
--
ALTER TABLE `book_room`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `detail_product`
--
ALTER TABLE `detail_product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `package`
--
ALTER TABLE `package`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `package_product`
--
ALTER TABLE `package_product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `room_price`
--
ALTER TABLE `room_price`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
