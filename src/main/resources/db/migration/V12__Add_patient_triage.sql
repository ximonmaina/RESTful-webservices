DROP TABLE IF EXISTS `patient_triage`;

CREATE TABLE `patient_triage` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                  `pt_weight` decimal(7,2) DEFAULT NULL,
                                  `pt_temp` decimal(7,2) DEFAULT NULL,
                                  `pt_height` decimal(7,2) DEFAULT NULL,
                                  `pt_blood_pressure` varchar(45) DEFAULT NULL,
                                  `pt_staff_name` varchar(45) DEFAULT NULL,
                                  `patient_id` bigint(20) DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `patient_id` (`patient_id`),
                                   FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
);