insert into groups(id, name, updated_by_user_id) values ('1', 'Admin', 'usr');
insert into groups(id, name, updated_by_user_id) values ('2', 'Members', 'usr');

update groups set name = 'Administrators', updated_by_user_id = 'usr' where id = '1';

insert into groups(id, name, updated_by_user_id) values ('3', 'Tmp', 'usr');
update groups set deleted_at = now(), updated_by_user_id = 'hacker' where id = '3';
