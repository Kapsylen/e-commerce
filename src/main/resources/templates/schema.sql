create table address
(
    id                     varchar(255) not null
        constraint PK_ADDRESS
            primary key,
    street                 varchar(32),
    number                 int       not null,
    city                   varchar(32)  not null,
    zipcode                int       not null
);