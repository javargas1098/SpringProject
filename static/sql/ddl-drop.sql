ALTER TABLE episode_characters DROP CONSTRAINT FKepisode_ch601545;
ALTER TABLE episode_characters DROP CONSTRAINT FKepisode_ch510140;
ALTER TABLE characters DROP CONSTRAINT FKcharacters558368;
DROP TABLE IF EXISTS characters CASCADE;
DROP TABLE IF EXISTS episode_characters CASCADE;
DROP TABLE IF EXISTS episodes CASCADE;
DROP TABLE IF EXISTS locations CASCADE;