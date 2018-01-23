-- Update Notifikasi Registrasi

DELETE FROM notification_configuration_variable WHERE id = 'pmb-registrasi-rekening';
DELETE FROM notification_configuration_variable WHERE id = 'pmb-registrasi-biaya';

update template_sms set template_content =
'Terima kasih telah melakukan registrasi atas nama {{nama}}<{{email}}>.Info {{namaKontak1}}-{{nomorKontak1}}'
where id = 'sms-pmb-registrasi';

-- Notifikasi Tagihan

DELETE FROM notification_configuration_variable WHERE id = 'keu-tagihan-tenggat';

update template_sms set template_content =
'Salam. Yth Sdr/i {{nama}} mohon transfer {{keterangan}} Rp.{{jumlah}} ke {{rekening}} Info {{contactinfo}}'
where id='sms-keu-tagihan';

update template_email set subject = 'Tagihan {{keterangan}}'
where id ='email-keu-tagihan';

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-rekening-full', 'keu-tagihan', 'rekeningFull', 'Rekening Pembayaran Detail', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-contact-full', 'keu-tagihan', 'contactinfoFull', 'Info Kontak Detail', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nohp', 'keu-tagihan', 'noHp', 'Nomor Telepon', FALSE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-email', 'keu-tagihan', 'email', 'Email', FALSE);


--Konfirmasi Pembayaran

update template_email set subject = 'Pembayaran {{keterangan}} berhasil'
where id ='email-keu-pembayaran';

update template_sms set template_content =
'Salam. Yth Bpk/Ibu {{nama}} telah ditransfer Rp.{{nilaiTagihan}} ke {{rekening}} utk {{keterangan}}. Info {{contactinfo}}'
where id = 'sms-keu-pembayaran';

INSERT INTO notification_configuration (id, id_sender, id_template_email, id_template_sms, configuration_name, description)
VALUES ('keu-pembayaran', 'keuangan', 'email-keu-pembayaran', 'sms-keu-pembayaran', 'Pembayaran', 'Notifikasi berhasil melakukan pembayaran');

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-nomor', 'keu-pembayaran', 'nomorTagihan', 'Nomor Tagihan', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-nama', 'keu-pembayaran', 'nama', 'Nama Pembayar', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-nohp', 'keu-pembayaran', 'noHp', 'Nomor Hp', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-nilaitagihan', 'keu-pembayaran', 'nilaiTagihan', 'Nilai Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-nilaipembayaran', 'keu-pembayaran', 'nilaiPembayaran', 'Nilai Pembayaran', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-keterangan', 'keu-pembayaran', 'keterangan', 'Keterangan Pembayaran', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-rekening', 'keu-pembayaran', 'rekening', 'Rekening Tujuan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-referensi', 'keu-pembayaran', 'referensi', 'Referensi Bank', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-waktu', 'keu-pembayaran', 'waktu', 'Waktu Transaksi', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-contact', 'keu-pembayaran', 'contactinfo', 'Kontak untuk menghubungi bagian keuangan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-contact-full', 'keu-pembayaran', 'contactinfoFull', 'Info Kontak Detail', TRUE);


-- Notifikasi reset password

INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-pmb-resetpassword', 'pmb', 'Template Reset Password', 'Username Password a.n {{nama}}', 'resetpassword.html');

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-pmb-resetpassword', 'pmb', 'Template SMS Reset Password',
        'Berikut Username dan Password anda {{nama}} - {{nomor}}.Username : {{username}}.Password : {{password}}.Untuk informasi hubungi kontak kami : {{namaKontak1}}-{{nomorKontak1}}');

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


--Pengisian Data Detail

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-pmb-registrasi-isi-data', 'pmb', 'Template SMS Pengisian Data',
        'Terima kasih telah melengkapi data a.n {{nama}}. Untuk tahap selanjutnya silahkan hubungi kontak kami untuk mendapatkan jadwal test. Info {{namaKontak1}}-{{nomorKontak1}}');

INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-pmb-registrasi-isi-data', 'pmb', 'Template Registrasi PMB Pengisisan Data', 'Pengisian Data a.n {{nama}}', 'isiData.html');


INSERT INTO notification_configuration (id, id_sender, id_template_email, id_template_sms, configuration_name, description)
VALUES ('pmb-registrasi-isi-data', 'pmb', 'email-pmb-registrasi-isi-data', 'sms-pmb-registrasi-isi-data', 'Registrasi Isi Data', 'Notifikasi registrasi isi data ');

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-nomor', 'pmb-registrasi-isi-data', 'nomor', 'Nomor Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-nama', 'pmb-registrasi-isi-data', 'nama', 'Nama Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-email', 'pmb-registrasi-isi-data', 'email', 'Email Pendaftar', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-sekolah', 'pmb-registrasi-isi-data', 'sekolah', 'Nama Sekolah Asal', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-nama-ibu', 'pmb-registrasi-isi-data', 'namaIbu', 'Nama Ibu', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-nama-ayah', 'pmb-registrasi-isi-data', 'namaAyah', 'Nama Ayah', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-namakontak1', 'pmb-registrasi-isi-data', 'namaKontak1', 'Nama Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-nomorkontak1', 'pmb-registrasi-isi-data', 'nomorKontak1', 'Nomor HP Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-namakontak2', 'pmb-registrasi-isi-data', 'namaKontak2', 'Nama Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-nomorkontak2', 'pmb-registrasi-isi-data', 'nomorKontak2', 'Nomor HP Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-namakontak3', 'pmb-registrasi-isi-data', 'namaKontak3', 'Nama Contact Person 3', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-isi-data-nomorkontak3', 'pmb-registrasi-isi-data', 'nomorKontak3', 'Nomor HP Contact Person 3', TRUE);
