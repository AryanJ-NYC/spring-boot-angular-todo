create table Todos(
  id int not null AUTO_INCREMENT,
  description text not null,
  completed boolean default false,
  created timestamp not null,
  lastUpdate timestamp not null,
  primary key (id)
);
