desc guestbook;

select * from guestbook;
select no, name, password, message, reg_date from guestbook;
insert into guestbook values(null, "강광", "1234", "뭐라는데", now());

delete from guestbook where no = "4" and password = "1234";

-- user
desc user;
select * from user;
-- join
insert into user values(null, '신해빈', 'abc@gmail.com', password('1234'), 'male', now());

-- select
select no, name from user where email = 'abc@gmail.com' and password = password('1234');

<<<<<<< HEAD
select no, name, email, password, gender, join_date from user where email='abc@gmail.com' and password = password('1234');

update user set name = "강광", email = "aa@email.com", password = password("7890"), gender = "female" where no = 2;
=======

>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7









