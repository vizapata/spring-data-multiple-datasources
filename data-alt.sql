CREATE TABLE alt_sample
(
    id   int not null auto_increment,
    doc_number varchar(255),
    name varchar(255),
    constraint pk_sample primary key (id)
);

insert into alt_sample(doc_number, name) values('123', 'Sample 123 - alt');
insert into alt_sample(doc_number, name) values('abc', 'Sample ABC - alt');
insert into alt_sample(doc_number, name) values('def', 'Sample DEF - alt');