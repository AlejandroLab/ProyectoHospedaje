/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  jcerv_pm92n0w
 * Created: Oct 28, 2024
 */

insert into clientes(nombres, apellidos,dni,numeroTelefonico) values ('Sergio', 'Fernandez',62256,56656);
insert into clientes(nombres, apellidos,dni,numeroTelefonico) values ('Dajana', 'Damian',4845,652565);
insert into personas(nombres,apellidos)values('maria','huaccachi');
insert into personas(nombres,apellidos)values('Milagros','huaccachi');
insert into personas(nombres,apellidos)values('Jose','Mendez');

insert into empleados(persona_id,salario,correo,cargo,numerotelefonico)values(1,1850,'maria@hootmail.com','admin',94587126);
insert into usuario(nombreuser,contrasena)values('mhu','12345');
insert into usuario(nombreuser,contrasena)values('cguillermo','98765');
insert into categorias(nombres)values('Productos de limpieza');
insert into categorias(nombres)values('Comida');
insert into habitaciones(piso,numdehab,tipo,caracteristica,precio,disponibilidad)values('primer piso',101,'matrimonial','normal',90,true);
insert into habitaciones(piso,numdehab,tipo,caracteristica,precio,disponibilidad)values('segundo piso',204,'habitacion individual','vista al mar',90,true);