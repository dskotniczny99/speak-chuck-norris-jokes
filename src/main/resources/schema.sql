drop table jokes;

create table if not exists jokes(
    id long PRIMARY KEY,
    joke varchar(max) NOT NULL
);