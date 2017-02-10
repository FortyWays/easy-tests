--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // First migration.
-- Migration SQL that makes the change goes here.
CREATE TABLE areas (
  id         SERIAL      NOT NULL,
  area_name       VARCHAR(30) NOT NULL,
  x_coord    FLOAT       NOT NULL,
  y_coord    FLOAT       NOT NULL,
  width      FLOAT       NOT NULL,
  height     FLOAT       NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE occupations (
  id         SERIAL      NOT NULL,
  oc_name       VARCHAR(30) NOT NULL,
  salary     FLOAT       NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE dwellers (
  id             SERIAL      NOT NULL,
  first_name     VARCHAR(30) NOT NULL,
  last_name      VARCHAR(30) NOT NULL,
  surname        VARCHAR(30) NOT NULL,
  area_id        SERIAL     ,
  occupation_id  SERIAL     ,
  PRIMARY KEY (id)
);
ALTER TABLE dwellers ADD CONSTRAINT areas FOREIGN KEY (area_id) REFERENCES areas (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;
ALTER TABLE dwellers ADD CONSTRAINT occupations FOREIGN KEY (occupation_id) REFERENCES occupations (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;




-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE dwellers;
DROP TABLE areas;
DROP TABLE occupations;


