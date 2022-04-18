create database if not exists blog;

use blog;

/**
  博客分类表
 */
drop table if exists t_category;

create table if not exists t_category (
    id bigint unsigned auto_increment comment '主键',
    category_name varchar(50) default null comment '分类名称',
    is_enabled tinyint(1) default 1 comment '是否启用,1-启用，0-禁用',
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
    is_enabled tinyint(1) default 1 comment '是否启用,1-启用，0-禁用',
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
    id bigint unsigned auto_increment comment '主键',
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
    is_top tinyint(1) default 0 comment '是否置顶,0-否,1-是',
    is_recommended tinyint(1) default 0 comment '是否推荐,0-否,1-是',
    is_original tinyint(1) default 1 comment '是否原创,0-否,1-是',
    is_can_commented tinyint(1) default 0 comment '是否开启评论功能,0-否,1-是',
    state tinyint(4) default 1 comment '博客状态，1-保存，2-发布，3-撤回',
    publish_time timestamp default null comment '发布时间',
    liked_num int unsigned default 0 comment '点赞数',
    views int unsigned default 0 comment '浏览量',
    comment_num int unsigned default 0 comment '评论数',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id)
) comment '博客表';

/**
  博客标签表
 */
drop table if exists t_blog_tag;

create table if not exists t_blog_tag (
    id bigint unsigned auto_increment comment '主键',
    blog_id bigint comment '博客id',
    tag_id bigint comment '标签id',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id)
) comment '博客标签表';

/**
  浏览记录表
 */
drop table if exists t_view_record;

create table if not exists t_view_record (
    id bigint unsigned auto_increment comment '主键',
    blog_id bigint comment '博客id',
    view_ip varchar(16) default null comment 'ip',
    view_duration int default null comment '浏览时长',
    create_time timestamp default current_timestamp comment '创建时间',
    primary key (id)
) comment '浏览记录表';

/**
  点赞记录点赞
 */
drop table if exists t_like_record;

create table if not exists t_like_record (
    id bigint unsigned auto_increment comment '主键',
    blog_id bigint comment '博客id',
    like_ip varchar(16) default null comment 'ip',
    create_time timestamp default current_timestamp comment '创建时间',
    primary key (id)
) comment '点赞记录表';