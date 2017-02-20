DROP TABLE IF EXISTS staff;

CREATE TABLE staff (
  _id       VARCHAR(20) NOT NULL UNIQUE PRIMARY KEY,
  staffname VARCHAR(16) NOT NULL,
  password  VARCHAR(16) NOT NULL,
  birthday  DATE        NOT NULL,
  datein    DATE        NOT NULL,
  issuper   TINYINT     NOT NULL
);

DROP TABLE IF EXISTS goods;

CREATE TABLE goods
(
  _id          VARCHAR(20) NOT NULL,
  goodsname    VARCHAR(16) NOT NULL,
  count        INT         NOT NULL,
  goodsclass   VARCHAR(16) NOT NULL,
  price        DOUBLE      NOT NULL,
  usefullife   INT DEFAULT 0,
  dateproduced DATE        NOT NULL,
  position     INT         NOT NULL,
  PRIMARY KEY (_id, position)
);

DROP TABLE IF EXISTS log;

CREATE TABLE log
(
  _id       VARCHAR(20) NOT NULL PRIMARY KEY,
  manage_id VARCHAR(20) NOT NULL,
  object_id VARCHAR(20) NOT NULL,
  logdate   DATETIME    NOT NULL,
  content   VARCHAR(20)
);