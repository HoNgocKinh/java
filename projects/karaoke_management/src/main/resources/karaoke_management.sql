-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 17, 2021 lúc 09:28 AM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `karaoke_management`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
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
-- Cấu trúc bảng cho bảng `bill_detail`
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
-- Cấu trúc bảng cho bảng `book_room`
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
-- Cấu trúc bảng cho bảng `detail_product`
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
-- Cấu trúc bảng cho bảng `package`
--

CREATE TABLE `package` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `exp_at` datetime DEFAULT NULL,
  `package_code` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `package_product`
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
-- Cấu trúc bảng cho bảng `product`
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
-- Cấu trúc bảng cho bảng `room`
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
  `staff_open_room` tinyblob,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `room`
--

INSERT INTO `room` (`id`, `active`, `created_at`, `updated_at`, `capacity`, `check_in`, `customer_phone`, `floor`, `name`, `staff_open_room`, `status`, `type`) VALUES
(1, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 1, 'F000', NULL, 'EMPTY', 'NORMAL'),
(2, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 1, 'F001', NULL, 'EMPTY', 'NORMAL'),
(3, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 1, 'F002', NULL, 'EMPTY', 'NORMAL'),
(4, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 1, 'F003', NULL, 'EMPTY', 'NORMAL'),
(5, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, NULL, 'EMPTY', 1, 'F004', NULL, 'EMPTY', 'NORMAL'),
(6, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 1, 'F005', NULL, 'EMPTY', 'NORMAL'),
(7, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, NULL, 'EMPTY', 1, 'F006', NULL, 'EMPTY', 'VIP'),
(8, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, NULL, 'EMPTY', 1, 'F007', NULL, 'EMPTY', 'VIP'),
(9, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 1, 'F008', NULL, 'EMPTY', 'VIP'),
(10, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 1, 'F009', NULL, 'EMPTY', 'VIP'),
(11, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 2, 'F010', NULL, 'EMPTY', 'NORMAL'),
(12, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 2, 'F011', NULL, 'EMPTY', 'NORMAL'),
(13, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 2, 'F012', NULL, 'EMPTY', 'NORMAL'),
(14, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 2, 'F013', NULL, 'EMPTY', 'NORMAL'),
(15, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, NULL, 'EMPTY', 2, 'F014', NULL, 'EMPTY', 'NORMAL'),
(16, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 2, 'F015', NULL, 'EMPTY', 'NORMAL'),
(17, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, NULL, 'EMPTY', 2, 'F016', NULL, 'EMPTY', 'VIP'),
(18, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, NULL, 'EMPTY', 2, 'F017', NULL, 'EMPTY', 'VIP'),
(19, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 2, 'F018', NULL, 'EMPTY', 'VIP'),
(20, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 2, 'F019', NULL, 'EMPTY', 'VIP'),
(21, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 3, 'F020', NULL, 'EMPTY', 'NORMAL'),
(22, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 3, 'F021', NULL, 'EMPTY', 'NORMAL'),
(23, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, NULL, 'EMPTY', 3, 'F022', NULL, 'EMPTY', 'NORMAL'),
(24, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, NULL, 'EMPTY', 3, 'F023', NULL, 'EMPTY', 'NORMAL'),
(25, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 3, 'F024', NULL, 'EMPTY', 'NORMAL'),
(26, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 3, 'F025', NULL, 'EMPTY', 'NORMAL'),
(27, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, NULL, 'EMPTY', 3, 'F026', NULL, 'EMPTY', 'VIP'),
(28, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, NULL, 'EMPTY', 3, 'F027', NULL, 'EMPTY', 'VIP'),
(29, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 3, 'F028', NULL, 'EMPTY', 'VIP'),
(30, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, NULL, 'EMPTY', 3, 'F029', NULL, 'EMPTY', 'VIP');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room_price`
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
  `type_room` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `room_price`
--

INSERT INTO `room_price` (`id`, `active`, `created_at`, `updated_at`, `capacity`, `check_in`, `check_out`, `price`, `type_day`, `type_room`) VALUES
(1, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, 0, 6, 100000, 'DAILY', 'NORMAL'),
(2, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, 6, 18, 70000, 'DAILY', 'NORMAL'),
(3, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, 18, 24, 80000, 'DAILY', 'NORMAL'),
(4, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 0, 6, 130000, 'DAILY', 'NORMAL'),
(5, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 6, 18, 80000, 'DAILY', 'NORMAL'),
(6, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 18, 24, 90000, 'DAILY', 'NORMAL'),
(7, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 0, 6, 150000, 'DAILY', 'NORMAL'),
(8, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 6, 18, 90000, 'DAILY', 'NORMAL'),
(9, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 18, 24, 100000, 'DAILY', 'NORMAL'),
(10, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, 0, 6, 200000, 'WEEKEND', 'NORMAL'),
(11, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, 6, 18, 110000, 'WEEKEND', 'NORMAL'),
(12, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, 18, 24, 130000, 'WEEKEND', 'NORMAL'),
(13, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 0, 6, 230000, 'WEEKEND', 'NORMAL'),
(14, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 6, 18, 120000, 'WEEKEND', 'NORMAL'),
(15, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 18, 24, 130000, 'WEEKEND', 'NORMAL'),
(16, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 0, 6, 250000, 'WEEKEND', 'NORMAL'),
(17, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 6, 18, 130000, 'WEEKEND', 'NORMAL'),
(18, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 18, 24, 140000, 'WEEKEND', 'NORMAL'),
(19, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, 0, 6, 220000, 'HOLIDAY', 'NORMAL'),
(20, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, 6, 18, 130000, 'HOLIDAY', 'NORMAL'),
(21, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 10, 18, 24, 170000, 'HOLIDAY', 'NORMAL'),
(22, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 0, 6, 260000, 'HOLIDAY', 'NORMAL'),
(23, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 6, 18, 150000, 'HOLIDAY', 'NORMAL'),
(24, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 18, 24, 180000, 'HOLIDAY', 'NORMAL'),
(25, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 0, 6, 280000, 'HOLIDAY', 'NORMAL'),
(26, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 6, 18, 180000, 'HOLIDAY', 'NORMAL'),
(27, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 18, 24, 200000, 'HOLIDAY', 'NORMAL'),
(28, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 0, 6, 350000, 'DAILY', 'VIP'),
(29, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 6, 18, 150000, 'DAILY', 'VIP'),
(30, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 18, 24, 160000, 'DAILY', 'VIP'),
(31, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 0, 6, 380000, 'DAILY', 'VIP'),
(32, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 6, 18, 200000, 'DAILY', 'VIP'),
(33, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 18, 24, 230000, 'DAILY', 'VIP'),
(34, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 0, 6, 400000, 'WEEKEND', 'VIP'),
(35, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 6, 18, 250000, 'WEEKEND', 'VIP'),
(36, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 18, 24, 300000, 'WEEKEND', 'VIP'),
(37, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 0, 6, 420000, 'WEEKEND', 'VIP'),
(38, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 6, 18, 270000, 'WEEKEND', 'VIP'),
(39, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 18, 24, 320000, 'WEEKEND', 'VIP'),
(40, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 0, 6, 430000, 'HOLIDAY', 'VIP'),
(41, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 6, 18, 280000, 'HOLIDAY', 'VIP'),
(42, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 15, 18, 24, 340000, 'HOLIDAY', 'VIP'),
(43, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 0, 6, 450000, 'HOLIDAY', 'VIP'),
(44, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 6, 18, 300000, 'HOLIDAY', 'VIP'),
(45, b'1', '2021-03-17 08:26:25', '2021-03-17 08:26:25', 20, 18, 24, 350000, 'HOLIDAY', 'VIP');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room_room_price`
--

