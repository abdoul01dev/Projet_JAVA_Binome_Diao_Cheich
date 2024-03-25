-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 25 mars 2024 à 12:27
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bd-trans`
--

-- --------------------------------------------------------

--
-- Structure de la table `billet`
--

CREATE TABLE `billet` (
  `ID_Billet` bigint(20) NOT NULL,
  `titre` varchar(25) NOT NULL,
  `Prix` double NOT NULL,
  `ID_Destination` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `billet`
--

INSERT INTO `billet` (`ID_Billet`, `titre`, `Prix`, `ID_Destination`) VALUES
(7, 'Aller', 10000, 20),
(8, 'Aller-Retour', 19000, 20),
(9, 'Aller', 6000, 21),
(10, 'Aller-Retour', 11500, 21),
(11, 'Aller', 3000, 22),
(12, 'Aller-Retour', 5500, 22),
(13, 'Aller', 12000, 23),
(14, 'Aller-Retour', 23000, 23);

-- --------------------------------------------------------

--
-- Structure de la table `caisse`
--

CREATE TABLE `caisse` (
  `ID_caisse` bigint(20) NOT NULL,
  `Date` date NOT NULL,
  `justification` text NOT NULL,
  `Responsable` varchar(100) DEFAULT NULL,
  `Montant` double NOT NULL,
  `code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `caisse`
--

INSERT INTO `caisse` (`ID_caisse`, `Date`, `justification`, `Responsable`, `Montant`, `code`) VALUES
(1, '2024-03-19', 'gazoil', 'Comptable', 20000, 1),
(6, '2024-03-17', 'PA-0020', NULL, 10000, 2),
(10, '2024-03-24', 'RE-0019', NULL, 11500, 3),
(11, '2024-03-21', 'RE-0033', NULL, 19000, 3),
(12, '2024-03-21', 'RE-0026', NULL, 6000, 3),
(13, '2024-03-21', 'RE-0031', NULL, 11500, 3),
(14, '2024-03-21', 'RE-0032', NULL, 6000, 3),
(15, '2024-03-18', 'RE-0036', NULL, 19000, 3),
(16, '2024-03-15', 'PA-0001', NULL, 10000, 2),
(17, '2024-03-17', 'PA-0022', NULL, 10000, 2),
(18, '2024-03-17', 'PA-0023', NULL, 19000, 2),
(19, '2024-03-17', 'PA-0025', NULL, 10000, 2),
(20, '2024-03-17', 'PA-0034', NULL, 6000, 2),
(21, '2024-03-18', 'PA-0035', NULL, 6000, 2),
(22, '2024-03-15', 'RE-0021', NULL, 19000, 3),
(23, '2024-03-15', 'CS-0001', NULL, 2000, 4),
(24, '2024-03-23', 'CE-0014', NULL, 0, 4),
(25, '2024-03-22', 'COS-0001', NULL, 1500, 5),
(26, '2024-03-23', 'COS-0010', NULL, 1500, 5),
(27, '2024-03-19', 'Salaire du chauffeur du car n°458', NULL, 75000, 1),
(28, '2024-03-20', 'PA-0037', NULL, 3000, 2),
(29, '2024-03-20', 'jutif', NULL, 5000, 1),
(30, '2024-03-22', 'RE-0038', NULL, 3000, 3),
(31, '2024-03-20', 'lavage de car', NULL, 2000, 1),
(32, '2024-03-20', 'Netoyage', NULL, 1000, 1),
(33, '2024-03-14', 'COS-0011', NULL, 1500, 5),
(34, '2024-03-21', 'colle', 'admin', 500, 1),
(35, '2024-03-22', 'RE-0034', NULL, 12000, 3),
(36, '2024-03-21', 'PA-0040', NULL, 5500, 2),
(37, '2024-03-22', 'RE-0041', NULL, 10000, 3),
(38, '2024-03-22', 'CE-0015', NULL, 0, 4),
(39, '2024-03-21', 'PA-0042', NULL, 6000, 2),
(40, '2024-03-22', 'CS-0016', NULL, 1000, 4),
(41, '2024-03-21', 'PA-0043', NULL, 11500, 2),
(42, '2024-03-21', 'CS-0017', NULL, 1250, 4),
(43, '2024-03-21', 'carburant', 'admin', 5000, 1),
(44, '2024-03-21', 'PA-0044', NULL, 3000, 2),
(45, '2024-03-23', 'RE-0045', NULL, 3000, 3),
(46, '2024-03-23', 'RE-0046', NULL, 6000, 3),
(47, '2024-03-21', 'PA-0047', NULL, 6000, 2),
(48, '2024-03-21', 'PA-0048', NULL, 12000, 2),
(49, '2024-03-21', 'PA-0048', 'admin', 12000, 2),
(50, '2024-03-20', 'COS-0012', NULL, 1000, 5),
(51, '2024-03-22', 'PA-0049', NULL, 23000, 2),
(52, '2024-03-22', 'PA-0049', 'admin', 23000, 2),
(53, '2024-03-22', 'CS-0018', NULL, 4000, 4),
(54, '2024-03-22', 'CE-0019', NULL, 0, 4);

