INSERT INTO sender (id, name) VALUES ('it', 'Divisi IT');
INSERT INTO sender (id, name) VALUES ('keuangan', 'Divisi Keuangan');
INSERT INTO sender (id, name) VALUES ('akademik', 'Divisi Akademik');
INSERT INTO sender (id, name) VALUES ('humas', 'Divisi Humas');

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-keu-tagihan', 'keuangan', 'Template SMS Tagihan',
        'Salam. Yth Sdr/i {{nama}} mohon transfer Rp.{{jumlah}} ke {{rekening}} utk {{deskripsi}} sebelum {{tanggal}}.Info {{contactinfo}}');

INSERT INTO template_sms (id, id_sender, description, template_content)
VALUES ('sms-keu-pembayaran', 'keuangan', 'Template SMS Pembayaran',
        'Salam. Yth Bpk/Ibu {{nama}} telah ditransfer Rp.{{jumlah}} ke {{rekening}} utk {{deskripsi}}.Info {{contactinfo}}');


INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-keu-tagihan', 'keuangan', 'Template Email Tagihan', 'Tagihan {{deskripsi}}', 'tagihan.html');

INSERT INTO template_email (id, id_sender, description, subject, file_location)
VALUES ('email-keu-pembayaran', 'keuangan', 'Template Email Pembayaran', 'Pembayaran {{deskripsi}}', 'pembayaran.html');

INSERT INTO notification_configuration (id, id_sender, id_template_email, id_template_sms, configuration_name, description)
VALUES ('keu-tagihan', 'keuangan', 'email-keu-tagihan', 'sms-keu-tagihan', 'Tagihan', 'Notifikasi tagihan uang sekolah');

INSERT INTO notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-nama', 'keu-tagihan', 'nama', 'Nama Penerima Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-jumlah', 'keu-tagihan', 'jumlah', 'Jumlah Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-rekening', 'keu-tagihan', 'rekening', 'Rekening Pembayaran', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-deskripsi', 'keu-tagihan', 'deskripsi', 'Keterangan Tagihan', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-tanggal', 'keu-tagihan', 'tanggal', 'Tanggal Jatuh Tempo', TRUE);

insert into notification_configuration_variable (id, id_notification_configuration, variable_name, description, required)
VALUES ('keu-tagihan-contact', 'keu-tagihan', 'contactinfo', 'Kontak untuk menghubungi bagian keuangan', TRUE);