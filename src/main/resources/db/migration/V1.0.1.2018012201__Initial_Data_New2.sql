--Konfirmasi Pembayaran

update template_email set subject = 'Terimakasih pembayaran {{keterangan}} telah berhasil.'
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
VALUES ('keu-pembayaran-contact', 'keu-pembayaran', 'contactinfo', 'Kontak untuk menghubungi bagian keuangan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-pembayaran-contact-full', 'keu-pembayaran', 'contactinfoFull', 'Info Kontak Detail', TRUE);


--Pengisian Data Detail

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-pmb-registrasi-selesai', 'pmb', 'Template SMS Pengisian Data Lengkap',
        'Terima kasih telah melengkapi data a.n {{nama}}. Untuk tahap selanjutnya silahkan hubungi kontak kami untuk mendapatkan jadwal test. Info {{namaKontak1}}-{{nomorKontak1}}');

INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-pmb-registrasi-selesai', 'pmb', 'Template Registrasi PMB Selesai', 'Pengisian Data a.n {{nama}}', 'selesai.html');


INSERT INTO notification_configuration (id, id_sender, id_template_email, id_template_sms, configuration_name, description)
VALUES ('pmb-registrasi-selesai', 'pmb', 'email-pmb-registrasi-selesai', 'sms-pmb-registrasi-selesai', 'Registrasi Selesai', 'Notifikasi registrasi selesai ');

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-nomor', 'pmb-registrasi-selesai', 'nomor', 'Nomor Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-nama', 'pmb-registrasi-selesai', 'nama', 'Nama Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-email', 'pmb-registrasi-selesai', 'email', 'Email Pendaftar', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-sekolah', 'pmb-registrasi-selesai', 'sekolah', 'Nama Sekolah Asal', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-nama-ibu', 'pmb-registrasi-selesai', 'namaIbu', 'Nama Ibu', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-nama-ayah', 'pmb-registrasi-selesai', 'namaAyah', 'Nama Ayah', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-namakontak1', 'pmb-registrasi-selesai', 'namaKontak1', 'Nama Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-nomorkontak1', 'pmb-registrasi-selesai', 'nomorKontak1', 'Nomor HP Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-namakontak2', 'pmb-registrasi-selesai', 'namaKontak2', 'Nama Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-nomorkontak2', 'pmb-registrasi-selesai', 'nomorKontak2', 'Nomor HP Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-namakontak3', 'pmb-registrasi-selesai', 'namaKontak3', 'Nama Contact Person 3', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-selesai-nomorkontak3', 'pmb-registrasi-selesai', 'nomorKontak3', 'Nomor HP Contact Person 3', TRUE);
