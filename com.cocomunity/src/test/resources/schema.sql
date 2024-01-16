drop table if exists POST CASCADE;
create table POST
(   POST_ID bigint NOT NULL AUTO_INCREMENT,
    TITLE VARCHAR(255),
    CONTENTS TEXT,
    VIEW_COUNT  INTEGER DEFAULT 0,
    LIKE_COUNT  INTEGER DEFAULT 0,
    CREATED_DATETIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_DATETIME TIMESTAMP NULL,
    PRIMARY KEY (POST_ID)
);
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Sample Title', 'Sample contents of the post', 0, 0, NOW(), NOW());
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Cooking Tips', 'Learn how to bake a perfect cake in 10 minutes.', 0, 0, '2024-01-10 15:48:42', '2024-01-10 15:48:42');
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Travel Diaries', 'Sharing my recent trip to the mountains.', 0, 0, '2024-01-10 15:48:42', '2024-01-10 15:48:42');
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Cooking Tips', 'Learn how to bake a perfect cake in 10 minutes.', 0, 0, '2024-01-10 15:48:42', '2024-01-10 15:48:42');


INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Sample Title', 'Sample contents of the post', 0, 0, NOW(), NOW());
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Cooking Tips', 'Learn how to bake a perfect cake in 10 minutes.', 0, 0, '2024-01-10 15:48:42', '2024-01-10 15:48:42');
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Travel Diaries', 'Sharing my recent trip to the mountains.', 0, 0, '2024-01-10 15:48:42', '2024-01-10 15:48:42');
INSERT INTO post (title, contents, view_count, like_count, created_datetime, updated_datetime)
VALUES ('Cooking Tips', 'Learn how to bake a perfect cake in 10 minutes.', 0, 0, '2024-01-10 15:48:42', '2024-01-10 15:48:42');
