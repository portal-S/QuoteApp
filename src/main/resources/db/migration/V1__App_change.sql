create table quotes(
                       id integer primary key auto_increment ,
                       score integer default 0 ,
                       text varchar(266) not null ,
                       posted_name varchar(66) not null ,
                       posted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)