-- 
-- Structure for table `Abonnement`
-- 

DROP TABLE IF EXISTS `Abonnement`;
CREATE TABLE IF NOT EXISTS `Abonnement` (
  `idAbonnement` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(32) CHARACTER SET utf8 NOT NULL,
  `prix` float(8,2) NOT NULL DEFAULT '0.00',
  `periode` int(11) NOT NULL DEFAULT '0' COMMENT 'Nombre de jour de validité de l''abonnement',
  `nombre` int(11) NOT NULL DEFAULT '0' COMMENT 'Le nombre d''article autorité à la consultation',
  PRIMARY KEY (`idAbonnement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 
-- Structure for table `ArtGro`
-- 

DROP TABLE IF EXISTS `ArtGro`;
CREATE TABLE IF NOT EXISTS `ArtGro` (
  `article` int(11) NOT NULL,
  `groupe` int(11) NOT NULL,
  PRIMARY KEY (`article`,`groupe`),
  KEY `groupe` (`groupe`),
  CONSTRAINT `ArtGro_ibfk_2` FOREIGN KEY (`article`) REFERENCES `Article` (`idArticle`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ArtGro_ibfk_1` FOREIGN KEY (`groupe`) REFERENCES `Groupe` (`idGroupe`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 
-- Structure for table `Article`
-- 

DROP TABLE IF EXISTS `Article`;
CREATE TABLE IF NOT EXISTS `Article` (
  `idArticle` int(11) NOT NULL,
  `titre` varchar(32) COLLATE utf8_bin NOT NULL,
  `resume` text COLLATE utf8_bin NOT NULL,
  `corps` text COLLATE utf8_bin NOT NULL,
  `statut` enum('visible','invisible','brouillon') COLLATE utf8_bin NOT NULL DEFAULT 'brouillon',
  `publication` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `miseAJour` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `utilisateur` int(11) NOT NULL,
  `prix` float(8,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`idArticle`),
  KEY `utilisateur` (`utilisateur`),
  CONSTRAINT `Article_ibfk_1` FOREIGN KEY (`utilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 
-- Structure for table `Commande`
-- 

DROP TABLE IF EXISTS `Commande`;
CREATE TABLE IF NOT EXISTS `Commande` (
  `idCommande` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `statut` enum('en cours','valide','annulee') CHARACTER SET utf8 NOT NULL DEFAULT 'en cours',
  `utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`idCommande`),
  KEY `utilisateur` (`utilisateur`),
  CONSTRAINT `Commande_ibfk_1` FOREIGN KEY (`utilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 
-- Structure for table `Groupe`
-- 

DROP TABLE IF EXISTS `Groupe`;
CREATE TABLE IF NOT EXISTS `Groupe` (
  `idGroupe` int(11) NOT NULL AUTO_INCREMENT,
  `prix` float(8,2) NOT NULL DEFAULT '0.00',
  `titre` varchar(32) CHARACTER SET utf8 NOT NULL,
  `statut` enum('valide','supprime') CHARACTER SET utf8 NOT NULL DEFAULT 'valide',
  PRIMARY KEY (`idGroupe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 
-- Structure for table `LigneCommande`
-- 

DROP TABLE IF EXISTS `LigneCommande`;
CREATE TABLE IF NOT EXISTS `LigneCommande` (
  `idLigneCommande` int(11) NOT NULL AUTO_INCREMENT,
  `prix` float(8,2) NOT NULL DEFAULT '0.00',
  `article` int(11) DEFAULT NULL,
  `groupe` int(11) DEFAULT NULL,
  `commande` int(11) NOT NULL,
  PRIMARY KEY (`idLigneCommande`),
  UNIQUE KEY `article_groupe` (`article`,`groupe`),
  UNIQUE KEY `article_commande` (`article`,`commande`),
  KEY `groupe` (`groupe`),
  KEY `commande` (`commande`),
  CONSTRAINT `LigneCommande_ibfk_3` FOREIGN KEY (`commande`) REFERENCES `Commande` (`idCommande`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `LigneCommande_ibfk_1` FOREIGN KEY (`article`) REFERENCES `Article` (`idArticle`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `LigneCommande_ibfk_2` FOREIGN KEY (`groupe`) REFERENCES `Groupe` (`idGroupe`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 
-- Structure for table `Tag`
-- 

DROP TABLE IF EXISTS `Tag`;
CREATE TABLE IF NOT EXISTS `Tag` (
  `article` int(11) NOT NULL,
  `nom` varchar(16) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`article`,`nom`),
  CONSTRAINT `Tag_ibfk_1` FOREIGN KEY (`article`) REFERENCES `Article` (`idArticle`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 
-- Structure for table `UtiAbo`
-- 

DROP TABLE IF EXISTS `UtiAbo`;
CREATE TABLE IF NOT EXISTS `UtiAbo` (
  `utilisateur` int(11) NOT NULL,
  `abonnement` int(11) NOT NULL,
  `achat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nombre` int(11) NOT NULL DEFAULT '0' COMMENT 'Le nombre d''article déjà vue',
  PRIMARY KEY (`utilisateur`,`abonnement`),
  KEY `abonnement` (`abonnement`),
  CONSTRAINT `UtiAbo_ibfk_1` FOREIGN KEY (`utilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UtiAbo_ibfk_2` FOREIGN KEY (`abonnement`) REFERENCES `Abonnement` (`idAbonnement`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 
-- Structure for table `Utilisateur`
-- 

DROP TABLE IF EXISTS `Utilisateur`;
CREATE TABLE IF NOT EXISTS `Utilisateur` (
  `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant` char(12) COLLATE utf8_bin NOT NULL,
  `motPasse` char(32) COLLATE utf8_bin NOT NULL,
  `statut` enum('redacteur','administrateur','abonne','visiteur') COLLATE utf8_bin NOT NULL DEFAULT 'visiteur',
  PRIMARY KEY (`idUtilisateur`),
  UNIQUE KEY `identifiant` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

