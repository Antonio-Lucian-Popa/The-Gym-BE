--liquibase formatted sql
--changeset Antonio Lucian:create-tables

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists users (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
profile_image_id uuid NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(50),
birthday DATE,
phone_number VARCHAR(50) NOT NULL,
subscription DATE,
number_of_months_payed INTEGER NOT NULL,
);

create table if not exists notifications (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
title VARCHAR(50) NOT NULL,
description VARCHAR(50) NOT NULL,
is_new BOOLEAN NOT NULL,
created_at DATE NOT NULL,
userId uuid NOT NULL,
);