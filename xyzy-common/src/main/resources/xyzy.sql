CREATE TABLE `user` (
`id` int(11) NOT NULL,
`name` varchar(255) NULL,
`age` int NULL,
`phone` varchar(255) NULL,
`address` varchar(255) NULL,
`school_id` int(255) NULL,
`avator` varchar(255) NULL,
`password` varchar(255) NULL,
`user_role` varchar(255) NULL,
`class` varchar(255) NULL,
`major` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `school` (
`id` int(11) NOT NULL,
`type` varchar(255) NULL,
`school_name` varchar(255) NULL,
`location` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `article` (
`id` int(11) NOT NULL,
`title` varchar(255) NULL,
`area` varchar(255) NULL,
`create_time` datetime NULL,
`last_modify_time` datetime NULL,
`content` varchar(255) NULL,
`author` varchar(255) NULL,
`free` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `commit` (
`id` int(11) NOT NULL,
`article_id` int(11) NULL,
`author` varchar(255) NULL,
`title` varchar(255) NULL,
`content` varchar(255) NULL,
`create_time` datetime NULL,
PRIMARY KEY (`id`) ,
INDEX (`article_id` ASC)
);

CREATE TABLE `image` (
`id` int(11) NOT NULL,
`type` varchar(255) NULL,
`src` varchar(255) NULL,
`author` varchar(255) NULL,
`size` double NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `note` (
`id` int(11) NOT NULL,
`area` varchar(255) NULL,
`user_type` varchar(255) NULL COMMENT '使用对象 ，学生年纪，在岗工作人员',
`price` decimal(10,2) NULL,
`content_type` varchar(255) NULL COMMENT '内容类型 word ，pdf ，img ',
`content` varchar(255) NULL,
`create_time` datetime NULL,
`author` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `skill` (
`id` int(11) NOT NULL,
`skill_name` varchar(255) NULL,
`area` varchar(255) NULL,
`user_type` varchar(255) NULL,
`usage` varchar(255) NULL,
`price` decimal(10,2) NULL,
`can_teach` varchar(255) NULL,
`teacher` varchar(255) NULL,
`creator` varchar(255) NULL,
`create_time` datetime NULL,
`teach_area` varchar(255) NULL,
`teach_time` datetime NULL,
PRIMARY KEY (`id`) 
);


ALTER TABLE `user` ADD FOREIGN KEY (`school_id`) REFERENCES `school` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

