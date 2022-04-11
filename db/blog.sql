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
  博客标签表
 */
drop table if exists t_tag;

create table if not exists t_tag (
    id bigint unsigned auto_increment comment '主键',
    tag_name varchar(50) default null comment '标签名称',
    is_deleted tinyint(1) default 0 comment '逻辑删除标志,0-有效，1-删除',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id),
    unique key (tag_name)
) comment '博客标签表';

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

/**
  博客表
 */
drop table if exists t_blog;

create table if not exists t_blog (
    id bigint unsigned auto_increment comment '主键',
    title varchar(50) default null comment '标题',
    main_pic varchar(128) default null comment '主图',
    category_id bigint unsigned default null comment '分类ID',
    content text default null comment '内容',
    is_recommended tinyint(1) default 0 comment '是否推荐,0-否,1-是',
    is_original tinyint(1) default 1 comment '是否原创,0-否,1-是',
    is_can_liked tinyint(1) default 1 comment '是否开启赞赏功能,0-否,1-是',
    is_can_commented tinyint(1) default 0 comment '是否开启评论功能,0-否,1-是',
    state tinyint(4) default 1 comment '博客状态，1-保存，2-发布，3-撤回',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id)
) comment '博客表';