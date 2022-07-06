
create table IF NOT EXISTS domicilios
(id int auto_increment primary key,
calle varchar(255),
numero varchar (255),
localidad varchar (255),
provincia varchar (255));

create table IF NOT EXISTS pacientes
(id int auto_increment primary key,
nombre varchar(255),
apellido varchar (255),
dni varchar (255),
fecha_ingreso TIMESTAMP WITHOUT TIME ZONE,
domicilio_id int);

create table IF NOT EXISTS odontologos
(id INT AUTO_INCREMENT PRIMARY KEY,
matricula varchar(50) NOT NULL,
nombre varchar(50) NOT NULL,
apellido varchar(50) NOT NULL);

