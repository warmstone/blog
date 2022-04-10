create database if not exists blog;

use blog;

/**
  博客分类表
 */
drop table if exists t_category;

create table if not exists t_category (
    id bigint unsigned auto_increment comment '主键',
    category_name varchar(50) default null comment '分类名称',
    is_deleted tinyint(1) default 0 comment '逻辑删除标志,0-有效，1-删除',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id),
    unique key (category_name)
) comment '博客分类表';

/**
  后台管理用户表
 */
 drop table if exists t_user;

create table if not exists t_user (
    id bigint unique auto_increment comment '主键',
    username varchar(50) default null comment '用户名',
    password varchar(256) default null comment '密码',
    secret varchar(60) default null comment '加密',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id)
) comment '后台管理员表';