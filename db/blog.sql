create database if not exists blog;

use blog;

create table if not exists blog_category (
    id bigint unsigned auto_increment comment '主键',
    category_name varchar(50) default null comment '分类名称',
    creat_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id),
    unique key (category_name)
) comment '博客分类表';