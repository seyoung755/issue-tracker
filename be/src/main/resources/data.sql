INSERT INTO user (id, is_deleted, login_type, name, password, profile_image, username) VALUES
(1, false, 'NORMAL', '포키', '$2a$10$dsU1SximhyIE3YU0nWVF1uPaOwNw7EHp3jLiYoi9.CYkV8rUgAWsK', 'link1', 'forky'),
(2, false, 'NORMAL', '산토리', '$2a$10$dsU1SximhyIE3YU0nWVF1uPaOwNw7EHp3jLiYoi9.CYkV8rUgAWsK', 'link2', 'suntory'),
(3, false, 'NORMAL', '루니', '$2a$10$dsU1SximhyIE3YU0nWVF1uPaOwNw7EHp3jLiYoi9.CYkV8rUgAWsK', 'link3', 'runny'),
(4, false, 'NORMAL', '덕배', '$2a$10$dsU1SximhyIE3YU0nWVF1uPaOwNw7EHp3jLiYoi9.CYkV8rUgAWsK', 'link4', 'deok');

INSERT INTO milestone (id, is_deleted, description, due_date, name) VALUES
(1, false, '테스트 설명', '2022-06-30', '테스트 제목1'),
(2, false, '테스트 설명2', '2022-07-01', '테스트 제목2'),
(3, false, '테스트 설명2', '2022-07-02', '테스트 제목3');

INSERT INTO issue (id, is_deleted, content, title, milestone_id, user_id) VALUES
(1, false, '테스트 내용', '테스트 제목', 1, 2),
(2, false, '테스트 내용2', '테스트 제목2', 2, 2),
(3, false, '테스트 내용3', '테스트 제목3', 1, 2),
(4, false, '테스트 내용4', '테스트 제목4', 2, 3),
(5, false, '테스트 내용5', '테스트 제목5', 3, 4);

INSERT INTO label (id, is_deleted, color_code, description, label_name, text_color) VALUES
(1, false, 'F123F1', '라벨 설명', '라벨 이름1', 'LIGHT'),
(2, false, 'A123A1', '라벨 설명', '라벨 이름2', 'DARK');

INSERT INTO issue_assignee (assignee_id, issue_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(2, 2),
(3, 2),
(1, 3),
(3, 3),
(4, 3);

INSERT INTO issue_label (label_id, issue_id) VALUES
(1, 1),
(2, 1),
(1, 2),
(2, 3);

INSERT INTO comment (is_deleted, content, issue_id, user_id) VALUES
(false, '덧글 내용', 1, 2);
