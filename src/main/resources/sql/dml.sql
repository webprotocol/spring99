select * from dept;

select * from country where code = 'KOR';

select count(*) from city;

select * from city where id = (select max(id) from city);

select city_id_seq.nextval from dual;
select city_id_seq.currval from dual;

drop sequence city_id_seq;
create sequence city_id_seq start with 4080;

insert into city
(	
	id,
	name,
	country_code,
	district,
	population
)
values
(
	city_id_seq.nextval,
	null,
	null,
	null,
	null
);


select * from country where code='KKK';

delete from country where code='KKK';
commit;






