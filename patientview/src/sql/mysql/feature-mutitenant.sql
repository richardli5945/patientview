ALTER TABLE USER DROP PRIMARY KEY;

ALTER TABLE USER ADD id BIGINT(20)
NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

ALTER TABLE patient ADD id BIGINT(20)
NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

ALTER TABLE comment ADD id BIGINT(20)
NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

ALTER TABLE diagnosis ADD id BIGINT(20)
NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

ALTER TABLE edtacode ADD id BIGINT(20)
NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

ALTER TABLE uktstatus ADD id BIGINT(20)
NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

ALTER TABLE unit ADD id BIGINT(20)
NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;