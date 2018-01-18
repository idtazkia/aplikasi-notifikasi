DELETE FROM notification_configuration_variable WHERE id = 'pmb-registrasi-rekening';
DELETE FROM notification_configuration_variable WHERE id = 'pmb-registrasi-biaya';

DELETE FROM template_sms WHERE id = 'sms-keu-tagihan';
DELETE FROM template_sms WHERE id = 'keu-tagihan-nomor';

DELETE FROM notification_configuration_variable WHERE id = 'keu-tagihan-tanggal';
DELETE FROM notification_configuration_variable WHERE id = 'keu-tagihan-nama', 'keu-tagihan';
DELETE FROM notification_configuration_variable WHERE id = 'keu-tagihan-jumlah';
DELETE FROM notification_configuration_variable WHERE id = 'keu-tagihan-rekening';
DELETE FROM notification_configuration_variable WHERE id = 'keu-tagihan-keterangan';
DELETE FROM notification_configuration_variable WHERE id = 'keu-tagihan-tenggat';
DELETE FROM notification_configuration_variable WHERE id = 'keu-tagihan-contact';


--reset password

INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-pmb-resetpassword', 'pmb', 'Template Reset Password', 'Username Password a.n {{nama}}', 'resetpassword.html');

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-pmb-resetpassword', 'pmb', 'Template SMS Reset Password',
        'Berikut Username dan Password anda {{nama}} - {{nomor}}.
         Username : {{username}}
         Password : {{password}}
         Untuk informasi hubungi kontak kami : {{namaKontak1}}-{{nomorKontak1}}');


INSERT INTO notification_configuration (id, id_sender, id_template_email, id_template_sms, configuration_name, description)
VALUES ('pmb-resetpassword', 'pmb', 'email-pmb-resetpassword', 'sms-pmb-resetpassword', 'ResetPassword', 'Notifikasi Username & Password');

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-nomor', 'pmb-resetpassword', 'nomor', 'Nomor Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-nama', 'pmb-resetpassword', 'nama', 'Nama Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-username', 'pmb-resetpassword', 'username', 'Username', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-password', 'pmb-resetpassword', 'password', 'Password', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-namakontak1', 'pmb-resetpassword', 'namaKontak1', 'Nama Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-nomorkontak1', 'pmb-resetpassword', 'nomorKontak1', 'Nomor HP Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-namakontak2', 'pmb-resetpassword', 'namaKontak2', 'Nama Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-nomorkontak2', 'pmb-resetpassword', 'nomorKontak2', 'Nomor HP Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-namakontak3', 'pmb-resetpassword', 'namaKontak3', 'Nama Contact Person 3', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-resetpassword-nomorkontak3', 'pmb-resetpassword', 'nomorKontak3', 'Nomor HP Contact Person 3', TRUE);
--//////


--Biaya/Tagihan
INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-pmb-biayaTagihan', 'keuangan', 'Template Biaya Tagihan', 'Berikut merupakan tagihan {{jenisBiaya}}, a.n {{nama}}', 'biayaTagihan.html');

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-keu-tagihan', 'keuangan', 'Template SMS Tagihan',
        'Salam. Yth Sdr/i {{nama}} mohon transfer Rp.{{jumlah}} ke {{nomorVA1}} atau {{nomorVA2}} utk {{deskripsi}} sebelum {{tanggal}}.Info {{contactinfo}}');

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nomorVa1', 'keu-tagihan', 'nomorVA1', 'NomorVa1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nomorVa2', 'keu-tagihan', 'nomorVA2', 'NomorVa2', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-tanggal', 'keu-tagihan', 'tanggalTagihan', 'Tanggal Tagihan', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nama', 'keu-tagihan', 'nama', 'Nama Penerima Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nilaiTagihan', 'keu-tagihan', 'nilaiTagihan', 'Nilai Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-keterangan', 'keu-tagihan', 'keterangan', 'Keterangan Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nomorkontak1', 'keu-tagihan', 'nomorKontal1', 'Nama Contact Person 1', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nomorkontak2', 'keu-tagihan', 'nomorKontal2', 'Nama Contact Person 2', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nomorkontak3', 'keu-tagihan', 'nomorKontal3', 'Nama Contact Person 3', TRUE);

--////////

--