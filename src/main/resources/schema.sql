DROP TABLE IF EXISTS staff;

CREATE TABLE staff (
  _id       VARCHAR(20) NOT NULL UNIQUE PRIMARY KEY,
  staffname VARCHAR(16) NOT NULL,
  password  VARCHAR(16) NOT NULL,
  birthday  DATE        NOT NULL,
  datein    DATE        NOT NULL,
  issuper   TINYINT     NOT NULL
);