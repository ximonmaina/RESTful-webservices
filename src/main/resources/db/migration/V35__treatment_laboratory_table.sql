CREATE TABLE IF NOT EXISTS `patient_management_system`.`treatment_laboratory`
(
    `treatment_id`  BIGINT(20) NOT NULL,
    `laboratory_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`treatment_id`, `laboratory_id`),
    CONSTRAINT `fk_treatment_has_laboratory_treatment1`
        FOREIGN KEY (`treatment_id`)
            REFERENCES `patient_management_system`.`treatment` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_treatment_has_laboratory_laboratory1`
        FOREIGN KEY (`laboratory_id`)
            REFERENCES `patient_management_system`.`laboratory` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = latin1