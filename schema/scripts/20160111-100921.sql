drop table if exists memberships;
drop table if exists users;
drop table if exists groups;

create table groups (
  id                    text primary key,
  name                  text not null check(util.non_empty_trimmed_string(name))
);

comment on table groups is '
  A group is a representation of users.
';

select audit.setup('public', 'groups');

create table users (
  id                    text primary key,
  email                 text not null check(util.non_empty_trimmed_string(email))
);

comment on table users is '
  A user is ...
';

select audit.setup('public', 'users');


create table memberships (
  id                    text primary key,
  user_id               text not null references users,
  group_id              text not null references groups
);

comment on table memberships is '
  A membership is ...
';

select audit.setup('public', 'memberships');

create index on memberships(user_id);
create index on memberships(group_id);
create unique index on memberships(group_id, user_id) where deleted_at is null;

