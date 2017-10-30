INSERT INTO s_permission (id, permission_value, permission_label) VALUES
  ('createnotification', 'CREATE_NOTIFICATION', 'Send Notification');

INSERT INTO s_role (id, description, name) VALUES
  ('clientapp', 'CLIENTAPP', 'Client Application');

INSERT INTO s_role_permission (id_role, id_permission) VALUES
  ('clientapp', 'createnotification');

INSERT INTO s_user (id, active, username, id_role) VALUES
  ('client001', true, 'client001', 'clientapp');

INSERT INTO s_user_password (id, id_user, password) VALUES
  -- password : test123
  ('cp001', 'client001', '$2a$13$d2GZHGr6gedUiNk8r3Pbo.Jc8eH7oBVdTta.WGMG9g1dO9T4hlNPG');