-- --------------------------------------------------------

--
-- Structure de la table `colis`
--

CREATE TABLE `colis` (
  `ID_Colis` bigint(20) NOT NULL,
  `Code_Cl` varchar(10) DEFAULT NULL,
  `Nom_Exp` varchar(25) DEFAULT NULL,
  `prenom_Exp` varchar(25) NOT NULL,
  `Tel_Exp` varchar(12) DEFAULT NULL,
  `Ref_Exp` varchar(50) DEFAULT NULL,
  `Nom_Dest` varchar(50) DEFAULT NULL,
  `prenom_Dest` varchar(25) NOT NULL,
  `Tel_Dest` varchar(12) DEFAULT NULL,
  `Ref_Dest` varchar(50) DEFAULT NULL,
  `Date_Recep_Cl` date DEFAULT NULL,
  `Date_envoie` date DEFAULT NULL,
  `codeES` int(1) NOT NULL,
  `ID_Destination` bigint(20) NOT NULL,
  `ID_Depart` bigint(20) NOT NULL,
  `Cout` double NOT NULL,
  `Description` text NOT NULL,
  `valeur` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `colis`
--

INSERT INTO `colis` (`ID_Colis`, `Code_Cl`, `Nom_Exp`, `prenom_Exp`, `Tel_Exp`, `Ref_Exp`, `Nom_Dest`, `prenom_Dest`, `Tel_Dest`, `Ref_Dest`, `Date_Recep_Cl`, `Date_envoie`, `codeES`, `ID_Destination`, `ID_Depart`, `Cout`, `Description`, `valeur`) VALUES
(13, 'CS-0001', 'zerbo', 'Kalil', '7896300', NULL, 'Zerbo', 'Nabo', '70235648', NULL, '2024-03-15', NULL, 1, 20, 0, 2000, 'desc', 45000),
(14, 'CE-0014', 'Zoé', 'Toé', '78965412', 'Ref_Exp', 'Zoe', 'Dav', '74102365', 'Ref_Dest', '2024-03-23', '2024-03-21', 2, 21, 0, 0, 'des', 20000),
(15, 'CE-0015', 'Hanro', 'Zakaria', '741023654', NULL, 'Hanro', 'desc', '78963201', NULL, '2024-03-22', NULL, 2, 21, 0, 0, 'desc', 10000),
(16, 'CS-0016', 'Soré', 'David', '71020304', NULL, 'Soré', 'Adama', '78231056', NULL, '2024-03-22', NULL, 1, 20, 0, 4500, 'desc', 10000),
(17, 'CS-0017', 'Zongo', 'Fati', '4563', 'Ref_Exp', 'mousa', 'yte', '54555', 'Ref_Dest', '2024-03-21', '2024-03-21', 1, 20, 0, 1250, 'ghjk', 2000),
(18, 'CS-0018', 'Barry', 'Nassourou', '70236910', NULL, 'Barry', 'Aziz', '71002233', NULL, '2024-03-22', NULL, 1, 22, 0, 4000, 'azert', 40000),
(19, 'CE-0019', 'aezrt', 'zertj', '785211256', NULL, 'azerthg', 'zezertghj', '784512350', NULL, '2024-03-22', NULL, 2, 21, 0, 0, 'cxvbn,', 7410);

-- --------------------------------------------------------

--
-- Structure de la table `couriers`
--

CREATE TABLE `couriers` (
  `ID_Courier` bigint(20) NOT NULL,
  `Nom_Exp` varchar(50) DEFAULT NULL,
  `prenom_Exp` varchar(25) NOT NULL,
  `Tel_Exp` varchar(12) DEFAULT NULL,
  `Ref_Exp` varchar(50) DEFAULT NULL,
  `Code` varchar(10) DEFAULT NULL,
  `Nom_Dest` varchar(50) DEFAULT NULL,
  `prenom_Dest` varchar(25) NOT NULL,
  `Tel_Dest` varchar(12) DEFAULT NULL,
  `Ref_Dest` varchar(50) DEFAULT NULL,
  `Date_recep` date DEFAULT NULL,
  `codeES` int(1) NOT NULL,
  `ID_Destination` bigint(20) NOT NULL,
  `ID_Depart` bigint(20) DEFAULT NULL,
  `Date_envoie` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `couriers`
--

INSERT INTO `couriers` (`ID_Courier`, `Nom_Exp`, `prenom_Exp`, `Tel_Exp`, `Ref_Exp`, `Code`, `Nom_Dest`, `prenom_Dest`, `Tel_Dest`, `Ref_Dest`, `Date_recep`, `codeES`, `ID_Destination`, `ID_Depart`, `Date_envoie`) VALUES
(9, 'Ganamé', 'Rafi', '78963200', NULL, 'COS-0001', 'Diao', 'Ali', '01020508', NULL, '2024-03-22', 1, 20, 0, NULL),
(10, 'Dablo', 'Viviane', '078888555', NULL, 'COS-0010', 'Dablo', 'Valantin', '78963210', NULL, '2024-03-23', 2, 20, 0, NULL),
(11, 'Touré', 'Malic', '78562100', NULL, 'COS-0011', 'Touré', 'Mariam', '741000333', NULL, '2024-03-14', 1, 23, 0, NULL),
(12, 'Zaré', 'Amed', '71023690', NULL, 'COS-0012', 'zaré', 'Sidi', '73690010', NULL, '2024-03-20', 1, 22, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `departs`
--

CREATE TABLE `departs` (
  `ID_Depart` bigint(20) NOT NULL,
  `Jour` char(10) DEFAULT NULL,
  `Heure` time DEFAULT NULL,
  `NbrsPlcs` int(11) NOT NULL,
  `ID_Destination` bigint(20) NOT NULL,
  `ID_ligne` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `departs`
--

INSERT INTO `departs` (`ID_Depart`, `Jour`, `Heure`, `NbrsPlcs`, `ID_Destination`, `ID_ligne`) VALUES
(9, 'Lundi', '06:00:00', 70, 20, 1),
(10, 'Lundi', '08:00:00', 70, 20, 1),
(12, 'Lundi', '07:00:00', 50, 1, 2),
(13, 'Lundi', '10:30:00', 80, 1, 2),
(14, 'Mardi', '09:00:00', 40, 1, 8),
(15, 'Mercredi', '11:00:00', 50, 1, 8);

-- --------------------------------------------------------

--
-- Structure de la table `employers`
--

CREATE TABLE `employers` (
  `ID_Emp` bigint(20) NOT NULL,
  `Nom_Emp` varchar(25) DEFAULT NULL,
  `Prenom_Emp` varchar(25) DEFAULT NULL,
  `Tel_Emp` varchar(12) DEFAULT NULL,
  `Salaire_Emp` double DEFAULT NULL,
  `id_ut` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `enoyer`
--

CREATE TABLE `enoyer` (
  `ID_Colis` bigint(20) NOT NULL,
  `ID_Destination` bigint(20) NOT NULL,
  `Date_Envoie` date DEFAULT NULL,
  `Tarif_Colis` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `expedier`
--

CREATE TABLE `expedier` (
  `ID_Courier` bigint(20) NOT NULL,
  `ID_Destination` bigint(20) NOT NULL,
  `Date_expedition` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `gerer`
--

CREATE TABLE `gerer` (
  `ID_Depart` bigint(20) NOT NULL,
  `ID_Ut` bigint(20) NOT NULL,
  `Date_Gestion` date DEFAULT NULL,
  `Heure_debut` time NOT NULL,
  `Heure_fin` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `grouputilisateurs`
--

CREATE TABLE `grouputilisateurs` (
  `ID_GU` bigint(20) NOT NULL,
  `Role_GU` varchar(25) DEFAULT NULL,
  `Description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `grouputilisateurs`
--

INSERT INTO `grouputilisateurs` (`ID_GU`, `Role_GU`, `Description`) VALUES
(1, 'Superviseur', ''),
(2, 'Caissier(e)', ''),
(8, 'Gestionnaire de colis', 'chagé de gerer les colis et les couriers\nde l\'agence');

-- --------------------------------------------------------

--
-- Structure de la table `ligne`
--

CREATE TABLE `ligne` (
  `ID_ligne` bigint(20) NOT NULL,
  `nomLingne` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `ligne`
--

INSERT INTO `ligne` (`ID_ligne`, `nomLingne`) VALUES
(1, 'Ouaga-Bobo'),
(2, 'Ouaga-Fada'),
(8, 'Ouaga-Dori');

-- --------------------------------------------------------

--
-- Structure de la table `passagers`
--

CREATE TABLE `passagers` (
  `ID_Passager` bigint(20) NOT NULL,
  `Code_Passager` varchar(20) NOT NULL,
  `Nom_Passager` varchar(50) DEFAULT NULL,
  `prenom_Passager` varchar(25) NOT NULL,
  `Tel_Passager` varchar(12) DEFAULT NULL,
  `Age_Passager` int(11) DEFAULT NULL,
  `Sexe_Passager` varchar(10) DEFAULT NULL,
  `Date_voy` date NOT NULL,
  `ID_billet` bigint(20) NOT NULL,
  `Type_Passager` int(11) NOT NULL,
  `cout` double DEFAULT NULL,
  `ID_Destination` bigint(11) NOT NULL,
  `ID_Depart` bigint(20) NOT NULL,
  `etat` int(11) DEFAULT NULL,
  `Date_enreg` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `passagers`
--

INSERT INTO `passagers` (`ID_Passager`, `Code_Passager`, `Nom_Passager`, `prenom_Passager`, `Tel_Passager`, `Age_Passager`, `Sexe_Passager`, `Date_voy`, `ID_billet`, `Type_Passager`, `cout`, `ID_Destination`, `ID_Depart`, `etat`, `Date_enreg`) VALUES
(18, 'PA-0001', 'Diao', 'Abdoul', '70102030', 0, NULL, '2024-03-15', 7, 1, NULL, 20, 9, 1, '2024-03-15'),
(19, 'RE-0019', 'Sondé', 'Abdoulaye', '75010203', 0, NULL, '2024-03-24', 10, 2, 11500, 20, 10, 1, '2024-03-15'),
(20, 'PA-0020', 'Somda', 'Zalisa', '78030256', 0, NULL, '2024-03-17', 7, 1, NULL, 20, 10, 1, '2024-03-17'),
(21, 'RE-0021', 'Zongo', 'Farida', '70003312', 0, NULL, '2024-03-15', 8, 2, NULL, 20, 9, 1, '2024-03-17'),
(22, 'PA-0022', 'Diallo', 'Seydou', '78102030', 0, NULL, '2024-03-17', 7, 1, NULL, 20, 9, 1, '2024-03-17'),
(23, 'PA-0023', 'Bére', 'Cédric', '78010306', 0, NULL, '2024-03-17', 8, 1, NULL, 20, 9, 1, '2024-03-17'),
(25, 'PA-0025', 'Congo', 'Abi', '78020301', 0, NULL, '2024-03-17', 7, 1, NULL, 20, 9, 1, '2024-03-17'),
(33, 'RE-0033', 'Kaboré', 'Fati', '70203050', 0, NULL, '2024-03-21', 8, 2, 19000, 20, 10, 1, '2024-03-17'),
(39, 'RE-0034', 'Gambré', 'Luc', '78854002', 0, NULL, '2024-03-22', 13, 2, 2400, 23, 14, 3, '2024-03-21'),
(41, 'RE-0041', 'Combré', 'Ablaye', '789332100', 0, NULL, '2024-03-22', 7, 2, 10000, 20, 9, 1, '2024-03-21'),
(42, 'PA-0042', 'Traoré', 'Ali', '74523001', 0, NULL, '2024-03-21', 9, 1, NULL, 21, 12, 1, '2024-03-21'),
(43, 'PA-0043', 'Toé', 'Ali', '7894546', 0, NULL, '2024-03-21', 10, 1, NULL, 21, 12, 1, '2024-03-21'),
(44, 'PA-0044', 'rtt', 'gj', '45', 0, NULL, '2024-03-21', 11, 1, NULL, 22, 12, 1, '2024-03-21'),
(45, 'RE-0045', 'Ouédraogo', 'Salou', '74102360', 0, NULL, '2024-03-23', 11, 2, 3000, 22, 13, 1, '2024-03-21'),
(46, 'RE-0046', 'Ilboudo', 'Awa', '1020506', 0, NULL, '2024-03-23', 9, 2, 6000, 21, 12, 1, '2024-03-21'),
(47, 'PA-0047', 'Tankoano', 'Paul', '7089632', 0, NULL, '2024-03-21', 9, 1, NULL, 21, 13, 1, '2024-03-21'),
(48, 'PA-0048', 'Passager', 'Voyageur', '', 0, NULL, '2024-03-21', 13, 1, NULL, 23, 14, 1, '2024-03-21'),
(49, 'PA-0049', 'Barry', 'Daouda', '', 0, NULL, '2024-03-22', 14, 1, NULL, 23, 14, 1, '2024-03-22');

-- --------------------------------------------------------

--
-- Structure de la table `recu`
--

CREATE TABLE `recu` (
  `id` bigint(20) NOT NULL,
  `prix` double NOT NULL,
  `ID_Destination` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `recu`
--

INSERT INTO `recu` (`id`, `prix`, `ID_Destination`) VALUES
(3, 1500, 20),
(4, 1000, 21),
(5, 1000, 22),
(7, 1500, 23);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `ID_client` bigint(20) NOT NULL,
  `Nom_client` varchar(25) DEFAULT NULL,
  `prenom_client` varchar(25) DEFAULT NULL,
  `age_client` int(11) DEFAULT NULL,
  `sexe_client` varchar(25) DEFAULT NULL,
  `tel_client` varchar(12) DEFAULT NULL,
  `cout` double NOT NULL,
  `date_voyage` date DEFAULT NULL,
  `etat` int(1) DEFAULT NULL,
  `ID_Destination` bigint(20) DEFAULT NULL,
  `ID_Depart` bigint(20) DEFAULT NULL,
  `ID_Billet` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `ID_Ut` bigint(20) NOT NULL,
  `Nom_Ut` varchar(25) DEFAULT NULL,
  `Mail_Ut` varchar(50) DEFAULT NULL,
  `MotPass_Ut` varchar(100) DEFAULT NULL,
  `statut` int(11) DEFAULT NULL,
  `Date_Creer` date DEFAULT NULL,
  `ID_GU` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`ID_Ut`, `Nom_Ut`, `Mail_Ut`, `MotPass_Ut`, `statut`, `Date_Creer`, `ID_GU`) VALUES
(4, 'Comptable', 'diao@gmail.com', '9af15b336e6a9619928537df30b2e6a2376569fcf9d7e773eccede65606529a0', 1, '2024-01-02', 1),
(19, 'admin', 'admin@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 1, '2024-03-02', 1),
(26, 'Gerant', 'gerant@gmail.com', '41c991eb6a66242c0454191244278183ce58cf4a6bcd372f799e4b9cc01886af', 1, '2024-03-21', 8);

-- --------------------------------------------------------

--
-- Structure de la table `villledestinations`
--

CREATE TABLE `villledestinations` (
  `ID_Destination` bigint(20) NOT NULL,
  `Nom_Destination` varchar(30) DEFAULT NULL,
  `Distance` double DEFAULT NULL,
  `ID_ligne` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `villledestinations`
--

INSERT INTO `villledestinations` (`ID_Destination`, `Nom_Destination`, `Distance`, `ID_ligne`) VALUES
(20, 'Bobo', 4500, 1),
(21, 'Fada', 220, 2),
(22, 'Koupéla', 140, 2),
(23, 'Dori', 350, 8);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `billet`
--
ALTER TABLE `billet`
  ADD PRIMARY KEY (`ID_Billet`),
  ADD KEY `ID_Destination` (`ID_Destination`);

--
-- Index pour la table `caisse`
--
ALTER TABLE `caisse`
  ADD PRIMARY KEY (`ID_caisse`);

--
-- Index pour la table `colis`
--
ALTER TABLE `colis`
  ADD PRIMARY KEY (`ID_Colis`),
  ADD KEY `colis_ibfk_2` (`ID_Destination`);

--
-- Index pour la table `couriers`
--
ALTER TABLE `couriers`
  ADD PRIMARY KEY (`ID_Courier`),
  ADD KEY `ID_Destination` (`ID_Destination`);

--
-- Index pour la table `departs`
--
ALTER TABLE `departs`
  ADD PRIMARY KEY (`ID_Depart`),
  ADD KEY `ID_ligne` (`ID_ligne`);

--
-- Index pour la table `employers`
--
ALTER TABLE `employers`
  ADD PRIMARY KEY (`ID_Emp`),
  ADD KEY `FK_Employers_utilisateurs_id_ut` (`id_ut`);

--
-- Index pour la table `enoyer`
--
ALTER TABLE `enoyer`
  ADD PRIMARY KEY (`ID_Colis`,`ID_Destination`),
  ADD KEY `FK_Enoyer_ID_Destination` (`ID_Destination`);

--
-- Index pour la table `expedier`
--
ALTER TABLE `expedier`
  ADD PRIMARY KEY (`ID_Courier`,`ID_Destination`),
  ADD KEY `FK_Expedier_ID_Destination` (`ID_Destination`);

--
-- Index pour la table `gerer`
--
ALTER TABLE `gerer`
  ADD PRIMARY KEY (`ID_Depart`,`ID_Ut`),
  ADD KEY `FK_Gerer_ID_Ut` (`ID_Ut`);

--
-- Index pour la table `grouputilisateurs`
--
ALTER TABLE `grouputilisateurs`
  ADD PRIMARY KEY (`ID_GU`);

--
-- Index pour la table `ligne`
--
ALTER TABLE `ligne`
  ADD PRIMARY KEY (`ID_ligne`);

--
-- Index pour la table `passagers`
--
ALTER TABLE `passagers`
  ADD PRIMARY KEY (`ID_Passager`),
  ADD KEY `ID_Destination` (`ID_Destination`),
  ADD KEY `ID_Depart` (`ID_Depart`),
  ADD KEY `ID_billet` (`ID_billet`);

--
-- Index pour la table `recu`
--
ALTER TABLE `recu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ID_Destination` (`ID_Destination`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`ID_Ut`);

--
-- Index pour la table `villledestinations`
--
ALTER TABLE `villledestinations`
  ADD PRIMARY KEY (`ID_Destination`),
  ADD KEY `ID_ligne` (`ID_ligne`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `billet`
--
ALTER TABLE `billet`
  MODIFY `ID_Billet` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `caisse`
--
ALTER TABLE `caisse`
  MODIFY `ID_caisse` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT pour la table `colis`
--
ALTER TABLE `colis`
  MODIFY `ID_Colis` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `couriers`
--
ALTER TABLE `couriers`
  MODIFY `ID_Courier` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `departs`
--
ALTER TABLE `departs`
  MODIFY `ID_Depart` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `employers`
--
ALTER TABLE `employers`
  MODIFY `ID_Emp` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `grouputilisateurs`
--
ALTER TABLE `grouputilisateurs`
  MODIFY `ID_GU` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `ligne`
--
ALTER TABLE `ligne`
  MODIFY `ID_ligne` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `passagers`
--
ALTER TABLE `passagers`
  MODIFY `ID_Passager` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT pour la table `recu`
--
ALTER TABLE `recu`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `ID_Ut` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT pour la table `villledestinations`
--
ALTER TABLE `villledestinations`
  MODIFY `ID_Destination` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `billet`
--
ALTER TABLE `billet`
  ADD CONSTRAINT `billet_ibfk_1` FOREIGN KEY (`ID_Destination`) REFERENCES `villledestinations` (`ID_Destination`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `colis`
--
ALTER TABLE `colis`
  ADD CONSTRAINT `colis_ibfk_2` FOREIGN KEY (`ID_Destination`) REFERENCES `villledestinations` (`ID_Destination`);

--
-- Contraintes pour la table `couriers`
--
ALTER TABLE `couriers`
  ADD CONSTRAINT `couriers_ibfk_1` FOREIGN KEY (`ID_Destination`) REFERENCES `villledestinations` (`ID_Destination`);

--
-- Contraintes pour la table `departs`
--
ALTER TABLE `departs`
  ADD CONSTRAINT `departs_ibfk_3` FOREIGN KEY (`ID_ligne`) REFERENCES `ligne` (`ID_ligne`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `employers`
--
ALTER TABLE `employers`
  ADD CONSTRAINT `FK_Employers_utilisateurs_id_ut` FOREIGN KEY (`id_ut`) REFERENCES `utilisateurs` (`ID_Ut`);

--
-- Contraintes pour la table `enoyer`
--
ALTER TABLE `enoyer`
  ADD CONSTRAINT `FK_Enoyer_ID_Colis` FOREIGN KEY (`ID_Colis`) REFERENCES `colis` (`ID_Colis`),
  ADD CONSTRAINT `FK_Enoyer_ID_Destination` FOREIGN KEY (`ID_Destination`) REFERENCES `villledestinations` (`ID_Destination`);

--
-- Contraintes pour la table `expedier`
--
ALTER TABLE `expedier`
  ADD CONSTRAINT `FK_Expedier_ID_Courier` FOREIGN KEY (`ID_Courier`) REFERENCES `couriers` (`ID_Courier`),
  ADD CONSTRAINT `FK_Expedier_ID_Destination` FOREIGN KEY (`ID_Destination`) REFERENCES `villledestinations` (`ID_Destination`);

--
-- Contraintes pour la table `gerer`
--
ALTER TABLE `gerer`
  ADD CONSTRAINT `FK_Gerer_ID_Depart` FOREIGN KEY (`ID_Depart`) REFERENCES `departs` (`ID_Depart`),
  ADD CONSTRAINT `FK_Gerer_ID_Ut` FOREIGN KEY (`ID_Ut`) REFERENCES `utilisateurs` (`ID_Ut`);

--
-- Contraintes pour la table `passagers`
--
ALTER TABLE `passagers`
  ADD CONSTRAINT `passagers_ibfk_1` FOREIGN KEY (`ID_Destination`) REFERENCES `villledestinations` (`ID_Destination`),
  ADD CONSTRAINT `passagers_ibfk_2` FOREIGN KEY (`ID_Depart`) REFERENCES `departs` (`ID_Depart`),
  ADD CONSTRAINT `passagers_ibfk_3` FOREIGN KEY (`ID_billet`) REFERENCES `billet` (`ID_Billet`);

--
-- Contraintes pour la table `recu`
--
ALTER TABLE `recu`
  ADD CONSTRAINT `recu_ibfk_1` FOREIGN KEY (`ID_Destination`) REFERENCES `villledestinations` (`ID_Destination`);

--
-- Contraintes pour la table `villledestinations`
--
ALTER TABLE `villledestinations`
  ADD CONSTRAINT `villledestinations_ibfk_1` FOREIGN KEY (`ID_ligne`) REFERENCES `ligne` (`ID_ligne`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
