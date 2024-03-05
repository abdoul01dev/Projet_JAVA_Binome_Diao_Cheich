-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 05 mars 2024 à 12:33
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
(1, 'Aller', 10000, 1),
(2, 'Aller-Retour', 19000, 1);

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
(1, 'CLS-0001', 'Son', 'Aboubacar', '70020304', NULL, 'Sana', 'Abel', '70022336', NULL, '2024-02-09', NULL, 1, 2, 0, 8000, 'description', 1000000),
(2, 'CLE-0002', 'Diao', 'Abdoul', '01020304', 'B-00223366', 'Diallo', 'Diamila', '78010203', 'B-96321045', '2024-02-07', '2024-02-15', 2, 4, 3, 6000, 'Desc', 1002000),
(6, 'CS-0003', 'azert', 'ertyuikj', '71256650', NULL, 'zertghjk', 'dtfyguhkjl', '102336', NULL, '2024-02-24', NULL, 1, 4, 0, 8785, 'a\"z\'retfhgjhk', 7000),
(10, 'CS-0007', 'xffcvgbn', 'vbnbn,', '985624', NULL, 'qsdf', 'zqesrd', '1242', NULL, '2024-02-29', NULL, 1, 8, 0, 500, 'zqsdf', 556);

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
(1, 'Son', 'Aboubacar', '70020304', 'B-00112233', 'CRS-0001', 'San', 'Abel', '70022336', 'B-00112200', '2024-02-24', 1, 2, 0, '2024-02-15'),
(2, 'Sondé', 'Abou', '70020344', 'B-00116622', 'CRE-0002', 'Sana', 'Abi', '70022300', 'B-0011223', '2024-02-21', 2, 3, 0, '2024-02-08'),
(3, 'azzert', 'zertjkl', '7854312', NULL, 'COS-0003', 'sdfdghh', 'rtuiklk', '86532.', NULL, '2024-02-08', 1, 4, 0, NULL);

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
(1, 'Lundi', '08:00:00', 65, 1, 1),
(5, 'Jeudi', '09:00:00', 50, 1, 1),
(7, 'Mardi', '11:30:00', 60, 1, 2);

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
(5, 'Caissier(e)', 'charger de la caisse');

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
(2, 'Ouaga-Fada');

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
  `ID_Depart` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `passagers`
--

INSERT INTO `passagers` (`ID_Passager`, `Code_Passager`, `Nom_Passager`, `prenom_Passager`, `Tel_Passager`, `Age_Passager`, `Sexe_Passager`, `Date_voy`, `ID_billet`, `Type_Passager`, `cout`, `ID_Destination`, `ID_Depart`) VALUES
(1, 'PA-0001', 'Traoré', 'Moussa', '70101012', 0, NULL, '2024-01-30', 1, 1, 10000, 1, 1),
(2, 'RE-0002', 'Sondé', 'Ali', '78010101', 29, 'M', '2024-01-30', 2, 2, 8000, 5, 1),
(3, 'PA-0003', 'azert', 'aezrgf', '7012360', 0, NULL, '2024-02-23', 1, 1, NULL, 1, 3),
(4, 'RE-0004', 'aezrt', 'azesdfcvb', '78453261', 0, NULL, '2024-02-08', 2, 2, NULL, 1, 3),
(6, 'PA-0005', 'Sebgo', 'Henry', '78102030', 0, NULL, '2024-03-04', 1, 1, NULL, 1, 1);

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
(1, 1000, 1),
(2, 1500, 2);

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
(4, 'diao@gmail.com', 'Comptable', 'comptable', 0, '2024-01-02', 1),
(6, 'diao@gmail.com', 'Admin', 'comptable', 0, '2024-01-17', 1),
(8, 'diao@gmail.com', 'Com', 'comptable', 0, NULL, 0),
(9, 'diao@gmail.com', 'Com', 'comptable', 0, '2023-12-06', 2),
(10, 'diao@gmail.com', 'Com', 'comptable00226', 0, NULL, 0),
(11, 'diao@gmail.com', 'Com', 'comptable', 0, NULL, 0),
(12, 'diao@gmail.com', 'Com', 'comptable', 0, NULL, 0),
(14, 'diao@gmail.com', 'Com', 'comptable', 0, NULL, 0),
(15, 'diao@gmail.com', 'Com', 'comptable', 0, NULL, 0),
(19, 'admin', 'admin@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 1, '2024-03-02', 1),
(20, 'caissier2@gmail.com', 'caissier2', 'f2d81a260dea8a100dd517984e53c56a7523d96942a834b9cdc249bd4e8c7aa9', 0, NULL, 1),
(22, 'caissier3', 'caissier2@gmail.com', '9af15b336e6a9619928537df30b2e6a2376569fcf9d7e773eccede65606529a0', 1, NULL, 2);

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
(1, 'Bobo', 250, 1),
(2, 'Koudougou', 180, 1),
(4, 'Fada', 220, 2),
(5, 'Bogandé', 240, 3),
(6, 'Gaoua', 300, 1),
(8, 'Dédougou', 230, 1),
(9, 'Zorgho', 120, 2),
(10, 'Koupéla', 150, 2),
(17, 'Pouytenga', 131, 2),
(18, 'Ziniaré', 45, 1),
(19, 'Sapaga', 125, 2);

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
-- Index pour la table `colis`
--
ALTER TABLE `colis`
  ADD PRIMARY KEY (`ID_Colis`),
  ADD KEY `colis_ibfk_2` (`ID_Destination`);

--
-- Index pour la table `couriers`
--
ALTER TABLE `couriers`
  ADD PRIMARY KEY (`ID_Courier`);

--
-- Index pour la table `departs`
--
ALTER TABLE `departs`
  ADD PRIMARY KEY (`ID_Depart`),
  ADD KEY `ID-Destination` (`ID_Destination`);

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
  ADD KEY `ID_Depart` (`ID_Depart`);

--
-- Index pour la table `recu`
--
ALTER TABLE `recu`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`ID_Ut`);

--
-- Index pour la table `villledestinations`
--
ALTER TABLE `villledestinations`
  ADD PRIMARY KEY (`ID_Destination`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `billet`
--
ALTER TABLE `billet`
  MODIFY `ID_Billet` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `colis`
--
ALTER TABLE `colis`
  MODIFY `ID_Colis` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `couriers`
--
ALTER TABLE `couriers`
  MODIFY `ID_Courier` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `departs`
--
ALTER TABLE `departs`
  MODIFY `ID_Depart` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `employers`
--
ALTER TABLE `employers`
  MODIFY `ID_Emp` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `grouputilisateurs`
--
ALTER TABLE `grouputilisateurs`
  MODIFY `ID_GU` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `ligne`
--
ALTER TABLE `ligne`
  MODIFY `ID_ligne` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `passagers`
--
ALTER TABLE `passagers`
  MODIFY `ID_Passager` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `recu`
--
ALTER TABLE `recu`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `ID_Ut` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `villledestinations`
--
ALTER TABLE `villledestinations`
  MODIFY `ID_Destination` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

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
-- Contraintes pour la table `departs`
--
ALTER TABLE `departs`
  ADD CONSTRAINT `departs_ibfk_1` FOREIGN KEY (`ID_Destination`) REFERENCES `villledestinations` (`ID_Destination`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `departs_ibfk_2` FOREIGN KEY (`ID_Destination`) REFERENCES `villledestinations` (`ID_Destination`) ON DELETE CASCADE ON UPDATE CASCADE;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
