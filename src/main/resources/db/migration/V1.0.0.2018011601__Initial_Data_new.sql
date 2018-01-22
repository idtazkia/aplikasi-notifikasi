DELETE FROM notification_configuration_variable WHERE id = 'pmb-registrasi-rekening';
DELETE FROM notification_configuration_variable WHERE id = 'pmb-registrasi-biaya';

DELETE FROM notification_configuration_variable WHERE id = 'keu-tagihan-tenggat';

update template_sms set template_content =
'Salam. Yth Sdr/i {{nama}} mohon transfer {{keterangan}} Rp.{{jumlah}} ke {{rekening}} Info {{contactinfo}}'
where id='sms-keu-tagihan';

update template_email set subject = 'Tagihan {{keterangan}}'
where id ='email-keu-tagihan';

-- variabel tambahan untuk notifikasi tagihan via email
insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-rekening-full', 'keu-tagihan', 'rekeningFull', 'Rekening Pembayaran Detail', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-contact-full', 'keu-tagihan', 'contactinfoFull', 'Info Kontak Detail', TRUE);

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
