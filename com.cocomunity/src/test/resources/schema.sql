drop table if exists post CASCADE;
create table post
(   post_id bigint NOT NULL AUTO_INCREMENT,
    title varchar(255),
    contents text,
    view_count  integer default 0,
    like_count  integer default 0,
    created_datetime timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_datetime timestamp null,
    primary key (post_id)
);
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Sample Title', 'Sample contents of the post', 0, 0, NOW(), NOW());
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Cooking Tips', 'Learn how to bake a perfect cake in 10 minutes.', 0, 0, '2024-01-10 15:48:42', '2024-01-10 15:48:42');
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Travel Diaries', 'Sharing my recent trip to the mountains.', 0, 0, '2024-01-10 15:48:42', '2024-01-10 15:48:42');
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Cooking Tips', 'Learn how to bake a perfect cake in 10 minutes.', 0, 0, '2024-01-10 15:48:42', '2024-01-10 15:48:42');
