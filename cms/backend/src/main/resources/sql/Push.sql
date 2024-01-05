CREATE TABLE `PUSH` (
                        `ID` bigint(20) NOT NULL AUTO_INCREMENT,
                        `TEXT` varchar(255) DEFAULT NULL,
                        `TARGET` bigint(20) DEFAULT NULL,
                        `TYPE` varchar(255) DEFAULT NULL,
                        `CREATED_DATE` varchar(255) DEFAULT NULL,
                        `UPDATE_DATE` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`ID`)
);