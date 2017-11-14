INSERT INTO sender (id, name, sms_sender_id, sms_username, sms_password) VALUES ('it', 'Tazkia IT', 'TAZKIA IT', 'tazkiait', 'tazkia123');
INSERT INTO sender (id, name, sms_sender_id, sms_username, sms_password) VALUES ('keuangan', 'Tazkia Finance', 'TAZKIA KEU', 'tazkiakeu', 'tazkia123');
INSERT INTO sender (id, name, sms_sender_id, sms_username, sms_password) VALUES ('akademik', 'Tazkia Akademik', 'TAZKIA AKD', 'tazkiaakd', 'tazkia123');
INSERT INTO sender (id, name, sms_sender_id, sms_username, sms_password) VALUES ('tazkia', 'Tazkia', 'TAZKIA', 'tazkia', 'tazkia123');
INSERT INTO sender (id, name, sms_sender_id, sms_username, sms_password) VALUES ('pmb', 'Registrasi Tazkia', 'TAZKIA PMB', 'tazkiapmb', 'tazkia123');

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-keu-tagihan', 'keuangan', 'Template SMS Tagihan',
        'Salam. Yth Sdr/i {{nama}} mohon transfer Rp.{{jumlah}} ke {{rekening}} utk {{deskripsi}} sebelum {{tanggal}}.Info {{contactinfo}}');

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-keu-pembayaran', 'keuangan', 'Template SMS Pembayaran',
        'Salam. Yth Bpk/Ibu {{nama}} telah ditransfer Rp.{{jumlah}} ke {{rekening}} utk {{deskripsi}}.Info {{contactinfo}}');

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-pmb-registrasi', 'pmb', 'Template SMS Registrasi',
        'Terima kasih telah melakukan registrasi atas nama {{nama}} - {{email}}.Kami akan segera menghubungi Anda.Info {{namaKontak1}}-{{nomorKontak1}}');

INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-keu-tagihan', 'keuangan', 'Template Email Tagihan', 'Tagihan {{deskripsi}}', 'tagihan.html');

INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-keu-pembayaran', 'keuangan', 'Template Email Pembayaran', 'Pembayaran {{deskripsi}}', 'pembayaran.html');

INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-pmb-registrasi', 'pmb', 'Template Registrasi Awal PMB', 'Registrasi a.n {{nama}}', 'registrasi.html');

INSERT INTO notification_configuration (id, id_sender, id_template_email, id_template_sms, configuration_name, description)
VALUES ('keu-tagihan', 'keuangan', 'email-keu-tagihan', 'sms-keu-tagihan', 'Tagihan', 'Notifikasi tagihan uang sekolah');

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nomor', 'keu-tagihan', 'nomorTagihan', 'Nomor Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-tanggal', 'keu-tagihan', 'tanggalTagihan', 'Tanggal Tagihan', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nama', 'keu-tagihan', 'nama', 'Nama Penerima Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-jumlah', 'keu-tagihan', 'jumlah', 'Jumlah Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-rekening', 'keu-tagihan', 'rekening', 'Rekening Pembayaran', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-keterangan', 'keu-tagihan', 'keterangan', 'Keterangan Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-tenggat', 'keu-tagihan', 'batasPembayaran', 'Tanggal Jatuh Tempo', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-contact', 'keu-tagihan', 'contactinfo', 'Kontak untuk menghubungi bagian keuangan', TRUE);

INSERT INTO notification_configuration (id, id_sender, id_template_email, id_template_sms, configuration_name, description)
VALUES ('pmb-registrasi', 'pmb', 'email-pmb-registrasi', 'sms-pmb-registrasi', 'Registrasi', 'Notifikasi registrasi awal');

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-nomor', 'pmb-registrasi', 'nomor', 'Nomor Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-nama', 'pmb-registrasi', 'nama', 'Nama Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-hp', 'pmb-registrasi', 'noHp', 'Nomor Handphone', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-email', 'pmb-registrasi', 'email', 'Email Pendaftar', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-sekolah', 'pmb-registrasi', 'sekolah', 'Nama Sekolah Asal', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-biaya', 'pmb-registrasi', 'biaya', 'Biaya Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-rekening', 'pmb-registrasi', 'rekening', 'Rekening Registrasi', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-namakontak1', 'pmb-registrasi', 'namaKontak1', 'Nama Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-nomorkontak1', 'pmb-registrasi', 'nomorKontak1', 'Nomor HP Contact Person 1', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-namakontak2', 'pmb-registrasi', 'namaKontak2', 'Nama Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-nomorkontak2', 'pmb-registrasi', 'nomorKontak2', 'Nomor HP Contact Person 2', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-namakontak3', 'pmb-registrasi', 'namaKontak3', 'Nama Contact Person 3', TRUE);

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('pmb-registrasi-nomorkontak3', 'pmb-registrasi', 'nomorKontak3', 'Nomor HP Contact Person 3', TRUE);