CREATE TABLE `room_room_price` (
  `room_id` bigint(20) NOT NULL,
  `room_price_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `room_room_price`
--

INSERT INTO `room_room_price` (`room_id`, `room_price_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 10),
(1, 11),
(1, 12),
(1, 19),
(1, 20),
(1, 21),
(2, 1),
(2, 2),
(2, 3),
(2, 10),
(2, 11),
(2, 12),
(2, 19),
(2, 20),
(2, 21),
(3, 1),
(3, 2),
(3, 3),
(3, 10),
(3, 11),
(3, 12),
(3, 19),
(3, 20),
(3, 21),
(4, 1),
(4, 2),
(4, 3),
(4, 10),
(4, 11),
(4, 12),
(4, 19),
(4, 20),
(4, 21),
(5, 4),
(5, 5),
(5, 6),
(5, 13),
(5, 14),
(5, 15),
(5, 22),
(5, 23),
(5, 24),
(6, 7),
(6, 8),
(6, 9),
(6, 16),
(6, 17),
(6, 18),
(6, 25),
(6, 26),
(6, 27),
(7, 28),
(7, 29),
(7, 30),
(7, 34),
(7, 35),
(7, 36),
(7, 40),
(7, 41),
(7, 42),
(8, 28),
(8, 29),
(8, 30),
(8, 34),
(8, 35),
(8, 36),
(8, 40),
(8, 41),
(8, 42),
(9, 31),
(9, 32),
(9, 33),
(9, 37),
(9, 38),
(9, 39),
(9, 43),
(9, 44),
(9, 45),
(10, 31),
(10, 32),
(10, 33),
(10, 37),
(10, 38),
(10, 39),
(10, 43),
(10, 44),
(10, 45),
(11, 1),
(11, 2),
(11, 3),
(11, 10),
(11, 11),
(11, 12),
(11, 19),
(11, 20),
(11, 21),
(12, 1),
(12, 2),
(12, 3),
(12, 10),
(12, 11),
(12, 12),
(12, 19),
(12, 20),
(12, 21),
(13, 1),
(13, 2),
(13, 3),
(13, 10),
(13, 11),
(13, 12),
(13, 19),
(13, 20),
(13, 21),
(14, 1),
(14, 2),
(14, 3),
(14, 10),
(14, 11),
(14, 12),
(14, 19),
(14, 20),
(14, 21),
(15, 4),
(15, 5),
(15, 6),
(15, 13),
(15, 14),
(15, 15),
(15, 22),
(15, 23),
(15, 24),
(16, 7),
(16, 8),
(16, 9),
(16, 16),
(16, 17),
(16, 18),
(16, 25),
(16, 26),
(16, 27),
(17, 28),
(17, 29),
(17, 30),
(17, 34),
(17, 35),
(17, 36),
(17, 40),
(17, 41),
(17, 42),
(18, 28),
(18, 29),
(18, 30),
(18, 34),
(18, 35),
(18, 36),
(18, 40),
(18, 41),
(18, 42),
(19, 31),
(19, 32),
(19, 33),
(19, 37),
(19, 38),
(19, 39),
(19, 43),
(19, 44),
(19, 45),
(20, 31),
(20, 32),
(20, 33),
(20, 37),
(20, 38),
(20, 39),
(20, 43),
(20, 44),
(20, 45),
(21, 1),
(21, 2),
(21, 3),
(21, 10),
(21, 11),
(21, 12),
(21, 19),
(21, 20),
(21, 21),
(22, 1),
(22, 2),
(22, 3),
(22, 10),
(22, 11),
(22, 12),
(22, 19),
(22, 20),
(22, 21),
(23, 1),
(23, 2),
(23, 3),
(23, 10),
(23, 11),
(23, 12),
(23, 19),
(23, 20),
(23, 21),
(24, 4),
(24, 5),
(24, 6),
(24, 13),
(24, 14),
(24, 15),
(24, 22),
(24, 23),
(24, 24),
(25, 7),
(25, 8),
(25, 9),
(25, 16),
(25, 17),
(25, 18),
(25, 25),
(25, 26),
(25, 27),
(26, 7),
(26, 8),
(26, 9),
(26, 16),
(26, 17),
(26, 18),
(26, 25),
(26, 26),
(26, 27),
(27, 28),
(27, 29),
(27, 30),
(27, 34),
(27, 35),
(27, 36),
(27, 40),
(27, 41),
(27, 42),
(28, 28),
(28, 29),
(28, 30),
(28, 34),
(28, 35),
(28, 36),
(28, 40),
(28, 41),
(28, 42),
(29, 31),
(29, 32),
(29, 33),
(29, 37),
(29, 38),
(29, 39),
(29, 43),
(29, 44),
(29, 45),
(30, 31),
(30, 32),
(30, 33),
(30, 37),
(30, 38),
(30, 39),
(30, 43),
(30, 44),
(30, 45);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
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
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`id`, `active`, `created_at`, `updated_at`, `address`, `name`, `phone`) VALUES
(1, b'1', '2021-03-17 08:26:15', '2021-03-17 08:26:15', 'Atlanta, Georgia, United States', 'Coca cola', '01213551223'),
(2, b'1', '2021-03-17 08:26:15', '2021-03-17 08:26:15', 'Purchase, Harrison, New York, United States', 'Pepsi', '01213551223'),
(3, b'1', '2021-03-17 08:26:15', '2021-03-17 08:26:15', '1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè', 'Mirinda', '01213551223'),
(4, b'1', '2021-03-17 08:26:15', '2021-03-17 08:26:15', '219 Đại lộ Bình Dương, Vĩnh Phú, Thuận An, Bình Dương', 'Tân Hiệp Phát', '01213551223'),
(5, b'1', '2021-03-17 08:26:15', '2021-03-17 08:26:15', '91 Pasteur, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh', 'Công Ty Tnhh Dv Thực Phẩm & Giải Khát Việt Nam', '01213551223'),
(6, b'1', '2021-03-17 08:26:15', '2021-03-17 08:26:15', 'Way 1A, Tường Khánh Block, Ward Khánh Hậu, Tân An City, Long An Province', 'Lavie', '01213551223');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgpfluataee5ad31ijyu9jfvms` (`account_id`);

--
-- Chỉ mục cho bảng `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeolgwyayei3o80bb7rj7t207q` (`bill_id`),
  ADD KEY `FKk62ecbvksghtflfqdjhf6tl2p` (`room_id`);

--
-- Chỉ mục cho bảng `book_room`
--
ALTER TABLE `book_room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcdmvcv77lp7to456ssbwj1cv9` (`account_id`),
  ADD KEY `FKi31ft97goy37a70h091ybs1dd` (`room_id`);

--
-- Chỉ mục cho bảng `detail_product`
--
ALTER TABLE `detail_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg7kvels0ej7g5sydcaoy6e1c4` (`detail_id`),
  ADD KEY `FK4r3clcdjdmduam3kt8qh2dqnt` (`product_id`);

--
-- Chỉ mục cho bảng `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `package_product`
--
ALTER TABLE `package_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoo06chqiiltblcvjcfbymwnip` (`packagez_id`),
  ADD KEY `FKghcigsdhgual4u6ttqlfgre3i` (`product_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `room_price`
--
ALTER TABLE `room_price`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `room_room_price`
--
ALTER TABLE `room_room_price`
  ADD KEY `FKmumkwvbyn05mwyievb2k7ggvu` (`room_price_id`),
  ADD KEY `FKc19mt1qlxgmwf5015c7m7sbk0` (`room_id`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `bill_detail`
--
ALTER TABLE `bill_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `book_room`
--
ALTER TABLE `book_room`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `detail_product`
--
ALTER TABLE `detail_product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `package`
--
ALTER TABLE `package`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `package_product`
--
ALTER TABLE `package_product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `room`
--
ALTER TABLE `room`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `room_price`
--
ALTER TABLE `room_price`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT cho bảng `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
