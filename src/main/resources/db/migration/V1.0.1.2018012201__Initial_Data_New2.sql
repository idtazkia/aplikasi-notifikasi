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
