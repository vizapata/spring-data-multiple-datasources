CREATE TABLE sample
(
    id   int not null auto_increment,
    doc varchar(255),
    name varchar(255),
    constraint pk_sample primary key (id)
);

insert into sample(doc, name) values('123', 'Sample 123 - main');
insert into sample(doc, name) values('456', 'Sample 456 - main');
insert into sample(doc, name) values('789', 'Sample 789 - main');