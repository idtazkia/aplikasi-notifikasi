INSERT INTO sender (id, name) VALUES ('it', 'Divisi IT');
INSERT INTO sender (id, name) VALUES ('keuangan', 'Divisi Keuangan');
INSERT INTO sender (id, name) VALUES ('akademik', 'Divisi Akademik');
INSERT INTO sender (id, name) VALUES ('humas', 'Divisi Humas');

insert into template_sms (id, id_sender, description, template_content)
VALUES ('sms-keu-tagihan', 'keuangan', 'Template SMS Tagihan', 'Salam. Yth Sdr/i <nama> mohon transfer Rp.<jumlah> ke <rekening> utk <deskripsi> sebelum <tanggal>.Info <contactinfo>');
insert into template_sms (id, id_sender, description, template_content)
VALUES ('sms-keu-pembayaran', 'keuangan', 'Template SMS Pembayaran', 'Salam. Yth Bpk/Ibu <nama> telah ditransfer Rp.<jumlah> ke <rekening> utk <deskripsi>.Info <contactinfo>');

insert into template_email (id, id_sender, description, file_location)
    VALUES ('email-keu-tagihan', 'keuangan', 'Template Email Tagihan', 'tagihan.html');
insert into template_email (id, id_sender, description, file_location)
    VALUES ('email-keu-pembayaran', 'keuangan', 'Template Email Pembayaran', 'pembayaran.html');

