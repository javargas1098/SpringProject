create sequence hibernate_sequence start 1 increment 1
create table characters (id int8 not null, image varchar(255), name varchar(255), species varchar(255), id_location int8, primary key (id))
create table episodies (episode int8 not null, name varchar(255), primary key (episode))
create table locations (id_location int8 not null, dimension varchar(255), name varchar(255), type varchar(255), primary key (id_location))
alter table if exists characters add constraint FKf52gmc77crlx4xnhclfey8g88 foreign key (id_location) references locations
alter table if exists characters add constraint FK3qy1nc8n1yg7pdop8y5axbqau foreign key (id) references episodies
