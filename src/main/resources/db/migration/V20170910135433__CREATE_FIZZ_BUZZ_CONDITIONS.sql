CREATE TABLE IF NOT EXISTS fizz_buzz_conditions (
  id_ IDENTITY,
  word varchar(32) NOT NULL,
  divider INT,
  status int DEFAULT 1,
  ins_time timestamp DEFAULT current_timestamp(),
  upd_time timestamp,
  PRIMARY KEY (id_)
);

ALTER TABLE fizz_buzz_conditions ADD CONSTRAINT uq_fizz_buzz_conditions_word UNIQUE(word);
COMMENT ON COLUMN fizz_buzz_conditions.status IS '0-Deactivated, 1-Active';

INSERT INTO fizz_buzz_conditions(word, divider) VALUES('fizz', 3);
INSERT INTO fizz_buzz_conditions(word, divider) VALUES('buzz', 5);