CREATE TABLE users
(
id serial PRIMARY KEY,
login VARCHAR(50) NOT NULL unique,
password VARCHAR(50) NOT NULL
);

create table notes
(
id serial primary key,
"text" Varchar(50),
tag varchar(50)
)