create table email (
  id                        bigint auto_increment not null,
  email                     varchar(255),
  is_send                   tinyint(1) default 0,
  create_at                 datetime,
  send_at                   datetime,
  constraint pk_email primary key (id))
;



