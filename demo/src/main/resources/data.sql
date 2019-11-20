DROP TABLE IF EXISTS persona;
 
CREATE TABLE persona(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  address VARCHAR(250) DEFAULT NULL,
  phone_number INT DEFAULT NULL,
  hair_colour VARCHAR(20) DEFAULT NULL
);

insert into persona(id,name,last_name,address,phone_number,hair_colour) values(1,'Pedro','Caro','calle 1',99889,'brown');
insert into persona(id,name,last_name,address,phone_number,hair_colour) values(2,'Isabel','Segovia','calle 2',4545,'blond');
insert into persona(id,name,last_name,address,phone_number,hair_colour) values(3,'Claudio','Lazo','calle 3',6565,'black');
insert into persona(id,name,last_name,address,phone_number,hair_colour) values(4,'Denisse','Vargas','calle 4',11111,'yellow');
 