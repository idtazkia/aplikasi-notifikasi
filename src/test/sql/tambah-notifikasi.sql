-- insert ke tabel notification_configuration
INSERT INTO notification_configuration (id, id_sender, id_template_email, id_template_sms, configuration_name, description)
VALUES ('pmb-kartuujian', 'pmb', 'email-pmb-registrasi-kartu-ujian', 'sms-pmb-registrasi-kartu-ujian', 'KartuUjian', 'Notifikasi Kartu Ujian');

-- insert into tabel notification_configuration_variable
INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartuujian-nomor', 'pmb-kartuujian', 'nomor', 'Nomor Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartuujian-nama', 'pmb-kartuujian', 'nama', 'Nama', TRUE);
INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartuujian-id', 'pmb-kartuujian', 'id', 'Id Pendaftar', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartuujian-namakontak2', 'pmb-kartuujian', 'namaKontak2', 'Nama Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartuujian-nomorkontak2', 'pmb-kartuujian', 'nomorKontak2', 'Nomor HP Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartuujian-namakontak3', 'pmb-kartuujian', 'namaKontak3', 'Nama Contact Person 3', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-kartuujian-nomorkontak3', 'pmb-kartuujian', 'nomorKontak3', 'Nomor HP Contact Person 3', TRUE);

-- insert into template_sms
INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-pmb-registrasi-kartu-ujian', 'pmb', 'Template SMS Kartu Ujian',
        'Terima kasih telah melengkapi data a.n {{nama}}. Untuk tahap selanjutnya silahkan DOWNLOAD kartu ujian di email Anda. Info {{namaKontak1}}-{{nomorKontak1}}');

-- insert into template_email
INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-pmb-registrasi-kartu-ujian', 'pmb', 'Template Registrasi PMB Kartu Ujian', 'Pengisian Data a.n {{nama}} & Kartu Ujian', 'kartuUjian.html');


