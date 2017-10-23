insert into notification(id, id_sender, id_template_email, id_template_sms, submit_time, send_time, notification_status)
VALUES ('test-001','keuangan','email-keu-tagihan','sms-keu-tagihan', now(), NULL, 'NEW');

insert into notification_variable(id, id_notification, variable_name, variable_content)
VALUES ('test-001-nama', 'test-001', 'nama', 'Endy Muhardin');

insert into notification_variable(id, id_notification, variable_name, variable_content)
VALUES ('test-001-jumlah', 'test-001', 'jumlah', '100000');

insert into notification_variable(id, id_notification, variable_name, variable_content)
VALUES ('test-001-rekening', 'test-001', 'rekening', 'BNI Syariah 001 002 003 a.n Yayasan Tazkia Cendekia');

insert into notification_variable(id, id_notification, variable_name, variable_content)
VALUES ('test-001-deskripsi', 'test-001', 'deskripsi', 'Pendaftaran Siswa Baru');

insert into notification_variable(id, id_notification, variable_name, variable_content)
VALUES ('test-001-tanggal', 'test-001', 'tanggal', '31-Des-2017');

insert into notification_variable(id, id_notification, variable_name, variable_content)
VALUES ('test-001-contact', 'test-001', 'contactinfo', '018234567890');