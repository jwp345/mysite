desc user;
-- select
select * from user;

-- 회원 가입
insert into user values(null, '편재원', 'jwp135@naver.com', password('1234'), 'male', now());

-- login
select no, name from user where email='jwp135@naver.com' and password=password('1234');

delete from user where no = 10;

update user set name='joy', password=password('2'), gender='male' where email='';

select * from board;

insert into board values(null, '안녕', '안녕', 0, now(), 2);

  select a.no, a.title, a.user_no as userNo, b.name, a.hit, date_format(a.reg_date, '%Y-%m-%d %h:%i:%s') as regDate
    from board a, user b 
   where a.user_no = b.no and (b.no = "안녕" or b.name = "안녕" or a.title = "안녕")
order by reg_date desc; 
 
 update board set hit where no=1;
 
 