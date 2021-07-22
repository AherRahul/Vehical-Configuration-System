open mysql terminal on Ubuntu : 
	sudo mysql -u root
database creation : 
	show databases;
	create database vehicleconfigurator;
	use vehicleconfigurator;
table creation:	
	create table Segment(
	seg_id INT NOT NULL AUTO_INCREMENT,
	seg_name VARCHAR(100) NOT NULL,
	PRIMARY KEY ( seg_id )
	);
	

	create table Manufacturer(
	man_id INT NOT NULL AUTO_INCREMENT,
	man_name VARCHAR(100) NOT NULL,
	PRIMARY KEY ( man_id )
	);
	
	
	create table Variant(
	var_id INT NOT NULL AUTO_INCREMENT,
	var_name VARCHAR(100) NOT NULL,
	min_qty INT NOT NULL,
	base_price DECIMAL NOT NULL,
	seg_id INT,
	man_id INT,
	image_path VARCHAR(50), 
	PRIMARY KEY ( var_id ),
	FOREIGN KEY (seg_id) REFERENCES Segment(seg_id),
	FOREIGN KEY (man_id) REFERENCES Manufacturer(man_id)	
	);
	
	
	create table configuration(
	conf_id INT NOT NULL AUTO_INCREMENT,
	description VARCHAR(500),
	type VARCHAR(50) NOT NULL,
	configurable VARCHAR(15) NOT NULL,
	var_id INT,
	PRIMARY KEY ( conf_id ),
	FOREIGN KEY (var_id) REFERENCES Variant(var_id)
	);
	
	
	create table alternate_conf(
	alt_id INT NOT NULL AUTO_INCREMENT,
	alt_description VARCHAR(500),
	alt_price DECIMAL NOT NULL,
	conf_id INT,
	PRIMARY KEY ( alt_id ),
	FOREIGN KEY (conf_id) REFERENCES configuration(conf_id)
	);
	
	
	create table Customer(
	company_id INT NOT NULL AUTO_INCREMENT,
	company_name VARCHAR(50) NOT NULL,
	login_id VARCHAR(50) NOT NULL UNIQUE,
	password VARCHAR(50) NOT NULL,
	customer_name VARCHAR(50) NOT NULL,
	designation VARCHAR(50) NOT NULL,
	email_id VARCHAR(50) NOT NULL UNIQUE,
	address_line_1 VARCHAR(100) NOT NULL,
	address_line_2 VARCHAR(100),
	city VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
	pincode INT NOT NULL,
	company_tel VARCHAR(15),
	customer_mob VARCHAR(15),
	vat_no VARCHAR(15),
	pan_no VARCHAR(15) UNIQUE NOT NULL,
	holding VARCHAR(15),
	PRIMARY KEY ( company_id )
	);
	

