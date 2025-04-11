insert into member (member_Id, password, phone_number, name) values ('wonju2286', '12341234', '01012341234', '손원주');

insert into room (name, description, category, horror_level, difficult_level) values ('트라이앵글', 'triangle', '공포', 10, 8);
insert into room (name, description, category, horror_level, difficult_level) values ('다크나이트', 'dark knight', '액션', 5, 4);

insert into room_reserve_time (reserve_time, room_id) values ('12:00', 1);
insert into room_reserve_time (reserve_time, room_id) values ('14:00', 1);
insert into room_reserve_time (reserve_time, room_id) values ('16:00', 1);
insert into room_reserve_time (reserve_time, room_id) values ('18:00', 1);

insert into room_reserve_time (reserve_time, room_id) values ('11:00', 2);
insert into room_reserve_time (reserve_time, room_id) values ('13:00', 2);
insert into room_reserve_time (reserve_time, room_id) values ('15:00', 2);
insert into room_reserve_time (reserve_time, room_id) values ('17:00', 2);

insert into member_room_reserve (member_room_reserve_id, person_count, description, member_id, room_id, room_reserve_time_id) values ('dfd847b4-4efa-4980-b21b-ddeb2fc04c29', 5, 'reservation history1', 'wonju2286', 1, 2)