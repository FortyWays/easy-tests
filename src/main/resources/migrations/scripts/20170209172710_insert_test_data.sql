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

-- // insert_test_data
-- Migration SQL that makes the change goes here.
insert into areas (id,area_name,x_coord,y_coord,width,height) values (1,'districtA',100,100,10,10);
insert into areas (id,area_name,x_coord,y_coord,width,height) values (2,'districtB',140,80,15,15);

insert into occupations (id, oc_name,salary) values (1,'fisher', 100);
insert into occupations (id, oc_name,salary) values (2,'lawyer', 150);

INSERT INTO dwellers (id,first_name, last_name, surname, area_id,occupation_id) VALUES(1,'John','John','Johnson',1,1);
INSERT INTO dwellers (id,first_name, last_name, surname, area_id,occupation_id) VALUES(2,'Jack','Travis','Smith',1,2);




-- //@UNDO
-- SQL to undo the change goes here.
TRUNCATE dwellers;
TRUNCATE areas;
TRUNCATE occupations

