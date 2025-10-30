INSERT INTO city (name,state,population) VALUES
('Toronto','ON',2930000), ('Montreal','QC',1780000);

INSERT INTO airport (name,code,city_id) VALUES
('Toronto Pearson','YYZ',1),
('Billy Bishop','YTZ',1),
('Montréal–Trudeau','YUL',2);

INSERT INTO passenger (first_name,last_name,phone_number,city_id) VALUES
('Ava','Singh','555-1111',1),
('Liam','Chen','555-2222',2);

INSERT INTO aircraft (type,airline_name,number_of_passengers) VALUES
('A320','Air Canada',180),
('B737','WestJet',186);

INSERT INTO passenger_aircraft (passenger_id, aircraft_id) VALUES
(1,1),(1,2),(2,1);

INSERT INTO aircraft_airport (aircraft_id, airport_id) VALUES
(1,1),(1,2),(1,3),(2,1);