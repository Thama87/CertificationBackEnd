create table if not exists users (
	id serial primary key,
	name varchar(50) unique not null
);

create table if not exists channels (
	id serial primary key,
	name varchar(50) unique not null
);

create table if not exists messages (
	id serial primary key,
	content text not null,
	post_time timestamp not null,
	edit_time timestamp,
    user_id BIGINT not null references users(id) on delete set null,
	channel_id BIGINT not null references canals(id) on delete cascade
);
