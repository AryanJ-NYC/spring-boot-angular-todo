create table Todos(
  id int not null AUTO_INCREMENT,
  description text not null,
  completed boolean default false,
  created timestamp not null,
  last_update timestamp not null,
  primary key (id)
);
