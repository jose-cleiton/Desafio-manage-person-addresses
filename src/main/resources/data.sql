INSERT INTO PersonModel (id, name, birthDate) VALUES (nextval('PersonModel_SEQ'), 'Caléo', '1990-01-01');
INSERT INTO Address (id, person_id, city, publicPlace, number, zipCode, main) 
VALUES (nextval('AddressModel_SEQ'), (SELECT MAX(id) FROM PersonModel), 'Salvador', 'Vale dos Lagos', '106', '41256', true);
INSERT INTO Address (id, person_id, city, publicPlace, number, zipCode, main) 
VALUES (nextval('AddressModel_SEQ'), (SELECT MAX(id) FROM PersonModel), 'Salvador', 'Vale dos Lagos', '106', '41256', false);


INSERT INTO PersonModel (id, name, birthDate) VALUES (nextval('PersonModel_SEQ'), 'José Cleiton', '1975-03-20');
INSERT INTO Address (id, person_id, city, publicPlace, number, zipCode, main)
VALUES (nextval('AddressModel_SEQ'), (SELECT MAX(id) FROM PersonModel), 'Salvador', 'Pau Miúdo', '16', '1234', true);
INSERT INTO Address (id, person_id, city, publicPlace, number, zipCode, main)
VALUES (nextval('AddressModel_SEQ'), (SELECT MAX(id) FROM PersonModel), 'Salvador', 'Cajazeiras', '186', '1324', false);

INSERT INTO PersonModel (id, name, birthDate) VALUES (nextval('PersonModel_SEQ'), 'Maria', '1980-01-01');
INSERT INTO Address (id, person_id, city, publicPlace, number, zipCode, main)
VALUES (nextval('AddressModel_SEQ'), (SELECT MAX(id) FROM PersonModel), 'Salvador', 'Capelinha', '156', '1234', true);
INSERT INTO Address (id, person_id, city, publicPlace, number, zipCode, main)
VALUES (nextval('AddressModel_SEQ'), (SELECT MAX(id) FROM PersonModel), 'Salvador', 'Geral', '186', '1324', false);