desc user;
-- select
select * from user;

-- 회원 가입
insert into user values(null, '편재원', 'jwp135@naver.com', password('1234'), 'male', now());

-- login
select no, name from user where email='jwp135@naver.com' and password=password('1234');

delete from user where email is null;

update user set name='joy', password=password('2'), gender='male' where email='dooly';