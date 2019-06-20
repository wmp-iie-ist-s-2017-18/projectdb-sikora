-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 21 Cze 2019, 00:31
-- Wersja serwera: 10.1.36-MariaDB
-- Wersja PHP: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `database`
--

DELIMITER $$
--
-- Procedury
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStates` ()  MODIFIES SQL DATA
BEGIN
DECLARE x int DEFAULT 0;
DECLARE y int DEFAULT 0;
SET x = (SELECT MAX(project.project_ID) From project);
WHILE x >= y DO
UPDATE `project` SET `state`=stateCheck(y) WHERE project.project_ID =y;
SET y = y + 1;
END WHILE;
END$$

--
-- Funkcje
--
CREATE DEFINER=`root`@`localhost` FUNCTION `stateCheck` (`ID_Project` INT) RETURNS VARCHAR(20) CHARSET utf16 COLLATE utf16_polish_ci READS SQL DATA
BEGIN

RETURN IF(DATE(now())>(SELECT finish FROM project Where project.project_ID = ID_Project), "Closed", "Active");
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `company`
--

CREATE TABLE `company` (
  `company_ID` int(11) NOT NULL,
  `company_name` varchar(1000) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `company`
--

INSERT INTO `company` (`company_ID`, `company_name`) VALUES
(1, 'Project Manager');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `company_informations`
--

CREATE TABLE `company_informations` (
  `company_ID` int(11) NOT NULL,
  `company_message` mediumtext COLLATE utf16_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `employee`
--

CREATE TABLE `employee` (
  `employee_ID` int(11) NOT NULL,
  `first_Name` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `last_Name` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `login` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(125) COLLATE utf8_polish_ci NOT NULL,
  `position` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `employee`
--

INSERT INTO `employee` (`employee_ID`, `first_Name`, `last_Name`, `login`, `email`, `password`, `position`) VALUES
(1, 'Karol', 'Sikora', 'kkaarrol', 'asdf@gmail.com', 'dupa123', 'CEO'),
(2, 'David', 'Nienajadło', 'david123', 'asew@gmail.com', 'dupa123', 'VP'),
(3, 'Adam', 'Krówka', 'adam12', 'adam@gmail.com', 'dupa123', 'VP'),
(4, 'Szwagier', 'Kolaska', 'qwed', 'zxc@wp.pl', 'dupa123', 'MIS'),
(7, 'Aqws', 'Zxcc', 'testowy1', 'kkaarrol@gmail.com', '$2y$10$28EuDluzT9qsww4oAvnyjuX0eyX6wz51Cenp5oGGjtd8Yh3AKzqUG', 'intern'),
(8, 'FBFB', 'DFs', 'testowy2', 'test@op.pl', '$2y$10$L/gS1I6HEt58pxzD8bZqO.sZnnEcUwnpAD2jcoIZDQ.DbTgxvOHrK', ''),
(9, 'SSDdV', 'Fvbn', 'boss123', 'tescik@wp.pl', '$2y$10$rKINaNxDOq0tYuJtav0MwuR0Hy8VJ9ZVk3sj7ylf.6uAzNrg27uSi', ''),
(10, 'sad', 'sadad', 'asda', 'asdsd', 'asd123', 'mis'),
(11, 'John', 'Wick', 'admin', 'admin@gmail.com', 'asdf1234', 'admin');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `project`
--

CREATE TABLE `project` (
  `project_ID` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_polish_ci NOT NULL,
  `state` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `start` date NOT NULL,
  `finish` date NOT NULL,
  `team_ID` int(11) NOT NULL,
  `description` mediumtext COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `project`
--

INSERT INTO `project` (`project_ID`, `name`, `state`, `start`, `finish`, `team_ID`, `description`) VALUES
(1, 'Testowy', 'sdfsf', '2019-03-03', '2019-03-24', 1, 'afsfefsfsfdf'),
(2, 'Pierwszy', 'pending', '2019-04-07', '2019-04-29', 2, 'grddfgdfgfdgd'),
(5, 'Drugi', 'pending', '2019-04-07', '2019-04-29', 2, 'grddfgdfgfdgd');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `team`
--

CREATE TABLE `team` (
  `team_ID` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `leader_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `team`
--

INSERT INTO `team` (`team_ID`, `name`, `leader_ID`) VALUES
(1, 'Asy', 1),
(2, 'Basy', 2),
(3, 'TKO', 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `team_employee`
--

CREATE TABLE `team_employee` (
  `employee_ID` int(11) NOT NULL,
  `team_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `team_employee`
--

INSERT INTO `team_employee` (`employee_ID`, `team_ID`) VALUES
(1, 1),
(2, 2),
(7, 2);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_ID`),
  ADD KEY `employee_ID` (`employee_ID`) USING BTREE;

--
-- Indeksy dla tabeli `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`project_ID`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `team_ID` (`team_ID`),
  ADD KEY `project_ID` (`project_ID`,`name`);

--
-- Indeksy dla tabeli `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`team_ID`),
  ADD KEY `leader_ID` (`leader_ID`);

--
-- Indeksy dla tabeli `team_employee`
--
ALTER TABLE `team_employee`
  ADD KEY `team_ID` (`team_ID`),
  ADD KEY `employee_ID` (`employee_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `project`
--
ALTER TABLE `project`
  MODIFY `project_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `team`
--
ALTER TABLE `team`
  MODIFY `team_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`team_ID`) REFERENCES `team` (`team_ID`) ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `team_ibfk_1` FOREIGN KEY (`leader_ID`) REFERENCES `employee` (`employee_ID`) ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `team_employee`
--
ALTER TABLE `team_employee`
  ADD CONSTRAINT `team_employee_ibfk_1` FOREIGN KEY (`team_ID`) REFERENCES `team` (`team_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `team_employee_ibfk_2` FOREIGN KEY (`employee_ID`) REFERENCES `employee` (`employee_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
