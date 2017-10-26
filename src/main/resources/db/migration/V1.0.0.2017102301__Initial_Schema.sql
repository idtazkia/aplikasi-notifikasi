CREATE TABLE sender (
  id   VARCHAR(36),
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (name)
);

CREATE TABLE template_email (
  id          VARCHAR(36),
  id_sender   VARCHAR(36) NOT NULL,
  subject     VARCHAR(255) NOT NULL,
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

CREATE TABLE notification_configuration (
  id        VARCHAR(36),
  id_sender VARCHAR(36)  NOT NULL,
  id_template_email VARCHAR(36),
  id_template_sms VARCHAR(36),
  configuration_name      VARCHAR(255) NOT NULL,
  description      VARCHAR(255),
  PRIMARY KEY (id),
  FOREIGN KEY (id_sender) REFERENCES sender (id),
  FOREIGN KEY (id_template_email) REFERENCES template_email (id),
  FOREIGN KEY (id_template_sms) REFERENCES template_sms (id),
  UNIQUE (configuration_name, id_sender)
);

CREATE TABLE notification_configuration_variable (
  id                            VARCHAR(36),
  id_notification_configuration VARCHAR(36)  NOT NULL,
  variable_name                 VARCHAR(255) NOT NULL,
  description                   VARCHAR(255),
  required                      BOOLEAN      NOT NULL DEFAULT FALSE,
  PRIMARY KEY (id),
  FOREIGN KEY (id_notification_configuration) REFERENCES notification_configuration (id),
  UNIQUE (id_notification_configuration, variable_name)
);

CREATE TABLE notification (
  id                            VARCHAR(36),
  id_notification_configuration VARCHAR(36)  NOT NULL,
  submit_time                   TIMESTAMP    NOT NULL,
  notification_data          TEXT         NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_notification_configuration) REFERENCES notification_configuration (id)
);

CREATE TABLE sms_notification (
  id                  VARCHAR(36),
  id_notification     VARCHAR(36) NOT NULL,
  destination_number  VARCHAR(36) NOT NULL,
  content             TEXT        NOT NULL,
  send_time           TIMESTAMP   NOT NULL,
  notification_status VARCHAR(20) NOT NULL,
  delivery_remarks    VARCHAR(255),
  PRIMARY KEY (id),
  FOREIGN KEY (id_notification) REFERENCES notification (id)
);

CREATE TABLE email_notification (
  id                  VARCHAR(36),
  id_notification     VARCHAR(36) NOT NULL,
  mail_to                  VARCHAR(255) NOT NULL,
  subject             VARCHAR(255) NOT NULL,
  body                TEXT        NOT NULL,
  send_time           TIMESTAMP   NOT NULL,
  notification_status VARCHAR(20) NOT NULL,
  delivery_remarks    VARCHAR(255),
  PRIMARY KEY (id),
  FOREIGN KEY (id_notification) REFERENCES notification (id)
);