Data Insertion : 
	
	insert into Segment (seg_name) values ("small car");
	insert into Segment (seg_name) values ("compact car");
	insert into Segment (seg_name) values ("sedan");
	insert into Segment (seg_name) values ("SUVs");
	insert into Segment (seg_name) values ("luxury cars");
	
	
	insert into Manufacturer (man_name) values ("tata motors");
	insert into Manufacturer (man_name) values ("mahindra and mahindra");
	insert into Manufacturer (man_name) values ("maruti suzuki");
	insert into Manufacturer (man_name) values ("bmw");
	insert into Manufacturer (man_name) values ("jeep");
	insert into Manufacturer (man_name) values ("ford");
	insert into Manufacturer (man_name) values ("honda");
	insert into Manufacturer (man_name) values ("hyundai");
	insert into Manufacturer (man_name) values ("kia");
	insert into Manufacturer (man_name) values ("mercedes");
	insert into Manufacturer (man_name) values ("renault");
	insert into Manufacturer (man_name) values ("nissan");
	insert into Manufacturer (man_name) values ("toyoto");
	insert into Manufacturer (man_name) values ("volkswagen");
	insert into Manufacturer (man_name) values ("tesla");
		
	
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("tigor", 20, 549000, 3, 1);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("nexon", 20, 709000, 2, 1);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("harrier", 20, 1400000, 4, 1);		
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("safari", 20, 1474000, 4, 1);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("indica", 20, 513000, 1, 1);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("nano", 20, 205000, 1, 1);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("bmw x1", 20, 3720000, 4, 4);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("bmw 3 series", 20, 4260000, 3, 4);		
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("bmw 2 series", 20, 4040000, 3, 4);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("bmw x5", 20, 7550000, 4, 4);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("mercedes benz glc", 20, 5736000, 4, 10);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("mercedes benz g class", 20, 16200000, 4, 10);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("mercedes benz v class", 20, 7170000, 2, 10);
	insert into Variant ( var_name, min_qty, base_price, seg_id, man_id )
		values ("mercedes benz s class", 20, 14100000, 3, 10);			
		
		
		
	insert into configuration ( description, type, configurable, var_id )
		values ("ARAI Mileage : 20.3 kmpl" ,"default" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("City Mileage : 12.34 kmpl" ,"default" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Fuel Type : petrol" ,"default" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Engine displacement : 1199cc" ,"default" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Seating Capacity : 5" ,"default" ,"no",1 );					
	insert into configuration ( description, type, configurable, var_id )
		values ("Power Steering" ,"default" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Air Conditioner" ,"default" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Driver and passenger Airbag" ,"default" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Driver Airbag" ,"default" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Tachometer" ,"interior" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Electronic Multi-Tripmeter" ,"interior" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Seat cover" ,"interior" ,"yes",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Steering Wheel" ,"interior" ,"yes",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("gear-shift selector wrap" ,"interior" ,"yes",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("headlights" ,"exterior" ,"yes",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("foglights front and rear" ,"exterior" ,"yes",1 );	
	insert into configuration ( description, type, configurable, var_id )
		values ("exterior mirrors" ,"exterior" ,"yes",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("wheel covers" ,"exterior" ,"yes",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("roof carrier" ,"exterior" ,"yes",1 );		
	insert into configuration ( description, type, configurable, var_id )
		values ("antenna" ,"exterior" ,"no",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("music system" ,"accessories" ,"yes",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("car cover" ,"accessories" ,"yes",1 );
	insert into configuration ( description, type, configurable, var_id )
		values ("radio" ,"accessories" ,"yes",1 );
		
	--------------------------------------------------------------------------------------------
	insert into configuration ( description, type, configurable, var_id )
		values ("ARAI Mileage : 19.62 kmpl" ,"default" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("City Mileage : 12.34 kmpl" ,"default" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Fuel Type : diesel" ,"default" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Engine displacement : 1998cc" ,"default" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Seating Capacity : 5" ,"default" ,"no",7 );					
	insert into configuration ( description, type, configurable, var_id )
		values ("Power Steering" ,"default" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Air Conditioner" ,"default" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Driver and passenger Airbag" ,"default" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Driver Airbag" ,"default" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Tachometer" ,"interior" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Electronic Multi-Tripmeter" ,"interior" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Seat cover" ,"interior" ,"yes",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("Steering Wheel" ,"interior" ,"yes",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("gear-shift selector wrap" ,"interior" ,"yes",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("headlights" ,"exterior" ,"yes",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("foglights front and rear" ,"exterior" ,"yes",7 );	
	insert into configuration ( description, type, configurable, var_id )
		values ("exterior mirrors" ,"exterior" ,"yes",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("wheel covers" ,"exterior" ,"yes",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("roof carrier" ,"exterior" ,"yes",7 );		
	insert into configuration ( description, type, configurable, var_id )
		values ("antenna" ,"exterior" ,"no",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("music system" ,"accessories" ,"yes",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("car cover" ,"accessories" ,"yes",7 );
	insert into configuration ( description, type, configurable, var_id )
		values ("radio" ,"accessories" ,"yes",7 );
-----------------------------------------------------------------------------------------------------------------------------------		
	
	
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 7, "Air conditioner 1", 15000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 7, "Air conditioner 2", 20000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 7, "Air conditioner 3", 25000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 8, "Passenger airbags 1", 8000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 8, "Passenger airbags 2", 10000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 8, "Passenger airbags 3", 12000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 9, "Driver airbags 1", 5000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 9, "Driver airbags 2", 6500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 9, "Driver airbags 3", 8000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 12, "Seat Cover 1", 4000 );	
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 12, "Seat Cover 2", 6000 );	
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 12, "Seat Cover 3", 8000 );	
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 12, "Seat Cover 4", 10000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 13, "Steering wheel 1", 5000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 13, "Steering wheel 2", 8000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 14, "gear-shift selector wrap 1", 1500 );					
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 14, "gear-shift selector wrap 2", 2500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 15, "headlights 1", 5000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 15, "headlights 2", 8000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 15, "headlights 3", 12000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 16, "foglights 1", 7000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 16, "foglights 2", 10000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 17, "exterior mirror 1", 1500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 17, "exterior mirror 2", 1500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 17, "exterior mirror 3", 3000 );				
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 18, "wheel covers 1", 4000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 18, "wheel covers 2", 16000 );		
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 19, "roof carrier 1", 15000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 19, "roof carrier 2", 20000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 19, "roof carrier 3", 30000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 21, "music system 1", 12000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 21, "music system 2", 25000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 21, "music system 3", 40000 );				
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 22, "car cover 1", 1500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 22, "car cover 2", 3000 );											
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 23, "radio 1", 3000 );		
----------------------------------------------------------

	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 30, "Air conditioner 1 bmw", 15000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 30, "Air conditioner 2 bmw", 20000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 30, "Air conditioner 3 bmw", 25000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 31, "Passenger airbags 1 bmw", 8000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 31, "Passenger airbags 2 bmw", 10000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 31, "Passenger airbags 3 bmw", 12000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 32, "Driver airbags 1 bmw", 5000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 32, "Driver airbags 2 bmw", 6500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 32, "Driver airbags 3 bmw", 8000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 35, "Seat Cover 1 bmw", 4000 );	
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 35, "Seat Cover 2 bmw", 6000 );	
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 35, "Seat Cover 3 bmw", 8000 );	
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 35, "Seat Cover 4 bmw", 10000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 36, "Steering wheel 1 bmw", 5000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 36, "Steering wheel 2 bmw", 8000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 37, "gear-shift selector wrap 1 bmw", 1500 );					
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 37, "gear-shift selector wrap 2 bmw", 2500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 38, "headlights 1 bmw", 5000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 38, "headlights 2 bmw", 8000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 38, "headlights 3 bmw", 12000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 39, "foglights 1 bmw", 7000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 39, "foglights 2 bmw", 10000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 40, "exterior mirror 1 bmw", 1500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 40, "exterior mirror 2 bmw", 1500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 40, "exterior mirror 3 bmw", 3000 );				
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 41, "wheel covers 1 bmw", 4000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 41, "wheel covers 2 bmw", 16000 );		
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 42, "roof carrier 1 bmw", 15000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 42, "roof carrier 2 bmw", 20000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 42, "roof carrier 3 bmw", 30000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 44, "music system 1 bmw", 12000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 44, "music system 2 bmw", 25000 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 44, "music system 3 bmw", 40000 );				
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 45, "car cover 1 bmw", 1500 );
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 45, "car cover 2 bmw", 3000 );											
	insert into alternate_conf ( conf_id, alt_description, alt_price )
		values ( 46, "radio 1 bmw", 3000 );