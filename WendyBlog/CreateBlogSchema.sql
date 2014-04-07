CREATE DATABASE `listing` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `logininfo` (
  `uid` int(11) NOT NULL,
  `pswd` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`uid`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `posting` (
  `idposting` int(11) NOT NULL,
  `datepost` date DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `body` varchar(45) DEFAULT NULL,
  `postedby` int(11) NOT NULL,
  PRIMARY KEY (`idposting`),
  KEY `postedby_idx` (`postedby`),
  CONSTRAINT `postedby` FOREIGN KEY (`postedby`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `response` (
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `body` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uid`,`pid`),
  KEY `uid_idx` (`uid`),
  KEY `a_idx` (`pid`),
  CONSTRAINT `b` FOREIGN KEY (`uid`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `telno` varchar(45) DEFAULT NULL,
  `bio` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

