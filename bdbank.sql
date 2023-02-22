
create table tbcliente(idcliente int PRIMARY key not null AUTO_INCREMENT,
nombres varchar(25) ,
apellidos varchar(25), 
fechaNacimiento varchar(15),
edad varchar(3),
domicilio varchar(30) 
); 

create table tbcuentatotal(idcuentatotal int PRIMARY key not null AUTO_INCREMENT,
idcliente int,
saldoTotal int,
FOREIGN KEY (idcliente) REFERENCES tbcliente(idcliente)
);

create table tbcuenta(idcuenta int PRIMARY key not null AUTO_INCREMENT,
idcuentaTotal int,
numeroCuenta varchar(16),
fecha varchar(30) ,
saldo int,
FOREIGN KEY (idcuentaTotal) REFERENCES tbcuentatotal(idcuentaTotal)
);

create table tbretirosincuenta(idretirosincuenta int PRIMARY key not null AUTO_INCREMENT,
idcuenta int,
folioOperacion varchar(8),
contraseña varchar(15),
estado varchar(15),
monto int,
nombre varchar(50), 
FOREIGN KEY (idcuenta) REFERENCES tbcuenta(idcuenta)
);

create table tbtransferencia(idtransferencia int PRIMARY key not null AUTO_INCREMENT,
idcuenta int,
destinatario varchar(50),
numCuentaDestinatario varchar(16),
monto int, 
FOREIGN KEY (idcuenta) REFERENCES tbcuenta(idcuenta)
);

