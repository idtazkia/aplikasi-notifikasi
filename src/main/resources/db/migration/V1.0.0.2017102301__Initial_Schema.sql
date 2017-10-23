CREATE TABLE sender (
  id   VARCHAR(36),
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (name)
);

CREATE TABLE template_email (
  id          VARCHAR(36),
  id_sender   VARCHAR(36) NOT NULL,
  description VARCHAR(255) NOT NULL,
  file_location    VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_sender) REFERENCES sender(id),
  UNIQUE (file_location)
);

CREATE TABLE template_sms (
  id               VARCHAR(36),
  id_sender        VARCHAR(36)  NOT NULL,
  description      VARCHAR(255) NOT NULL,
  template_content TEXT         NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_sender) REFERENCES sender (id)
);

CREATE TABLE notification (
  id                  VARCHAR(36),
  id_sender           VARCHAR(255),
  id_template_email   VARCHAR(36),
  id_template_sms     VARCHAR(36),
  submit_time         TIMESTAMP    NOT NULL,
  send_time           TIMESTAMP,
  notification_status VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_template_email) REFERENCES template_email (id),
  FOREIGN KEY (id_template_sms) REFERENCES template_sms (id)
);

CREATE TABLE notification_variable (
  id               VARCHAR(36),
  id_notification  VARCHAR(36)  NOT NULL,
  variable_name    VARCHAR(255) NOT NULL,
  variable_content TEXT         NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_notification) REFERENCES notification (id)
);
