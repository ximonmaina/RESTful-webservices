DROP TABLE IF EXISTS  drug_inventory;

CREATE TABLE IF NOT EXISTS drug_inventory (
    id bigint AUTO_INCREMENT PRIMARY KEY ,
    br_id bigint unique not null ,
    drug_name varchar(255),
    unit_price long,
    selling_price long,
    inventory bigint,
    expiry_date DATE,
    manufacturer varchar(255),
    notes TEXT

);

insert into drug_inventory (br_id, drug_name, unit_price, selling_price, inventory, expiry_date, manufacturer, notes)
values (13223432,'piltons', 5, 9, 500, '2025-09-12', 'Johnson johnson', 'optimum stock');