# Tasks schema

# --- !Ups

CREATE SEQUENCE cat_id_seq;
CREATE TABLE cat (
    id integer NOT NULL DEFAULT nextval('cat_id_seq'),
    name varchar(255),
    color varchar(255),
    race varchar(255),
    gender varchar(255)
);

# --- !Downs

DROP TABLE cat;
DROP SEQUENCE cat_id_seq;
