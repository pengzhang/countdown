# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table email (
  id                        bigint not null,
  email                     varchar(255),
  is_send                   boolean,
  create_at                 timestamp,
  send_at                   timestamp,
  constraint pk_email primary key (id))
;

create sequence email_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists email;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists email_seq;

