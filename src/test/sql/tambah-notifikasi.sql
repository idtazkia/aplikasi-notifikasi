-- insert into template_sms
INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-pmb-kartu-jpa', 'pmb', 'Template SMS Kartu Jpa',
        '');
-- insert into template_email
INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-pmb-kartu-jpa', 'pmb', 'Template Registrasi PMB Kartu jpa', 'Pengisian Data a.n {{nama}} & Perintah Pengumpulan berkas', 'jpa.html');


-- insert ke tabel notification_configuration
INSERT INTO notification_configuration (id, id_sender, id_template_email, id_template_sms, configuration_name, description)VALUES
 ('pmb-kartu-jpa', 'pmb', 'email-pmb-kartu-jpa', 'sms-pmb-kartu-jpa', 'KartuJpa', 'Notifikasi Perintah Pengumpulan Berkas Jpa');

-- insert into tabel notification_configuration_variable
INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartu-jpa-nomor', 'pmb-kartu-jpa', 'nomor', 'Nomor Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartu-jpa-nama', 'pmb-kartu-jpa', 'nama', 'Nama', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartu-jpa-email', 'pmb-kartu-jpa', 'email', 'Email', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartu-jpa-noHp', 'pmb-kartu-jpa', 'noHp', 'No Hp', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartu-jpa-namakontak1', 'pmb-kartu-jpa', 'namaKontak1', 'Nama Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartu-jpa-nomorkontak1', 'pmb-kartu-jpa', 'nomorKontak1', 'Nomor HP Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartu-jpa-namakontak3', 'pmb-kartu-jpa', 'namaKontak3', 'Nama Contact Person 3', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartu-jpa-nomorkontak3', 'pmb-kartu-jpa', 'nomorKontak3', 'Nomor HP Contact Person 3', TRUE);


