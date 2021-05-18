CREATE TABLE characters (
  id          numeric(19, 0) NOT NULL, 
  image       varchar(255) NOT NULL, 
  name        varchar(255) NOT NULL, 
  species     varchar(255) NOT NULL, 
  location_id numeric(19, 0) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE episode_characters (
  character_id numeric(19, 0) NOT NULL, 
  episode_id   numeric(19, 0) NOT NULL, 
  PRIMARY KEY (character_id, 
  episode_id));
CREATE TABLE episodes (
  id           numeric(19, 0) NOT NULL, 
  episode_name varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE locations (
  id        numeric(19, 0) NOT NULL, 
  dimension varchar(255) NOT NULL, 
  name      varchar(255) NOT NULL, 
  type      varchar(255) NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE episode_characters ADD CONSTRAINT FKepisode_ch601545 FOREIGN KEY (episode_id) REFERENCES episodes (id);
ALTER TABLE episode_characters ADD CONSTRAINT FKepisode_ch510140 FOREIGN KEY (character_id) REFERENCES characters (id);
ALTER TABLE characters ADD CONSTRAINT FKcharacters558368 FOREIGN KEY (location_id) REFERENCES locations (id);
